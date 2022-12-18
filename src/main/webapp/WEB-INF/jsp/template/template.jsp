<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>

<!doctype html>
<html class="min-vh-100">
<head>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
          crossorigin="anonymous">
</head>
<body class="min-vh-100">

    <nav class="navbar" role="navigation">
        <div class="d-flex w-50 justify-content-start align-items-center flex-nowrap p-2">
            <a class="navbar-brand" href="<spring:url value='/'/>">
                <img src='<spring:url value="/images/logo.png"/>' alt="logo" width="40">
            </a>
            <a class="ml-4 text-secondary" href="<spring:url value='/'/>">
                Home
            </a>
            <a class="ml-4 text-secondary" href="<spring:url value='/product/all'/>">
                Products
            </a>
        </div>

        <div class="d-flex collapse w-50 justify-content-end align-items-center flex-nowrap p-2">
            <div class="pr-4">
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-info" href="<spring:url value='/login'/>">Login</a>
                    <a role="button" class="btn btn-outline-info" href="<spring:url value='/register'/>">Register</a>
                </div>
            </div>

            <div class="dropdown pr-4">
                <button class="btn btn-outline-dark dropdown-toggle he" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src='<spring:url value="/images/en_flag.png"/>' class="pr-1" style="height: 25px" alt="uk flag">
                    Language
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">French</a>
                </div>
            </div>

            <a href="<spring:url value='/basket'/>">
                <button class="btn btn-outline-dark" type="submit">
                    <img src='<spring:url value="/images/cart.png"/>' style="height: 25px" alt="basket icon">
                </button>
            </a>
        </div>
    </nav>

    <div class="d-flex min-vh-100 m-5 border border-danger">
        <tiles:insertAttribute name="main-content" />
    </div>

    <footer class="d-flex w-100 justify-content-center align-items-center py-4 border-top sticky-bottom">
        <div class="d-flex w-75 justify-content-between">
            <p>Chess corner 2023 - <a href="<spring:url value='/about'/>">About us</a></p>
            <p>Made with love and coffee</p>
        </div>
    </footer>

    <script
            src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous">

    </script>
    <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous">

    </script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous">

    </script>
</body>
</html>
