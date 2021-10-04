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

import com.serious.orders.model.OrderInfo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the order info service. This utility wraps <code>com.serious.orders.service.persistence.impl.OrderInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderInfoPersistence
 * @generated
 */
public class OrderInfoUtil {

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
	public static void clearCache(OrderInfo orderInfo) {
		getPersistence().clearCache(orderInfo);
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
	public static Map<Serializable, OrderInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrderInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrderInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrderInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrderInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrderInfo update(OrderInfo orderInfo) {
		return getPersistence().update(orderInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrderInfo update(
		OrderInfo orderInfo, ServiceContext serviceContext) {

		return getPersistence().update(orderInfo, serviceContext);
	}

	/**
	 * Returns the order info where orderid = &#63; or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param orderid the orderid
	 * @return the matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public static OrderInfo findByOrderid(long orderid)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().findByOrderid(orderid);
	}

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orderid the orderid
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public static OrderInfo fetchByOrderid(long orderid) {
		return getPersistence().fetchByOrderid(orderid);
	}

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orderid the orderid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public static OrderInfo fetchByOrderid(
		long orderid, boolean useFinderCache) {

		return getPersistence().fetchByOrderid(orderid, useFinderCache);
	}

	/**
	 * Removes the order info where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 * @return the order info that was removed
	 */
	public static OrderInfo removeByOrderid(long orderid)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().removeByOrderid(orderid);
	}

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	public static int countByOrderid(long orderid) {
		return getPersistence().countByOrderid(orderid);
	}

	/**
	 * Returns all the order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the matching order infos
	 */
	public static List<OrderInfo> findByOrder(long orderid) {
		return getPersistence().findByOrder(orderid);
	}

	/**
	 * Returns a range of all the order infos where orderid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param orderid the orderid
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @return the range of matching order infos
	 */
	public static List<OrderInfo> findByOrder(
		long orderid, int start, int end) {

		return getPersistence().findByOrder(orderid, start, end);
	}

	/**
	 * Returns an ordered range of all the order infos where orderid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param orderid the orderid
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching order infos
	 */
	public static List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		OrderByComparator<OrderInfo> orderByComparator) {

		return getPersistence().findByOrder(
			orderid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the order infos where orderid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param orderid the orderid
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching order infos
	 */
	public static List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		OrderByComparator<OrderInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrder(
			orderid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public static OrderInfo findByOrder_First(
			long orderid, OrderByComparator<OrderInfo> orderByComparator)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().findByOrder_First(orderid, orderByComparator);
	}

	/**
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public static OrderInfo fetchByOrder_First(
		long orderid, OrderByComparator<OrderInfo> orderByComparator) {

		return getPersistence().fetchByOrder_First(orderid, orderByComparator);
	}

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public static OrderInfo findByOrder_Last(
			long orderid, OrderByComparator<OrderInfo> orderByComparator)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().findByOrder_Last(orderid, orderByComparator);
	}

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public static OrderInfo fetchByOrder_Last(
		long orderid, OrderByComparator<OrderInfo> orderByComparator) {

		return getPersistence().fetchByOrder_Last(orderid, orderByComparator);
	}

	/**
	 * Returns the order infos before and after the current order info in the ordered set where orderid = &#63;.
	 *
	 * @param id the primary key of the current order info
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public static OrderInfo[] findByOrder_PrevAndNext(
			long id, long orderid,
			OrderByComparator<OrderInfo> orderByComparator)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().findByOrder_PrevAndNext(
			id, orderid, orderByComparator);
	}

	/**
	 * Removes all the order infos where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 */
	public static void removeByOrder(long orderid) {
		getPersistence().removeByOrder(orderid);
	}

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	public static int countByOrder(long orderid) {
		return getPersistence().countByOrder(orderid);
	}

	/**
	 * Caches the order info in the entity cache if it is enabled.
	 *
	 * @param orderInfo the order info
	 */
	public static void cacheResult(OrderInfo orderInfo) {
		getPersistence().cacheResult(orderInfo);
	}

	/**
	 * Caches the order infos in the entity cache if it is enabled.
	 *
	 * @param orderInfos the order infos
	 */
	public static void cacheResult(List<OrderInfo> orderInfos) {
		getPersistence().cacheResult(orderInfos);
	}

	/**
	 * Creates a new order info with the primary key. Does not add the order info to the database.
	 *
	 * @param id the primary key for the new order info
	 * @return the new order info
	 */
	public static OrderInfo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the order info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order info
	 * @return the order info that was removed
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public static OrderInfo remove(long id)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().remove(id);
	}

	public static OrderInfo updateImpl(OrderInfo orderInfo) {
		return getPersistence().updateImpl(orderInfo);
	}

	/**
	 * Returns the order info with the primary key or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public static OrderInfo findByPrimaryKey(long id)
		throws com.serious.orders.exception.NoSuchOrderInfoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the order info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info, or <code>null</code> if a order info with the primary key could not be found
	 */
	public static OrderInfo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the order infos.
	 *
	 * @return the order infos
	 */
	public static List<OrderInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the order infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @return the range of order infos
	 */
	public static List<OrderInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the order infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of order infos
	 */
	public static List<OrderInfo> findAll(
		int start, int end, OrderByComparator<OrderInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the order infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of order infos
	 */
	public static List<OrderInfo> findAll(
		int start, int end, OrderByComparator<OrderInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the order infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of order infos.
	 *
	 * @return the number of order infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrderInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OrderInfoPersistence, OrderInfoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OrderInfoPersistence.class);

		ServiceTracker<OrderInfoPersistence, OrderInfoPersistence>
			serviceTracker =
				new ServiceTracker<OrderInfoPersistence, OrderInfoPersistence>(
					bundle.getBundleContext(), OrderInfoPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}