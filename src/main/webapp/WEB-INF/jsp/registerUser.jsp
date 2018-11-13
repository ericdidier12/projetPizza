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

       <%-- <div class="form-group col-md-6">
            <form:label path="street" for="email">Street </form:label>
            <form:input  path="street" class="form-control" id="email" placeholder="street"/>
            <form:errors path="street" cssClass="error"/>
        </div>

        <div class="form-group col-md-6">
            <form:label path="country" for="country">country </form:label>
            <form:input  path="country" class="form-control" id="country" placeholder="country"/>
            <form:errors path="country" cssClass="error"/>
        </div>
        <div class="form-group col-md-2">
            <form:label path="zip_code" for="country">zip_code </form:label>
            <form:input  path="zip_code" class="form-control" id="zip_code" placeholder="zip_code"/>
            <form:errors path="zip_code" cssClass="error"/>
        </div>

        <div class="form-group col-md-2">
            <form:label path="number" for="country">number </form:label>
            <form:input  path="number" class="form-control" id="zip_code" placeholder="number"/>
            <form:errors path="number" cssClass="error"/>
        </div>

        <div class="form-group col-md-2">
            <form:label path="box" for="country">box </form:label>
            <form:input  path="box" class="form-control" id="box" placeholder="box"/>
            <form:errors path="number" cssClass="box"/>
        </div>--%>

    </div>


    <button type="submit" class="btn btn-primary">Sign in</button>
</form:form>