
<%@ include file="../jsp/include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Logo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/home">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Pizza</a>
                </li>


                <li class="nav-item">
                    <span class="fi-cart"></span>
                    <a class="nav-link" href="#">Panier</a>
                </li>

                <li class="nav-item">
                    <div class="dropdown show">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Langage
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="#">En</a>
                            <a class="dropdown-item" href="#">Fr</a>
                        </div>
                    </div>
                </li>

                <li class="nav-item">
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
        </div>
    </div>
</nav>