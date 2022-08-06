<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate Author</title>
</head>
<body>
<table>
    <tr>
        <th>Nazwa pola</th>
        <th> : </th>
        <th>Nazwa błędu</th>
    </tr>
    <c:forEach items="${validationResult}" var="validation">
        <tr>
            <th> ${validation.propertyPath}</th>
            <th> : </th>
            <th> ${validation.message}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
