<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title}</title>
</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-start align-items-center">
        <h3 class="my-3">
            <spring:message code="homeContent"/>
        </h3>

        <div class="carousel slide mb-5" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src='<spring:url value="/images/products/board_vinyl.jpg"/>' class="d-block" alt="board_vinyl" style="width: 400px">
                </div>
                <div class="carousel-item">
                    <img src='<spring:url value="/images/products/clock_green.jpg"/>' class="d-block" alt="clock_green" style="width: 400px">
                </div>
                <div class="carousel-item">
                    <img src='<spring:url value="/images/products/piece_metal.jpg"/>' class="d-block" alt="piece_metal" style="width: 400px">
                </div>
                <div class="carousel-item">
                    <img src='<spring:url value="/images/products/board_red.jpg"/>' class="d-block" alt="board_red" style="width: 400px">
                </div>
                <div class="carousel-item">
                    <img src='<spring:url value="/images/products/travel_set.jpg"/>' class="d-block" alt="travel_set" style="width: 400px">
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-center mt-3 w-50">
            <a role="button" class="btn btn-info mr-5" href="<spring:url value='/about'/>">
                <spring:message code="aboutUs"/>
            </a>

            <a role="button" class="btn btn-info" href="<spring:url value='/product/all'/>">
                <spring:message code="products"/>
            </a>
        </div>


    </div>
</body>
</html>