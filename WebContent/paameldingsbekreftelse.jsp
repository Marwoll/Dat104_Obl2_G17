<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
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
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="deltagerliste.jsp">Gå til deltagerlisten</a>
</body>
</html>