<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/importTags.jsp"%>

<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<%--<table>
    <c:forEach var="pizza" items="${ContentCart}">
        <tr>
            <td></td>
        </tr>
    </c:forEach>
</table>--%>

<table border="5">
    <c:forEach var="pizza" items="${ContentCart}">
        <tr>
            <td>
                <c:out value="${pizza.id}" />
            </td>
            <td>
                <c:out value="${pizza.name}" />
            </td>
            <td>
                <c:out value="${pizza.price}" />  euro
            </td>
            <td>
             <%--   <c:out value="${pizza.category.name}" />--%>
            </td>
            <td>
                <form:form  method="POST"
                            action="/cart/sendAdd"
                            modelAttribute="pizzaEdit">
                    <form:hidden path="id" value="${pizza.id}"/>
                    <form:button><i></i></form:button>
                </form:form>
               <%-- <button id="<c:out value="${pizza.id}" />"path="sendMin">-</button>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<div>${Total}
    <input type="button"  onclick= 'testSend()' value="Register" >
    <%--<div><button:button path="send">Send</button:button></div>--%>
<%--<table>
    <!-- here should go some titles... -->
    <tr>
        <th>Pizza</th>
        <th>Prix</th>

    </tr>
    <c:forEach begin="1" end= "${ no }" step="1" varStatus="loopCounter"
               value="${test}" var="book">
        <tr>
            <td>
                <c:out value="${book.isbn}" />
            </td>
            <td>
                <c:out value="${book.title}" />
            </td>
            <td>
                <c:out value="${book.authors}" />
            </td>
            <td>
                <c:out value="${book.version}" />
            </td>
        </tr>
    </c:forEach>
</table>--%>
</body>
<%--

<script>
function testSend()
{
    $.ajax(
        {
            type: 'POST',
            url:"Cart/sendAdd",
            data: id.valueOf(),
            dataType: 'json',
            success: function(result){},
        }
    );
}
</script>--%>
