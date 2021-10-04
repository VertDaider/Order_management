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

import com.serious.orders.exception.NoSuchOrderInfoException;
import com.serious.orders.model.OrderInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the order info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderInfoUtil
 * @generated
 */
@ProviderType
public interface OrderInfoPersistence extends BasePersistence<OrderInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrderInfoUtil} to access the order info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the order info where orderid = &#63; or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param orderid the orderid
	 * @return the matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public OrderInfo findByOrderid(long orderid)
		throws NoSuchOrderInfoException;

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orderid the orderid
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public OrderInfo fetchByOrderid(long orderid);

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orderid the orderid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public OrderInfo fetchByOrderid(long orderid, boolean useFinderCache);

	/**
	 * Removes the order info where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 * @return the order info that was removed
	 */
	public OrderInfo removeByOrderid(long orderid)
		throws NoSuchOrderInfoException;

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	public int countByOrderid(long orderid);

	/**
	 * Returns all the order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the matching order infos
	 */
	public java.util.List<OrderInfo> findByOrder(long orderid);

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
	public java.util.List<OrderInfo> findByOrder(
		long orderid, int start, int end);

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
	public java.util.List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator);

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
	public java.util.List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public OrderInfo findByOrder_First(
			long orderid,
			com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
				orderByComparator)
		throws NoSuchOrderInfoException;

	/**
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public OrderInfo fetchByOrder_First(
		long orderid,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator);

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	public OrderInfo findByOrder_Last(
			long orderid,
			com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
				orderByComparator)
		throws NoSuchOrderInfoException;

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info, or <code>null</code> if a matching order info could not be found
	 */
	public OrderInfo fetchByOrder_Last(
		long orderid,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator);

	/**
	 * Returns the order infos before and after the current order info in the ordered set where orderid = &#63;.
	 *
	 * @param id the primary key of the current order info
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public OrderInfo[] findByOrder_PrevAndNext(
			long id, long orderid,
			com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
				orderByComparator)
		throws NoSuchOrderInfoException;

	/**
	 * Removes all the order infos where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 */
	public void removeByOrder(long orderid);

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	public int countByOrder(long orderid);

	/**
	 * Caches the order info in the entity cache if it is enabled.
	 *
	 * @param orderInfo the order info
	 */
	public void cacheResult(OrderInfo orderInfo);

	/**
	 * Caches the order infos in the entity cache if it is enabled.
	 *
	 * @param orderInfos the order infos
	 */
	public void cacheResult(java.util.List<OrderInfo> orderInfos);

	/**
	 * Creates a new order info with the primary key. Does not add the order info to the database.
	 *
	 * @param id the primary key for the new order info
	 * @return the new order info
	 */
	public OrderInfo create(long id);

	/**
	 * Removes the order info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order info
	 * @return the order info that was removed
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public OrderInfo remove(long id) throws NoSuchOrderInfoException;

	public OrderInfo updateImpl(OrderInfo orderInfo);

	/**
	 * Returns the order info with the primary key or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	public OrderInfo findByPrimaryKey(long id) throws NoSuchOrderInfoException;

	/**
	 * Returns the order info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info, or <code>null</code> if a order info with the primary key could not be found
	 */
	public OrderInfo fetchByPrimaryKey(long id);

	/**
	 * Returns all the order infos.
	 *
	 * @return the order infos
	 */
	public java.util.List<OrderInfo> findAll();

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
	public java.util.List<OrderInfo> findAll(int start, int end);

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
	public java.util.List<OrderInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator);

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
	public java.util.List<OrderInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrderInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the order infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of order infos.
	 *
	 * @return the number of order infos
	 */
	public int countAll();

}