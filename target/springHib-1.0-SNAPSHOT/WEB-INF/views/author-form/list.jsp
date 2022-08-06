<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/author-form/add"/>">dodaj</a>
<table>
    <tr>
        <th>first name</th>
        <th>last name</th>
        <th>action</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
                <a href="<c:url value="/author-form/delete?id=${author.id}"/>">usuń</a>
                <a href="<c:url value="/author-form/edit?id=${author.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>