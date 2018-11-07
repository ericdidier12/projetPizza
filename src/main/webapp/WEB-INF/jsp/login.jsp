<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html>
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
                    <!-- Sign in button -->
                    <form:button class="btn btn-info btn-block my-4" type="submit">Sign in</form:button>
                    <!-- Register -->
                    <p>Not a member?
                        <a href="${pageContext.request.contextPath}/user/register">Register</a>
                    </p>

                </form:form>
                <!-- Default form login -->

    </body>
</html>
