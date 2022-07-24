<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<br> First name : ${student.firstName} <br/>
<br> Last name : ${student.lastName} <br/>
<br> ${student.gender} <br/>
<br> ${student.country} <br/>
<br> ${student.mailingList} <br/>
<br> <c:forEach items="${student.country}" var="country">
    ${country} </c:forEach><br/>
<br> <c:forEach items="${student.programmingSkills}" var="skill">
    ${skill} </c:forEach><br/>

<br> <c:forEach items="${student.hobbies}" var="hobby">
    ${hobby} </c:forEach><br/>
</body>
</html>
