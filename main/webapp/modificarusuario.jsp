<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Acceso" %>
<%@ page import="logica.Profesor" %>
<%@ page import="logica.Socio" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/modificarusuario.css">
	<style type="text/css">
		h1 {font-size: small;}
		textarea {resize: none; overflow: scroll;}
	</style>
<meta charset="UTF-8">
	<title>ModificarUsuario</title>
</head>
<body>
	<div id="contenedorcentrado">
		<div id="modificarusuario">
		<form id="modificarusuarioform"> 
			<table class="demo">
				<tbody>
					<tr>
						<td width="800px" style="word-break: break-word;">
							<%Acceso ac = Acceso.getInstancia();
	                        if(ac.getP()==null){%>
	                        	<h1>Nickname </h1><input id="Nickname" type="text" name="Nickname" height="400px" value="<%=ac.getS().getNickname()%>" required>
                        		<h1>Nombre </h1><input id="Nombre" type="text" name="Nombre" value="<%=ac.getS().getNombre()%>" required>
								<h1>Apellido </h1><input id="Apellido" type="text" name="Apellido" value="<%=ac.getS().getApellido()%>" required>
								<h1>Fecha de Nacimiento </h1><input id="Fecha de Nacimiento" type="text" name="Fecha de Nacimiento" value="<%=ac.getS().getFechaNac()%>" required>
								<h1>Email </h1><input id="Email" type="text" name="Email" value="<%=ac.getS().getEmail()%>" required>
	                        <%}else{%>
	                        	<h1>Nickname </h1><input id="Nickname" type="text" name="Nickname" value="<%=ac.getP().getNickname()%>" required>
                        		<h1>Nombre </h1><input id="Nombre" type="text" name="Nombre" value="<%=ac.getP().getNombre()%>" required>
								<h1>Apellido </h1><input id="Apellido" type="text" name="Apellido" value="<%=ac.getP().getApellido()%>" required>
								
								<h1>Fecha de Nacimiento </h1><input id="Fecha de Nacimiento" type="text" name="Fecha de Nacimiento" value="<%=ac.getP().getFechaNac()%>" required>
								<h1>Email </h1><input id="Email" type="text" name="Email" value="<%=ac.getP().getEmail()%>" required>
								<h1>Biografía </h1><textarea id="Biografía" name="Biografía" cols="62" rows="5"><%=ac.getP().getBiografia()%></textarea>
								<h1>Descripción </h1><textarea id="Descripción" name="Descripción" cols="62" rows="5"><%=ac.getP().getDescripcion()%></textarea>
								<h1>Sitio Web </h1><textarea id="SitioWeb" name="SitioWeb" cols="62" rows="5"><%=ac.getP().getSitioweb()%></textarea>
<%}%>
						</td>
						<td style="vertical-align: baseline;">
							<%if(ac.getP()==null){%>
								<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getS().getImage())%>" width="300px" height="300px" id="imagenPreCarga">
								<input type="file" class="form-control" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
							<%}else{%>
								<img src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getP().getImage())%>" width="300px" height="300px" id="imagenPreCarga">
								<input type="file" class="form-control" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
							<%}%>
						</td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</body>
</html>

<script src="https://code.jquery.com/jquery-3.3.1.min.js">
function readURL(input) {
  	if (input.files && input.files[0]) {
    	var reader = new FileReader();
    	reader.onload = function(e) {
      		// Asignamos el atributo src a la tag de imagenNew
      		$('#imagenPreCarga').attr('src', e.target.result);
    	}
   		reader.readAsDataURL(input.files[0]);
 		}
}
//El listener va asignado al input
$("#imagenNew").change(function() {readURL(this);});
</script>
