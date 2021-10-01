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

package com.serious.orders.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.serious.orders.model.Honey;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the honey service. This utility wraps <code>com.serious.orders.service.persistence.impl.HoneyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HoneyPersistence
 * @generated
 */
public class HoneyUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Honey honey) {
		getPersistence().clearCache(honey);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Honey> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Honey> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Honey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Honey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Honey> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Honey update(Honey honey) {
		return getPersistence().update(honey);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Honey update(Honey honey, ServiceContext serviceContext) {
		return getPersistence().update(honey, serviceContext);
	}

	/**
	 * Returns all the honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching honeys
	 */
	public static List<Honey> findBytype(String type) {
		return getPersistence().findBytype(type);
	}

	/**
	 * Returns a range of all the honeys where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @return the range of matching honeys
	 */
	public static List<Honey> findBytype(String type, int start, int end) {
		return getPersistence().findBytype(type, start, end);
	}

	/**
	 * Returns an ordered range of all the honeys where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching honeys
	 */
	public static List<Honey> findBytype(
		String type, int start, int end,
		OrderByComparator<Honey> orderByComparator) {

		return getPersistence().findBytype(type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the honeys where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching honeys
	 */
	public static List<Honey> findBytype(
		String type, int start, int end,
		OrderByComparator<Honey> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytype(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public static Honey findBytype_First(
			String type, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public static Honey fetchBytype_First(
		String type, OrderByComparator<Honey> orderByComparator) {

		return getPersistence().fetchBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public static Honey findBytype_Last(
			String type, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findBytype_Last(type, orderByComparator);
	}

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public static Honey fetchBytype_Last(
		String type, OrderByComparator<Honey> orderByComparator) {

		return getPersistence().fetchBytype_Last(type, orderByComparator);
	}

	/**
	 * Returns the honeys before and after the current honey in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current honey
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public static Honey[] findBytype_PrevAndNext(
			long id, String type, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findBytype_PrevAndNext(
			id, type, orderByComparator);
	}

	/**
	 * Removes all the honeys where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeBytype(String type) {
		getPersistence().removeBytype(type);
	}

	/**
	 * Returns the number of honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching honeys
	 */
	public static int countBytype(String type) {
		return getPersistence().countBytype(type);
	}

	/**
	 * Returns all the honeys where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching honeys
	 */
	public static List<Honey> findByprice(int price) {
		return getPersistence().findByprice(price);
	}

	/**
	 * Returns a range of all the honeys where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @return the range of matching honeys
	 */
	public static List<Honey> findByprice(int price, int start, int end) {
		return getPersistence().findByprice(price, start, end);
	}

	/**
	 * Returns an ordered range of all the honeys where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching honeys
	 */
	public static List<Honey> findByprice(
		int price, int start, int end,
		OrderByComparator<Honey> orderByComparator) {

		return getPersistence().findByprice(
			price, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the honeys where price = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param price the price
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching honeys
	 */
	public static List<Honey> findByprice(
		int price, int start, int end,
		OrderByComparator<Honey> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByprice(
			price, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public static Honey findByprice_First(
			int price, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findByprice_First(price, orderByComparator);
	}

	/**
	 * Returns the first honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public static Honey fetchByprice_First(
		int price, OrderByComparator<Honey> orderByComparator) {

		return getPersistence().fetchByprice_First(price, orderByComparator);
	}

	/**
	 * Returns the last honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public static Honey findByprice_Last(
			int price, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findByprice_Last(price, orderByComparator);
	}

	/**
	 * Returns the last honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public static Honey fetchByprice_Last(
		int price, OrderByComparator<Honey> orderByComparator) {

		return getPersistence().fetchByprice_Last(price, orderByComparator);
	}

	/**
	 * Returns the honeys before and after the current honey in the ordered set where price = &#63;.
	 *
	 * @param id the primary key of the current honey
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public static Honey[] findByprice_PrevAndNext(
			long id, int price, OrderByComparator<Honey> orderByComparator)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findByprice_PrevAndNext(
			id, price, orderByComparator);
	}

	/**
	 * Removes all the honeys where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public static void removeByprice(int price) {
		getPersistence().removeByprice(price);
	}

	/**
	 * Returns the number of honeys where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching honeys
	 */
	public static int countByprice(int price) {
		return getPersistence().countByprice(price);
	}

	/**
	 * Caches the honey in the entity cache if it is enabled.
	 *
	 * @param honey the honey
	 */
	public static void cacheResult(Honey honey) {
		getPersistence().cacheResult(honey);
	}

	/**
	 * Caches the honeys in the entity cache if it is enabled.
	 *
	 * @param honeys the honeys
	 */
	public static void cacheResult(List<Honey> honeys) {
		getPersistence().cacheResult(honeys);
	}

	/**
	 * Creates a new honey with the primary key. Does not add the honey to the database.
	 *
	 * @param id the primary key for the new honey
	 * @return the new honey
	 */
	public static Honey create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the honey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the honey
	 * @return the honey that was removed
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public static Honey remove(long id)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().remove(id);
	}

	public static Honey updateImpl(Honey honey) {
		return getPersistence().updateImpl(honey);
	}

	/**
	 * Returns the honey with the primary key or throws a <code>NoSuchHoneyException</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public static Honey findByPrimaryKey(long id)
		throws com.serious.orders.exception.NoSuchHoneyException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the honey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey, or <code>null</code> if a honey with the primary key could not be found
	 */
	public static Honey fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the honeys.
	 *
	 * @return the honeys
	 */
	public static List<Honey> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the honeys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @return the range of honeys
	 */
	public static List<Honey> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the honeys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of honeys
	 */
	public static List<Honey> findAll(
		int start, int end, OrderByComparator<Honey> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the honeys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of honeys
	 */
	public static List<Honey> findAll(
		int start, int end, OrderByComparator<Honey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the honeys from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of honeys.
	 *
	 * @return the number of honeys
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HoneyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HoneyPersistence, HoneyPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HoneyPersistence.class);

		ServiceTracker<HoneyPersistence, HoneyPersistence> serviceTracker =
			new ServiceTracker<HoneyPersistence, HoneyPersistence>(
				bundle.getBundleContext(), HoneyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}