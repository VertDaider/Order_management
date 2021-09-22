/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.serious.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.serious.exception.NoSuchOrdersException;
import com.serious.model.Orders;
import com.serious.service.OrdersLocalServiceUtil;
import com.serious.service.persistence.OrdersPersistence;
import com.serious.service.persistence.OrdersUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class OrdersPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.serious.service"));

	@Before
	public void setUp() {
		_persistence = OrdersUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Orders> iterator = _orderses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Orders orders = _persistence.create(pk);

		Assert.assertNotNull(orders);

		Assert.assertEquals(orders.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Orders newOrders = addOrders();

		_persistence.remove(newOrders);

		Orders existingOrders = _persistence.fetchByPrimaryKey(
			newOrders.getPrimaryKey());

		Assert.assertNull(existingOrders);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOrders();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Orders newOrders = _persistence.create(pk);

		newOrders.setDateOrder(RandomTestUtil.nextDate());

		newOrders.setCustomer(RandomTestUtil.randomString());

		newOrders.setOrderinfo(RandomTestUtil.nextLong());

		newOrders.setStatus(RandomTestUtil.nextInt());

		_orderses.add(_persistence.update(newOrders));

		Orders existingOrders = _persistence.findByPrimaryKey(
			newOrders.getPrimaryKey());

		Assert.assertEquals(existingOrders.getId(), newOrders.getId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingOrders.getDateOrder()),
			Time.getShortTimestamp(newOrders.getDateOrder()));
		Assert.assertEquals(
			existingOrders.getCustomer(), newOrders.getCustomer());
		Assert.assertEquals(
			existingOrders.getOrderinfo(), newOrders.getOrderinfo());
		Assert.assertEquals(existingOrders.getStatus(), newOrders.getStatus());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Orders newOrders = addOrders();

		Orders existingOrders = _persistence.findByPrimaryKey(
			newOrders.getPrimaryKey());

		Assert.assertEquals(existingOrders, newOrders);
	}

	@Test(expected = NoSuchOrdersException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Orders> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"my_orders_Orders", "id", true, "dateOrder", true, "customer", true,
			"orderinfo", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Orders newOrders = addOrders();

		Orders existingOrders = _persistence.fetchByPrimaryKey(
			newOrders.getPrimaryKey());

		Assert.assertEquals(existingOrders, newOrders);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Orders missingOrders = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOrders);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Orders newOrders1 = addOrders();
		Orders newOrders2 = addOrders();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrders1.getPrimaryKey());
		primaryKeys.add(newOrders2.getPrimaryKey());

		Map<Serializable, Orders> orderses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, orderses.size());
		Assert.assertEquals(
			newOrders1, orderses.get(newOrders1.getPrimaryKey()));
		Assert.assertEquals(
			newOrders2, orderses.get(newOrders2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Orders> orderses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(orderses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Orders newOrders = addOrders();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrders.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Orders> orderses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, orderses.size());
		Assert.assertEquals(newOrders, orderses.get(newOrders.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Orders> orderses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(orderses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Orders newOrders = addOrders();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrders.getPrimaryKey());

		Map<Serializable, Orders> orderses = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, orderses.size());
		Assert.assertEquals(newOrders, orderses.get(newOrders.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OrdersLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Orders>() {

				@Override
				public void performAction(Orders orders) {
					Assert.assertNotNull(orders);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Orders newOrders = addOrders();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Orders.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newOrders.getId()));

		List<Orders> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Orders existingOrders = result.get(0);

		Assert.assertEquals(existingOrders, newOrders);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Orders.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Orders> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Orders newOrders = addOrders();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Orders.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newOrders.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Orders.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Orders addOrders() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Orders orders = _persistence.create(pk);

		orders.setDateOrder(RandomTestUtil.nextDate());

		orders.setCustomer(RandomTestUtil.randomString());

		orders.setOrderinfo(RandomTestUtil.nextLong());

		orders.setStatus(RandomTestUtil.nextInt());

		_orderses.add(_persistence.update(orders));

		return orders;
	}

	private List<Orders> _orderses = new ArrayList<Orders>();
	private OrdersPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}