<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 17/11/2017
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Client</title>
</head>
<body>
<s:form action="client">
    <s:label form="CodeClient" value="Codigo Cliente"/>
    <s:textfield id="CodeClient" name="codeClient"/>

    <s:label form="CodeDistrict" value="Codigo Distrito"/>
    <s:textfield id="CodeDistrict" name="codeDistrict"/>

    <s:label form="NameClient" value="Nombre Cliente"/>
    <s:textfield id="NameClient" name="nameClient"/>

    <s:label form="LastNameClient" value="Apellido Cliente"/>
    <s:textfield id="LastNameClient" name="lastNameClient"/>

    <s:label form="AgeClient" value="Edad"/>
    <s:textfield id="AgeClient" name="ageClient"/>

    <s:label form="CellPhoneClient" value="Numero Celular"/>
    <s:textfield id="CellPhoneClient" name="cellPhoneClient"/>

    <s:label form="AddressClient" value="Direccion"/>
    <s:textfield id="AddressClient" name="addressClient"/>

    <s:label form="PasswordClient" value="Contraseña"/>
    <s:textfield id="PasswordClient" name="passwordClient"/>

    <s:submit value="Submit"/>
</s:form>

</body>
</html>
