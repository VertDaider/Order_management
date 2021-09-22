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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrderInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderInfo
 * @generated
 */
public class OrderInfoWrapper
	extends BaseModelWrapper<OrderInfo>
	implements ModelWrapper<OrderInfo>, OrderInfo {

	public OrderInfoWrapper(OrderInfo orderInfo) {
		super(orderInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("type", getType());
		attributes.put("amount", getAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer amount = (Integer)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}
	}

	/**
	 * Returns the amount of this order info.
	 *
	 * @return the amount of this order info
	 */
	@Override
	public int getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the ID of this order info.
	 *
	 * @return the ID of this order info
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this order info.
	 *
	 * @return the primary key of this order info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this order info.
	 *
	 * @return the type of this order info
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amount of this order info.
	 *
	 * @param amount the amount of this order info
	 */
	@Override
	public void setAmount(int amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the ID of this order info.
	 *
	 * @param id the ID of this order info
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this order info.
	 *
	 * @param primaryKey the primary key of this order info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this order info.
	 *
	 * @param type the type of this order info
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected OrderInfoWrapper wrap(OrderInfo orderInfo) {
		return new OrderInfoWrapper(orderInfo);
	}

}