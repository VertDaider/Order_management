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

package com.serious.orders.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.serious.orders.model.Order;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Order in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrderCacheModel implements CacheModel<Order>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrderCacheModel)) {
			return false;
		}

		OrderCacheModel orderCacheModel = (OrderCacheModel)object;

		if (id == orderCacheModel.id) {
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Order toEntityModel() {
		OrderImpl orderImpl = new OrderImpl();

		orderImpl.setId(id);

		if (dateOrder == Long.MIN_VALUE) {
			orderImpl.setDateOrder(null);
		}
		else {
			orderImpl.setDateOrder(new Date(dateOrder));
		}

		if (customer == null) {
			orderImpl.setCustomer("");
		}
		else {
			orderImpl.setCustomer(customer);
		}

		orderImpl.setStatus(status);

		if (address == null) {
			orderImpl.setAddress("");
		}
		else {
			orderImpl.setAddress(address);
		}

		orderImpl.resetOriginalValues();

		return orderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		dateOrder = objectInput.readLong();
		customer = objectInput.readUTF();

		status = objectInput.readInt();
		address = objectInput.readUTF();
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

		objectOutput.writeInt(status);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public long id;
	public long dateOrder;
	public String customer;
	public int status;
	public String address;

}