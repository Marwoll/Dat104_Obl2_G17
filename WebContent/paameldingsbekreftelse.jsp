<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
<h2>P�meldingsbekreftelse</h2>
<p>P�meldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp;<c:if test="${not empty fornavn}">
    ${fornavn}
</c:if><br/>
&nbsp;&nbsp;&nbsp;<c:if test="${not empty etternavn}">
    ${etternavn}
</c:if><br/>
&nbsp;&nbsp;&nbsp;<c:if test="${not empty mobil}">
    ${mobil}
</c:if><br/>
&nbsp;&nbsp;&nbsp;<c:if test="${not empty kjonn}">
    ${kjonn}
</c:if></p>
<p><b>NB! Husk � betale til kassereren f�r festen!</b></p>
<a href="deltagerliste.jsp">G� til deltagerlisten</a>
</body>
</html>