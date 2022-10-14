<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso" %>
<%@ page import="datatypes.DtProfesor" %>
<%@ page import="datatypes.DtSocio" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/consultausuario.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<title>Mis Datos</title>
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getP()!=null){%>
		<jsp:include page="headerP.jsp" />
	<%}else{%>
		<jsp:include page="headerS.jsp" />
	<%}%>
</head>
<body>
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Mis datos
		</h1>
		<table>
			<tbody>
				<%if(ac.getP()==null){%>
                    <tr><td style="word-break: break-word;"><h2>Nickname </h2><p><%=ac.getS().getNickname()%></p></td><td style="vertical-align: top" rowspan="5"><img style="margin-left: 15px;" width="380px" height="380px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getS().getImage())%>"></td></tr>
					<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=ac.getS().getNombre()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Apellido </h2><p><%=ac.getS().getApellido()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Nacimiento </h2><p><%=ac.getS().getFechaNac()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Email </h2><p><%=ac.getS().getEmail()%></p></td></tr>
                      <%}else{%>
                    <tr><td style="word-break: break-word;"><h2>Nickname </h2><p><%=ac.getP().getNickname()%></p></td><td style="vertical-align: top" rowspan="8"><img width="380px" height="380px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getP().getImage())%>"></td></tr>
					<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=ac.getP().getNombre()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Apellido </h2><p><%=ac.getP().getApellido()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Nacimiento </h2><p><%=ac.getP().getFechaNac()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Email </h2><p><%=ac.getP().getEmail()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Biografía </h2><p><%=ac.getP().getBiografia()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Descripción </h2><p><%=ac.getP().getDescripcion()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Sitio Web </h2><p><%=ac.getP().getSitioweb()%></p></td></tr>
				<%}%>
			</tbody>
		</table>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M12.075,10.812c1.358-0.853,2.242-2.507,2.242-4.037c0-2.181-1.795-4.618-4.198-4.618S5.921,4.594,5.921,6.775c0,1.53,0.884,3.185,2.242,4.037c-3.222,0.865-5.6,3.807-5.6,7.298c0,0.23,0.189,0.42,0.42,0.42h14.273c0.23,0,0.42-0.189,0.42-0.42C17.676,14.619,15.297,11.677,12.075,10.812 M6.761,6.775c0-2.162,1.773-3.778,3.358-3.778s3.359,1.616,3.359,3.778c0,2.162-1.774,3.778-3.359,3.778S6.761,8.937,6.761,6.775 M3.415,17.69c0.218-3.51,3.142-6.297,6.704-6.297c3.562,0,6.486,2.787,6.705,6.297H3.415z"/>
		</symbol>
	</svg>
</body>
</html>