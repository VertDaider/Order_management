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

package com.serious.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.serious.model.Orders;
import com.serious.model.OrdersModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Orders service. Represents a row in the &quot;my_orders_Orders&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>OrdersModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OrdersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrdersImpl
 * @generated
 */
public class OrdersModelImpl
	extends BaseModelImpl<Orders> implements OrdersModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a orders model instance should use the <code>Orders</code> interface instead.
	 */
	public static final String TABLE_NAME = "my_orders_Orders";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"dateOrder", Types.TIMESTAMP},
		{"customer", Types.VARCHAR}, {"orderinfo", Types.BIGINT},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dateOrder", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("customer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("orderinfo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table my_orders_Orders (id_ LONG not null primary key,dateOrder DATE null,customer VARCHAR(75) null,orderinfo LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table my_orders_Orders";

	public static final String ORDER_BY_JPQL =
		" ORDER BY orders.dateOrder DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY my_orders_Orders.dateOrder DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DATEORDER_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public OrdersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Orders.class;
	}

	@Override
	public String getModelClassName() {
		return Orders.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Orders, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Orders, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Orders, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Orders)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Orders, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Orders, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Orders)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Orders, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Orders, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Orders>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Orders.class.getClassLoader(), Orders.class, ModelWrapper.class);

		try {
			Constructor<Orders> constructor =
				(Constructor<Orders>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Orders, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Orders, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Orders, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Orders, Object>>();
		Map<String, BiConsumer<Orders, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Orders, ?>>();

		attributeGetterFunctions.put("id", Orders::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Orders, Long>)Orders::setId);
		attributeGetterFunctions.put("dateOrder", Orders::getDateOrder);
		attributeSetterBiConsumers.put(
			"dateOrder", (BiConsumer<Orders, Date>)Orders::setDateOrder);
		attributeGetterFunctions.put("customer", Orders::getCustomer);
		attributeSetterBiConsumers.put(
			"customer", (BiConsumer<Orders, String>)Orders::setCustomer);
		attributeGetterFunctions.put("orderinfo", Orders::getOrderinfo);
		attributeSetterBiConsumers.put(
			"orderinfo", (BiConsumer<Orders, Long>)Orders::setOrderinfo);
		attributeGetterFunctions.put("status", Orders::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Orders, Integer>)Orders::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@Override
	public Date getDateOrder() {
		return _dateOrder;
	}

	@Override
	public void setDateOrder(Date dateOrder) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dateOrder = dateOrder;
	}

	@Override
	public String getCustomer() {
		if (_customer == null) {
			return "";
		}
		else {
			return _customer;
		}
	}

	@Override
	public void setCustomer(String customer) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_customer = customer;
	}

	@Override
	public long getOrderinfo() {
		return _orderinfo;
	}

	@Override
	public void setOrderinfo(long orderinfo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_orderinfo = orderinfo;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Orders.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Orders toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Orders>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OrdersImpl ordersImpl = new OrdersImpl();

		ordersImpl.setId(getId());
		ordersImpl.setDateOrder(getDateOrder());
		ordersImpl.setCustomer(getCustomer());
		ordersImpl.setOrderinfo(getOrderinfo());
		ordersImpl.setStatus(getStatus());

		ordersImpl.resetOriginalValues();

		return ordersImpl;
	}

	@Override
	public int compareTo(Orders orders) {
		int value = 0;

		value = DateUtil.compareTo(getDateOrder(), orders.getDateOrder());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Orders)) {
			return false;
		}

		Orders orders = (Orders)object;

		long primaryKey = orders.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Orders> toCacheModel() {
		OrdersCacheModel ordersCacheModel = new OrdersCacheModel();

		ordersCacheModel.id = getId();

		Date dateOrder = getDateOrder();

		if (dateOrder != null) {
			ordersCacheModel.dateOrder = dateOrder.getTime();
		}
		else {
			ordersCacheModel.dateOrder = Long.MIN_VALUE;
		}

		ordersCacheModel.customer = getCustomer();

		String customer = ordersCacheModel.customer;

		if ((customer != null) && (customer.length() == 0)) {
			ordersCacheModel.customer = null;
		}

		ordersCacheModel.orderinfo = getOrderinfo();

		ordersCacheModel.status = getStatus();

		return ordersCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Orders, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Orders, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Orders, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Orders)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Orders, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Orders, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Orders, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Orders)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Orders>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _id;
	private Date _dateOrder;
	private String _customer;
	private long _orderinfo;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Orders, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Orders)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("dateOrder", _dateOrder);
		_columnOriginalValues.put("customer", _customer);
		_columnOriginalValues.put("orderinfo", _orderinfo);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("id_", 1L);

		columnBitmasks.put("dateOrder", 2L);

		columnBitmasks.put("customer", 4L);

		columnBitmasks.put("orderinfo", 8L);

		columnBitmasks.put("status", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Orders _escapedModel;

}