<%@ page import="com.serious.model.Honey" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Honey honey = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<%--<portlet:renderURL var="viewKindURL">
    <portlet:param name="mvcPath" value="/kind/view.jsp"/>
</portlet:renderURL>--%>

<portlet:actionURL name="addKind" var="addKindURL"/>

<aui:form action="${addKindURL}" name="fm">
    <aui:model-context bean="<%= honey %>" model="<%= Honey.class%>"/>
    
    <aui:input name="type" label="Тип" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>
    <aui:input name="price" label="Цена" type="number" cssClass="add">
        <aui:validator errorMessage="errorInputMessageDigit" name="required" />
    </aui:input>
    <aui:input name="stock" label="stock" type="checkbox"/>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>