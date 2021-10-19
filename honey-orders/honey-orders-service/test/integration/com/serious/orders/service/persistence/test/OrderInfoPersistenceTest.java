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

package com.serious.orders.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.serious.orders.exception.NoSuchOrderInfoException;
import com.serious.orders.model.OrderInfo;
import com.serious.orders.service.OrderInfoLocalServiceUtil;
import com.serious.orders.service.persistence.OrderInfoPersistence;
import com.serious.orders.service.persistence.OrderInfoUtil;

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
public class OrderInfoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.serious.orders.service"));

	@Before
	public void setUp() {
		_persistence = OrderInfoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<OrderInfo> iterator = _orderInfos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OrderInfo orderInfo = _persistence.create(pk);

		Assert.assertNotNull(orderInfo);

		Assert.assertEquals(orderInfo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		_persistence.remove(newOrderInfo);

		OrderInfo existingOrderInfo = _persistence.fetchByPrimaryKey(
			newOrderInfo.getPrimaryKey());

		Assert.assertNull(existingOrderInfo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOrderInfo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OrderInfo newOrderInfo = _persistence.create(pk);

		newOrderInfo.setOrderid(RandomTestUtil.nextLong());

		newOrderInfo.setType(RandomTestUtil.nextLong());

		newOrderInfo.setAmount(RandomTestUtil.nextInt());

		_orderInfos.add(_persistence.update(newOrderInfo));

		OrderInfo existingOrderInfo = _persistence.findByPrimaryKey(
			newOrderInfo.getPrimaryKey());

		Assert.assertEquals(existingOrderInfo.getId(), newOrderInfo.getId());
		Assert.assertEquals(
			existingOrderInfo.getOrderid(), newOrderInfo.getOrderid());
		Assert.assertEquals(
			existingOrderInfo.getType(), newOrderInfo.getType());
		Assert.assertEquals(
			existingOrderInfo.getAmount(), newOrderInfo.getAmount());
	}

	@Test
	public void testCountByOrderid() throws Exception {
		_persistence.countByOrderid(RandomTestUtil.nextLong());

		_persistence.countByOrderid(0L);
	}

	@Test
	public void testCountByOrder() throws Exception {
		_persistence.countByOrder(RandomTestUtil.nextLong());

		_persistence.countByOrder(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		OrderInfo existingOrderInfo = _persistence.findByPrimaryKey(
			newOrderInfo.getPrimaryKey());

		Assert.assertEquals(existingOrderInfo, newOrderInfo);
	}

	@Test(expected = NoSuchOrderInfoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<OrderInfo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"manager_odr_OrderInfo", "id", true, "orderid", true, "type", true,
			"amount", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		OrderInfo existingOrderInfo = _persistence.fetchByPrimaryKey(
			newOrderInfo.getPrimaryKey());

		Assert.assertEquals(existingOrderInfo, newOrderInfo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OrderInfo missingOrderInfo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOrderInfo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		OrderInfo newOrderInfo1 = addOrderInfo();
		OrderInfo newOrderInfo2 = addOrderInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrderInfo1.getPrimaryKey());
		primaryKeys.add(newOrderInfo2.getPrimaryKey());

		Map<Serializable, OrderInfo> orderInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, orderInfos.size());
		Assert.assertEquals(
			newOrderInfo1, orderInfos.get(newOrderInfo1.getPrimaryKey()));
		Assert.assertEquals(
			newOrderInfo2, orderInfos.get(newOrderInfo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, OrderInfo> orderInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(orderInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		OrderInfo newOrderInfo = addOrderInfo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrderInfo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, OrderInfo> orderInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, orderInfos.size());
		Assert.assertEquals(
			newOrderInfo, orderInfos.get(newOrderInfo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, OrderInfo> orderInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(orderInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOrderInfo.getPrimaryKey());

		Map<Serializable, OrderInfo> orderInfos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, orderInfos.size());
		Assert.assertEquals(
			newOrderInfo, orderInfos.get(newOrderInfo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OrderInfoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<OrderInfo>() {

				@Override
				public void performAction(OrderInfo orderInfo) {
					Assert.assertNotNull(orderInfo);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			OrderInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newOrderInfo.getId()));

		List<OrderInfo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		OrderInfo existingOrderInfo = result.get(0);

		Assert.assertEquals(existingOrderInfo, newOrderInfo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			OrderInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<OrderInfo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			OrderInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newOrderInfo.getId();

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
			OrderInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		OrderInfo newOrderInfo = addOrderInfo();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newOrderInfo.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		OrderInfo newOrderInfo = addOrderInfo();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			OrderInfo.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newOrderInfo.getId()));

		List<OrderInfo> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(OrderInfo orderInfo) {
		Assert.assertEquals(
			Long.valueOf(orderInfo.getOrderid()),
			ReflectionTestUtil.<Long>invoke(
				orderInfo, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "orderid"));
	}

	protected OrderInfo addOrderInfo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OrderInfo orderInfo = _persistence.create(pk);

		orderInfo.setOrderid(RandomTestUtil.nextLong());

		orderInfo.setType(RandomTestUtil.nextLong());

		orderInfo.setAmount(RandomTestUtil.nextInt());

		_orderInfos.add(_persistence.update(orderInfo));

		return orderInfo;
	}

	private List<OrderInfo> _orderInfos = new ArrayList<OrderInfo>();
	private OrderInfoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}