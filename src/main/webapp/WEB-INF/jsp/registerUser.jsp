<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp" %>
<%@include file="include/importLinks.jsp" %>
<div class="row"> <h2>Register User </h2>  </div>
<form:form id="form" method="POST" action="${pageContext.request.contextPath}/user/register/send"  modelAttribute="currentUser"  >

    <div class="form-row">
        <div class="form-group col-md-6">
            <form:label  path="name" for="name">First & Second Name</form:label>
            <form:input  path="name" class="form-control" id="name" placeholder="First Name and Second Name"/>
            <form:errors path="name" cssClass="error"/>
        </div>

        <div class="form-group col-md-6">
            <form:label  path="username" for="username">Username</form:label>
            <form:input  path="username" class="form-control" id="username" placeholder="username"/>
            <form:errors path="username" cssClass="error"></form:errors>

        </div>

        <div class="form-group col-md-6">
            <form:label  path="password" for="password">Password</form:label>
            <form:password path="password" class="form-control" id="password" placeholder="Password"/>
            <form:errors path="password" cssClass="error"></form:errors>
        </div>

        <div class="form-group col-md-6">
            <form:label path="email" for="email">Email</form:label>
            <form:input  path="email"  class="form-control" id="email" placeholder="Email"/>
            <form:errors path="email" cssClass="error"></form:errors>
        </div>

        <div class="form-group col-md-6">
            <form:label path="adress" for="adress">adress </form:label>
            <form:input  path="adress" class="form-control" id="adress" placeholder="Avenue Paris,1050,Bruxelles"/>
            <form:errors path="adress" cssClass="error"></form:errors>
        </div>

    </div>


    <button type="submit" class="btn btn-primary">Sign in</button>
</form:form>