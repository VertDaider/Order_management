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

import com.serious.orders.exception.NoSuchHoneyException;
import com.serious.orders.model.Honey;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the honey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HoneyUtil
 * @generated
 */
@ProviderType
public interface HoneyPersistence extends BasePersistence<Honey> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoneyUtil} to access the honey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching honeys
	 */
	public java.util.List<Honey> findBytype(String type);

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
	public java.util.List<Honey> findBytype(String type, int start, int end);

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
	public java.util.List<Honey> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

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
	public java.util.List<Honey> findBytype(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public Honey findBytype_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public Honey fetchBytype_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public Honey findBytype_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public Honey fetchBytype_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

	/**
	 * Returns the honeys before and after the current honey in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current honey
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public Honey[] findBytype_PrevAndNext(
			long id, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Removes all the honeys where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeBytype(String type);

	/**
	 * Returns the number of honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching honeys
	 */
	public int countBytype(String type);

	/**
	 * Returns all the honeys where price = &#63;.
	 *
	 * @param price the price
	 * @return the matching honeys
	 */
	public java.util.List<Honey> findByprice(int price);

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
	public java.util.List<Honey> findByprice(int price, int start, int end);

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
	public java.util.List<Honey> findByprice(
		int price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

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
	public java.util.List<Honey> findByprice(
		int price, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public Honey findByprice_First(
			int price,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Returns the first honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public Honey fetchByprice_First(
		int price,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

	/**
	 * Returns the last honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	public Honey findByprice_Last(
			int price,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Returns the last honey in the ordered set where price = &#63;.
	 *
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey, or <code>null</code> if a matching honey could not be found
	 */
	public Honey fetchByprice_Last(
		int price,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

	/**
	 * Returns the honeys before and after the current honey in the ordered set where price = &#63;.
	 *
	 * @param id the primary key of the current honey
	 * @param price the price
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public Honey[] findByprice_PrevAndNext(
			long id, int price,
			com.liferay.portal.kernel.util.OrderByComparator<Honey>
				orderByComparator)
		throws NoSuchHoneyException;

	/**
	 * Removes all the honeys where price = &#63; from the database.
	 *
	 * @param price the price
	 */
	public void removeByprice(int price);

	/**
	 * Returns the number of honeys where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching honeys
	 */
	public int countByprice(int price);

	/**
	 * Caches the honey in the entity cache if it is enabled.
	 *
	 * @param honey the honey
	 */
	public void cacheResult(Honey honey);

	/**
	 * Caches the honeys in the entity cache if it is enabled.
	 *
	 * @param honeys the honeys
	 */
	public void cacheResult(java.util.List<Honey> honeys);

	/**
	 * Creates a new honey with the primary key. Does not add the honey to the database.
	 *
	 * @param id the primary key for the new honey
	 * @return the new honey
	 */
	public Honey create(long id);

	/**
	 * Removes the honey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the honey
	 * @return the honey that was removed
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public Honey remove(long id) throws NoSuchHoneyException;

	public Honey updateImpl(Honey honey);

	/**
	 * Returns the honey with the primary key or throws a <code>NoSuchHoneyException</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	public Honey findByPrimaryKey(long id) throws NoSuchHoneyException;

	/**
	 * Returns the honey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey, or <code>null</code> if a honey with the primary key could not be found
	 */
	public Honey fetchByPrimaryKey(long id);

	/**
	 * Returns all the honeys.
	 *
	 * @return the honeys
	 */
	public java.util.List<Honey> findAll();

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
	public java.util.List<Honey> findAll(int start, int end);

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
	public java.util.List<Honey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator);

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
	public java.util.List<Honey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Honey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the honeys from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of honeys.
	 *
	 * @return the number of honeys
	 */
	public int countAll();

}