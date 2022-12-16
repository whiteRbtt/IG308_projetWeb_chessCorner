<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>

<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
<%--        <h1>Hello World ${name}</h1>--%>
<%--        <img src= '<spring:url value="/images/clock_green.jpg"/>' width="250px"/>--%>
        <div class="container">
            <h1>Employee Register Form:</h1>
            <div class="card">
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/register" method="post">

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">First Name</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="firstName"
                                       placeholder="Enter first name">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Last Name</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="lastName"
                                       placeholder="Enter last name">
                            </div>
                        </div>

                        <div class=" form-group row">
                            <label class="col-sm-2 col-form-label">User Name</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="username"
                                       placeholder="Enter user name">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Passwrod</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" name="password"
                                       placeholder="Enter Password">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Address</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="address"
                                       placeholder="Enter Address">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Contact No</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="contact"
                                       placeholder="Enter Contact Address">
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>