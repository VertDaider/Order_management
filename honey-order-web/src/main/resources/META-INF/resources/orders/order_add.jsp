<%@ page import="com.serious.orders.model.Order" %>
<%@ page import="com.serious.orders.model.Honey" %>
<%@ page import="com.serious.orders.service.HoneyLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.serious.portlet.AppOrderPortlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/init.jsp" %>

<%
    Log log = LogFactoryUtil.getLog("/orders/order_add.jsp");
    Order order = null;
    boolean showQuestion = ParamUtil.getBoolean(request, "showQ", true);
    int COUNT_TYPES = ParamUtil.getInteger(request, "countTypes");
    if (COUNT_TYPES == 0) {
        COUNT_TYPES = 1;
    }
%>

<%
    if (showQuestion) {
%>
<portlet:resourceURL id="inputCountTypes" var="enterCountTypes"/>
<aui:form action="${enterCountTypes}" name="fmm">

    <aui:input name="countTypes" label="Сколько будет сортов мёда?" type="number" cssClass="add">
        <aui:validator name="required" errorMessage="errorInputMessageDigit"/>
    </aui:input>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>
</aui:form>
<%
    }
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
        <aui:fieldset>
            <%
                for (int i = 0; i < COUNT_TYPES; i++) {
            %>
            <aui:row>
                <aui:col width="50">
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
                    <aui:input name="count" type="number" style="width: 100px;">
                        <aui:validator name="required" errorMessage="errorInputMessageDigit"/>
                    </aui:input>
                </aui:col>
            </aui:row>
            <%
                }
            %>
        </aui:fieldset>
    </aui:fieldset-group>

    <portlet:renderURL var="viewURL">
        <portlet:param name="mvcPath" value="/view.jsp"/>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>

