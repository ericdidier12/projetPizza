<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/importTags.jsp"%>
<%--<%@include file="include/importLinks.jsp"%>--%>

<!-- Page Content -->
<div class="container">
  ${user}
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
        <h1 class="display-3">Bienvenu dans notre Pizzeria!</h1>
        <p class="lead">
            Soyez les bienvenu au 3 rue des pommes, 1954 Fleur,
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
        <div>
            <img src="<spring:url value="/images/imagePiza.jpg"/>"/>
        </div>
    </header>

    <!-- Page Features -->
    <div class="row text-center">
        <div class="col-lg-6 col-md-6 mb-4">
            <div class="card">
                <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                <div class="card-body">
                    <h4 class="card-title">Card title</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Find Out More!</a>
                </div>
            </div>
        </div>

        <div class="col-lg-6 col-md-6 mb-4">
            <div class="card">
                <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                <div class="card-body">
                    <h4 class="card-title">Card title</h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Find Out More!</a>
                </div>
            </div>
        </div>

    </div>
    <!-- /.row -->
</div>
<!-- /.container -->