<%@ page import="com.serious.orders.model.Honey" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Honey honey = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
    <portlet:param name="tab" value="tabKind"/>
</portlet:renderURL>

<portlet:actionURL name="addHoney" var="addHoneyURL">
    <portlet:param name="tab" value="tabKind"/>
</portlet:actionURL>

<aui:form action="${addHoneyURL}" name="fm">
    <aui:model-context bean="<%= honey %>" model="<%= Honey.class%>"/>
    
    <aui:input name="type" label="Тип" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>
    <aui:input name="price" label="Цена" type="number" cssClass="add">
        <aui:validator errorMessage="errorInputMessageDigit" name="required" />
    </aui:input>
    <aui:input name="stock" label="stock" type="checkbox" checked="true"/>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>