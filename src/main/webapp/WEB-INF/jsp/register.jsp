<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <title>${title} - <spring:message code="register"/></title>
</head>
<body>
    <div class="d-flex w-100 flex-column justify-content-start align-items-center">

        <h2 class="mb-4">
            <spring:message code="register"/>
        </h2>

        <form:form class="w-50" id="registerForm" method="POST" action="" modelAttribute="user">

            <div class="form-group">
                <form:label path="lastName"><spring:message code="LastName"/></form:label>
                <form:input path="lastName" type="text" class="form-control" required="required"/>
                <form:errors path="lastName">
                    <spring:message code="Pattern.registerForm.firstName" />
                </form:errors>
            </div>
            <div class="form-group">
                <form:label path="firstName"><spring:message code="firstName"/></form:label>
                <form:input path="firstName" type="text" class="form-control" required="required"/>
                <form:errors path="firstName">
                    <spring:message code="Pattern.registerForm.firstName" />
                </form:errors>
            </div>
            <div class="form-group">
                <form:label path="username"><spring:message code="mail"/></form:label>
                <form:input path="username" type="email" class="form-control" required="required"/>
                <form:errors path="username">
                    <c:choose>
                        <c:when test="${alreadyRegistered != null}">
                            <spring:message code="Constraint.Unique.registerForm.username" />
                        </c:when>
                        <c:otherwise>
                            <spring:message code="Pattern.registerForm.username" />
                        </c:otherwise>
                    </c:choose>
                </form:errors>
            </div>
            <div class="form-group">
                <form:label path="password"><spring:message code="password"/></form:label>
                <form:input path="password" type="password" class="form-control" required="required"/>
                <form:errors path="password">
                    <spring:message code="Size.registerForm.password" />
                </form:errors>
            </div>
            <div class="form-group">
                <form:label path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
                <form:input path="phoneNumber" type="text" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="address"><spring:message code="address"/></form:label>
                <form:input path="address" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
                <form:label path="birthDate"><spring:message code="birthDate"/></form:label>
                <form:input path="birthDate" type="date" class="form-control" required="required"/>
                <form:errors path="birthDate">
                    <c:choose>
                        <c:when test="${minYearNotValid != null}">
                            <spring:message code="Min.registerForm.birthDate" />
                        </c:when>
                        <c:otherwise>
                            <spring:message code="Pattern.registerForm.birthDate" />
                        </c:otherwise>
                    </c:choose>
                </form:errors>
            </div>

            <form:button type="submit" class="btn btn-primary mt-4">
                <spring:message code="register"/>
            </form:button>

        </form:form>
    </div>
</body>
</html>
