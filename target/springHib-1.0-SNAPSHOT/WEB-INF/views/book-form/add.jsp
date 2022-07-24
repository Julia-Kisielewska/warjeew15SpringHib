<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <form:input path="title"/>
    <form:input path="rating"/>
    <form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name"/>

    <input type="submit" value="Save">
</form:form>
</body>
</html>