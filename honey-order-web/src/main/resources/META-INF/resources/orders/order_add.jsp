<%@ page import="com.serious.model.Orders" %>
<%@ page import="com.serious.model.Honey" %>
<%@ page import="com.serious.service.HoneyLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/init.jsp" %>

<%
    Orders order = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addOrder" var="addOrderURL"/>

<aui:form action="${addOrderURL}" name="fm">
    <aui:model-context bean="<%= order %>" model="<%= Orders.class%>"/>
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
            <aui:row>
                <aui:col width="50">
                    <aui:select label="Сорт" name="type" cssClass="add">
                        <%
                            List<Honey> list = HoneyLocalServiceUtil.getHoneys(0, HoneyLocalServiceUtil.getHoneysCount());
                            for (Honey h : list) {
                        %>
                        <aui:option value="<%=h.getId()%>">
                            <%=h.getType()%>
                        </aui:option>
                        <%
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
        </aui:fieldset>
    </aui:fieldset-group>

    <aui:button-row>
        <aui:button type="submit"/>
        <aui:button type="cancel" href="${viewURL}"/>
    </aui:button-row>

</aui:form>

