<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 17/11/2017
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Answer</title>

</head>
<body>
<s:form action="answer">
    <s:label form="CodeAnswer" value="Codigo de Respuesta"/>
    <s:textfield id="CodeAnswer" name="codeAnswer"/>

    <s:label form="CodeTechnician" value="Codigo del Tecnico"/>
    <s:textfield id="CodeTechnician" name="codeTechnician"/>

    <s:label form="CodeQuotation" value="Codigo de Cotizacion"/>
    <s:textfield id="CodeQuotation" name="codeQuotation"/>

    <s:label form="CodeClient" value="Codigo de Client"/>
    <s:textfield id="CodeClient" name="codeClient"/>

    <s:label form="DateAnswer" value="Fecha de la Respuesta"/>
    <s:textfield id="DateAnswer" name="dateAnswer"/>

    <s:label form="CommentAnswer" value="Comentario"/>
    <s:textfield id="CommentAnswer" name="commentAnswer"/>

    <s:label form="PriceAnswer" value="Precio"/>
    <s:textfield id="PriceAnswer" name="priceAnswer"/>

    <s:submit value="Submit"/>
</s:form>
</body>
</html>
