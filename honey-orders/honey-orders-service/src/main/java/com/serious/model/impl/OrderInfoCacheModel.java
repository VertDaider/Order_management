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

import com.serious.model.OrderInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrderInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OrderInfoCacheModel
	implements CacheModel<OrderInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OrderInfoCacheModel)) {
			return false;
		}

		OrderInfoCacheModel orderInfoCacheModel = (OrderInfoCacheModel)object;

		if (id == orderInfoCacheModel.id) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", amount=");
		sb.append(amount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrderInfo toEntityModel() {
		OrderInfoImpl orderInfoImpl = new OrderInfoImpl();

		orderInfoImpl.setId(id);

		if (type == null) {
			orderInfoImpl.setType("");
		}
		else {
			orderInfoImpl.setType(type);
		}

		orderInfoImpl.setAmount(amount);

		orderInfoImpl.resetOriginalValues();

		return orderInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		type = objectInput.readUTF();

		amount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeInt(amount);
	}

	public long id;
	public String type;
	public int amount;

}