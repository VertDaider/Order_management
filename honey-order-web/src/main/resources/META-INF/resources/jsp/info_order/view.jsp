<%@ page import="com.serious.orders.service.OrderLocalServiceUtil" %>
<%@ page import="com.serious.orders.model.Order" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.serious.orders.model.OrderInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.serious.orders.service.OrderInfoLocalServiceUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page import="com.serious.orders.model.Honey" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    long orderId = ParamUtil.getLong(request, "orderId");
    Order order = OrderLocalServiceUtil.fetchOrder(orderId);
    Honey honey;
    List<OrderInfo> infoList = OrderInfoLocalServiceUtil.findByOrder(order.getId());
%>

<liferay-ui:message key="key.order.number"/>
<liferay-ui:message key="<%=String.valueOf(orderId)%>"/>
<p></p>
<portlet:actionURL name="addType" var="addTypeURL">
    <portlet:param name="jspPage" value="/jsp/info_order/view.jsp"/>
    <portlet:param name="orderId" value="<%=String.valueOf(orderId)%>"/>
</portlet:actionURL>
<aui:form action="${addTypeURL}">
    <aui:fieldset>
        <aui:row>
            <aui:col width="20">
                <aui:select label="Сорт" name="type" cssClass="addType">
                    <%
                        List<Honey> list = HoneyLocalServiceUtil.getHoneys(0, HoneyLocalServiceUtil.getHoneysCount());
                        for (Honey h : list) {
                            if (h.isStock()) {
                    %>
                    <aui:option value="<%=h.getId()%>">
                        <%=h.getType()%>
                    </aui:option>
                    <%
                            }
                        }
                    %>
                </aui:select>
            </aui:col>
            <aui:col width="15">
                <aui:input label="Количество" name="amount" type="number" style="width: 100px;"/>
            </aui:col>
            <aui:col width="20" cssClass="buttonDown">
                <aui:button type="submit" value="action.add"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>
</aui:form>

<liferay-ui:search-container searchContainer="${searchContainerList}" curParam="cur2" deltaParam="delta2">
    <liferay-ui:search-container-results results="<%=infoList%>"/>
    <liferay-ui:search-container-row className="com.serious.orders.model.OrderInfo" modelVar="info" cssClass="text-center">
        <%
            long honeyId = info.getType();
            honey = HoneyLocalServiceUtil.fetchHoney(honeyId);
            int price = honey.getPrice();
            String type = honey.getType();
            int sum = price * info.getAmount();
        %>
        <liferay-ui:search-container-column-text name="Сорт" value="<%=String.valueOf(type)%>"/>
        <liferay-ui:search-container-column-text name="Количество" property="amount"/>
        <liferay-ui:search-container-column-text name="Сумма" value="<%=String.valueOf(sum)%>"/>
        <liferay-ui:search-container-column-text>
            <liferay-ui:icon-menu direction="left-side" icon="list"	markupView="lexicon" message="" showWhenSingleIcon="true">

                <portlet:renderURL var="editInfoURL">
                    <portlet:param name="jspPage" value="/jsp/info_order/edit.jsp"/>
                    <portlet:param name="OrderInfoId" value="<%=String.valueOf(info.getId())%>"/>
                </portlet:renderURL>
                <liferay-ui:icon icon="pencil" markupView="lexicon" message="action.edit" url="${editInfoURL}"/>
                <portlet:actionURL name="deleteRecInfo" var="delInfoURL">
                    <portlet:param name="jspPage" value="/jsp/info_order/view.jsp"/>
                    <portlet:param name="orderId" value="<%=String.valueOf(orderId)%>"/>
                    <portlet:param name="orderInfoId" value="<%=String.valueOf(info.getId())%>"/>
                </portlet:actionURL>
                <liferay-ui:icon-delete showIcon="true" message="action.delete" url="${delInfoURL}" confirmation = "action.confirm"/>

            </liferay-ui:icon-menu>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>

<portlet:renderURL var="viewURL">
    <portlet:param name="jspPage" value="/jsp/view.jsp"/>
</portlet:renderURL>

<aui:button-row>
    <aui:button type="cancel" value="Назад" href="${viewURL}"/>
</aui:button-row>

