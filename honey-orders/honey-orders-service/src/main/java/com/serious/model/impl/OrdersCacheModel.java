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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.serious.model.Orders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Orders in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrdersCacheModel implements CacheModel<Orders>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrdersCacheModel)) {
			return false;
		}

		OrdersCacheModel ordersCacheModel = (OrdersCacheModel)object;

		if (id == ordersCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", dateOrder=");
		sb.append(dateOrder);
		sb.append(", customer=");
		sb.append(customer);
		sb.append(", orderinfo=");
		sb.append(orderinfo);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Orders toEntityModel() {
		OrdersImpl ordersImpl = new OrdersImpl();

		ordersImpl.setId(id);

		if (dateOrder == Long.MIN_VALUE) {
			ordersImpl.setDateOrder(null);
		}
		else {
			ordersImpl.setDateOrder(new Date(dateOrder));
		}

		if (customer == null) {
			ordersImpl.setCustomer("");
		}
		else {
			ordersImpl.setCustomer(customer);
		}

		ordersImpl.setOrderinfo(orderinfo);
		ordersImpl.setStatus(status);

		ordersImpl.resetOriginalValues();

		return ordersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		dateOrder = objectInput.readLong();
		customer = objectInput.readUTF();

		orderinfo = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(dateOrder);

		if (customer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customer);
		}

		objectOutput.writeLong(orderinfo);

		objectOutput.writeInt(status);
	}

	public long id;
	public long dateOrder;
	public String customer;
	public long orderinfo;
	public int status;

}