<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Base64"%>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>
<%@ page import="publicadores.ControladorPublishRSC" %>
<%@ page import="publicadores.ControladorPublishRSCService" %>
<%@ page import="publicadores.ControladorPublishRSCServiceLocator" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/pages.css">
	<meta charset="UTF-8">
	<%ControladorPublishRSCService cpsRSC = new ControladorPublishRSCServiceLocator();
	ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
	ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();
	ControladorPublishRSC portRSC = cpsRSC.getControladorPublishRSCPort();
	
	  if(!portA.sIsNull()){%>
		  <title>Registrarme a Clase</title>
	  	  <jsp:include page="headerS.jsp" />
	<%}%>
	  <script type="text/javascript">
			function loaded(){
				<%if(portA.isModal() || portA.isModalErr() || portA.isModalAux()){%>
					modal.style.display = "block";
				<%}%>
				<%if(portA.sIsNull()){%>
					location.href="login.jsp";
				<%}%>
			}
	</script>
</head>
<body onload="loaded();">
<%if(!portA.sIsNull()){%>	
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Registrarme a Clase
		</h1>
		<form class="responsive" action="RegElimDeClase" method="post">
		<table class="responsive">
			<tbody>
				<tr><td style="word-break: break-word;">
					<select name="institucion" id="institucion">
						<option><%=portA.iIsNull() ? "Selecciona una institución" : portA.getInstitucion().getNombre()%></option>
							<%for(String i: portRSC.listarInstituciones()){
								  	  if(portA.iIsNull()){%> 
									  	  <option value="<%=i%>"><%=i%></option>
									<%}else if(!portA.getInstitucion().getNombre().equals(i)){%>
									  	  <option value="<%=i%>"><%=i%></option>
									<%}
							  }%>
			        </select>
			        <button class="button" type="submit">Continuar</button>
		        	</td></tr>
				<%if(!portA.iIsNull()){%>
					<tr><td style="word-break: break-word;">
					<input type="hidden" name="ultimaInstitucion" value="<%=portA.getInstitucion().getNombre()%>"/>
						<select name="actividad" id="actividad">
							<option><%=portA.aIsNull() ? "Selecciona una actividad" : portA.getActividad().getNombre()%></option>
								<%for(String a: portRSC.listarActividades(portA.getInstitucion().getNombre())){
									  if(portA.aIsNull()){%> 
										  <option value="<%=a%>"><%=a%></option>
									<%}else if(!portA.getActividad().getNombre().equals(a)){%>
										  <option value="<%=a%>"><%=a%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Continuar</button>
				        </td></tr>
			        <%if(!portA.aIsNull()){%>
						<tr><td style="word-break: break-word;">
						<input type="hidden" name="ultimaActividad" value="<%=portA.getActividad().getNombre()%>"/>
						<select name="clase" id="clase">
							<option><%=portA.cIsNull() ? "Selecciona una clase" : portA.getclase().getNombre()%></option>
								<%for(String c: portRSC.listarClases(portA.getActividad().getNombre())){
									  if(portA.cIsNull()){%> 
										  <option value="<%=c%>"><%=c%></option>
									<%}else if(!portA.getclase().getNombre().equals(c)){%>
										  <option value="<%=c%>"><%=c%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Continuar</button>
				        </td></tr>
		        </tbody>
			</table>
			<%}}%>
		</form>
	</div>
	<div id="myModal" class="modal">
		<div class="modal-content">
    		<span class="close">&times;</span>
   			<%if(portA.isModalAux()){
   				portA.setModalAux(false);%>
				  <p>Se ha registrado a clase con éxito!!!</p>
			<%}else if (!portA.isModal() && portA.isModalErr()){
				portA.setModalErr(false);%>
				  <p>Ya está registrado a esa clase</p>
			<%}else if (portA.isModal() && !portA.isModalErr()){
				portA.setModal(false);%>
				  <p>Se ha dado de baja</p>
			<%}else if (portA.isModal() && portA.isModalErr()){
				portA.setModal(false);
				portA.setModalErr(false);%>
				  <p>No pertenecía a esa clase</p>
			<%}%>			
		</div>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M18.303,4.742l-1.454-1.455c-0.171-0.171-0.475-0.171-0.646,0l-3.061,3.064H2.019c-0.251,0-0.457,0.205-0.457,0.456v9.578c0,0.251,0.206,0.456,0.457,0.456h13.683c0.252,0,0.457-0.205,0.457-0.456V7.533l2.144-2.146C18.481,5.208,18.483,4.917,18.303,4.742 M15.258,15.929H2.476V7.263h9.754L9.695,9.792c-0.057,0.057-0.101,0.13-0.119,0.212L9.18,11.36h-3.98c-0.251,0-0.457,0.205-0.457,0.456c0,0.253,0.205,0.456,0.457,0.456h4.336c0.023,0,0.899,0.02,1.498-0.127c0.312-0.077,0.55-0.137,0.55-0.137c0.08-0.018,0.155-0.059,0.212-0.118l3.463-3.443V15.929z M11.241,11.156l-1.078,0.267l0.267-1.076l6.097-6.091l0.808,0.808L11.241,11.156z">
		</symbol>
	</svg>
<%}%>
</body>
<script>

var modal = document.getElementById("myModal");
	
	//Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	//When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
	
	//When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
		 modal.style.display = "none";
		}
	}
</script>
</html>