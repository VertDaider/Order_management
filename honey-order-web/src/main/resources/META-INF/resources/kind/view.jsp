<%@ page import="com.serious.model.Honey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.serious.service.HoneyLocalServiceUtil" %>

<%@ include file="/init.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Honey> honeyList = HoneyLocalServiceUtil.getHoneys(0, HoneyLocalServiceUtil.getHoneysCount());
%>

<liferay-ui:search-container searchContainer="${searchContainerList}" curParam="cur2" deltaParam="delta2">
    <liferay-ui:search-container-results results="<%=honeyList%>"/>
    <liferay-ui:search-container-row className="com.serious.model.Honey" modelVar="honey" cssClass="text-center">
        <liferay-ui:search-container-column-text name="Вид" property="type"/>
        <liferay-ui:search-container-column-text name="Цена" property="price"/>
        <liferay-ui:search-container-column-text name="Наличие">
            <% if (honey.isStock()) { %>
            <liferay-ui:icon image="checked"/>
            <% } else { %>
            <liferay-ui:icon image="close"/>
            <% } %>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

