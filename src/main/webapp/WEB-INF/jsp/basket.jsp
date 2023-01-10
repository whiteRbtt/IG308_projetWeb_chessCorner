<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="basket"/></title>
</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-start align-items-center">
        <h2>
            <spring:message code="basket"/>
        </h2>

        <form:form method="POST" action="" modelAttribute="basket" class="d-flex flex-column w-100 justify-content-center align-items-center">
            <div class="d-flex w-75 mt-5 justify-content-center align-items-center flex-wrap">
                <c:set var="total" value="${0}" scope="page"/>
                <c:forEach items="${basket.basketProducts}" var="basketItem">

                    <c:forEach items="${basketItem.value.product.productTranslations}" var="translation">
                        <c:if test="${cookie.localeCookie.value == translation.getLanguage().getCode()}">

                            <c:set var="name" value="${translation.getProductName()}" scope="page"/>
                            <c:set var="price" value="${basketItem.value.product.getPrice()}" scope="page"/>
                            <c:set var="quantity" value="${basketItem.value.getQuantity()}" scope="page"/>

                            <div class="d-flex align-items-center justify-content-between my-3 w-100">
                                <h5>${name}</h5>
                                <h6>
                                    <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${price}"/> €
                                </h6>
                                <form:input
                                        path="basketProducts[${basketItem.key}].quantity"
                                        type="number"
                                        value="${quantity}"
                                        min="0"
                                        class="form-control"
                                        cssStyle="width: 100px"/>
                                <h6>
                                    <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${price * quantity}"/> €
                                </h6>
                            </div>

                            <c:set var="total" value="${total + (price * quantity)}" scope="page"/>

                        </c:if>
                    </c:forEach>
                </c:forEach>
            </div>
            <div class="d-flex w-75 mt-4 align-items-center justify-content-end">
                <c:if test="${basket.basketProducts.size() > 0}">
                    <h2>
                        <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${total}"/> €
                    </h2>
                    <form:button type="submit" name="updateCart" class="btn btn-primary ml-5">
                        <spring:message code="updateCart"/>
                    </form:button>
                    <form:button type="submit" name="placeOrder" class="btn btn-primary ml-5">
                        <spring:message code="checkout"/>
                    </form:button>
                </c:if>
            </div>
            <div class="d-flex w-75 mt-4 align-items-center justify-content-center">
                <c:if test="${basket.basketProducts.isEmpty()}">
                    <h5>
                        <spring:message code="emptyBasket"/>
                    </h5>
                </c:if>
            </div>
        </form:form>
    </div>
</body>
</html>
