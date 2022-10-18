<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Fabrica" %>
<%@ page import="interfaces.ICconsultaclase" %>
<%@ page import="interfaces.Acceso" %>
<%@ page import="java.text.Format"%>


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
	<link rel="stylesheet" href="css/regelimaclase.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getS()!=null){%>
		  <title>Registrarse a Clase</title>
	  	  <jsp:include page="headerS.jsp" />
	<%}%>
	  <script type="text/javascript">
			function loaded(){
				<%if(ac.getS()==null){%>
					location.href="login.jsp";
				<%}%>
			}
	</script>
</head>
<body onload="loaded();">
<%if(ac.getS()!=null){
	Fabrica f = Fabrica.getInstancia();
	ICconsultaclase c = f.getICconsultaclase();
	String clase=request.getParameter("clase");
	c.buscarClase(clase);
	String nickname = ac.getS().getNickname();
	Format formatter,formatter2;
	String fInicio,hInicio,fechaReg;
	formatter = new SimpleDateFormat("dd-MM-yyyy");
	fInicio = formatter.format(c.getDtc().getFecha());
	formatter2 = new SimpleDateFormat("HH:mm");
	hInicio = formatter2.format(c.getDtc().getHoraInicio());
	fechaReg = formatter.format(c.getDtc().getFechaReg());%>
	<div class="leaderboard">
 			<h1>
   			<svg class="icon">
     				<use xlink:href="#icono"></use>
   			</svg>
   			Registrar Clase
 			</h1>
 			<form action="RegElimDeClase" method="post"> 
			<table class="demo">
				<tbody>
					<tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=c.getDtc().getNombre()%></p></td><td style="vertical-align: top" rowspan="5"><img style="margin-left: 30px;" width="380px" height="380px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getclase().getImage())%>"></td></tr>
					<tr><td style="word-break: break-word;"><h2>Url </h2><p><%=c.getDtc().getUrl()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Inicio </h2><p><%=fInicio%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Hora de Inicio </h2><p><%=hInicio%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Registro </h2><p><%=fechaReg%></p></td></tr>
				</tbody>
			</table>
			
			<input type="hidden" name="nickname" value="<%=nickname%>">
			<input type="hidden" name="clase" value="<%=clase%>">
			<input type="hidden" name="boton" id="boton" value="">
			<button type="button" class="btn btn-primary"
				onclick="procesar('registro')">Registrarse</button>
			<button type="button" class="btn btn-primary"
				onclick="procesar('eliminar')">Eliminar</button>
	 		</form>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M18.303,4.742l-1.454-1.455c-0.171-0.171-0.475-0.171-0.646,0l-3.061,3.064H2.019c-0.251,0-0.457,0.205-0.457,0.456v9.578c0,0.251,0.206,0.456,0.457,0.456h13.683c0.252,0,0.457-0.205,0.457-0.456V7.533l2.144-2.146C18.481,5.208,18.483,4.917,18.303,4.742 M15.258,15.929H2.476V7.263h9.754L9.695,9.792c-0.057,0.057-0.101,0.13-0.119,0.212L9.18,11.36h-3.98c-0.251,0-0.457,0.205-0.457,0.456c0,0.253,0.205,0.456,0.457,0.456h4.336c0.023,0,0.899,0.02,1.498-0.127c0.312-0.077,0.55-0.137,0.55-0.137c0.08-0.018,0.155-0.059,0.212-0.118l3.463-3.443V15.929z M11.241,11.156l-1.078,0.267l0.267-1.076l6.097-6.091l0.808,0.808L11.241,11.156z">
		</symbol>
	</svg>
<%}%>
</body>
 <script type="text/javascript">
	function procesar(tipo) {
		document.getElementById("boton").value = tipo;
		document.forms[0].submit();
	}
</script>
</html>