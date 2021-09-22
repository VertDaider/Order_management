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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.serious.exception.NoSuchOrdersException;
import com.serious.model.Orders;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the orders service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrdersUtil
 * @generated
 */
@ProviderType
public interface OrdersPersistence extends BasePersistence<Orders> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrdersUtil} to access the orders persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the orders in the entity cache if it is enabled.
	 *
	 * @param orders the orders
	 */
	public void cacheResult(Orders orders);

	/**
	 * Caches the orderses in the entity cache if it is enabled.
	 *
	 * @param orderses the orderses
	 */
	public void cacheResult(java.util.List<Orders> orderses);

	/**
	 * Creates a new orders with the primary key. Does not add the orders to the database.
	 *
	 * @param id the primary key for the new orders
	 * @return the new orders
	 */
	public Orders create(long id);

	/**
	 * Removes the orders with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the orders
	 * @return the orders that was removed
	 * @throws NoSuchOrdersException if a orders with the primary key could not be found
	 */
	public Orders remove(long id) throws NoSuchOrdersException;

	public Orders updateImpl(Orders orders);

	/**
	 * Returns the orders with the primary key or throws a <code>NoSuchOrdersException</code> if it could not be found.
	 *
	 * @param id the primary key of the orders
	 * @return the orders
	 * @throws NoSuchOrdersException if a orders with the primary key could not be found
	 */
	public Orders findByPrimaryKey(long id) throws NoSuchOrdersException;

	/**
	 * Returns the orders with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the orders
	 * @return the orders, or <code>null</code> if a orders with the primary key could not be found
	 */
	public Orders fetchByPrimaryKey(long id);

	/**
	 * Returns all the orderses.
	 *
	 * @return the orderses
	 */
	public java.util.List<Orders> findAll();

	/**
	 * Returns a range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @return the range of orderses
	 */
	public java.util.List<Orders> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of orderses
	 */
	public java.util.List<Orders> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Orders>
			orderByComparator);

	/**
	 * Returns an ordered range of all the orderses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrdersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of orderses
	 * @param end the upper bound of the range of orderses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of orderses
	 */
	public java.util.List<Orders> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Orders>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the orderses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of orderses.
	 *
	 * @return the number of orderses
	 */
	public int countAll();

}