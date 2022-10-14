<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso"%>
<%@ page import="datatypes.DtProfesor"%>
<%@ page import="datatypes.DtSocio"%>
<%@ page import="datatypes.DtActividadDep"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/modificarusuario.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<title>Modificar mis datos</title>
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getP()!=null){%>
		<jsp:include page="headerP.jsp" />
	<%}else{%>
		<jsp:include page="headerS.jsp" />
	<%}%>
</head>
<script>
	function loaded(){
		if(<%=ac.isModal()%>){
			<%ac.setModal(false);%>
			modal.style.display = "block";
		}
	}
</script>
<body onload="loaded()">
		<div class="leaderboard">
  			<h1>
    			<svg class="icon">
      				<use xlink:href="#icono"></use>
    			</svg>
    			Modificar mis datos
  			</h1>
  			<form id="modificarusuarioform" action="ModificarUsuario" method="post"> 
				<table class="demo">
					<tbody>
						<tr>
							<td width="800px" style="word-break: break-word;">
								<%if(ac.getP()==null){%>
		                        	<h1>Nickname </h1><input id="Nickname" type="text" name="Nickname" readonly="true"  height="400px" value="<%=ac.getS().getNickname()%>" required>
	                        		<h1>Nombre </h1><input id="Nombre" type="text" name="Nombre" value="<%=ac.getS().getNombre()%>" required>
									<h1>Apellido </h1><input id="Apellido" type="text" name="Apellido" value="<%=ac.getS().getApellido()%>" required>
		                            <h1>Fecha de Nacimiento </h1><input id="fecha" type="date" name="fecha" min="1900-01-01" max="<%=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))%>" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(ac.getS().getFechaNac())%>" required>
									<h1>Email </h1><input id="Email" type="text" name="Email" readonly="true" value="<%=ac.getS().getEmail()%>" required>
		                        <%}else{%>
		                        	<h1>Nickname </h1><input id="Nickname" type="text" name="Nickname" readonly="true" value="<%=ac.getP().getNickname()%>" required>
	                        		<h1>Nombre </h1><input id="Nombre" type="text" name="Nombre" value="<%=ac.getP().getNombre()%>" required>
									<h1>Apellido </h1><input id="Apellido" type="text" name="Apellido" value="<%=ac.getP().getApellido()%>" required>
									
									<h1>Fecha de Nacimiento </h1><input id="fecha" type="date" name="fecha" min="1900-01-01" max="<%=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))%>" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(ac.getP().getFechaNac())%>" required>
									<h1>Email </h1><input id="Email" type="text" name="Email" readonly="true" value="<%=ac.getP().getEmail()%>" required>
									<h1>Biografía </h1><textarea id="Biografia" name="Biografia" cols="62" rows="5"><%=ac.getP().getBiografia()%></textarea>
									<h1>Descripción </h1><textarea id="Descripcion" name="Descripcion" cols="62" rows="5"><%=ac.getP().getDescripcion()%></textarea>
									<h1>Sitio Web </h1><textarea id="SitioWeb" name="SitioWeb" cols="62" rows="5"><%=ac.getP().getSitioweb()%></textarea>
								<%}%>
							</td>
							<td style="vertical-align: baseline;">
								<%if(ac.getP()==null){%>
									<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getS().getImage())%>" width="300px" height="300px" name="imagenPreCarga" id="imagenPreCarga">
									<input type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
									<input type="hidden" name="img" id="img" value="">
								<%}else{%>
									<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getP().getImage())%>" width="250px" height="250px" name="imagenPreCarga" id="imagenPreCarga">
									<input type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
									<input type="hidden" name="img" id="img" value="">
								<%}%>
								<div id = "done" style="text-align: center"></div>
								<button class="button" type="submit" title="Aceptar" name="Aceptar" id = "Aceptar">Guardar Cambios</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div id="myModal" class="modal">
			<div class="modal-content">
	    		<span class="close">&times;</span>
	    		<p>Tus datos han sido actualizados con éxito!!!</p>
			</div>
		</div>
		<svg style="display: none;">
			<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
				<path fill="#F26856" d="M8.749,9.934c0,0.247-0.202,0.449-0.449,0.449H4.257c-0.247,0-0.449-0.202-0.449-0.449S4.01,9.484,4.257,9.484H8.3C8.547,9.484,8.749,9.687,8.749,9.934 M7.402,12.627H4.257c-0.247,0-0.449,0.202-0.449,0.449s0.202,0.449,0.449,0.449h3.145c0.247,0,0.449-0.202,0.449-0.449S7.648,12.627,7.402,12.627 M8.3,6.339H4.257c-0.247,0-0.449,0.202-0.449,0.449c0,0.247,0.202,0.449,0.449,0.449H8.3c0.247,0,0.449-0.202,0.449-0.449C8.749,6.541,8.547,6.339,8.3,6.339 M18.631,4.543v10.78c0,0.248-0.202,0.45-0.449,0.45H2.011c-0.247,0-0.449-0.202-0.449-0.45V4.543c0-0.247,0.202-0.449,0.449-0.449h16.17C18.429,4.094,18.631,4.296,18.631,4.543 M17.732,4.993H2.46v9.882h15.272V4.993z M16.371,13.078c0,0.247-0.202,0.449-0.449,0.449H9.646c-0.247,0-0.449-0.202-0.449-0.449c0-1.479,0.883-2.747,2.162-3.299c-0.434-0.418-0.714-1.008-0.714-1.642c0-1.197,0.997-2.246,2.133-2.246s2.134,1.049,2.134,2.246c0,0.634-0.28,1.224-0.714,1.642C15.475,10.331,16.371,11.6,16.371,13.078M11.542,8.137c0,0.622,0.539,1.348,1.235,1.348s1.235-0.726,1.235-1.348c0-0.622-0.539-1.348-1.235-1.348S11.542,7.515,11.542,8.137 M15.435,12.629c-0.214-1.273-1.323-2.246-2.657-2.246s-2.431,0.973-2.644,2.246H15.435z"/>
		    </symbol>
		</svg>
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



























	






