<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="type=text/html ; charset=UTF-8"/>
        <title>Welcome</title>
    </head>
    <body>

                <!-- Default form login -->
                <form:form method="post" modelAttribute="userLogin" class="text-center border border-light p-5">

                    <p class="h4 mb-4">Sign in</p>

                    <!-- username -->
                    <form:input path="username" placeholder="username" class="form-control mb-4"/>

                    <!-- Password -->
                    <form:password path="password" class="form-control mb-4" placeholder="Password"/>

                    <%--<div class="d-flex justify-content-around">--%>
                        <%--<div>--%>
                            <%--<!-- Remember me -->--%>
                            <%--<div class="custom-control custom-checkbox">--%>
                                <%--<input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">--%>
                                <%--<label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div>--%>
                            <%--<!-- Forgot password -->--%>
                            <%--<a href="#">Forgot password?</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <!-- Sign in button -->
                    <form:button class="btn btn-info btn-block my-4" type="submit">Sign in</form:button>

                    <!-- Register -->
                    <p>Not a member?
                        <a href="${pageContext.request.contextPath}/account/register">Register</a>
                    </p>

                    <!-- Social login -->
                    <p>or sign in with:</p>

                    <a type="button" class="light-blue-text mx-2">
                        <i class="fa fa-facebook"></i>
                    </a>
                    <a type="button" class="light-blue-text mx-2">
                        <i class="fa fa-twitter"></i>
                    </a>
                    <a type="button" class="light-blue-text mx-2">
                        <i class="fa fa-linkedin"></i>
                    </a>
                    <a type="button" class="light-blue-text mx-2">
                        <i class="fa fa-github"></i>
                    </a>

                </form:form>
                <!-- Default form login -->

    </body>
</html>
