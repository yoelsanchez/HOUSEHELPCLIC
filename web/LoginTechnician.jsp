<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 17/11/2017
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Technician</title>
</head>
<body>

<s:form action="technician">
    <s:label form="CodeTechnician" value="Codigo del Tecnico"/>
    <s:textfield id="CodeTechnician" name="codeTechnician"/>

    <s:label form="PasswordTech" value="Contraseña"/>
    <s:textfield id="PasswordTech" name="passwordTech"/>

    <s:submit value="Submit"/>
</s:form>

</body>
</html>
