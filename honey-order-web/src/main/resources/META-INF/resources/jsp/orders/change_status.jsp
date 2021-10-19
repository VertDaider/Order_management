<%@ page import="com.serious.orders.service.OrderLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.serious.orders.model.Order" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    long orderId = ParamUtil.getLong(request, "orderId");
    Order order = OrderLocalServiceUtil.getOrder(orderId);
%>

<portlet:actionURL name="editStatusOrder" var="editURL">
    <portlet:param name="orderId" value="<%=String.valueOf(orderId)%>"/>
    <portlet:param name="tab" value="tabOrders"/>
</portlet:actionURL>

<aui:form action="${editURL}" name="fm">
    <aui:model-context bean="<%= order %>" model="<%= Order.class%>"/>
        <aui:select label="Статус" name="status" cssClass="add">
                <aui:option value="1" label="Новый"/>
                <aui:option value="2" label="Отправлен"/>
                <aui:option value="3" label="Получен"/>
                <aui:option value="4" label="Оплачен"/>
                <aui:option value="0" label="Архивный"/>
        </aui:select>

    <portlet:renderURL var="viewURL">
        <portlet:param name="jspPage" value="/jsp/view.jsp"/>
        <portlet:param name="tab" value="tabOrders"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>