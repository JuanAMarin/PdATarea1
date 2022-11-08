<%@page import="interfaces.Acceso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Login</title>
	<link rel="stylesheet" href="css/login.css">
	<link rel="icon" href="imagenes/icono.jpg">
</head>
	<script>
		function loaded(){
			<%ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
			  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();%>
			  if(<%=portA.isModal()%>){
			  	<%portA.setModal(false);%>
				  modal.style.display = "block";
			  }
			  <%portA.killInstancia();%>
		}
	</script>
<body onload="loaded()">
	<div id="contenedor">
		<div id="contenedorcentrado"> 
			<div class="titulo">Iniciar Sesión</div>
			<div id="login">
				<form id="loginform" action="Login" method="post">
					<label for="usuario">Usuario</label>
					<input id="usuario" type="text" name="nickname" placeholder="Usuario" required>
					<label for="password">Contraseña</label>
					<input id="password" type="password" placeholder="Contraseña" name="password" required>
					<div class="btn-container">
						<button type="submit" title="Ingresar" name="Ingresar">
							<span class="text">Iniciar sesión</span>
							<div class="icon-container">
								<div class="icon icon--left">
									<svg>
										<use xlink:href="#arrow-right"></use>
									</svg>
								</div>
								<div class="icon icon--right">
									<svg>
										<use xlink:href="#arrow-right"></use>
									</svg>
								</div>
							</div>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
        <div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<p>Usuario o contraseña incorrecto</p>
			</div>
		</div>
		<svg style="display: none;">
			<symbol id="arrow-right" viewBox="0 0 20 10">
				<path d="M14.84 0l-1.08 1.06 3.3 3.2H0v1.49h17.05l-3.3 3.2L14.84 10 20 5l-5.16-5z"></path>
			</symbol>
		</svg>
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