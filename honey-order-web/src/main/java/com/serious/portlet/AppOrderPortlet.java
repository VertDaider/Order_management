package com.serious.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.serious.constants.apporderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.serious.model.Honey;
import com.serious.service.HoneyLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author dovgopolov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=apporder",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + apporderPortletKeys.APPORDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AppOrderPortlet extends MVCPortlet {
	
	public void editStockHoney(ActionRequest request, ActionResponse response) throws PortalException {
		long honeyID = ParamUtil.getLong(request, "honeyId");
		Honey honey = HoneyLocalServiceUtil.getHoney(honeyID);
		honey.setStock(!honey.getStock());
		HoneyLocalServiceUtil.updateHoney(honey);
	}

	public void addKind(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Honey.class.getName(), request);

		String kind = ParamUtil.getString(request, "type");
		int price = ParamUtil.getInteger(request, "price");
		boolean isStock = ParamUtil.getBoolean(request, "stock", false);

		long honeyId = CounterLocalServiceUtil.increment();
		Honey honey = HoneyLocalServiceUtil.createHoney(honeyId);
		honey.setStock(isStock);
		honey.setPrice(price);
		honey.setType(kind);
		HoneyLocalServiceUtil.updateHoney(honey);
	}

	public void deleteStockHoney(ActionRequest request, ActionResponse response) throws PortalException {
		long honeyId = ParamUtil.getLong(request, "honeyId");
		HoneyLocalServiceUtil.deleteHoney(honeyId);
	}
}