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

package com.serious.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HoneyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HoneyLocalService
 * @generated
 */
public class HoneyLocalServiceWrapper
	implements HoneyLocalService, ServiceWrapper<HoneyLocalService> {

	public HoneyLocalServiceWrapper(HoneyLocalService honeyLocalService) {
		_honeyLocalService = honeyLocalService;
	}

	/**
	 * Adds the honey to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoneyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param honey the honey
	 * @return the honey that was added
	 */
	@Override
	public com.serious.model.Honey addHoney(com.serious.model.Honey honey) {
		return _honeyLocalService.addHoney(honey);
	}

	/**
	 * Creates a new honey with the primary key. Does not add the honey to the database.
	 *
	 * @param id the primary key for the new honey
	 * @return the new honey
	 */
	@Override
	public com.serious.model.Honey createHoney(long id) {
		return _honeyLocalService.createHoney(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _honeyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the honey from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoneyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param honey the honey
	 * @return the honey that was removed
	 */
	@Override
	public com.serious.model.Honey deleteHoney(com.serious.model.Honey honey) {
		return _honeyLocalService.deleteHoney(honey);
	}

	/**
	 * Deletes the honey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoneyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the honey
	 * @return the honey that was removed
	 * @throws PortalException if a honey with the primary key could not be found
	 */
	@Override
	public com.serious.model.Honey deleteHoney(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _honeyLocalService.deleteHoney(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _honeyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _honeyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _honeyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _honeyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _honeyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _honeyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _honeyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.serious.model.Honey fetchHoney(long id) {
		return _honeyLocalService.fetchHoney(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _honeyLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the honey with the primary key.
	 *
	 * @param id the primary key of the honey
	 * @return the honey
	 * @throws PortalException if a honey with the primary key could not be found
	 */
	@Override
	public com.serious.model.Honey getHoney(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _honeyLocalService.getHoney(id);
	}

	/**
	 * Returns a range of all the honeys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.serious.model.impl.HoneyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of honeys
	 * @param end the upper bound of the range of honeys (not inclusive)
	 * @return the range of honeys
	 */
	@Override
	public java.util.List<com.serious.model.Honey> getHoneys(
		int start, int end) {

		return _honeyLocalService.getHoneys(start, end);
	}

	/**
	 * Returns the number of honeys.
	 *
	 * @return the number of honeys
	 */
	@Override
	public int getHoneysCount() {
		return _honeyLocalService.getHoneysCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _honeyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _honeyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _honeyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the honey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HoneyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param honey the honey
	 * @return the honey that was updated
	 */
	@Override
	public com.serious.model.Honey updateHoney(com.serious.model.Honey honey) {
		return _honeyLocalService.updateHoney(honey);
	}

	@Override
	public HoneyLocalService getWrappedService() {
		return _honeyLocalService;
	}

	@Override
	public void setWrappedService(HoneyLocalService honeyLocalService) {
		_honeyLocalService = honeyLocalService;
	}

	private HoneyLocalService _honeyLocalService;

}