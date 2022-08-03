<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/publisher-form/add"/>">dodaj</a>
<table>
    <tr>
        <th>name</th>
        <th>action</th>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td>
                <a href="<c:url value="/publisher-form/delete?id=${publisher.id}"/>">usuń</a>
                <a href="<c:url value="/publisher-form/edit?id=${publisher.id}"/>">edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>