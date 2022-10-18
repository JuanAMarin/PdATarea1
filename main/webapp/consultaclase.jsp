<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="interfaces.Fabrica"%>
<%@ page import="interfaces.Acceso"%>
<%@ page import="interfaces.ICconsultaclase"%>
<%@ page import="datatypes.DtActividadDep"%>
<%@ page import="java.util.Base64"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/consultaacticlas.css">
	<style type="text/css">
		p {font-size: x-large;}
	</style>
	<meta charset="UTF-8">
	<%Acceso ac = Acceso.getInstancia();
	  if(ac.getP()!=null){%>
		  <title>Ver Clase</title>
		  <jsp:include page="headerP.jsp" />
	<%}%>
	<script type="text/javascript">
		function enviar(){
			<%if(ac.getP()==null){%>
				location.href="login.jsp";
			<%}%>
		}
	</script>
</head>
<body onload="enviar();">
<%if(ac.getP()!=null){%>
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Ver Clase
		</h1>
		<form id="consultaclaseform" action="ConsultaClase" method="post">
		<table>
			<tbody>
				<tr><td style="word-break: break-word;">
					<select name="actividades" id="actividades">
						<option><%=ac.getActividad()==null ? "Selecciona una actividad" : ac.getActividad().getNombre()%></option>
							<%Fabrica f = Fabrica.getInstancia();
							  ICconsultaclase ICcc = f.getICconsultaclase();
				  			  for(String i: ICcc.listarInstituciones()){
								  for(String a: ICcc.listarActividades(i)){
								  	  if(ac.getActividad() == null){%> 
									  	  <option value="<%=a%>"><%=a%></option>
									<%}else if(!ac.getActividad().getNombre().equals(a)){%>
									  	  <option value="<%=a%>"><%=a%></option>
									<%}
								  }
							  }%>
			        </select>
			        <button class="button" type="submit">Buscar</button>
		        </td></tr>
				<%if(ac.getActividad()!=null){%>
                    <tr><td style="word-break: break-word;">
					<input type="hidden" name="ultimaActividad" value="<%=ac.getActividad().getNombre()%>"/>
						<select name="clases" id="clases">
							<option><%=ac.getclase()==null ? "Selecciona una clase" : ac.getclase().getNombre()%></option>
								<%for(String c: ICcc.listarClases(ac.getActividad().getNombre())){
									  if(ac.getclase() == null){%> 
										  <option value="<%=c%>"><%=c%></option>
									<%}else if(!ac.getclase().getNombre().equals(c)){%>
										  <option value="<%=c%>"><%=c%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Buscar</button>
			        </td></tr>
		        <%}%>
		        <%if(ac.getclase()!=null){%>
                    <tr><td style="word-break: break-word;"><h2>Nombre </h2><p><%=ac.getclase().getNombre()%></p></td><td style="vertical-align: top" rowspan="5"><img style="margin-left: 15px;" width="380px" height="380px" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(ac.getclase().getImage())%>"></td></tr>
					<tr><td style="word-break: break-word;"><h2>Url </h2><p><%=ac.getclase().getUrl()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Inicio </h2><p><%=new SimpleDateFormat("dd/MM/yyyy").format(ac.getclase().getFecha())%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Hora de Inicio </h2><p><%=new SimpleDateFormat("hh:mm").format(ac.getclase().getHoraInicio())%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Fecha de Registro </h2><p><%=ac.getclase().getFechaReg()%></p></td></tr>
					<tr><td style="word-break: break-word;"><h2>Registros </h2></td></tr>
			</tbody>
		</table>
					<ol class="ol">
						<%for(Object[] r: ICcc.listarRegistros(ac.getclase().getNombre())){%>
							<li style="list-style-type: none; height: 50px;">
								<mark style="width: 98%">Nombre: <%=r[0]%></mark>
							</li>
						<%}%>
	  				</ol>
		        <%}ac.setActividad(null);ac.setclase(null);%>
		</form>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M10,6.978c-1.666,0-3.022,1.356-3.022,3.022S8.334,13.022,10,13.022s3.022-1.356,3.022-3.022S11.666,6.978,10,6.978M10,12.267c-1.25,0-2.267-1.017-2.267-2.267c0-1.25,1.016-2.267,2.267-2.267c1.251,0,2.267,1.016,2.267,2.267C12.267,11.25,11.251,12.267,10,12.267 M18.391,9.733l-1.624-1.639C14.966,6.279,12.563,5.278,10,5.278S5.034,6.279,3.234,8.094L1.609,9.733c-0.146,0.147-0.146,0.386,0,0.533l1.625,1.639c1.8,1.815,4.203,2.816,6.766,2.816s4.966-1.001,6.767-2.816l1.624-1.639C18.536,10.119,18.536,9.881,18.391,9.733 M16.229,11.373c-1.656,1.672-3.868,2.594-6.229,2.594s-4.573-0.922-6.23-2.594L2.41,10l1.36-1.374C5.427,6.955,7.639,6.033,10,6.033s4.573,0.922,6.229,2.593L17.59,10L16.229,11.373z">
		</symbol>
	</svg>
<%}%>
</body>
</html>