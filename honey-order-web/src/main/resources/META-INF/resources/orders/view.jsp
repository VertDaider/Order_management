<%@ page import="java.util.List" %>
<%@ page import="com.serious.model.Orders" %>
<%@ page import="com.serious.service.OrdersLocalServiceUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/init.jsp" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    List<Orders> ordersList = OrdersLocalServiceUtil.getOrderses(0, OrdersLocalServiceUtil.getOrdersesCount());
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
        <liferay-ui:search-container-row className="com.serious.model.Orders" modelVar="orders" cssClass="text-center">
                <liferay-ui:search-container-column-text name="Номер заказа" property="id"/>
                <liferay-ui:search-container-column-text name="Дата заказа" value="<%=String.valueOf(orders.getDateOrder())%>"/>
                <liferay-ui:search-container-column-text name="Заказчик" property="customer"/>
                <liferay-ui:search-container-column-text name="Статус заказа" property="status"/>
        </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>




