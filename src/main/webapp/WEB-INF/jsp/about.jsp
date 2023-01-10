<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="aboutUs"/></title>
</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-start align-items-center">
        <h2>
            <spring:message code="aboutUs"/>
        </h2>
        <p class="mt-5">
            <spring:message code="aboutUsContent"/>
        </p>
    </div>
</body>
</html>