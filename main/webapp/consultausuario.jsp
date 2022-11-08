<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="publicadores.DtProfesor" %>
<%@ page import="publicadores.DtSocio" %>
<%@ page import="publicadores.DtClase" %>
<%@ page import="publicadores.DtActividadDep" %>
<%@ page import="java.util.Base64" %>
<%@ page import="publicadores.ControladorPublishCUCA" %>
<%@ page import="publicadores.ControladorPublishCUCAService" %>
<%@ page import="publicadores.ControladorPublishCUCAServiceLocator" %>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>

<%ControladorPublishCUCAService cpsCUCA = new ControladorPublishCUCAServiceLocator();
  ControladorPublishCUCA portCUCA = cpsCUCA.getControladorPublishCUCAPort();
  ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/pages.css">
	<meta charset="UTF-8">
	<%if(!portA.sIsNull() || !portA.pIsNull()){%>
		  <title>Mis Datos</title>
	<%if(!portA.pIsNull()){%>
		  <jsp:include page="headerP.jsp" />
	<%}else{%>
		  <jsp:include page="headerS.jsp" />
	<%}}%>
	<script type="text/javascript">
		function enviar(){
			<%if(portA.sIsNull() && portA.pIsNull()){%>
				location.href="login.jsp";
			<%}%>
		}
	</script>
