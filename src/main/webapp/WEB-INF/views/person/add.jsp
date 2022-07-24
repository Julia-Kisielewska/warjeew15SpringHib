
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <form:input path="login"/>
    <form:input path="password"/>
    <form:input path="email"/>
    <input type="submit">
</form:form>

<a href="<c:url value="/person/list"/>">lista</a>
</body>
</html>