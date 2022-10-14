<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="interfaces.Fabrica"%>
<%@ page import="interfaces.Acceso"%>
<%@ page import="interfaces.ICconsultaactividad"%>
<%@ page import="datatypes.DtActividadDep"%>
<%@ page import="java.util.Base64"%>

<!DOCTYPE html>
<%Acceso ac = Acceso.getInstancia();
  if(ac.getP()!=null){%>
  	<jsp:include page="headerP.jsp" />
<%}else{%>
  	<jsp:include page="headerS.jsp" />
<%}%>
<html>
<head>
	<link rel="stylesheet" href="css/consultaactividad.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<title>Ver Actividad</title>
</head>
<body>
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Ver Actividad
		</h1>
		<form id="consultaractividadform" action="ConsultaActividad" method="post">
		<table>
			<tbody>
				<tr><td style="word-break: break-word;">
					<select name="actividades" id="actividades">
						<option>Selecciona una Actividad</option>
						<%Fabrica f = Fabrica.getInstancia();
			  			  ICconsultaactividad ICca = f.getICconsultaactividad();
			  			  for(String i: ICca.listarInstituciones()){
							  for(String a: ICca.listarActividades(i)){%> 
								  <option value="<%=a%>"><%=a%></option>
							<%}
						  }%>
			        </select>
			        <button class="button" type="submit">Buscar</button>
		        </td></tr>
				<%if(ac.getActividad()!=null){%>
                    <tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=ac.getActividad().getNombre()%></p></td><td style="vertical-align: top" rowspan="5"><img style="margin-left: 15px;" width="380px" height="380px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getActividad().getImage())%>"></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de registro </h2><p><%=ac.getActividad().getFechaReg()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Descripción </h2><p><%=ac.getActividad().getDescripcion()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Costo </h2><p><%=ac.getActividad().getCosto()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Duración </h2><p><%=ac.getActividad().getDuracion()%></p></td></tr>
				<%ac.setActividad(null);
				    }%>
			</tbody>
		</table>
		</form>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M10,6.978c-1.666,0-3.022,1.356-3.022,3.022S8.334,13.022,10,13.022s3.022-1.356,3.022-3.022S11.666,6.978,10,6.978M10,12.267c-1.25,0-2.267-1.017-2.267-2.267c0-1.25,1.016-2.267,2.267-2.267c1.251,0,2.267,1.016,2.267,2.267C12.267,11.25,11.251,12.267,10,12.267 M18.391,9.733l-1.624-1.639C14.966,6.279,12.563,5.278,10,5.278S5.034,6.279,3.234,8.094L1.609,9.733c-0.146,0.147-0.146,0.386,0,0.533l1.625,1.639c1.8,1.815,4.203,2.816,6.766,2.816s4.966-1.001,6.767-2.816l1.624-1.639C18.536,10.119,18.536,9.881,18.391,9.733 M16.229,11.373c-1.656,1.672-3.868,2.594-6.229,2.594s-4.573-0.922-6.23-2.594L2.41,10l1.36-1.374C5.427,6.955,7.639,6.033,10,6.033s4.573,0.922,6.229,2.593L17.59,10L16.229,11.373z">
		</symbol>
	</svg>
</body>
</html>