</head>
<body onload="enviar()">
<%if(!portA.sIsNull() || !portA.pIsNull()){%>
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Mis datos
		</h1>
		<form class="responsive" id="consultarusuarioform" action="ConsultaUsuario" method="post">
		<table class = "responsive">
			<tbody>
				<%if(portA.pIsNull()){%>
                    <tr><td style="word-break: break-word;"><h2>Nickname </h2><p><%=portA.getS().getNickname()%></p></td><td class="imageHolder" rowspan="5"><div class="responsiveDiv"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getS().getImage())%>"></div></td></tr>
					<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=portA.getS().getNombre()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Apellido </h2><p><%=portA.getS().getApellido()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Nacimiento </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(portA.getS().getFechaNac().getTime())%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Email </h2><p><%=portA.getS().getEmail()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Mis Registros </h2></td></tr>
			</tbody>
		</table>
			<select name="clasS" id="clasS">
				<option><%=portA.cIsNull() ? "Selecciona una clase" : portA.getclase().getNombre()%></option>
					<%for(String c: portCUCA.listarClasesS(portA.getS().getNickname())){
						if(portA.cIsNull()){%> 
							  <option value="<%=c%>"><%=c%></option>
						<%}else if(!portA.getclase().getNombre().equals(c)){%>
							  <option value="<%=c%>"><%=c%></option>
						<%}
					  }%>
	        </select>
	        <button class="button" type="submit">Buscar</button>
	        <%if(!portA.cIsNull()){%>
				<input type="hidden" name="ultimaClas" value="<%=portA.getclase().getNombre()%>"/>    
	        <table class = "responsive">
			<tbody>
				<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=portA.getclase().getNombre()%></p></td><td class="imageHolder" rowspan="5"><div class="responsiveDiv"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getclase().getImage())%>"></div></td></tr>
				<tr><td style="word-break: break-word;"><h2>Url </h2><p><%=portA.getclase().getUrl()%></p></td></tr>
				<tr><td style="word-break: break-word;"><h2>Fecha de Inicio </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(portA.getclase().getFecha().getTime())%></p></td></tr>
				<tr><td style="word-break: break-word;"><h2>Hora de Inicio </h2><p><%=new SimpleDateFormat("hh:mm").format(portA.getclase().getHoraInicio().getTime())%></p></td></tr>
				<tr><td style="word-break: break-word;"><h2>Fecha de Registro </h2><p><%=portA.getclase().getFechaReg().getTime()%></p></td></tr>
			<%}%>
                <%}else{%>
                    <tr><td style="word-break: break-word;"><h2>Nickname </h2><p><%=portA.getP().getNickname()%></p></td><td class="imageHolder" rowspan="5"><div class="responsiveDiv"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getP().getImage())%>"></div></td></tr>
					<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=portA.getP().getNombre()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Apellido </h2><p><%=portA.getP().getApellido()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Nacimiento </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(portA.getP().getFechaNac().getTime())%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Email </h2><p><%=portA.getP().getEmail()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Biografía </h2><p><%=portA.getP().getBiografia()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Descripción </h2><p><%=portA.getP().getDescripcion()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Sitio Web </h2><p><%=portA.getP().getSitioweb()%></p></td></tr>
					<tr><td style="word-break: break-word;">
					<select name="actividades" id="actividades">
						<option><%=portA.aIsNull() ? "Selecciona una actividad" : portA.getActividad().getNombre()%></option>
							<%for(String act: portCUCA.listarActividadesP(portA.getP().getNickname())){
								if(portA.aIsNull()){%> 
									  	  <option value="<%=act%>"><%=act%></option>
									<%}else if(!portA.getActividad().getNombre().equals(act)){%>
									  	  <option value="<%=act%>"><%=act%></option>
									<%}
							  }%>
			        </select>
			        <button class="button" type="submit">Buscar</button>
			        </td></tr>
					<%if(!portA.aIsNull()){%>
	                    <tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=portA.getActividad().getNombre()%></p></td><td class="imageHolder" rowspan="5"><div class="responsiveDiv"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getActividad().getImage())%>"></div></td></tr>
						<tr><td style="word-break: break-word;"><h2>Fecha de registro </h2><p><%=portA.getActividad().getFechaReg().getTime()%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Descripción </h2><p><%=portA.getActividad().getDescripcion()%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Costo </h2><p><%=portA.getActividad().getCosto()%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Duración </h2><p><%=portA.getActividad().getDuracion()%></p></td></tr>
						<tr><td style="word-break: break-word;">
						<input type="hidden" name="ultimaActividad" value="<%=portA.getActividad().getNombre()%>"/>
							<select name="clases" id="clases">
								<option><%=portA.cIsNull() ? "Selecciona una clase" : portA.getclase().getNombre()%></option>
									<%for(String c: portCUCA.listarClasesA(portA.getActividad().getNombre())){
										  if(portA.cIsNull()){%> 
											  <option value="<%=c%>"><%=c%></option>
										<%}else if(!portA.getclase().getNombre().equals(c)){%>
											  <option value="<%=c%>"><%=c%></option>
										<%}
									  }%>
					        </select>
					        <button class="button" type="submit">Buscar</button>
				        </td></tr>
			        <%}%>
			        <%if(!portA.cIsNull()){%>
	                    <tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=portA.getclase().getNombre()%></p></td><td class="imageHolder" rowspan="5"><div class="responsiveDiv"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getclase().getImage())%>"></div></td></tr>
						<tr><td style="word-break: break-word;"><h2>Url </h2><p><%=portA.getclase().getUrl()%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Fecha de Inicio </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(portA.getclase().getFecha().getTime())%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Hora de Inicio </h2><p><%=new SimpleDateFormat("hh:mm").format(portA.getclase().getHoraInicio().getTime())%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Fecha de Registro </h2><p><%=portA.getclase().getFechaReg().getTime()%></p></td></tr>
						<tr><td style="word-break: break-word;"><h2>Registros </h2></td></tr>
			</tbody>
		</table>
			<ol class="ol">
			<%if(portCUCA.listarRegistros(portA.getclase().getNombre()).length!=0){%>
				<%for(String r: portCUCA.listarRegistros(portA.getclase().getNombre())){%>
					<li style="list-style-type: none; height: 50px;">
						<mark style="width: 98%">Nombre: <%=r%></mark>
					</li>
				<%}%>
	  		</ol>
	  		<%}else{%>
		    	<p>No está registrado en ninguna clase</p>
		    <%}
		        }
		    }%>
		</form>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M12.075,10.812c1.358-0.853,2.242-2.507,2.242-4.037c0-2.181-1.795-4.618-4.198-4.618S5.921,4.594,5.921,6.775c0,1.53,0.884,3.185,2.242,4.037c-3.222,0.865-5.6,3.807-5.6,7.298c0,0.23,0.189,0.42,0.42,0.42h14.273c0.23,0,0.42-0.189,0.42-0.42C17.676,14.619,15.297,11.677,12.075,10.812 M6.761,6.775c0-2.162,1.773-3.778,3.358-3.778s3.359,1.616,3.359,3.778c0,2.162-1.774,3.778-3.359,3.778S6.761,8.937,6.761,6.775 M3.415,17.69c0.218-3.51,3.142-6.297,6.704-6.297c3.562,0,6.486,2.787,6.705,6.297H3.415z"/>
		</symbol>
	</svg>
<%}%>
</body>
</html>