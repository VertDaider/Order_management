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

package com.serious.orders.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrderInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrderInfoLocalService
 * @generated
 */
public class OrderInfoLocalServiceWrapper
	implements OrderInfoLocalService, ServiceWrapper<OrderInfoLocalService> {

	public OrderInfoLocalServiceWrapper(
		OrderInfoLocalService orderInfoLocalService) {

		_orderInfoLocalService = orderInfoLocalService;
	}

	/**
	 * Adds the order info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderInfo the order info
	 * @return the order info that was added
	 */
	@Override
	public com.serious.orders.model.OrderInfo addOrderInfo(
		com.serious.orders.model.OrderInfo orderInfo) {

		return _orderInfoLocalService.addOrderInfo(orderInfo);
	}

	/**
	 * Creates a new order info with the primary key. Does not add the order info to the database.
	 *
	 * @param id the primary key for the new order info
	 * @return the new order info
	 */
	@Override
	public com.serious.orders.model.OrderInfo createOrderInfo(long id) {
		return _orderInfoLocalService.createOrderInfo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderInfoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the order info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the order info
	 * @return the order info that was removed
	 * @throws PortalException if a order info with the primary key could not be found
	 */
	@Override
	public com.serious.orders.model.OrderInfo deleteOrderInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderInfoLocalService.deleteOrderInfo(id);
	}

	/**
	 * Deletes the order info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderInfo the order info
	 * @return the order info that was removed
	 */
	@Override
	public com.serious.orders.model.OrderInfo deleteOrderInfo(
		com.serious.orders.model.OrderInfo orderInfo) {

		return _orderInfoLocalService.deleteOrderInfo(orderInfo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orderInfoLocalService.dynamicQuery();
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

		return _orderInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.orders.model.impl.OrderInfoModelImpl</code>.
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

		return _orderInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.orders.model.impl.OrderInfoModelImpl</code>.
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

		return _orderInfoLocalService.dynamicQuery(
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

		return _orderInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _orderInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.serious.orders.model.OrderInfo fetchOrderInfo(long id) {
		return _orderInfoLocalService.fetchOrderInfo(id);
	}

	@Override
	public java.util.List<com.serious.orders.model.OrderInfo> findByOrder(
		long orderId) {

		return _orderInfoLocalService.findByOrder(orderId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _orderInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _orderInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the order info with the primary key.
	 *
	 * @param id the primary key of the order info
	 * @return the order info
	 * @throws PortalException if a order info with the primary key could not be found
	 */
	@Override
	public com.serious.orders.model.OrderInfo getOrderInfo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderInfoLocalService.getOrderInfo(id);
	}

	/**
	 * Returns a range of all the order infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.orders.model.impl.OrderInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of order infos
	 * @param end the upper bound of the range of order infos (not inclusive)
	 * @return the range of order infos
	 */
	@Override
	public java.util.List<com.serious.orders.model.OrderInfo> getOrderInfos(
		int start, int end) {

		return _orderInfoLocalService.getOrderInfos(start, end);
	}

	/**
	 * Returns the number of order infos.
	 *
	 * @return the number of order infos
	 */
	@Override
	public int getOrderInfosCount() {
		return _orderInfoLocalService.getOrderInfosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _orderInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _orderInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the order info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrderInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param orderInfo the order info
	 * @return the order info that was updated
	 */
	@Override
	public com.serious.orders.model.OrderInfo updateOrderInfo(
		com.serious.orders.model.OrderInfo orderInfo) {

		return _orderInfoLocalService.updateOrderInfo(orderInfo);
	}

	@Override
	public OrderInfoLocalService getWrappedService() {
		return _orderInfoLocalService;
	}

	@Override
	public void setWrappedService(OrderInfoLocalService orderInfoLocalService) {
		_orderInfoLocalService = orderInfoLocalService;
	}

	private OrderInfoLocalService _orderInfoLocalService;

}