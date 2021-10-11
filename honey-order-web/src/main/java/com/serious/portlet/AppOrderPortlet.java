package com.serious.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.serious.constants.apporderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.serious.orders.model.Honey;
import com.serious.orders.model.Order;
import com.serious.orders.model.OrderInfo;
import com.serious.orders.service.HoneyLocalServiceUtil;
import com.serious.orders.service.OrderInfoLocalServiceUtil;
import com.serious.orders.service.OrderLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.Date;

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
                "javax.portlet.name=" + apporderPortletKeys.MANAGERORDERS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AppOrderPortlet extends MVCPortlet {

    private static final Log log = LogFactoryUtil.getLog(AppOrderPortlet.class);

    public void editStockHoney(ActionRequest request, ActionResponse response) throws PortalException {
        long honeyID = ParamUtil.getLong(request, "honeyId");
        Honey honey = HoneyLocalServiceUtil.getHoney(honeyID);
        honey.setStock(!honey.getStock());
        HoneyLocalServiceUtil.updateHoney(honey);
    }

    public void addHoney(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Honey.class.getName(), request);

        String type = ParamUtil.getString(request, "type");
        int price = ParamUtil.getInteger(request, "price");
        boolean isStock = ParamUtil.getBoolean(request, "stock", false);

        long honeyId = CounterLocalServiceUtil.increment();
        Honey honey = HoneyLocalServiceUtil.createHoney(honeyId);
        honey.setStock(isStock);
        honey.setPrice(price);
        honey.setType(type);
        HoneyLocalServiceUtil.updateHoney(honey);
    }

    public void deleteRecHoney(ActionRequest request, ActionResponse response) throws PortalException {
        long honeyId = ParamUtil.getLong(request, "honeyId");
        HoneyLocalServiceUtil.deleteHoney(honeyId);
    }

    public void editHoney(ActionRequest request, ActionResponse response) throws PortalException {
        long honeyId = ParamUtil.getLong(request, "honeyId");

        String type = ParamUtil.getString(request, "type");
        int price = ParamUtil.getInteger(request, "price");
        boolean isStock = ParamUtil.getBoolean(request, "stock");

        Honey honey = HoneyLocalServiceUtil.getHoney(honeyId);
        honey.setType(type);
        honey.setPrice(price);
        honey.setStock(isStock);
        HoneyLocalServiceUtil.updateHoney(honey);
    }

    public void deleteOrder(ActionRequest request, ActionResponse response) throws PortalException {
        long orderId = ParamUtil.getLong(request, "orderId");
        OrderLocalServiceUtil.deleteOrder(orderId);
    }

    public void addOrder(ActionRequest request, ActionResponse response) throws PortalException {
        String address = ParamUtil.getString(request, "address");
        String customer = ParamUtil.getString(request, "customer");
        // TODO: 11.10.2021 доработать добавление заказа
        int type = ParamUtil.getInteger(request, "type");
        int count = ParamUtil.getInteger(request, "count");

        long orderId = CounterLocalServiceUtil.increment();
        Order order = OrderLocalServiceUtil.createOrder(orderId);
        order.setAddress(address);
        order.setCustomer(customer);
        order.setDateOrder(new Date());
        order.setStatus(1);
        OrderLocalServiceUtil.updateOrder(order);

        long orderInfoId = CounterLocalServiceUtil.increment();
        OrderInfo orderInfo = OrderInfoLocalServiceUtil.createOrderInfo(orderInfoId);

        orderInfo.setAmount(count);
        orderInfo.setOrderid(orderId);
        orderInfo.setType(type);
        OrderInfoLocalServiceUtil.updateOrderInfo(orderInfo);
    }

    public void editStatusOrder(ActionRequest request, ActionResponse response) throws PortalException {
        int status = ParamUtil.getInteger(request, "status");
        long orderId = ParamUtil.getLong(request, "orderId");
        Order order = OrderLocalServiceUtil.getOrder(orderId);
        order.setStatus(status);
        OrderLocalServiceUtil.updateOrder(order);
    }

    public void editInfo(ActionRequest request, ActionResponse response) throws PortalException {
        long orderInfoId = ParamUtil.getLong(request, "orderInfoId");
        OrderInfo orderInfo = OrderInfoLocalServiceUtil.getOrderInfo(orderInfoId);
        long orderId = orderInfo.getOrderid();

        int[] types = ParamUtil.getIntegerValues(request, "type");
        int[] counts = ParamUtil.getIntegerValues(request, "amount");

        orderInfo.setAmount(counts[0]);
        orderInfo.setType(types[0]);
        OrderInfoLocalServiceUtil.updateOrderInfo(orderInfo);
        if (types.length > 1) {
            for (int i = 1; i < types.length; i++) {
                // TODO: 11.10.2021 что то с инкрементом подумать
                orderInfoId = CounterLocalServiceUtil.increment();
                orderInfo = OrderInfoLocalServiceUtil.createOrderInfo(orderInfoId);

                orderInfo.setAmount(counts[i]);
                orderInfo.setOrderid(orderId);
                orderInfo.setType(orderId);
                OrderInfoLocalServiceUtil.updateOrderInfo(orderInfo);
            }
        }
    }

    public void deleteRecInfo(ActionRequest request, ActionResponse response) throws PortalException, IOException {
        long orderInfoId = ParamUtil.getLong(request, "orderInfoId");
        OrderInfoLocalServiceUtil.deleteOrderInfo(orderInfoId);
    }
}