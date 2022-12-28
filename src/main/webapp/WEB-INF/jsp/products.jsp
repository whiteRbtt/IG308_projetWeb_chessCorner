<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="products"/></title>

</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-center align-items-center">
        <h2>
            <spring:message code="availablesProductsForSale"/>
        </h2>

        <div class="d-flex w-100 mt-4 justify-content-center align-items-center flex-wrap">
            <c:forEach items="${products}" var="product">
                <c:forEach items="${product.productTranslations}" var="translation">
                    <c:if test="${cookie.localeCookie.value == translation.getLanguage().getCode()}">
                        <div class="card m-3" style="width: 300px">
                            <div class="card-body">
                                <img src='<spring:url value="/images/products/product${product.productId}.jpg"/>'
                                     class="card-img-top mb-4"
                                     style="height: 200px"
                                >
                                <h5 class="card-title">${translation.getProductName()}</h5>
                                <p class="card-text" style="font-style: italic; color: green">${product.price} €</p>
                                <a href="<spring:url value='/product?id=${product.productId}'/>" class="btn btn-primary">
                                    <spring:message code="discover"/>
                                </a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </div>
    </div>
</body>
</html>
