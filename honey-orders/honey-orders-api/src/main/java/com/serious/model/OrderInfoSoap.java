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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrderInfoSoap implements Serializable {

	public static OrderInfoSoap toSoapModel(OrderInfo model) {
		OrderInfoSoap soapModel = new OrderInfoSoap();

		soapModel.setId(model.getId());
		soapModel.setType(model.getType());
		soapModel.setAmount(model.getAmount());

		return soapModel;
	}

	public static OrderInfoSoap[] toSoapModels(OrderInfo[] models) {
		OrderInfoSoap[] soapModels = new OrderInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrderInfoSoap[][] toSoapModels(OrderInfo[][] models) {
		OrderInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrderInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrderInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrderInfoSoap[] toSoapModels(List<OrderInfo> models) {
		List<OrderInfoSoap> soapModels = new ArrayList<OrderInfoSoap>(
			models.size());

		for (OrderInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrderInfoSoap[soapModels.size()]);
	}

	public OrderInfoSoap() {
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

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		_amount = amount;
	}

	private long _id;
	private long _type;
	private int _amount;

}