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

import com.serious.orders.exception.NoSuchHoneyException;
import com.serious.orders.model.Honey;
import com.serious.orders.service.HoneyLocalServiceUtil;
import com.serious.orders.service.persistence.HoneyPersistence;
import com.serious.orders.service.persistence.HoneyUtil;

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
public class HoneyPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.serious.orders.service"));

	@Before
	public void setUp() {
		_persistence = HoneyUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Honey> iterator = _honeys.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Honey honey = _persistence.create(pk);

		Assert.assertNotNull(honey);

		Assert.assertEquals(honey.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Honey newHoney = addHoney();

		_persistence.remove(newHoney);

		Honey existingHoney = _persistence.fetchByPrimaryKey(
			newHoney.getPrimaryKey());

		Assert.assertNull(existingHoney);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHoney();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Honey newHoney = _persistence.create(pk);

		newHoney.setType(RandomTestUtil.randomString());

		newHoney.setPrice(RandomTestUtil.nextInt());

		newHoney.setStock(RandomTestUtil.randomBoolean());

		_honeys.add(_persistence.update(newHoney));

		Honey existingHoney = _persistence.findByPrimaryKey(
			newHoney.getPrimaryKey());

		Assert.assertEquals(existingHoney.getId(), newHoney.getId());
		Assert.assertEquals(existingHoney.getType(), newHoney.getType());
		Assert.assertEquals(existingHoney.getPrice(), newHoney.getPrice());
		Assert.assertEquals(existingHoney.isStock(), newHoney.isStock());
	}

	@Test
	public void testCountByType() throws Exception {
		_persistence.countByType("");

		_persistence.countByType("null");

		_persistence.countByType((String)null);
	}

	@Test
	public void testCountByPrice() throws Exception {
		_persistence.countByPrice(RandomTestUtil.nextInt());

		_persistence.countByPrice(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Honey newHoney = addHoney();

		Honey existingHoney = _persistence.findByPrimaryKey(
			newHoney.getPrimaryKey());

		Assert.assertEquals(existingHoney, newHoney);
	}

	@Test(expected = NoSuchHoneyException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Honey> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"manager_odr_Honey", "id", true, "type", true, "price", true,
			"stock", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Honey newHoney = addHoney();

		Honey existingHoney = _persistence.fetchByPrimaryKey(
			newHoney.getPrimaryKey());

		Assert.assertEquals(existingHoney, newHoney);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Honey missingHoney = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHoney);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Honey newHoney1 = addHoney();
		Honey newHoney2 = addHoney();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoney1.getPrimaryKey());
		primaryKeys.add(newHoney2.getPrimaryKey());

		Map<Serializable, Honey> honeys = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, honeys.size());
		Assert.assertEquals(newHoney1, honeys.get(newHoney1.getPrimaryKey()));
		Assert.assertEquals(newHoney2, honeys.get(newHoney2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Honey> honeys = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(honeys.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Honey newHoney = addHoney();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoney.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Honey> honeys = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, honeys.size());
		Assert.assertEquals(newHoney, honeys.get(newHoney.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Honey> honeys = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(honeys.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Honey newHoney = addHoney();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHoney.getPrimaryKey());

		Map<Serializable, Honey> honeys = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, honeys.size());
		Assert.assertEquals(newHoney, honeys.get(newHoney.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HoneyLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Honey>() {

				@Override
				public void performAction(Honey honey) {
					Assert.assertNotNull(honey);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Honey newHoney = addHoney();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Honey.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newHoney.getId()));

		List<Honey> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Honey existingHoney = result.get(0);

		Assert.assertEquals(existingHoney, newHoney);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Honey.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Honey> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Honey newHoney = addHoney();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Honey.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newHoney.getId();

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
			Honey.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Honey newHoney = addHoney();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newHoney.getPrimaryKey()));
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

		Honey newHoney = addHoney();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Honey.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newHoney.getId()));

		List<Honey> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Honey honey) {
		Assert.assertEquals(
			Integer.valueOf(honey.getPrice()),
			ReflectionTestUtil.<Integer>invoke(
				honey, "getColumnOriginalValue", new Class<?>[] {String.class},
				"price"));
	}

	protected Honey addHoney() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Honey honey = _persistence.create(pk);

		honey.setType(RandomTestUtil.randomString());

		honey.setPrice(RandomTestUtil.nextInt());

		honey.setStock(RandomTestUtil.randomBoolean());

		_honeys.add(_persistence.update(honey));

		return honey;
	}

	private List<Honey> _honeys = new ArrayList<Honey>();
	private HoneyPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}