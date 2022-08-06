<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<a href="<c:url value="/publisher-form/list"/>">wstecz</a>

<form:form method="post" modelAttribute="publisher">
    <table>
        <tr>
            Czy jesteś pewny, że chcesz usunąć wydawcę:
        </tr>
    </table>
    <table>
        <tr>
            <th>nazwa</th>
        </tr>
        <tr>
            <td> ${publisher.name}</td>
    </table>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
