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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.serious.orders.exception.NoSuchOrderException;
import com.serious.orders.model.Order;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderUtil
 * @generated
 */
@ProviderType
public interface OrderPersistence extends BasePersistence<Order> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrderUtil} to access the order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the order in the entity cache if it is enabled.
	 *
	 * @param order the order
	 */
	public void cacheResult(Order order);

	/**
	 * Caches the orders in the entity cache if it is enabled.
	 *
	 * @param orders the orders
	 */
	public void cacheResult(java.util.List<Order> orders);

	/**
	 * Creates a new order with the primary key. Does not add the order to the database.
	 *
	 * @param id the primary key for the new order
	 * @return the new order
	 */
	public Order create(long id);

	/**
	 * Removes the order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order
	 * @return the order that was removed
	 * @throws NoSuchOrderException if a order with the primary key could not be found
	 */
	public Order remove(long id) throws NoSuchOrderException;

	public Order updateImpl(Order order);

	/**
	 * Returns the order with the primary key or throws a <code>NoSuchOrderException</code> if it could not be found.
	 *
	 * @param id the primary key of the order
	 * @return the order
	 * @throws NoSuchOrderException if a order with the primary key could not be found
	 */
	public Order findByPrimaryKey(long id) throws NoSuchOrderException;

	/**
	 * Returns the order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order
	 * @return the order, or <code>null</code> if a order with the primary key could not be found
	 */
	public Order fetchByPrimaryKey(long id);

	/**
	 * Returns all the orders.
	 *
	 * @return the orders
	 */
	public java.util.List<Order> findAll();

	/**
	 * Returns a range of all the orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orders
	 * @param end the upper bound of the range of orders (not inclusive)
	 * @return the range of orders
	 */
	public java.util.List<Order> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orders
	 * @param end the upper bound of the range of orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orders
	 */
	public java.util.List<Order> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Order>
			orderByComparator);

	/**
	 * Returns an ordered range of all the orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orders
	 * @param end the upper bound of the range of orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of orders
	 */
	public java.util.List<Order> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Order>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the orders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of orders.
	 *
	 * @return the number of orders
	 */
	public int countAll();

}