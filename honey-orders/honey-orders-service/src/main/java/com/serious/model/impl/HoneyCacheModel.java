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

import com.serious.model.Honey;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Honey in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HoneyCacheModel implements CacheModel<Honey>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HoneyCacheModel)) {
			return false;
		}

		HoneyCacheModel honeyCacheModel = (HoneyCacheModel)object;

		if (id == honeyCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", price=");
		sb.append(price);
		sb.append(", stock=");
		sb.append(stock);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Honey toEntityModel() {
		HoneyImpl honeyImpl = new HoneyImpl();

		honeyImpl.setId(id);

		if (type == null) {
			honeyImpl.setType("");
		}
		else {
			honeyImpl.setType(type);
		}

		honeyImpl.setPrice(price);
		honeyImpl.setStock(stock);

		honeyImpl.resetOriginalValues();

		return honeyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		type = objectInput.readUTF();

		price = objectInput.readInt();

		stock = objectInput.readBoolean();
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

		objectOutput.writeInt(price);

		objectOutput.writeBoolean(stock);
	}

	public long id;
	public String type;
	public int price;
	public boolean stock;

}