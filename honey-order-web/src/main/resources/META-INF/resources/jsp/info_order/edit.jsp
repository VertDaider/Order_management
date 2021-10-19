<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.serious.orders.model.OrderInfo" %>
<%@ page import="com.serious.orders.service.OrderInfoLocalServiceUtil" %>
<%@ page import="com.serious.orders.model.Honey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/META-INF/resources/jsp/init.jsp" %>
<%
    long orderInfoId = ParamUtil.getLong(request, "OrderInfoId");
    OrderInfo orderInfo = OrderInfoLocalServiceUtil.getOrderInfo(orderInfoId);
%>

<portlet:actionURL name="editInfo" var="editInfoURL">
    <portlet:param name="orderInfoId" value="<%=String.valueOf(orderInfoId)%>"/>
    <portlet:param name="jspPage" value="/jsp/info_order/view.jsp"/>
    <portlet:param name="orderId" value="<%=String.valueOf(orderInfo.getOrderid())%>"/>
</portlet:actionURL>

<aui:form action="${editInfoURL}" name="fm">
    <aui:model-context bean="<%= orderInfo %>" model="<%= OrderInfo.class%>"/>

    <aui:fieldset>
        <aui:row>
            <aui:col width="50" >
                <aui:select label="Сорт" name="type" cssClass="add">
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
            <aui:col width="50">
                <aui:input label="Количество" name="amount" type="number" style="width: 100px;"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <portlet:renderURL var="viewURL">
        <portlet:param name="jspPage" value="/jsp/info_order/view.jsp"/>
        <portlet:param name="orderId" value="<%=String.valueOf(orderInfo.getOrderid())%>"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>
