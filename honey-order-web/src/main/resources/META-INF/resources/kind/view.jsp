<%@ page import="com.serious.model.Honey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.serious.service.HoneyLocalServiceUtil" %>
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
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu direction="left-side" icon=""	markupView="lexicon" message="" showWhenSingleIcon="true">
                <portlet:actionURL name="editStockHoney" var="editStockURL">
                    <portlet:param name="mvcPath" value="/kind/view.jsp"/>
                    <portlet:param name="honeyId" value="<%=String.valueOf(honey.getId())%>"/>
                </portlet:actionURL>
                <liferay-ui:icon icon="redo" markupView="lexicon" message="action.changestatus" url="${editStockURL}"/>
            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

