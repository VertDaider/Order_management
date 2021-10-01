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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Honey}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Honey
 * @generated
 */
public class HoneyWrapper
	extends BaseModelWrapper<Honey> implements Honey, ModelWrapper<Honey> {

	public HoneyWrapper(Honey honey) {
		super(honey);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("type", getType());
		attributes.put("price", getPrice());
		attributes.put("stock", isStock());

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

		Integer price = (Integer)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean stock = (Boolean)attributes.get("stock");

		if (stock != null) {
			setStock(stock);
		}
	}

	/**
	 * Returns the ID of this honey.
	 *
	 * @return the ID of this honey
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the price of this honey.
	 *
	 * @return the price of this honey
	 */
	@Override
	public int getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this honey.
	 *
	 * @return the primary key of this honey
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stock of this honey.
	 *
	 * @return the stock of this honey
	 */
	@Override
	public boolean getStock() {
		return model.getStock();
	}

	/**
	 * Returns the type of this honey.
	 *
	 * @return the type of this honey
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns <code>true</code> if this honey is stock.
	 *
	 * @return <code>true</code> if this honey is stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isStock() {
		return model.isStock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this honey.
	 *
	 * @param id the ID of this honey
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the price of this honey.
	 *
	 * @param price the price of this honey
	 */
	@Override
	public void setPrice(int price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this honey.
	 *
	 * @param primaryKey the primary key of this honey
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this honey is stock.
	 *
	 * @param stock the stock of this honey
	 */
	@Override
	public void setStock(boolean stock) {
		model.setStock(stock);
	}

	/**
	 * Sets the type of this honey.
	 *
	 * @param type the type of this honey
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected HoneyWrapper wrap(Honey honey) {
		return new HoneyWrapper(honey);
	}

}