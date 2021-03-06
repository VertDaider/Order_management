<%@ include file="/META-INF/resources/jsp/init.jsp"%>
<portlet:renderURL var="viewURL">
    <portlet:param name="view" value="viewMain"/>
</portlet:renderURL>
<liferay-ui:tabs names="tab.orders,tab.kind" param="tab" tabsValues="tabOrders,tabKind"  url="${viewURL.toString()}">
    <c:choose>
        <c:when test="${'tabOrders' eq renderRequest.getParameter('tab')}">
            <jsp:include page="/META-INF/resources/jsp/orders/view.jsp"/>
        </c:when>
        <c:when test="${'tabKind' eq renderRequest.getParameter('tab')}">
            <jsp:include page="/META-INF/resources/jsp/kind/view.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="/META-INF/resources/jsp/orders/view.jsp"/>
        </c:otherwise>
    </c:choose>
</liferay-ui:tabs>
