<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>

<html>
<head>
    <title>pages template</title>
    <link type="text/css" rel="stylesheet" href='<spring:url value="/css/first.css"/>' >
</head>
<body>
    <div>
        Header
    </div>
    <div>
        <tiles:insertAttribute name="main-content" />
    </div>
    <div>
        Footer
    </div>
</body>
</html>
