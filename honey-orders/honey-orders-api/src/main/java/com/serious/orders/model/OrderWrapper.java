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

package com.serious.orders.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Order}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Order
 * @generated
 */
public class OrderWrapper
	extends BaseModelWrapper<Order> implements ModelWrapper<Order>, Order {

	public OrderWrapper(Order order) {
		super(order);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("dateOrder", getDateOrder());
		attributes.put("customer", getCustomer());
		attributes.put("status", getStatus());
		attributes.put("address", getAddress());

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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	/**
	 * Returns the address of this order.
	 *
	 * @return the address of this order
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the customer of this order.
	 *
	 * @return the customer of this order
	 */
	@Override
	public String getCustomer() {
		return model.getCustomer();
	}

	/**
	 * Returns the date order of this order.
	 *
	 * @return the date order of this order
	 */
	@Override
	public Date getDateOrder() {
		return model.getDateOrder();
	}

	/**
	 * Returns the ID of this order.
	 *
	 * @return the ID of this order
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this order.
	 *
	 * @return the primary key of this order
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this order.
	 *
	 * @return the status of this order
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
	 * Sets the address of this order.
	 *
	 * @param address the address of this order
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the customer of this order.
	 *
	 * @param customer the customer of this order
	 */
	@Override
	public void setCustomer(String customer) {
		model.setCustomer(customer);
	}

	/**
	 * Sets the date order of this order.
	 *
	 * @param dateOrder the date order of this order
	 */
	@Override
	public void setDateOrder(Date dateOrder) {
		model.setDateOrder(dateOrder);
	}

	/**
	 * Sets the ID of this order.
	 *
	 * @param id the ID of this order
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this order.
	 *
	 * @param primaryKey the primary key of this order
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this order.
	 *
	 * @param status the status of this order
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected OrderWrapper wrap(Order order) {
		return new OrderWrapper(order);
	}

}