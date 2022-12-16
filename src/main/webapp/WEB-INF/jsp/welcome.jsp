<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <h1>Hello World ${name}</h1>
        <img src= '<spring:url value="/images/clock_green.jpg"/>' width="250px"/>
    </body>
</html>