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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HoneySoap implements Serializable {

	public static HoneySoap toSoapModel(Honey model) {
		HoneySoap soapModel = new HoneySoap();

		soapModel.setId(model.getId());
		soapModel.setType(model.getType());
		soapModel.setPrice(model.getPrice());
		soapModel.setStock(model.isStock());

		return soapModel;
	}

	public static HoneySoap[] toSoapModels(Honey[] models) {
		HoneySoap[] soapModels = new HoneySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoneySoap[][] toSoapModels(Honey[][] models) {
		HoneySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoneySoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoneySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoneySoap[] toSoapModels(List<Honey> models) {
		List<HoneySoap> soapModels = new ArrayList<HoneySoap>(models.size());

		for (Honey model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoneySoap[soapModels.size()]);
	}

	public HoneySoap() {
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}

	public boolean getStock() {
		return _stock;
	}

	public boolean isStock() {
		return _stock;
	}

	public void setStock(boolean stock) {
		_stock = stock;
	}

	private long _id;
	private String _type;
	private int _price;
	private boolean _stock;

}