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

<%@ include file="/init.jsp" %>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    long orderId = ParamUtil.getLong(request, "orderId");
    Order order = OrderLocalServiceUtil.fetchOrder(orderId);
    Honey honey;
    List<OrderInfo> infoList = OrderInfoLocalServiceUtil.getOrderInfos(0, OrderInfoLocalServiceUtil.getOrderInfosCount());
%>

<aui:fieldset>
    <aui:row>
        <h3> Номер заказа: <%=String.valueOf(orderId)%> <br>
            Дата заказа : <%=sdf.format(order.getDateOrder())%></h3>
    </aui:row>
</aui:fieldset>

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
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>

<%--todo    кнопка назад--%>