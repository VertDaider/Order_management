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

package com.serious.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrdersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrdersLocalService
 * @generated
 */
public class OrdersLocalServiceWrapper
	implements OrdersLocalService, ServiceWrapper<OrdersLocalService> {

	public OrdersLocalServiceWrapper(OrdersLocalService ordersLocalService) {
		_ordersLocalService = ordersLocalService;
	}

	/**
	 * Adds the orders to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrdersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orders the orders
	 * @return the orders that was added
	 */
	@Override
	public com.serious.model.Orders addOrders(com.serious.model.Orders orders) {
		return _ordersLocalService.addOrders(orders);
	}

	/**
	 * Creates a new orders with the primary key. Does not add the orders to the database.
	 *
	 * @param id the primary key for the new orders
	 * @return the new orders
	 */
	@Override
	public com.serious.model.Orders createOrders(long id) {
		return _ordersLocalService.createOrders(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ordersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrdersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the orders
	 * @return the orders that was removed
	 * @throws PortalException if a orders with the primary key could not be found
	 */
	@Override
	public com.serious.model.Orders deleteOrders(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ordersLocalService.deleteOrders(id);
	}

	/**
	 * Deletes the orders from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrdersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orders the orders
	 * @return the orders that was removed
	 */
	@Override
	public com.serious.model.Orders deleteOrders(
		com.serious.model.Orders orders) {

		return _ordersLocalService.deleteOrders(orders);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ordersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ordersLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ordersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ordersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ordersLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ordersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ordersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.serious.model.Orders fetchOrders(long id) {
		return _ordersLocalService.fetchOrders(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ordersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ordersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the orders with the primary key.
	 *
	 * @param id the primary key of the orders
	 * @return the orders
	 * @throws PortalException if a orders with the primary key could not be found
	 */
	@Override
	public com.serious.model.Orders getOrders(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ordersLocalService.getOrders(id);
	}

	/**
	 * Returns a range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @return the range of orderses
	 */
	@Override
	public java.util.List<com.serious.model.Orders> getOrderses(
		int start, int end) {

		return _ordersLocalService.getOrderses(start, end);
	}

	/**
	 * Returns the number of orderses.
	 *
	 * @return the number of orderses
	 */
	@Override
	public int getOrdersesCount() {
		return _ordersLocalService.getOrdersesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ordersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ordersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the orders in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrdersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orders the orders
	 * @return the orders that was updated
	 */
	@Override
	public com.serious.model.Orders updateOrders(
		com.serious.model.Orders orders) {

		return _ordersLocalService.updateOrders(orders);
	}

	@Override
	public OrdersLocalService getWrappedService() {
		return _ordersLocalService;
	}

	@Override
	public void setWrappedService(OrdersLocalService ordersLocalService) {
		_ordersLocalService = ordersLocalService;
	}

	private OrdersLocalService _ordersLocalService;

}