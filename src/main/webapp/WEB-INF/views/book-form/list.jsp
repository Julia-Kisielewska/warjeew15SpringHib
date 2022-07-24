<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/book-form/add"/>">dodaj</a>
<table>
    <tr>
        <th>title</th>
        <th>rating</th>
        <th>publisher</th>
        <th>action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>

            <td>
                <a href="<c:url value="/book-form/delete?id=${book.id}"/>">usuń</a>
                <a href="<c:url value="/book-form/edit?id=${book.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>