<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html ; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html lang="en">
    <head>
        <meta  http-equiv="Content-Type" content="type=text/html ; charset=UTF-8" />
        <title> Welcome </title>
    </head>
    <body>
        Page Login!

        <form:form method="post" modelAttribute="toto">
            Username :<form:input path="username" />
            <br/>
            Password :<form:password path="password" />
            <br />
            <form:button> Send</form:button>
        </form:form>

    </body>
</html>
