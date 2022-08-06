<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<a href="<c:url value="/author-form/list"/>">wstecz</a>

<form:form method="post" modelAttribute="author">
    <table>
        <tr>
            Czy jesteś pewny, że chcesz usunąć autora:
        </tr>
    </table>
    <table>
        <tr>
            <th>first name</th>
            <th>last name</th>
        </tr>
        <tr>
            <td> ${author.firstName}</td>
            <td>${author.lastName}</td>
    </table>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
