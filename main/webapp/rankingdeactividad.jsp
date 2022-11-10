<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="publicadores.DtActividadDep"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Locale"%>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>
<%@ page import="publicadores.ControladorPublishRAC" %>
<%@ page import="publicadores.ControladorPublishRACService" %>
<%@ page import="publicadores.ControladorPublishRACServiceLocator" %>
<!DOCTYPE html>

<html>
<head>
	<link rel="stylesheet" href="css/rankingpage.css">
	<style type="text/css">
		h1 {font-size: small;}
		textarea {resize: none; overflow: scroll;}
	</style>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
	  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();
  	  if(!portA.pIsNull()){%>
  	  <title>Ranking de Actividades</title>
	  <jsp:include page="headerP.jsp"/>
	<%}%>
	<script type="text/javascript">
		function enviar(){
			<%if(portA.pIsNull()){%>
				location.href="login.jsp";
			<%}%>
		}
	</script>
</head>
<body onload="enviar();">
<%if(!portA.pIsNull()){%>
	<div id="contenedorcentrado">
		<div class="leaderboard">
  			<h1>
    			<svg class="ico-cup">
      				<use xlink:href="#cup"></use>
    			</svg>
    			Ranking de Actividades
  			</h1>
  			<ol class="ol">
				<%ControladorPublishRACService cpsRAC = new ControladorPublishRACServiceLocator();
				  ControladorPublishRAC portRAC = cpsRAC.getControladorPublishRACPort();
				  DtActividadDep[] actividades = portRAC.rankActividadesDT();
			 	  int[] cant = portRAC.obtCantClases();
				  int i=0;
				  for(DtActividadDep a: actividades){%>
				<li style="list-style-type: none; height: 150px;">
					<div>
					<mark style="width: 98%">
					
					Nombre: <%=a.getNombre()%><br>
					Costo: <%=a.getCosto()%><br>
					Descripción: <%=a.getDescripcion()%>
					
					</mark>
					</div>
					<small><%=cant[i]%></small>
					
				</li>
				<%i++;}%>
  			</ol>
		</div>
	</div>
	<svg style="display: none;">
		<symbol id="cup" x="0px" y="0px" width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M15.94,10.179l-2.437-0.325l1.62-7.379c0.047-0.235-0.132-0.458-0.372-0.458H5.25c-0.241,0-0.42,0.223-0.373,0.458l1.634,7.376L4.06,10.179c-0.312,0.041-0.446,0.425-0.214,0.649l2.864,2.759l-0.724,3.947c-0.058,0.315,0.277,0.554,0.559,0.401l3.457-1.916l3.456,1.916c-0.419-0.238,0.56,0.439,0.56-0.401l-0.725-3.947l2.863-2.759C16.388,10.604,16.254,10.22,15.94,10.179M10.381,2.778h3.902l-1.536,6.977L12.036,9.66l-1.655-3.546V2.778z M5.717,2.778h3.903v3.335L7.965,9.66L7.268,9.753L5.717,2.778zM12.618,13.182c-0.092,0.088-0.134,0.217-0.11,0.343l0.615,3.356l-2.938-1.629c-0.057-0.03-0.122-0.048-0.184-0.048c-0.063,0-0.128,0.018-0.185,0.048l-2.938,1.629l0.616-3.356c0.022-0.126-0.019-0.255-0.11-0.343l-2.441-2.354l3.329-0.441c0.128-0.017,0.24-0.099,0.295-0.215l1.435-3.073l1.435,3.073c0.055,0.116,0.167,0.198,0.294,0.215l3.329,0.441L12.618,13.182z"/>
		</symbol>
	</svg>
<%}%>
</body>
</html>
