<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Fabrica" %>
<%@ page import="interfaces.ICaltadictadoclase" %>
<%@ page import="interfaces.Acceso" %>
<%@ page import="datatypes.DtProfesor" %>
<%@ page import="datatypes.DtClase" %>
<%@ page import="logica.Clase" %>
<%@ page import="java.time.LocalDate" %> 
<%@ page import="java.util.*" %>   
<%@ page import="java.util.Base64" %>
<%@ page import = "java.text.SimpleDateFormat,java.text.ParseException"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/altaclase.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getP()!=null){%>
		  <title>Registrar Clase</title>
	  	  <jsp:include page="headerP.jsp" />
	<%}%>
	  <script type="text/javascript">
			function loaded(){
				<%if(ac.isModal() || ac.isModalErr()){%>
					modal.style.display = "block";
				<%}%>
				<%if(ac.getP()==null){%>
					location.href="login.jsp";
				<%}%>
			}
	</script>
</head>
<body onload="loaded();">
<%if(ac.getP()!=null){%>
	<div class="leaderboard">
 			<h1>
   			<svg class="icon">
     				<use xlink:href="#icono"></use>
   			</svg>
   			Registrar Clase
 			</h1>
 			<form id="altaclaseform1" action="AltaClase" method="post"> 
			<table class="demo">
				<tbody>
					<tr><td style="word-break: break-word;">
							<select name="instituciones" id="instituciones">
							<option><%=ac.getInstitucion()==null ? "Selecciona una institución" : ac.getInstitucion().getNombre()%></option>
								<%Fabrica f = Fabrica.getInstancia();
								ICaltadictadoclase ICac = f.getICaltadictadoclase();
					  			  for(String i: ICac.listarInstituciones()){
									  if(ac.getInstitucion() == null){%> 
										  	  <option value="<%=i%>"><%=i%></option>
									<%}else if(!ac.getInstitucion().getNombre().equals(i)){%>
										  	  <option value="<%=i%>"><%=i%></option>
									<%}
								  }%>
							</select>
							<button class="button" type="submit">Continuar</button>
						</td></tr>
						<%if(ac.getInstitucion()!=null){%>
		        			 <tr><td style="word-break: break-word;">
				        		<input type="hidden" name="ultimaInstitucion" value="<%=ac.getInstitucion().getNombre()%>"/>
								<select name="actividades" id="actividades">
								<option><%=ac.getActividad()==null ? "Selecciona una actividad" : ac.getActividad().getNombre()%></option>
								<%for(String a: ICac.listarActividades(ac.getInstitucion().getNombre())){
								  	  if(ac.getActividad() == null){%> 
									  	  <option value="<%=a%>"><%=a%></option>
									<%}else if(!ac.getActividad().getNombre().equals(a)){%>
									  	  <option value="<%=a%>"><%=a%></option>
									<%}
								  }%>
							  
				        		</select>
				        		<button class="button" type="submit">Continuar</button>
					        		<%if(ac.getActividad()!=null){ %>
					        			<h1>Complete los datos de la Clase</h1>
					        		<%}%>
				        	  </td></tr>
				</tbody>
			</table>
			</form>
			<form id="altaclaseform2" action="AltaClase2" method="post"> 
			<table class="demo">
				<tbody>	       
					  <%if(ac.getActividad()!=null){ %>
					  	  <tr><td width="800px" style="word-break: break-word;">
						  		<input type="hidden" name="ultimaActividad" value="<%=ac.getActividad().getNombre()%>"/>
					       		<input type="hidden" name="nickname" value="<%=ac.getP().getNickname()%>">
						  		<input type="hidden" name="nomIns" value="<%=ac.getInstitucion().getNombre()%>">
								<input type="hidden" name="nomAct" value="<%=ac.getActividad().getNombre()%>">
					       		<h1>Nombre</h1><input id="nombre" type="text" name="clase" placeholder="Clase" required>
					            <h1>Fecha de Inicio</h1><input id="fechainicio" type="date" placeholder="fechainicio" name="fechainicio" min="<%=LocalDate.now()%>" required>
					            <h1>Hora de Inicio</h1><input id="horainicio" type="time" placeholder="horainicio" name="horainicio" required>
					            <h1>URL</h1><input id="url" type="text" placeholder="url" name="url" required>
					            </td>
					            <td style="vertical-align: baseline;">
					            <img src="imagenes/default.jpg" width="250px" height="250px" id="imagenPreCarga">
								<input type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
								<input type="hidden" name="img" id="img" value="">
				       	  </td></tr>
						  <tr><td width="800px" style="word-break: break-word;">
			            		<button type="submit" id="Aceptar" name="Aceptar">Aceptar</button>
			             		
			              </td></tr>  
				</tbody>
			</table>
			</form>
			<form id="altaclaseform3" action="Cancelar" method="post">
			<table>
			<tbody>
			<tr><td width="800px" style="word-break: break-word;">
			<button type="submit" id="Cancelar" name="Aceptar">Cancelar</button>
			</td><tr>
			</tbody>
			</table>
			</form>
			<%}%>
		<%}%>
	</div>
	<div id="myModal" class="modal">
		<div class="modal-content">
    		<span class="close">&times;</span>
   			<%if(ac.isModal()){
				  ac.setModal(false);%>
				  <p>Se a registrado la clase éxito!!!</p>
			<%}else if (ac.isModalErr()){
				  ac.setModalErr(false);%>
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