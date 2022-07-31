<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<a href="<c:url value="/book-form/list"/>">wstecz</a>

<form:form method="post" modelAttribute="book">
    <table>
        <tr>
            Czy jesteś pewny, że chcesz usunąć ksiązkę:
        </tr>
    </table>
    <table>
        <tr>
            <th>title</th>
            <th>rating</th>
            <th>publisher</th>
        </tr>
        <tr>
            <td> ${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
    </table>
    <input type="submit" value="Usuń">
</form:form>

<%--<a href="<c:url value="/book-form/delete?id=${book.id}"/>">usuń</a>--%>

</body>
</html>
