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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrderSoap implements Serializable {

	public static OrderSoap toSoapModel(Order model) {
		OrderSoap soapModel = new OrderSoap();

		soapModel.setId(model.getId());
		soapModel.setDateOrder(model.getDateOrder());
		soapModel.setCustomer(model.getCustomer());
		soapModel.setStatus(model.getStatus());
		soapModel.setAddress(model.getAddress());

		return soapModel;
	}

	public static OrderSoap[] toSoapModels(Order[] models) {
		OrderSoap[] soapModels = new OrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrderSoap[][] toSoapModels(Order[][] models) {
		OrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrderSoap[] toSoapModels(List<Order> models) {
		List<OrderSoap> soapModels = new ArrayList<OrderSoap>(models.size());

		for (Order model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrderSoap[soapModels.size()]);
	}

	public OrderSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Date getDateOrder() {
		return _dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		_dateOrder = dateOrder;
	}

	public String getCustomer() {
		return _customer;
	}

	public void setCustomer(String customer) {
		_customer = customer;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	private long _id;
	private Date _dateOrder;
	private String _customer;
	private int _status;
	private String _address;

}