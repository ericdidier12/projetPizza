<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp" %>
<%@include file="include/importLinks.jsp" %>

<div class="row"> <h2><spring:message code="registerUser"/> </h2>  </div>
<form:form id="form" method="POST" action="${pageContext.request.contextPath}/user/register/send"  modelAttribute="currentUser"  >

    <div class="form-row">
        <div class="form-group col-md-6" <spring:message code="fakeName" var="fakenamePlaceHolder"/>>
            <form:label  path="name" for="name"><spring:message code="firstSecondName"/></form:label>
            <form:input  path="name" class="form-control" id="name" placeholder="${fakenamePlaceHolder}"/>
            <form:errors path="name" cssClass="error"/>
        </div>

        <div class="form-group col-md-6"<spring:message code="fakeusername" var="fakeusernamePlaceHolder"/>>
            <form:label  path="username" for="username"><spring:message code="username"/></form:label>
            <form:input  path="username" class="form-control" id="username" placeholder="${fakeusernamePlaceHolder}"/>
            <form:errors path="username" cssClass="error"></form:errors>

        </div>

        <div class="form-group col-md-6">
            <form:label  path="password" for="password"><spring:message code="password"/></form:label>
            <form:password path="password" class="form-control" id="password" placeholder="********************"/>
            <form:errors path="password" cssClass="error"></form:errors>
        </div>

        <div class="form-group col-md-6" <spring:message code="fakeEmail" var="fakeEmailPlaceHolder"/>>
            <form:label path="email" for="email">Email</form:label>
            <form:input  path="email"  class="form-control" id="email" placeholder="${fakeEmailPlaceHolder}"/>
            <form:errors path="email" cssClass="error"></form:errors>
        </div>

        <div class="form-group col-md-6" <spring:message code="fakeAddress" var="fakeAddressPlaceHolder"/>>
            <form:label path="adress" for="adress"><spring:message code="address"/> </form:label>
            <form:input  path="adress" class="form-control" id="adress" placeholder="${fakeAddressPlaceHolder}"/>
            <form:errors path="adress" cssClass="error"></form:errors>
        </div>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="Signin"/></button>
</form:form>