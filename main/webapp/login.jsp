<%@page import="interfaces.Acceso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<title>Login</title>
	
	<link rel="stylesheet" href="css/login.css">

</head>

<body>

	<div id="contenedor"> 
            <div id="contenedorcentrado">
                <div id="login">
                    <form id="loginform" action="Login" method="post">
                        <label for="usuario">Usuario</label>
                        <input id="usuario" type="text" name="nickname" placeholder="Usuario" required>
                        
                        <label for="password">Contraseña</label>
                        <input id="password" type="password" placeholder="Contraseña" name="password" required>
                        
                        <button type="submit" title="Ingresar" name="Ingresar">Login</button>
                        <div id = "error" style="text-align: center">
                        	<%
							String login_msg=(String)request.getAttribute("error");  
							if(login_msg!=null)
							out.println("<font color=red size=4px text-align=center>"+login_msg+"</font>");
							%>
                        </div>
                    </form>
                    
                </div>
                <div id="derecho">
                    <div class="titulo">
                        Bienvenido
                    </div>
                    <hr>
                    <div class="pie-form">
                        <a href="#">¿Perdiste tu contraseña?</a>
                        <a href="#">¿No tienes Cuenta? Registrate</a>
                        <hr>
                        <a href="#">Volver</a>
                    </div>
                </div>
            </div>
        </div>
	
</body>

</html>