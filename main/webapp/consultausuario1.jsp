<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso" %>
<%@ page import="logica.Profesor" %>
<%@ page import="logica.Socio" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/consultausuario1.css">
	<style type="text/css">
	
	texto {font-size: x-large;}
	
	</style>
<meta charset="UTF-8">
<title>ConsultaUsuario</title>
</head>
<body>
	<div id="contenedorcentrado">
                <div id="login">
                    
<table class="demo">
	<tbody>
	<tr>
		<td style="word-break: break-word;"><% 	
                        Acceso ac = Acceso.getInstancia();
                        if(ac.getP()==null){
                        %>
                        	<h1>Nickname </h1><texto><%=ac.getS().getNickname()%></texto>
							<h1>Nombre </h1><texto><%=ac.getS().getNombre()%></texto>
							<h1>Apellido </h1><texto><%=ac.getS().getApellido()%></texto>
							<h1>Fecha de Nacimiento </h1><texto><%=ac.getS().getFechaNac()%></texto>
							<h1>Email </h1><texto><%=ac.getS().getEmail()%></texto>
                        <%	
                        }else{
                        %>
						<h1>Nickname </h1><texto><%=ac.getP().getNickname()%></texto>
						<h1>Nombre </h1><texto><%=ac.getP().getNombre()%></texto>
						<h1>Apellido </h1><texto><%=ac.getP().getApellido()%></texto>
						<h1>Fecha de Nacimiento </h1><texto><%=ac.getP().getFechaNac()%></texto>
						<h1>Email </h1><texto><%=ac.getP().getEmail()%></texto>
						<h1>Biografía </h1><texto><%=ac.getP().getBiografia()%></texto>
						<h1>Descripción </h1><texto><%=ac.getP().getDescripcion()%></texto>
						<h1>Sitio Web </h1><texto><%=ac.getP().getSitioweb()%></texto>
						<%
                        }
						%></td>
		<td style="vertical-align: baseline;">
		
		<%if(ac.getP()==null){%>
			<img style="margin-left: 10%;" width="400px" height="400px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getS().getImage())%>">
		<%}else{%>
			<img width="400px" height="400px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getP().getImage())%>">
		<%}%>
		</td>
	</tr>
	</tbody>
</table>
                    
                   
                        

                    
                </div>
            </div>
</body>
</html>