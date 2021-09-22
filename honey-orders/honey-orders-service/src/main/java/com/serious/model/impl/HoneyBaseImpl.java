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

import com.serious.model.Honey;
import com.serious.service.HoneyLocalServiceUtil;

/**
 * The extended model base implementation for the Honey service. Represents a row in the &quot;my_orders_Honey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HoneyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HoneyImpl
 * @see Honey
 * @generated
 */
public abstract class HoneyBaseImpl extends HoneyModelImpl implements Honey {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a honey model instance should use the <code>Honey</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			HoneyLocalServiceUtil.addHoney(this);
		}
		else {
			HoneyLocalServiceUtil.updateHoney(this);
		}
	}

}