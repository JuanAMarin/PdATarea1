<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="interfaces.Acceso" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú</title>
</head>
<body>
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getP()!=null){%>
		<jsp:include page="headerP.jsp" />
	<%}else{%>
		<jsp:include page="headerS.jsp" />
	<%}%>
</body>
</html>


