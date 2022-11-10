<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Base64"%>
<%@ page import="publicadores.ControladorPublishCUCA" %>
<%@ page import="publicadores.ControladorPublishCUCAService" %>
<%@ page import="publicadores.ControladorPublishCUCAServiceLocator" %>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/pages.css">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
	  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();
	  if(!portA.pIsNull()){%>
		  <title>Ver Clase</title>
		  <jsp:include page="headerP.jsp" />
	<%}%>
	<script type="text/javascript">
		function enviar(){
			<%if(portA.pIsNull()){%>
				location.href="login.jsp";
			<%}%>
		}
	</script>
</head>
<body onload="enviar();">
<%if(!portA.pIsNull()){%>
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Ver Clase
		</h1>
		<form class="responsive" id="consultaclaseform" action="ConsultaClase" method="post">
			<select name="actividades" id="actividades">
				<option><%=portA.aIsNull() ? "Selecciona una actividad" : portA.getActividad().getNombre()%></option>
					<%ControladorPublishCUCAService cpsCUCA = new ControladorPublishCUCAServiceLocator();
					  ControladorPublishCUCA portCUCA = cpsCUCA.getControladorPublishCUCAPort();
		  			  for(String i: portCUCA.listarInstituciones()){
						  for(String a: portCUCA.listarActividadesI(i)){
						  	  if(portA.aIsNull()){%> 
							  	  <option value="<%=a%>"><%=a%></option>
							<%}else if(!portA.getActividad().getNombre().equals(a)){%>
							  	  <option value="<%=a%>"><%=a%></option>
							<%}
						  }
					  }%>
	        </select>
			<button class="button" type="submit">Buscar</button>
				<%if(!portA.aIsNull()){%>
					<input type="hidden" name="ultimaActividad" value="<%=portA.getActividad().getNombre()%>"/>
						<select name="clases" id="clases">
							<option><%=portA.cIsNull() ? "Selecciona una clase" : portA.getclase().getNombre()%></option>
								<%for(String c: portCUCA.listarClases(portA.getActividad().getNombre())){
									  if(portA.cIsNull()){%> 
										  <option value="<%=c%>"><%=c%></option>
									<%}else if(!portA.getclase().getNombre().equals(c)){%>
										  <option value="<%=c%>"><%=c%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Buscar</button>
		        <%}%>
		        <%if(!portA.cIsNull()){%>
		        <div class="imageHolder"><img class="image" width="370px" height="370px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(portA.getclase().getImage())%>"></div>
		        <div class="responsive">
                    <h2>Nombre </h2><p><%=portA.getclase().getNombre()%></p>
					<h2>Url </h2><p><%=portA.getclase().getUrl()%></p>
					<h2>Fecha de Inicio </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(portA.getclase().getFecha().getTime())%></p>
					<h2>Hora de Inicio </h2><p><%=new SimpleDateFormat("hh:mm").format(portA.getclase().getHoraInicio().getTime())%></p>
					<h2>Fecha de Registro </h2><p><%=portA.getclase().getFechaReg().getTime()%></p>
					<h2>Registros </h2>
				</div>
			</tbody>
		</table>
			<%if(portCUCA.listarRegistrosC(portA.getclase().getNombre()).length!=0){%>
					<ol class="ol">
						<%for(String r: portCUCA.listarRegistrosC(portA.getclase().getNombre())){%>
							<li style="list-style-type: none; height: 50px;">
								<mark style="width: 98%">Nombre: <%=r%></mark>
							</li>
						<%}%>
	  				</ol>
		    <%}else{%>
		    	<p>No hay socios registrados</p>
		    <%}
		    }%>
		</form>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M10,6.978c-1.666,0-3.022,1.356-3.022,3.022S8.334,13.022,10,13.022s3.022-1.356,3.022-3.022S11.666,6.978,10,6.978M10,12.267c-1.25,0-2.267-1.017-2.267-2.267c0-1.25,1.016-2.267,2.267-2.267c1.251,0,2.267,1.016,2.267,2.267C12.267,11.25,11.251,12.267,10,12.267 M18.391,9.733l-1.624-1.639C14.966,6.279,12.563,5.278,10,5.278S5.034,6.279,3.234,8.094L1.609,9.733c-0.146,0.147-0.146,0.386,0,0.533l1.625,1.639c1.8,1.815,4.203,2.816,6.766,2.816s4.966-1.001,6.767-2.816l1.624-1.639C18.536,10.119,18.536,9.881,18.391,9.733 M16.229,11.373c-1.656,1.672-3.868,2.594-6.229,2.594s-4.573-0.922-6.23-2.594L2.41,10l1.36-1.374C5.427,6.955,7.639,6.033,10,6.033s4.573,0.922,6.229,2.593L17.59,10L16.229,11.373z">
		</symbol>
	</svg>
<%}%>
</body>
</html>