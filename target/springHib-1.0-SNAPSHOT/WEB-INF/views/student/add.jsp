<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>

<table>
    <form:form method="post"
               modelAttribute="student">

        <tr>
            <th>
                First name:
                <form:input path="firstName"/>
            </th>
        </tr>
        <tr>
            <th>
                Last name:
                <form:input path="lastName"/>
            </th>
        </tr>
        <tr>
            <th>
                Gender
                Male: <form:radiobutton path="gender" value="M"/>
                Female: <form:radiobutton path="gender" value="F"/>
            </th>
        </tr>
        <tr>
            <th>
                Country
                <form:select path="country" items="${countries}"/>
            </th>
        </tr>
        <tr>
            <th>
                Notes
                <form:textarea path="notes" rows="3"
                               cols="20"/>
            </th>
        </tr>
        <tr>
            <th>
                Mailing list
                <form:checkbox path="mailingList"
                               value="true"/>
            </th>
        </tr>
        <tr>
            <th>
                Programming skills
                <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
            </th>
        </tr>
        <tr>
            <th>
                hobbies (grupa checkboxów)
                <form:checkboxes items="${hobbies}" path="hobbies"/>
            </th>
        </tr>
        <tr>
            <th>
                <input type="submit" value="Save">
            </th>
        </tr>
    </form:form>

</table>
</body>
</html>
