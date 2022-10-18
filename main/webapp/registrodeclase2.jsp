<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Fabrica" %>
<%@ page import="interfaces.ICconsultaclase" %>     
<%@ page import="java.util.*" %>
<%@ page import="interfaces.Acceso" %>
<%@ page import="java.text.SimpleDateFormat,java.text.ParseException"%>  
<%@ page import="java.text.Format"%>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/continuarregistrodeclase.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
<meta charset="UTF-8">
	<title>Registro de Clase</title>
</head>
<body>
<%
	Fabrica f = Fabrica.getInstancia();
	ICconsultaclase c = f.getICconsultaclase();
	String clase=request.getParameter("clase");
	c.buscarClase(clase);
	Acceso ac = Acceso.getInstancia();
	String nickname = ac.getS().getNickname();
	Format formatter,formatter2;
	String fInicio,hInicio,fechaReg;
	formatter = new SimpleDateFormat("dd-MM-yyyy");
	fInicio = formatter.format(c.getDtc().getFecha());
	formatter2 = new SimpleDateFormat("HH:mm");
	hInicio = formatter2.format(c.getDtc().getHoraInicio());
	fechaReg = formatter.format(c.getDtc().getFechaReg());
%>
	<div id="contenedorcentrado">
		<div id="registroclase">
			<table class="tabla">
				<tbody>
					<tr>
						<td style="word-break: break-word;">
						<h1>Nombre </h1><p><%=c.getDtc().getNombre()%></p>
							<h1>Url </h1><p><%=c.getDtc().getUrl()%></p>
							<h1>Fecha de Inicio </h1><p><%=fInicio%></p>
							<h1>Hora de Inicio </h1><p><%=hInicio%></p>
							<h1>Fecha de Registro </h1><p><%=fechaReg%></p>
						</td>
					</tr>
				</tbody>	
			</table>
			<form action="RegElimDeClase" method="post">
			<input type="hidden" name="nickname" value="<%=nickname%>">
			<input type="hidden" name="clase" value="<%=clase%>">
			<input type="hidden" name="boton" id="boton" value="">
			<button type="button" class="btn btn-primary"
				onclick="procesar('registro')">Registrarse</button>
			<button type="button" class="btn btn-primary"
				onclick="procesar('eliminar')">Eliminar</button>
	 </form>
	 
 <script type="text/javascript">
	function procesar(tipo) {
		document.getElementById("boton").value = tipo;
		document.forms[0].submit();
	}
</script>	
		</div>
	</div>	
</body>
</html>