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
    <title>Create Quotation</title>
</head>
<body>
<s:form action="quotation">
    <s:label form="CodeQuotation" value="Codigo Cotizacion"/>
    <s:textfield id="CodeQuotation" name="codeQuotation"/>

    <s:label form="CodeClient" value="Codigo Cliente"/>
    <s:textfield id="CodeClient" name="codeClient"/>

    <s:label form="CodeTypeQuotation" value="Codigo Typo de Cotizacion"/>
    <s:textfield id="CodeTypeQuotation" name="codeTypeQuotation"/>

    <s:label form="CodeJob" value="Codigo de Trabajo"/>
    <s:textfield id="CodeJob" name="codeJob"/>

    <s:label form="TitleSubject" value="Titulo del Asunto"/>
    <s:textfield id="TitleSubject" name="titleSubject"/>

    <s:label form="DetailSubject" value="Detalle del Asunto"/>
    <s:textfield id="DetailSubject" name="detailSubject"/>

    <s:label form="VisitCost" value="Costo de la Visita"/>
    <s:textfield id="VisitCost" name="visitCost"/>

    <s:label form="AddressSubject" value="Direccion del Asunto"/>
    <s:textfield id="AddressSubject" name="addressSubject"/>

    <s:label form="StartSubject" value="Inicio Hora"/>
    <s:textfield id="StartSubject" name="startSubject"/>

    <s:label form="EndSubject" value="Fin Hora"/>
    <s:textfield id="EndSubject" name="endSubject"/>

    <s:label form="DateSubject" value="Fecha hora"/>
    <s:textfield id="DateSubject" name="dateSubject"/>

    <s:label form="StateQuotation" value="Estado de Cotizacion"/>
    <s:textfield id="StateQuotation" name="stateQuotation"/>

    <s:label form="CountAnswerQuotation" value="Contador de Respuestas"/>
    <s:textfield id="CountAnswerQuotation" name="countAnswerQuotation"/>

    <s:submit value="Submit"/>
</s:form>

</body>
</html>
