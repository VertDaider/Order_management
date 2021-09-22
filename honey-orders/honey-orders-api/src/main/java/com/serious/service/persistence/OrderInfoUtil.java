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

package com.serious.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.serious.model.OrderInfo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the order info service. This utility wraps <code>com.serious.service.persistence.impl.OrderInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
		throws com.serious.exception.NoSuchOrderInfoException {

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
		throws com.serious.exception.NoSuchOrderInfoException {

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