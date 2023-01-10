<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="checkout"/></title>
</head>
<body>
<div class="d-flex w-100 flex-column justify-content-start align-items-center">
    <c:choose>
        <c:when test="${orderPrice > 0.0}">
            <form:form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="POST">

                <input type="hidden" name="cmd" value="_xclick">
                <input type="hidden" name="business" value="sb-moiol14643089@business.example.com">
                <input type="hidden" name="currency_code" value="EUR">
                <input type="hidden" name="return" value="http://localhost:8082/chesscorner/checkout/success?orderId=${orderId}">
                <input type="hidden" name="cancel_return" value="http://localhost:8082/chesscorner/checkout/cancel?orderId=${orderId}">

                <input type="hidden" name="item_name" value="n°${orderId}">
                <input type="hidden" name="amount" value="${orderPrice}">

                <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but01.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!">
            </form:form>
        </c:when>
        <c:otherwise>
            <div class="card mt-5" style="width: 400px">
                <div class="card-body d-flex flex-column align-items-center">
                    <h5 class="card-title">
                        <spring:message code="confirmOrder"/>
                    </h5>
                    <h4 class="card-text my-5">
                        <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/> € TTC
                    </h4>
                    <form:form method="POST" action="" modelAttribute="basket" class="d-flex w-100 justify-content-between align-items-center">
                        <form:button type="submit" name="proceedCheckout" class="btn btn-primary">
                            <spring:message code="confirm"/>
                        </form:button>
                        <a role="button" class="btn btn-primary" href="<spring:url value='/checkout/cancel?orderId=${orderId ? orderId : -1}'/>">
                            <spring:message code="cancel"/>
                        </a>
                    </form:form>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
