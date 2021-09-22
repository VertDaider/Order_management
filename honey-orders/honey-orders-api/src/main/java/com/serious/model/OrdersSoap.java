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
public class OrdersSoap implements Serializable {

	public static OrdersSoap toSoapModel(Orders model) {
		OrdersSoap soapModel = new OrdersSoap();

		soapModel.setId(model.getId());
		soapModel.setDateOrder(model.getDateOrder());
		soapModel.setCustomer(model.getCustomer());
		soapModel.setOrderinfo(model.getOrderinfo());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static OrdersSoap[] toSoapModels(Orders[] models) {
		OrdersSoap[] soapModels = new OrdersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrdersSoap[][] toSoapModels(Orders[][] models) {
		OrdersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrdersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrdersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrdersSoap[] toSoapModels(List<Orders> models) {
		List<OrdersSoap> soapModels = new ArrayList<OrdersSoap>(models.size());

		for (Orders model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrdersSoap[soapModels.size()]);
	}

	public OrdersSoap() {
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

	public long getOrderinfo() {
		return _orderinfo;
	}

	public void setOrderinfo(long orderinfo) {
		_orderinfo = orderinfo;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _id;
	private Date _dateOrder;
	private String _customer;
	private long _orderinfo;
	private int _status;

}