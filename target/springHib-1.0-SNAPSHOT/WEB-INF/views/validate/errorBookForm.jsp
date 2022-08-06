<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Book Form</title>
</head>
<body>

<form:form method="post" modelAttribute="book">

    <label>title</label>
    <form:input path="title"></form:input>
    <form:errors path="title" cssClass="error-class"/>
    <br>

    <label>description</label>
    <form:input path="description"></form:input>
    <form:errors path="description" cssClass="error-class"/>

    <input type="submit">
</form:form>

</body>
</html>
