<%@ page import="java.util.List" %>
<%@ page import="com.serious.orders.model.Order" %>
<%@ page import="com.serious.orders.service.OrderLocalServiceUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.serious.util.StatusKeys" %>
<%@ page import="com.serious.orders.model.OrderInfo" %>
<%@ page import="com.serious.orders.service.persistence.OrderInfoUtil" %>

<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactory" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.serious.orders.service.OrderInfoLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/init.jsp" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    List<Order> ordersList = OrderLocalServiceUtil.getOrders(0, OrderLocalServiceUtil.getOrdersCount());
    Log log = LogFactoryUtil.getLog("/orders/view.jsp");
%>

<portlet:renderURL var="addOrder">
    <portlet:param name="mvcPath" value="/orders/order_add.jsp"/>
</portlet:renderURL>

<aui:button-row>
    <aui:a href="${addOrder}" cssClass="btn btn-primary" title="action.add">
        <liferay-ui:icon icon="plus" markupView="lexicon"/>
        <liferay-ui:message key="action.add"/>
    </aui:a>
</aui:button-row>

<liferay-ui:search-container searchContainer="${searchContainerList}" curParam="cur2" deltaParam="delta2">
    <liferay-ui:search-container-results results="<%=ordersList%>"/>
    <liferay-ui:search-container-row className="com.serious.orders.model.Order" modelVar="order" cssClass="text-center">
        <liferay-ui:search-container-column-text name="Номер заказа" property="id"/>
        <liferay-ui:search-container-column-text name="Дата заказа" value="<%=sdf.format(order.getDateOrder())%>"/>
        <liferay-ui:search-container-column-text name="Заказчик" property="customer"/>
        <%
            AtomicInteger sumOrder = new AtomicInteger();
           List<OrderInfo> infoList = OrderInfoLocalServiceUtil.findByOrder(order.getId());
            infoList.forEach(item -> {
                long type = item.getType();
                int price = HoneyLocalServiceUtil.fetchHoney(type).getPrice();
                sumOrder.addAndGet(item.getAmount() * price);
            });
        %>
        <liferay-ui:search-container-column-text name="Итоговая сумма" value="<%= String.valueOf(sumOrder) %>"/>
        <liferay-ui:search-container-column-text name="Статус заказа" value="<%=StatusKeys.getTextOnInt(order.getStatus())%>"/>
        <liferay-ui:search-container-column-text>

            <liferay-ui:icon-menu direction="left-side" icon="list" markupView="lexicon" message="" showWhenSingleIcon="true">

                <portlet:renderURL var="infoOrderURL">
                    <portlet:param name="mvcPath" value="/info_order/view.jsp"/>
                    <portlet:param name="orderId" value="<%=String.valueOf(order.getId())%>"/>
                </portlet:renderURL>
                <liferay-ui:icon icon="info-panel-closed" markupView="lexicon" message="action.info" url="${infoOrderURL}"/>

                <portlet:renderURL var="editStatusURL">
                    <portlet:param name="mvcPath" value="/orders/change_status.jsp"/>
                    <portlet:param name="tab" value="tabOrders"/>
                    <portlet:param name="orderId" value="<%=String.valueOf(order.getId())%>"/>
                </portlet:renderURL>
                <liferay-ui:icon icon="change" markupView="lexicon" message="action.change.status" url="${editStatusURL}"/>

                <portlet:renderURL var="editOrderURL">
                    <portlet:param name="mvcPath" value="/orders/edit.jsp"/>
                    <portlet:param name="orderId" value="<%=String.valueOf(order.getId())%>"/>
                </portlet:renderURL>
                <liferay-ui:icon icon="pencil" markupView="lexicon" message="action.edit" url="${editOrderURL}"/>

                <portlet:actionURL name="deleteOrder" var="delOrderURL">
                    <portlet:param name="mvcPath" value="/view.jsp"/>
                    <portlet:param name="tab" value="tabOrders"/>
                    <portlet:param name="orderId" value="<%=String.valueOf(order.getId())%>"/>
                </portlet:actionURL>
                <liferay-ui:icon-delete showIcon="true" message="action.delete" url="${delOrderURL}" confirmation="action.confirm"/>

            </liferay-ui:icon-menu>

        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>




