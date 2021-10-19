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

package com.serious.orders.service.impl;

import com.liferay.portal.aop.AopService;

import com.serious.orders.model.OrderInfo;
import com.serious.orders.service.base.OrderInfoLocalServiceBaseImpl;

import com.serious.orders.service.persistence.OrderInfoUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.List;

/**
 * The implementation of the order info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.serious.orders.service.OrderInfoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrderInfoLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.serious.orders.model.OrderInfo",
	service = AopService.class
)
public class OrderInfoLocalServiceImpl extends OrderInfoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.serious.orders.service.OrderInfoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.serious.orders.service.OrderInfoLocalServiceUtil</code>.
	 */
	public List<OrderInfo> findByOrder(long orderId) {
		List<OrderInfo> result = Collections.emptyList();

		try{
			result=orderInfoPersistence.findByOrder(orderId);
		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	}
}