<%@ page import="com.serious.orders.model.Order" %>
<%@ page import="com.serious.orders.model.Honey" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    Log log = LogFactoryUtil.getLog("/jsp/orders/add.jsp");
    Order order = null;
%>

<portlet:actionURL name="addOrder" var="addOrderURL"/>

<aui:form action="${addOrderURL}" name="fm">
    <aui:model-context bean="<%= order %>" model="<%= Order.class%>"/>
    <aui:fieldset-group>
        <aui:fieldset>
            <aui:row>
                <aui:col width="50">
                    <aui:input name="customer" label="Заказчик" type="text" cssClass="add">
                        <aui:validator errorMessage="errorInputMessage" name="required"/>
                    </aui:input>
                </aui:col>
                <aui:col width="50">
                    <aui:input name="address" label="Адрес" type="text" cssClass="add"/>
                </aui:col>
            </aui:row>
        </aui:fieldset>
    </aui:fieldset-group>

    <portlet:renderURL var="viewURL">
        <portlet:param name="jspPage" value="/jsp/view.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>

