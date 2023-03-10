<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="login"/></title>
</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-start align-items-center">

        <h2 class="mb-4">
            <spring:message code="login"/>
        </h2>

        <form:form class="w-50" id="loginForm" method="POST" action="" modelAttribute="user">

            <div class="form-group">
                <form:label path="username">
                    <spring:message code="mail"/>
                </form:label>
                <form:input path="username" type="email" class="form-control mt-2"/>
            </div>

            <div class="form-group">
                <form:label path="password">
                    <spring:message code="password"/>
                </form:label>
                <form:input path="password" type="password" class="form-control mt-2"/>
            </div>

            <form:button type="submit" class="btn btn-primary mt-4">Login</form:button>

        </form:form>
    </div>
</body>
</html>
