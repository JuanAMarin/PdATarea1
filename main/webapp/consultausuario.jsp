<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso" %>
<%@ page import="logica.Profesor" %>
<%@ page import="logica.Socio" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/consultausuario.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
<meta charset="UTF-8">
	<title>ConsultaUsuario</title>
</head>
<body>
	<div id="contenedorcentrado">
		<div id="consultausuario">
			<table class="demo">
				<tbody>
					<tr>
						<td style="word-break: break-word;">
							<%Acceso ac = Acceso.getInstancia();
	                        if(ac.getP()==null){%>
                        		<h1>Nickname </h1><p><%=ac.getS().getNickname()%></p>
								<h1>Nombre </h1><p><%=ac.getS().getNombre()%></p>
								<h1>Apellido </h1><p><%=ac.getS().getApellido()%></p>
								<h1>Fecha de Nacimiento </h1><p><%=ac.getS().getFechaNac()%></p>
								<h1>Email </h1><p><%=ac.getS().getEmail()%></p>
	                        <%}else{%>
	                        	<h1>Nickname </h1><p><%=ac.getP().getNickname()%></p>
								<h1>Nombre </h1><p><%=ac.getP().getNombre()%></p>
								<h1>Apellido </h1><p><%=ac.getP().getApellido()%></p>
								<h1>Fecha de Nacimiento </h1><p><%=ac.getP().getFechaNac()%></p>
								<h1>Email </h1><p><%=ac.getP().getEmail()%></p>
								<h1>Biografía </h1><p><%=ac.getP().getBiografia()%></p>
								<h1>Descripción </h1><p><%=ac.getP().getDescripcion()%></p>
								<h1>Sitio Web </h1><p><%=ac.getP().getSitioweb()%></p>
							<%}%>
						</td>
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