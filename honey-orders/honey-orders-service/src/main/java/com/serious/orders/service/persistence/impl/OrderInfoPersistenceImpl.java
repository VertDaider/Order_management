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

import com.serious.orders.exception.NoSuchOrderInfoException;
import com.serious.orders.model.OrderInfo;
import com.serious.orders.model.impl.OrderInfoImpl;
import com.serious.orders.model.impl.OrderInfoModelImpl;
import com.serious.orders.service.persistence.OrderInfoPersistence;
import com.serious.orders.service.persistence.impl.constants.manager_odrPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the order info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OrderInfoPersistence.class)
public class OrderInfoPersistenceImpl
	extends BasePersistenceImpl<OrderInfo> implements OrderInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OrderInfoUtil</code> to access the order info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OrderInfoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByOrderid;
	private FinderPath _finderPathCountByOrderid;

	/**
	 * Returns the order info where orderid = &#63; or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param orderid the orderid
	 * @return the matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	@Override
	public OrderInfo findByOrderid(long orderid)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = fetchByOrderid(orderid);

		if (orderInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("orderid=");
			sb.append(orderid);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOrderInfoException(sb.toString());
		}

		return orderInfo;
	}

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orderid the orderid
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	@Override
	public OrderInfo fetchByOrderid(long orderid) {
		return fetchByOrderid(orderid, true);
	}

	/**
	 * Returns the order info where orderid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orderid the orderid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching order info, or <code>null</code> if a matching order info could not be found
	 */
	@Override
	public OrderInfo fetchByOrderid(long orderid, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {orderid};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByOrderid, finderArgs, this);
		}

		if (result instanceof OrderInfo) {
			OrderInfo orderInfo = (OrderInfo)result;

			if (orderid != orderInfo.getOrderid()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ORDERINFO_WHERE);

			sb.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderid);

				List<OrderInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByOrderid, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {orderid};
							}

							_log.warn(
								"OrderInfoPersistenceImpl.fetchByOrderid(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					OrderInfo orderInfo = list.get(0);

					result = orderInfo;

					cacheResult(orderInfo);
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
			return (OrderInfo)result;
		}
	}

	/**
	 * Removes the order info where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 * @return the order info that was removed
	 */
	@Override
	public OrderInfo removeByOrderid(long orderid)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = findByOrderid(orderid);

		return remove(orderInfo);
	}

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	@Override
	public int countByOrderid(long orderid) {
		FinderPath finderPath = _finderPathCountByOrderid;

		Object[] finderArgs = new Object[] {orderid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORDERINFO_WHERE);

			sb.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderid);

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

	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 =
		"orderInfo.orderid = ?";

	private FinderPath _finderPathWithPaginationFindByOrder;
	private FinderPath _finderPathWithoutPaginationFindByOrder;
	private FinderPath _finderPathCountByOrder;

	/**
	 * Returns all the order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the matching order infos
	 */
	@Override
	public List<OrderInfo> findByOrder(long orderid) {
		return findByOrder(orderid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OrderInfo> findByOrder(long orderid, int start, int end) {
		return findByOrder(orderid, start, end, null);
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
	@Override
	public List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		OrderByComparator<OrderInfo> orderByComparator) {

		return findByOrder(orderid, start, end, orderByComparator, true);
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
	@Override
	public List<OrderInfo> findByOrder(
		long orderid, int start, int end,
		OrderByComparator<OrderInfo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrder;
				finderArgs = new Object[] {orderid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrder;
			finderArgs = new Object[] {orderid, start, end, orderByComparator};
		}

		List<OrderInfo> list = null;

		if (useFinderCache) {
			list = (List<OrderInfo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OrderInfo orderInfo : list) {
					if (orderid != orderInfo.getOrderid()) {
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

			sb.append(_SQL_SELECT_ORDERINFO_WHERE);

			sb.append(_FINDER_COLUMN_ORDER_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OrderInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderid);

				list = (List<OrderInfo>)QueryUtil.list(
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
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	@Override
	public OrderInfo findByOrder_First(
			long orderid, OrderByComparator<OrderInfo> orderByComparator)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = fetchByOrder_First(orderid, orderByComparator);

		if (orderInfo != null) {
			return orderInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderid=");
		sb.append(orderid);

		sb.append("}");

		throw new NoSuchOrderInfoException(sb.toString());
	}

	/**
	 * Returns the first order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching order info, or <code>null</code> if a matching order info could not be found
	 */
	@Override
	public OrderInfo fetchByOrder_First(
		long orderid, OrderByComparator<OrderInfo> orderByComparator) {

		List<OrderInfo> list = findByOrder(orderid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info
	 * @throws NoSuchOrderInfoException if a matching order info could not be found
	 */
	@Override
	public OrderInfo findByOrder_Last(
			long orderid, OrderByComparator<OrderInfo> orderByComparator)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = fetchByOrder_Last(orderid, orderByComparator);

		if (orderInfo != null) {
			return orderInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("orderid=");
		sb.append(orderid);

		sb.append("}");

		throw new NoSuchOrderInfoException(sb.toString());
	}

	/**
	 * Returns the last order info in the ordered set where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching order info, or <code>null</code> if a matching order info could not be found
	 */
	@Override
	public OrderInfo fetchByOrder_Last(
		long orderid, OrderByComparator<OrderInfo> orderByComparator) {

		int count = countByOrder(orderid);

		if (count == 0) {
			return null;
		}

		List<OrderInfo> list = findByOrder(
			orderid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OrderInfo[] findByOrder_PrevAndNext(
			long id, long orderid,
			OrderByComparator<OrderInfo> orderByComparator)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			OrderInfo[] array = new OrderInfoImpl[3];

			array[0] = getByOrder_PrevAndNext(
				session, orderInfo, orderid, orderByComparator, true);

			array[1] = orderInfo;

			array[2] = getByOrder_PrevAndNext(
				session, orderInfo, orderid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OrderInfo getByOrder_PrevAndNext(
		Session session, OrderInfo orderInfo, long orderid,
		OrderByComparator<OrderInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ORDERINFO_WHERE);

		sb.append(_FINDER_COLUMN_ORDER_ORDERID_2);

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
			sb.append(OrderInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(orderid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(orderInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OrderInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the order infos where orderid = &#63; from the database.
	 *
	 * @param orderid the orderid
	 */
	@Override
	public void removeByOrder(long orderid) {
		for (OrderInfo orderInfo :
				findByOrder(
					orderid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(orderInfo);
		}
	}

	/**
	 * Returns the number of order infos where orderid = &#63;.
	 *
	 * @param orderid the orderid
	 * @return the number of matching order infos
	 */
	@Override
	public int countByOrder(long orderid) {
		FinderPath finderPath = _finderPathCountByOrder;

		Object[] finderArgs = new Object[] {orderid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ORDERINFO_WHERE);

			sb.append(_FINDER_COLUMN_ORDER_ORDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(orderid);

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

	private static final String _FINDER_COLUMN_ORDER_ORDERID_2 =
		"orderInfo.orderid = ?";

	public OrderInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(OrderInfo.class);

		setModelImplClass(OrderInfoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the order info in the entity cache if it is enabled.
	 *
	 * @param orderInfo the order info
	 */
	@Override
	public void cacheResult(OrderInfo orderInfo) {
		entityCache.putResult(
			OrderInfoImpl.class, orderInfo.getPrimaryKey(), orderInfo);

		finderCache.putResult(
			_finderPathFetchByOrderid, new Object[] {orderInfo.getOrderid()},
			orderInfo);
	}

	/**
	 * Caches the order infos in the entity cache if it is enabled.
	 *
	 * @param orderInfos the order infos
	 */
	@Override
	public void cacheResult(List<OrderInfo> orderInfos) {
		for (OrderInfo orderInfo : orderInfos) {
			if (entityCache.getResult(
					OrderInfoImpl.class, orderInfo.getPrimaryKey()) == null) {

				cacheResult(orderInfo);
			}
		}
	}

	/**
	 * Clears the cache for all order infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OrderInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the order info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrderInfo orderInfo) {
		entityCache.removeResult(OrderInfoImpl.class, orderInfo);
	}

	@Override
	public void clearCache(List<OrderInfo> orderInfos) {
		for (OrderInfo orderInfo : orderInfos) {
			entityCache.removeResult(OrderInfoImpl.class, orderInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OrderInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OrderInfoModelImpl orderInfoModelImpl) {

		Object[] args = new Object[] {orderInfoModelImpl.getOrderid()};

		finderCache.putResult(
			_finderPathCountByOrderid, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOrderid, args, orderInfoModelImpl, false);
	}

	/**
	 * Creates a new order info with the primary key. Does not add the order info to the database.
	 *
	 * @param id the primary key for the new order info
	 * @return the new order info
	 */
	@Override
	public OrderInfo create(long id) {
		OrderInfo orderInfo = new OrderInfoImpl();

		orderInfo.setNew(true);
		orderInfo.setPrimaryKey(id);

		return orderInfo;
	}

	/**
	 * Removes the order info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the order info
	 * @return the order info that was removed
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	@Override
	public OrderInfo remove(long id) throws NoSuchOrderInfoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the order info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the order info
	 * @return the order info that was removed
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	@Override
	public OrderInfo remove(Serializable primaryKey)
		throws NoSuchOrderInfoException {

		Session session = null;

		try {
			session = openSession();

			OrderInfo orderInfo = (OrderInfo)session.get(
				OrderInfoImpl.class, primaryKey);

			if (orderInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(orderInfo);
		}
		catch (NoSuchOrderInfoException noSuchEntityException) {
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
	protected OrderInfo removeImpl(OrderInfo orderInfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orderInfo)) {
				orderInfo = (OrderInfo)session.get(
					OrderInfoImpl.class, orderInfo.getPrimaryKeyObj());
			}

			if (orderInfo != null) {
				session.delete(orderInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (orderInfo != null) {
			clearCache(orderInfo);
		}

		return orderInfo;
	}

	@Override
	public OrderInfo updateImpl(OrderInfo orderInfo) {
		boolean isNew = orderInfo.isNew();

		if (!(orderInfo instanceof OrderInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(orderInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(orderInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in orderInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OrderInfo implementation " +
					orderInfo.getClass());
		}

		OrderInfoModelImpl orderInfoModelImpl = (OrderInfoModelImpl)orderInfo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(orderInfo);
			}
			else {
				orderInfo = (OrderInfo)session.merge(orderInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OrderInfoImpl.class, orderInfoModelImpl, false, true);

		cacheUniqueFindersCache(orderInfoModelImpl);

		if (isNew) {
			orderInfo.setNew(false);
		}

		orderInfo.resetOriginalValues();

		return orderInfo;
	}

	/**
	 * Returns the order info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the order info
	 * @return the order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	@Override
	public OrderInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrderInfoException {

		OrderInfo orderInfo = fetchByPrimaryKey(primaryKey);

		if (orderInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrderInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return orderInfo;
	}

	/**
	 * Returns the order info with the primary key or throws a <code>NoSuchOrderInfoException</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info
	 * @throws NoSuchOrderInfoException if a order info with the primary key could not be found
	 */
	@Override
	public OrderInfo findByPrimaryKey(long id) throws NoSuchOrderInfoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the order info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the order info
	 * @return the order info, or <code>null</code> if a order info with the primary key could not be found
	 */
	@Override
	public OrderInfo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the order infos.
	 *
	 * @return the order infos
	 */
	@Override
	public List<OrderInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OrderInfo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<OrderInfo> findAll(
		int start, int end, OrderByComparator<OrderInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<OrderInfo> findAll(
		int start, int end, OrderByComparator<OrderInfo> orderByComparator,
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

		List<OrderInfo> list = null;

		if (useFinderCache) {
			list = (List<OrderInfo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ORDERINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ORDERINFO;

				sql = sql.concat(OrderInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OrderInfo>)QueryUtil.list(
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
	 * Removes all the order infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OrderInfo orderInfo : findAll()) {
			remove(orderInfo);
		}
	}

	/**
	 * Returns the number of order infos.
	 *
	 * @return the number of order infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ORDERINFO);

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
		return _SQL_SELECT_ORDERINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OrderInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the order info persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new OrderInfoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", OrderInfo.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByOrderid = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByOrderid",
			new String[] {Long.class.getName()}, new String[] {"orderid"},
			true);

		_finderPathCountByOrderid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderid",
			new String[] {Long.class.getName()}, new String[] {"orderid"},
			false);

		_finderPathWithPaginationFindByOrder = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrder",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"orderid"}, true);

		_finderPathWithoutPaginationFindByOrder = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrder",
			new String[] {Long.class.getName()}, new String[] {"orderid"},
			true);

		_finderPathCountByOrder = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrder",
			new String[] {Long.class.getName()}, new String[] {"orderid"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OrderInfoImpl.class.getName());

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

	private static final String _SQL_SELECT_ORDERINFO =
		"SELECT orderInfo FROM OrderInfo orderInfo";

	private static final String _SQL_SELECT_ORDERINFO_WHERE =
		"SELECT orderInfo FROM OrderInfo orderInfo WHERE ";

	private static final String _SQL_COUNT_ORDERINFO =
		"SELECT COUNT(orderInfo) FROM OrderInfo orderInfo";

	private static final String _SQL_COUNT_ORDERINFO_WHERE =
		"SELECT COUNT(orderInfo) FROM OrderInfo orderInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "orderInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OrderInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OrderInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OrderInfoPersistenceImpl.class);

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

	private static class OrderInfoModelArgumentsResolver
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

			OrderInfoModelImpl orderInfoModelImpl =
				(OrderInfoModelImpl)baseModel;

			long columnBitmask = orderInfoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(orderInfoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						orderInfoModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(orderInfoModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			OrderInfoModelImpl orderInfoModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = orderInfoModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = orderInfoModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}