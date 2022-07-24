<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/person/add"/>">dodaj</a>
<table>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.login}</td>
            <td>${person.password}</td>
            <td>${person.email}</td>
            <td>
                <a href="<c:url value="/person/delete?id=${person.id}"/>">usuń</a>
                <a href="<c:url value="/person/edit?id=${person.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>