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

import com.serious.exception.NoSuchOrderException;
import com.serious.model.Order;
import com.serious.service.OrderLocalServiceUtil;
import com.serious.service.persistence.OrderPersistence;
import com.serious.service.persistence.OrderUtil;

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
public class OrderPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.serious.service"));

	@Before
	public void setUp() {
		_persistence = OrderUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Order> iterator = _orders.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Order order = _persistence.create(pk);

		Assert.assertNotNull(order);

		Assert.assertEquals(order.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Order newOrder = addOrder();

		_persistence.remove(newOrder);

		Order existingOrder = _persistence.fetchByPrimaryKey(
			newOrder.getPrimaryKey());

		Assert.assertNull(existingOrder);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOrder();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Order newOrder = _persistence.create(pk);

		newOrder.setDateOrder(RandomTestUtil.nextDate());

		newOrder.setCustomer(RandomTestUtil.randomString());

		newOrder.setStatus(RandomTestUtil.nextInt());

		newOrder.setAddress(RandomTestUtil.randomString());

		_orders.add(_persistence.update(newOrder));

		Order existingOrder = _persistence.findByPrimaryKey(
			newOrder.getPrimaryKey());

		Assert.assertEquals(existingOrder.getId(), newOrder.getId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingOrder.getDateOrder()),
			Time.getShortTimestamp(newOrder.getDateOrder()));
		Assert.assertEquals(
			existingOrder.getCustomer(), newOrder.getCustomer());
		Assert.assertEquals(existingOrder.getStatus(), newOrder.getStatus());
		Assert.assertEquals(existingOrder.getAddress(), newOrder.getAddress());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Order newOrder = addOrder();

		Order existingOrder = _persistence.findByPrimaryKey(
			newOrder.getPrimaryKey());

		Assert.assertEquals(existingOrder, newOrder);
	}

	@Test(expected = NoSuchOrderException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Order> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"my_orders_Order", "id", true, "dateOrder", true, "customer", true,
			"status", true, "address", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Order newOrder = addOrder();

		Order existingOrder = _persistence.fetchByPrimaryKey(
			newOrder.getPrimaryKey());

		Assert.assertEquals(existingOrder, newOrder);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Order missingOrder = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOrder);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Order newOrder1 = addOrder();
		Order newOrder2 = addOrder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrder1.getPrimaryKey());
		primaryKeys.add(newOrder2.getPrimaryKey());

		Map<Serializable, Order> orders = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, orders.size());
		Assert.assertEquals(newOrder1, orders.get(newOrder1.getPrimaryKey()));
		Assert.assertEquals(newOrder2, orders.get(newOrder2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Order> orders = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(orders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Order newOrder = addOrder();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrder.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Order> orders = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, orders.size());
		Assert.assertEquals(newOrder, orders.get(newOrder.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Order> orders = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(orders.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Order newOrder = addOrder();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrder.getPrimaryKey());

		Map<Serializable, Order> orders = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, orders.size());
		Assert.assertEquals(newOrder, orders.get(newOrder.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OrderLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Order>() {

				@Override
				public void performAction(Order order) {
					Assert.assertNotNull(order);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Order newOrder = addOrder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Order.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newOrder.getId()));

		List<Order> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Order existingOrder = result.get(0);

		Assert.assertEquals(existingOrder, newOrder);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Order.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Order> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Order newOrder = addOrder();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Order.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newOrder.getId();

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
			Order.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Order addOrder() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Order order = _persistence.create(pk);

		order.setDateOrder(RandomTestUtil.nextDate());

		order.setCustomer(RandomTestUtil.randomString());

		order.setStatus(RandomTestUtil.nextInt());

		order.setAddress(RandomTestUtil.randomString());

		_orders.add(_persistence.update(order));

		return order;
	}

	private List<Order> _orders = new ArrayList<Order>();
	private OrderPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}