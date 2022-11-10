<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %> 
<%@ page import="java.util.*" %>   
<%@ page import="java.util.Base64" %>
<%@ page import = "java.text.SimpleDateFormat,java.text.ParseException"%>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>
<%@ page import="publicadores.ControladorPublishAC" %>
<%@ page import="publicadores.ControladorPublishACService" %>
<%@ page import="publicadores.ControladorPublishACServiceLocator" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/modregpages.css">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%ControladorPublishACService cpsAC = new ControladorPublishACServiceLocator();
	  ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
	  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();
	  ControladorPublishAC portAC = cpsAC.getControladorPublishACPort();
	  if(!portA.pIsNull()){%>
		  <title>Registrar Clase</title>
	  	  <jsp:include page="headerP.jsp" />
	<%}%>
	  <script type="text/javascript">
			function loaded(){
				<%if(portA.isModal() || portA.isModalErr()){%>
					modal.style.display = "block";
				<%}%>
				<%if(portA.getP()==null){%>
					location.href="login.jsp";
				<%}%>
			}
	</script>
</head>
<body onload="loaded();">
<%if(!portA.pIsNull()){%>
	<div class="leaderboard">
 			<h1>
   			<svg class="icon">
     				<use xlink:href="#icono"></use>
   			</svg>
   			Registrar Clase
 			</h1>
 			<form class="responsive" id="altaclaseform1" action="AltaClase" method="post">
						<select name="instituciones" id="instituciones">
							<option><%=portA.iIsNull() ? "Selecciona una institución" : portA.getInstitucion().getNombre()%></option>
								<%for(String i: portAC.listarInstituciones()){
									  if(portA.iIsNull()){%> 
										  	  <option value="<%=i%>"><%=i%></option>
									<%}else if(!portA.getInstitucion().getNombre().equals(i)){%>
										  	  <option value="<%=i%>"><%=i%></option>
									<%}
								  }%>
						</select>
						<button class="button" type="submit">Continuar</button>
						<%if(!portA.iIsNull()){%>
						<div>
				        		<input type="hidden" name="ultimaInstitucion" value="<%=portA.getInstitucion().getNombre()%>"/>
								<select name="actividades" id="actividades">
								<option><%=portA.aIsNull() ? "Selecciona una actividad" : portA.getActividad().getNombre()%></option>
								<%for(String a: portAC.listarActividades(portA.getInstitucion().getNombre())){
								  	  if(portA.aIsNull()){%> 
									  	  <option value="<%=a%>"><%=a%></option>
									<%}else if(!portA.getActividad().getNombre().equals(a)){%>
									  	  <option value="<%=a%>"><%=a%></option>
									<%}
								  }%>
							  
				        		</select>
				        		<button class="button" type="submit">Continuar</button>
					        		<%if(!portA.aIsNull()){ %>
					        			<h1>Complete los datos de la Clase</h1>
					        		<%}%>
					   </div>
			</form>
			<form class="responsive" id="altaclaseform2" action="AltaClase2" method="post">       
					  <%if(!portA.aIsNull()){ %>
					  	   <div class="imageHolder" style="width: fit-content; max-width: 370px; padding-top: 10px;">
					            <img style="float:left" class="image" width="370px" height="370px" src="imagenes/default.jpg" id="imagenPreCarga">
				       	  		<input style="color: transparent; float:left;" type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
								<input style="float: right" type="hidden" name="img" id="img" value="">
				       	   </div>
					  	   <div class="responsive" style="width: fit-content; float:left;">
						  		<input type="hidden" name="ultimaActividad" value="<%=portA.getActividad().getNombre()%>"/>
					       		<input type="hidden" name="nickname" value="<%=portA.getP().getNickname()%>">
						  		<input type="hidden" name="nomIns" value="<%=portA.getInstitucion().getNombre()%>">
								<input type="hidden" name="nomAct" value="<%=portA.getActividad().getNombre()%>">
					       		<h1>Nombre</h1><input id="nombre" type="text" name="clase" placeholder="Clase" required>
					      		<h1>Fecha de Inicio</h1><input id="fechainicio" type="date" placeholder="fechainicio" name="fechainicio" min="<%=LocalDate.now()%>" required>
					            <h1>Hora de Inicio</h1><input id="horainicio" type="time" placeholder="horainicio" name="horainicio" required>
					            <h1>URL</h1><input id="url" type="text" placeholder="url" name="url" required>
								
			               </div>
			               <div class="responsive" style="float:left;">
								<button type="submit" id="Aceptar" name="Aceptar" style="margin-block-end: 0px;">Aceptar</button>
			               </div>

			</form>
			<form class="responsive" id="altaclaseform3" action="Cancelar" method="post">
				<div class="responsive">
					<button type="submit" id="Cancelar" name="Cancelar">Cancelar</button>
				</div>
			</form>
			<%}%>
		<%}%>
	</div>
	<div id="myModal" class="modal">
		<div class="modal-content">
    		<span class="close">&times;</span>
   			<%if(portA.isModal()){
   				portA.setModal(false);%>
				  <p>Se a registrado la clase éxito!!!</p>
			<%}else if (portA.isModalErr()){
				portA.setModalErr(false);%>
				  <p>Ya hay una clase con ese nombre</p>
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

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function readURL(input) {
	  	if (input.files && input.files[0]) {
	    	var reader = new FileReader();
	    	reader.onload = function(e) {
	      		// Asignamos el atributo src a la tag de imagenNew
	      		$('#imagenPreCarga').attr('src', e.target.result);
	      		$('#img').attr('value', e.target.result);
	    	}
	   		reader.readAsDataURL(input.files[0]);
	 		}
	}
	//El listener va asignado al input
	$("#imagenNew").change(function() {readURL(this);});
	
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