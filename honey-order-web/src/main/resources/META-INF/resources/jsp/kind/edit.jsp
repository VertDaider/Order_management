<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.serious.orders.model.Honey" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    long honeyId = ParamUtil.getLong(request, "honeyId");
    Honey honey = HoneyLocalServiceUtil.getHoney(honeyId);
%>

<portlet:actionURL name="editHoney" var="editHoneyURL">
    <portlet:param name="honeyId" value="<%=String.valueOf(honeyId)%>"/>
    <portlet:param name="tab" value="tabKind"/>
</portlet:actionURL>

<aui:form action="${editHoneyURL}" name="fm">
    <aui:model-context bean="<%= honey %>" model="<%= Honey.class%>"/>

    <aui:input name="type" label="Сорт" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>
    <aui:input name="price" label="Цена" type="number" cssClass="add">
        <aui:validator errorMessage="errorInputMessageDigit" name="required" />
    </aui:input>
    <aui:input name="stock" label="stock" checked="<%=honey.getStock()%>" type="checkbox"/>

    <portlet:renderURL var="viewURL">
        <portlet:param name="jspPage" value="/jsp/view.jsp"/>
        <portlet:param name="tab" value="tabKind"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>