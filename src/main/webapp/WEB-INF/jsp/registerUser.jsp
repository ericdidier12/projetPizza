<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="include/importLinks.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>register</title>
</head>
<body>
<div class="row text-center">
    <h2> Register user </h2>
</div>
<div class="row">
    <form:form>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label  path="username" for="username">Username</form:label>
                <form:input  path="username" class="form-control" id="username" placeholder="username"/>
            </div>

            <div class="form-group col-md-6">
                <form:label path="email" for="email">Email</form:label>
                <form:input  path="email" type="email" class="form-control" id="email" placeholder="Email"/>
            </div>
            <div class="form-group col-md-6">
                <form:label  path="password" for="password">Password</form:label>
                <form:password path="password" class="form-control" id="password" placeholder="Password"/>
            </div>

            <div class="form-group col-md-6">
                <form:label path="birth_date" for="birth_date">Birth_date</form:label>
                <form:input  path="" type="date" class="form-control" id="birth_date" >
            </div>
        </div>
        <div class="form-group">
            <label for="street">Street</label>
            <input type="text" class="form-control" id="street" placeholder="1234 Main St">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">State</label>
                <select id="inputState" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="inputZip">Zip</label>
                <input type="text" class="form-control" id="inputZip">
            </div>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    Check me out
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form:form>
</div>
</body>
</html>