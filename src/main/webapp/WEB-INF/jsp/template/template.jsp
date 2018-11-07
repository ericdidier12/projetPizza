<%@ include file="../include/importTags.jsp" %>
<%--<%@ include file="../include/importLinks.jsp" %>--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <link type="text/css" href="<spring:url value='/css/webApp.css'/>" rel="stylesheet"/>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div>
    <header>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="#">Logo</a>

            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li class="nav-item">
                    <a class="nav-link"><i class="fa fa-envelope"></i> <span class="clearfix d-none d-sm-inline-block">Home</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link"><i class="fa fa-shopping-basket" aria-hidden="true"></i> <span
                            class="clearfix d-none d-sm-inline-block">Panier</span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Langage
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">French</a>
                        <a class="dropdown-item" href="#">English</a>
                    </div>
                </li>

                <li class="nav-item"><i class="fa fa-sign-in" aria-hidden="true"></i>
                    <a href="href="${pageContext.request.contextPath}/login">
                    <button type="button" class="btn">
                        <sec:authorize access="!isAuthenticated()">
                            Login
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            Logout
                        </sec:authorize></button>
                    </a>
                </li>
            </ul>
        </nav>
    </header>
</div>

<div class="container">
    <tiles:insertAttribute name="main-content"/>
</div>

<!---- footer --->
<div class="footer">
    <p class="copyright">Copyright @ 2018-2020 </p>
    <p class="site">Website developped by Eric & Sébatien </p>
</div>

</body>
</html>