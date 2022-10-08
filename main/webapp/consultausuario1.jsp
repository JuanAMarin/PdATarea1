<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso" %>
<%@ page import="logica.Profesor" %>
<%@ page import="logica.Socio" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/consultausuario1.css">
	
<meta charset="UTF-8">
<title>ConsultaUsuario</title>
</head>
<body>
	<div id="contenedorcentrado">
                <div id="login">
                    <form id="consultaform" action="ConsultaUsuario1">
                   
                        <% 	Acceso ac = Acceso.getInstancia();
                        	Profesor p = ac.getP();
                        	if(p==null){
                        		Socio s = ac.getS();
                        %> 
                        	<label>Nickname </label><h1><%=s.getNickname()%></h1>
							<label>Nombre </label><h1><%=s.getNombre()%></h1>
							<label>Apellido </label><h1><%=s.getApellido()%></h1>
							<label>Fecha de Nacimiento </label><h1><%=s.getFechaNac()%></h1>
							<label>Email </label><h1><%=s.getEmail()%></h1>
                        <%	
                        	}else{
                        %>
						<label>Nickname </label><h1><%=p.getNickname()%></h1>
						<label>Nombre </label><h1><%=p.getNombre()%></h1>
						<label>Apellido </label><h1><%=p.getApellido()%></h1>
						<label>Fecha de Nacimiento </label><h1><%=p.getFechaNac()%></h1>
						<label>Email </label><h1><%=p.getEmail()%></h1>
						<label>Biografía </label><h1><%=p.getBiografia()%></h1>
						<label>Descripción </label><h1><%=p.getDescripcion()%></h1>
						<label>Sitio Web </label><h1><%=p.getSitioweb()%></h1>
						<%
                        	}
						%>
                        
                    </form>
                    
                </div>
            </div>
</body>
</html>