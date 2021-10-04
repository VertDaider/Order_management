<%@ page import="com.serious.orders.model.Honey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/init.jsp" %>

<%
    List<Honey> honeyList = HoneyLocalServiceUtil.getHoneys(0, HoneyLocalServiceUtil.getHoneysCount());
%>
<portlet:renderURL var="addKind">
    <portlet:param name="mvcPath" value="/kind/kind_add.jsp"/>
</portlet:renderURL>

<aui:button-row>
    <aui:a href="${addKind}" cssClass="btn btn-primary" title="action.add">
        <liferay-ui:icon icon="plus" markupView="lexicon"/>
        <liferay-ui:message key="action.add"/>
    </aui:a>
</aui:button-row>

<liferay-ui:search-container searchContainer="${searchContainerList}" curParam="cur2" deltaParam="delta2">
    <liferay-ui:search-container-results results="<%=honeyList%>"/>
    <liferay-ui:search-container-row className="com.serious.orders.model.Honey" modelVar="honey" cssClass="text-center">
        <liferay-ui:search-container-column-text name="Вид" property="type"/>
        <liferay-ui:search-container-column-text name="Цена" property="price"/>
        <liferay-ui:search-container-column-text name="Наличие">
            <% if (honey.isStock()) { %>
            <liferay-ui:icon image="checked"/>
            <% } else { %>
            <liferay-ui:icon image="close"/>
            <% } %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu direction="left-side" icon="list"	markupView="lexicon" message="" showWhenSingleIcon="true">
                <portlet:actionURL name="editStockHoney" var="editStockURL">
                    <portlet:param name="mvcPath" value="/view.jsp"/>
                    <portlet:param name="tab" value="tabKind"/>
                    <portlet:param name="honeyId" value="<%=String.valueOf(honey.getId())%>"/>
                </portlet:actionURL>
                <liferay-ui:icon icon="redo" markupView="lexicon" message="action.change.stock" url="${editStockURL}"/>
                <portlet:renderURL var="editKindURL">
                    <portlet:param name="mvcPath" value="/kind/edit.jsp"/>
                    <portlet:param name="honeyId" value="<%=String.valueOf(honey.getId())%>"/>
                </portlet:renderURL>
                <liferay-ui:icon icon="pencil" markupView="lexicon" message="action.edit" url="${editKindURL}"/>
                <portlet:actionURL name="deleteRecHoney" var="delStockURL">
                    <portlet:param name="mvcPath" value="/view.jsp"/>
                    <portlet:param name="tab" value="tabKind"/>
                    <portlet:param name="honeyId" value="<%=String.valueOf(honey.getId())%>"/>
                </portlet:actionURL>
                <liferay-ui:icon-delete showIcon="true" message="action.delete" url="${delStockURL}" confirmation = "action.confirm"/>
            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>

