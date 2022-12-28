<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="products"/></title>
</head>
<body>
    <div class="d-flex w-100 mt-5 justify-content-start align-items-start">
        <div class="d-flex w-50 justify-content-center align-items-center">
            <img src='<spring:url value="/images/products/product${product.getProductId()}.jpg"/>'
                 class="my-4"
                 style="height: 200px"
            >
        </div>

        <div class="d-flex w-50 flex-column">
            <h1 class="mb-5">${name}</h1>
            <p class="mb-4">${description}</p>

            <form:form id="basketItem" action="/chesscorner/product/add?id=${product.getProductId()}" method="POST" modelAttribute="basketItem">
                <div class="d-flex justify-content-start align-items-center">
                    <div class="d-flex flex-column align-items-start">
                        <form:input path="quantity" min="1" max="99" value="1"/>

                        <div class="mt-3">
                            <form:errors path="quantity">
                                <spring:message code="basketItem.quantity"/>
                            </form:errors>
                        </div>
                    </div>

                    <form:button class="btn btn-primary ml-5" type="submit">
                        <spring:message code="addCart"/>
                    </form:button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
