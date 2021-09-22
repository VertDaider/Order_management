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

package com.serious.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Orders}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Orders
 * @generated
 */
public class OrdersWrapper
	extends BaseModelWrapper<Orders> implements ModelWrapper<Orders>, Orders {

	public OrdersWrapper(Orders orders) {
		super(orders);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("dateOrder", getDateOrder());
		attributes.put("customer", getCustomer());
		attributes.put("orderinfo", getOrderinfo());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date dateOrder = (Date)attributes.get("dateOrder");

		if (dateOrder != null) {
			setDateOrder(dateOrder);
		}

		String customer = (String)attributes.get("customer");

		if (customer != null) {
			setCustomer(customer);
		}

		Long orderinfo = (Long)attributes.get("orderinfo");

		if (orderinfo != null) {
			setOrderinfo(orderinfo);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the customer of this orders.
	 *
	 * @return the customer of this orders
	 */
	@Override
	public String getCustomer() {
		return model.getCustomer();
	}

	/**
	 * Returns the date order of this orders.
	 *
	 * @return the date order of this orders
	 */
	@Override
	public Date getDateOrder() {
		return model.getDateOrder();
	}

	/**
	 * Returns the ID of this orders.
	 *
	 * @return the ID of this orders
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the orderinfo of this orders.
	 *
	 * @return the orderinfo of this orders
	 */
	@Override
	public long getOrderinfo() {
		return model.getOrderinfo();
	}

	/**
	 * Returns the primary key of this orders.
	 *
	 * @return the primary key of this orders
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this orders.
	 *
	 * @return the status of this orders
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the customer of this orders.
	 *
	 * @param customer the customer of this orders
	 */
	@Override
	public void setCustomer(String customer) {
		model.setCustomer(customer);
	}

	/**
	 * Sets the date order of this orders.
	 *
	 * @param dateOrder the date order of this orders
	 */
	@Override
	public void setDateOrder(Date dateOrder) {
		model.setDateOrder(dateOrder);
	}

	/**
	 * Sets the ID of this orders.
	 *
	 * @param id the ID of this orders
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the orderinfo of this orders.
	 *
	 * @param orderinfo the orderinfo of this orders
	 */
	@Override
	public void setOrderinfo(long orderinfo) {
		model.setOrderinfo(orderinfo);
	}

	/**
	 * Sets the primary key of this orders.
	 *
	 * @param primaryKey the primary key of this orders
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this orders.
	 *
	 * @param status the status of this orders
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected OrdersWrapper wrap(Orders orders) {
		return new OrdersWrapper(orders);
	}

}