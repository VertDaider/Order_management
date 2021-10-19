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

package com.serious.orders.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.serious.orders.exception.NoSuchHoneyException;
import com.serious.orders.model.Honey;
import com.serious.orders.model.impl.HoneyImpl;
import com.serious.orders.model.impl.HoneyModelImpl;
import com.serious.orders.service.persistence.HoneyPersistence;
import com.serious.orders.service.persistence.impl.constants.manager_odrPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the honey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = HoneyPersistence.class)
public class HoneyPersistenceImpl
	extends BasePersistenceImpl<Honey> implements HoneyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HoneyUtil</code> to access the honey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HoneyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching honeys
	 */
	@Override
	public List<Honey> findByType(String type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Honey> findByType(String type, int start, int end) {
		return findByType(type, start, end, null);
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
	@Override
	public List<Honey> findByType(
		String type, int start, int end,
		OrderByComparator<Honey> orderByComparator) {

		return findByType(type, start, end, orderByComparator, true);
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
	@Override
	public List<Honey> findByType(
		String type, int start, int end,
		OrderByComparator<Honey> orderByComparator, boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<Honey> list = null;

		if (useFinderCache) {
			list = (List<Honey>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Honey honey : list) {
					if (!type.equals(honey.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_HONEY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HoneyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<Honey>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	@Override
	public Honey findByType_First(
			String type, OrderByComparator<Honey> orderByComparator)
		throws NoSuchHoneyException {

		Honey honey = fetchByType_First(type, orderByComparator);

		if (honey != null) {
			return honey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchHoneyException(sb.toString());
	}

	/**
	 * Returns the first honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching honey, or <code>null</code> if a matching honey could not be found
	 */
	@Override
	public Honey fetchByType_First(
		String type, OrderByComparator<Honey> orderByComparator) {

		List<Honey> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	@Override
	public Honey findByType_Last(
			String type, OrderByComparator<Honey> orderByComparator)
		throws NoSuchHoneyException {

		Honey honey = fetchByType_Last(type, orderByComparator);

		if (honey != null) {
			return honey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchHoneyException(sb.toString());
	}

	/**
	 * Returns the last honey in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching honey, or <code>null</code> if a matching honey could not be found
	 */
	@Override
	public Honey fetchByType_Last(
		String type, OrderByComparator<Honey> orderByComparator) {

		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<Honey> list = findByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Honey[] findByType_PrevAndNext(
			long id, String type, OrderByComparator<Honey> orderByComparator)
		throws NoSuchHoneyException {

		type = Objects.toString(type, "");

		Honey honey = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Honey[] array = new HoneyImpl[3];

			array[0] = getByType_PrevAndNext(
				session, honey, type, orderByComparator, true);

			array[1] = honey;

			array[2] = getByType_PrevAndNext(
				session, honey, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Honey getByType_PrevAndNext(
		Session session, Honey honey, String type,
		OrderByComparator<Honey> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HONEY_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(HoneyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(honey)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Honey> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the honeys where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(String type) {
		for (Honey honey :
				findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(honey);
		}
	}

	/**
	 * Returns the number of honeys where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching honeys
	 */
	@Override
	public int countByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HONEY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "honey.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(honey.type IS NULL OR honey.type = '')";

	private FinderPath _finderPathFetchByPrice;
	private FinderPath _finderPathCountByPrice;

	/**
	 * Returns the honey where price = &#63; or throws a <code>NoSuchHoneyException</code> if it could not be found.
	 *
	 * @param price the price
	 * @return the matching honey
	 * @throws NoSuchHoneyException if a matching honey could not be found
	 */
	@Override
	public Honey findByPrice(int price) throws NoSuchHoneyException {
		Honey honey = fetchByPrice(price);

		if (honey == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("price=");
			sb.append(price);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHoneyException(sb.toString());
		}

		return honey;
	}

	/**
	 * Returns the honey where price = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param price the price
	 * @return the matching honey, or <code>null</code> if a matching honey could not be found
	 */
	@Override
	public Honey fetchByPrice(int price) {
		return fetchByPrice(price, true);
	}

	/**
	 * Returns the honey where price = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param price the price
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching honey, or <code>null</code> if a matching honey could not be found
	 */
	@Override
	public Honey fetchByPrice(int price, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {price};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPrice, finderArgs, this);
		}

		if (result instanceof Honey) {
			Honey honey = (Honey)result;

			if (price != honey.getPrice()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_HONEY_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

				List<Honey> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPrice, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {price};
							}

							_log.warn(
								"HoneyPersistenceImpl.fetchByPrice(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Honey honey = list.get(0);

					result = honey;

					cacheResult(honey);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Honey)result;
		}
	}

	/**
	 * Removes the honey where price = &#63; from the database.
	 *
	 * @param price the price
	 * @return the honey that was removed
	 */
	@Override
	public Honey removeByPrice(int price) throws NoSuchHoneyException {
		Honey honey = findByPrice(price);

		return remove(honey);
	}

	/**
	 * Returns the number of honeys where price = &#63;.
	 *
	 * @param price the price
	 * @return the number of matching honeys
	 */
	@Override
	public int countByPrice(int price) {
		FinderPath finderPath = _finderPathCountByPrice;

		Object[] finderArgs = new Object[] {price};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HONEY_WHERE);

			sb.append(_FINDER_COLUMN_PRICE_PRICE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(price);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRICE_PRICE_2 =
		"honey.price = ?";

	public HoneyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Honey.class);

		setModelImplClass(HoneyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the honey in the entity cache if it is enabled.
	 *
	 * @param honey the honey
	 */
	@Override
	public void cacheResult(Honey honey) {
		entityCache.putResult(HoneyImpl.class, honey.getPrimaryKey(), honey);

		finderCache.putResult(
			_finderPathFetchByPrice, new Object[] {honey.getPrice()}, honey);
	}

	/**
	 * Caches the honeys in the entity cache if it is enabled.
	 *
	 * @param honeys the honeys
	 */
	@Override
	public void cacheResult(List<Honey> honeys) {
		for (Honey honey : honeys) {
			if (entityCache.getResult(HoneyImpl.class, honey.getPrimaryKey()) ==
					null) {

				cacheResult(honey);
			}
		}
	}

	/**
	 * Clears the cache for all honeys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HoneyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the honey.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Honey honey) {
		entityCache.removeResult(HoneyImpl.class, honey);
	}

	@Override
	public void clearCache(List<Honey> honeys) {
		for (Honey honey : honeys) {
			entityCache.removeResult(HoneyImpl.class, honey);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HoneyImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(HoneyModelImpl honeyModelImpl) {
		Object[] args = new Object[] {honeyModelImpl.getPrice()};

		finderCache.putResult(
			_finderPathCountByPrice, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPrice, args, honeyModelImpl, false);
	}

	/**
	 * Creates a new honey with the primary key. Does not add the honey to the database.
	 *
	 * @param id the primary key for the new honey
	 * @return the new honey
	 */
	@Override
	public Honey create(long id) {
		Honey honey = new HoneyImpl();

		honey.setNew(true);
		honey.setPrimaryKey(id);

		return honey;
	}

	/**
	 * Removes the honey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the honey
	 * @return the honey that was removed
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	@Override
	public Honey remove(long id) throws NoSuchHoneyException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the honey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the honey
	 * @return the honey that was removed
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	@Override
	public Honey remove(Serializable primaryKey) throws NoSuchHoneyException {
		Session session = null;

		try {
			session = openSession();

			Honey honey = (Honey)session.get(HoneyImpl.class, primaryKey);

			if (honey == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoneyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(honey);
		}
		catch (NoSuchHoneyException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Honey removeImpl(Honey honey) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(honey)) {
				honey = (Honey)session.get(
					HoneyImpl.class, honey.getPrimaryKeyObj());
			}

			if (honey != null) {
				session.delete(honey);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (honey != null) {
			clearCache(honey);
		}

		return honey;
	}

	@Override
	public Honey updateImpl(Honey honey) {
		boolean isNew = honey.isNew();

		if (!(honey instanceof HoneyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(honey.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(honey);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in honey proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Honey implementation " +
					honey.getClass());
		}

		HoneyModelImpl honeyModelImpl = (HoneyModelImpl)honey;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(honey);
			}
			else {
				honey = (Honey)session.merge(honey);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HoneyImpl.class, honeyModelImpl, false, true);

		cacheUniqueFindersCache(honeyModelImpl);

		if (isNew) {
			honey.setNew(false);
		}

		honey.resetOriginalValues();

		return honey;
	}

	/**
	 * Returns the honey with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the honey
	 * @return the honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	@Override
	public Honey findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHoneyException {

		Honey honey = fetchByPrimaryKey(primaryKey);

		if (honey == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHoneyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return honey;
	}

	/**
	 * Returns the honey with the primary key or throws a <code>NoSuchHoneyException</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey
	 * @throws NoSuchHoneyException if a honey with the primary key could not be found
	 */
	@Override
	public Honey findByPrimaryKey(long id) throws NoSuchHoneyException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the honey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the honey
	 * @return the honey, or <code>null</code> if a honey with the primary key could not be found
	 */
	@Override
	public Honey fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the honeys.
	 *
	 * @return the honeys
	 */
	@Override
	public List<Honey> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Honey> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Honey> findAll(
		int start, int end, OrderByComparator<Honey> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Honey> findAll(
		int start, int end, OrderByComparator<Honey> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Honey> list = null;

		if (useFinderCache) {
			list = (List<Honey>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HONEY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HONEY;

				sql = sql.concat(HoneyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Honey>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the honeys from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Honey honey : findAll()) {
			remove(honey);
		}
	}

	/**
	 * Returns the number of honeys.
	 *
	 * @return the number of honeys
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HONEY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HONEY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HoneyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the honey persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HoneyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Honey.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		_finderPathFetchByPrice = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPrice",
			new String[] {Integer.class.getName()}, new String[] {"price"},
			true);

		_finderPathCountByPrice = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrice",
			new String[] {Integer.class.getName()}, new String[] {"price"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(HoneyImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = manager_odrPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = manager_odrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = manager_odrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HONEY =
		"SELECT honey FROM Honey honey";

	private static final String _SQL_SELECT_HONEY_WHERE =
		"SELECT honey FROM Honey honey WHERE ";

	private static final String _SQL_COUNT_HONEY =
		"SELECT COUNT(honey) FROM Honey honey";

	private static final String _SQL_COUNT_HONEY_WHERE =
		"SELECT COUNT(honey) FROM Honey honey WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "honey.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Honey exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Honey exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HoneyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class HoneyModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			HoneyModelImpl honeyModelImpl = (HoneyModelImpl)baseModel;

			long columnBitmask = honeyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(honeyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= honeyModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(honeyModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HoneyModelImpl honeyModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = honeyModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = honeyModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}