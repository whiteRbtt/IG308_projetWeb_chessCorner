<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp" %>

<!doctype html>
<html>
<head>
    <title>pages template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>

    <!-- Header-->
    <nav class="navbar navbar-inverse navbar-expand-lg">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img src='<spring:url value="/images/logo.png"/>' alt="logo" width="40">
                </a>
            </div>

            <div class="d-flex w-50 justify-content-end align-items-center flex-nowrap">
                <div class="pr-4">
                    <button class="btn btn-primary" type="button">
                        Login
                    </button>
                </div>

                <div class="dropdown pr-4">

                    <button class="btn btn-outline-dark dropdown-toggle he" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src='<spring:url value="/images/en_flag.png"/>' class="pr-1 img-fluid" style="height: 25px">
                        Language
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">French</a>
                    </div>
                </div>

                <button class="btn btn-outline-dark" type="submit">
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                </button>

            </div>
        </div>
    </nav>

    <div class="d-flex justify-content-center align-items-center m-5">
        <tiles:insertAttribute name="main-content" />
    </div>

<%--    <footer class="py-4">--%>
<%--        <div class="container">--%>
<%--            <p class="m-0 text-center">Chess corner 2023. Made with love and coffee</p>--%>
<%--        </div>--%>
<%--    </footer>--%>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</body>
</html>
