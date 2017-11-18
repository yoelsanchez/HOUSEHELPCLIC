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
    <title>Create Contract</title>
</head>
<body>
<s:form action="contract">
    <s:label form="CodeContract" value="Codigo Contrato"/>
    <s:textfield id="CodeContract" name="codeContract"/>

    <s:label form="CodeClient" value="Codigo Cliente"/>
    <s:textfield id="CodeClient" name="codeClient"/>

    <s:label form="CodeTechnician" value="Codigo Tecnico"/>
    <s:textfield id="CodeTechnician" name="codeTechnician"/>

    <s:label form="CodeQuotation" value="Codigo cotizacion"/>
    <s:textfield id="CodeQuotation" name="codeQuotation"/>

    <s:label form="DateContract" value="Fecha del Contrato"/>
    <s:textfield id="DateContract" name="dateContract"/>

    <s:label form="TotalCostContract" value="Costo Total del Contrato"/>
    <s:textfield id="TotalCostContract" name="totalCostContract"/>

    <s:label form="StateContract" value="Estado del Contrato"/>
    <s:textfield id="StateCostContract" name="stateContract"/>

    <s:label form="AssistanceReason" value="Rason de Asistencia"/>
    <s:textfield id="AssistanceReason" name="assistanceReason"/>

    <s:label form="RatingScore" value="Puntaje"/>
    <s:textfield id="RatingScore" name="ratingScore"/>

    <s:label form="RatingState" value="Estado de Calificacion"/>
    <s:textfield id="RatingState" name="ratingState"/>

    <s:label form="RatingCommentary" value="Comentario de la Calificacion"/>
    <s:textfield id="RatingCommentary" name="ratingCommentary"/>

    <s:submit value="Submit"/>
</s:form>
</body>
</html>
