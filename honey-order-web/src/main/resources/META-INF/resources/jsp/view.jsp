<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>
<portlet:renderURL var="viewURL">
    <portlet:param name="view" value="viewMain"/>
</portlet:renderURL>

<div class="container-fluid">
    <clay:row>
        <clay:col md="3">
            <nav class="sidebar-sticky navbar-expand-md">
                <div class="collapse navbar-collapse" id="menu-tab">
                    <liferay-ui:tabs names="tab.orders,tab.kind" cssClass="navbar-nav mr-auto flex-column"
                                     param="tab" tabsValues="tabOrders,tabKind" url="${viewURL.toString()}">
                    </liferay-ui:tabs>
                </div>
            </nav>
        </clay:col>
        <clay:col md="9">
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
        </clay:col>
    </clay:row>
</div>

