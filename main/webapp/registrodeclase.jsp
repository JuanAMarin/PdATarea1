<%@page import="interfaces.ICregistrodeclases"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="interfaces.Fabrica"%>
<%@ page import="interfaces.Acceso"%>
<%@ page import="interfaces.ICmodinstitucion"%>
<%@ page import="interfaces.ICaltadictadoclase"%>
<%@ page import="datatypes.DtActividadDep"%>
<%@ page import="java.util.Base64"%>

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
		  <title>Registrarme a Clase</title>
	  	  <jsp:include page="headerS.jsp" />
	<%}%>
	  <script type="text/javascript">
			function loaded(){
				<%if(ac.isModal() || ac.isModalErr()){%>
					modal.style.display = "block";
				<%}%>
				<%if(ac.isModalAux()){%>
					modal.style.display = "block";
				<%}%>
				<%if(ac.getS()==null){%>
					location.href="login.jsp";
				<%}%>
			}
	</script>
</head>
<body onload="loaded();">
<%if(ac.getS()!=null){
Fabrica f = Fabrica.getInstancia();
ICregistrodeclases ICrc = f.getICregistrodeclases();%>	
	<div class="leaderboard">
  		<h1>
    		<svg class="icon">
      			<use xlink:href="#icono"></use>
    		</svg>
			Registrarme a Clase
		</h1>
		<form action="RegElimDeClase" method="post">
		<table>
			<tbody>
				<tr><td style="word-break: break-word;">
					<select name="institucion" id="institucion">
						<option><%=ac.getInstitucion()==null ? "Selecciona una institución" : ac.getInstitucion().getNombre()%></option>
							<%for(String i: ICrc.listarInstituciones()){
								  	  if(ac.getInstitucion() == null){%> 
									  	  <option value="<%=i%>"><%=i%></option>
									<%}else if(!ac.getInstitucion().getNombre().equals(i)){%>
									  	  <option value="<%=i%>"><%=i%></option>
									<%}
							  }%>
			        </select>
			        <button class="button" type="submit">Continuar</button>
		        	</td></tr>
				<%if(ac.getInstitucion()!=null){
					String ins=request.getParameter("institucion");%>
					<tr><td style="word-break: break-word;">
					<input type="hidden" name="institucion" value="<%=ins%>">
					<input type="hidden" name="ultimaInstitucion" value="<%=ac.getInstitucion().getNombre()%>"/>
						<select name="actividad" id="actividad">
							<option><%=ac.getActividad()==null ? "Selecciona una actividad" : ac.getActividad().getNombre()%></option>
								<%for(String a: ICrc.listarActividades(ins)){
									  if(ac.getActividad() == null){%> 
										  <option value="<%=a%>"><%=a%></option>
									<%}else if(!ac.getActividad().getNombre().equals(a)){%>
										  <option value="<%=a%>"><%=a%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Continuar</button>
				        </td></tr>
			        <%if(ac.getActividad()!=null){
						String act=request.getParameter("actividad");%>
						<tr><td style="word-break: break-word;">
						<input type="hidden" name="actividad" value="<%=act%>">
						<input type="hidden" name="ultimaActividad" value="<%=ac.getActividad().getNombre()%>"/>
						<select name="clase" id="clase">
							<option><%=ac.getclase()==null ? "Selecciona una clase" : ac.getclase().getNombre()%></option>
								<%for(String c: ICrc.listarClases(ac.getActividad().getNombre())){
									  if(ac.getclase() == null){%> 
										  <option value="<%=c%>"><%=c%></option>
									<%}else if(!ac.getclase().getNombre().equals(c)){%>
										  <option value="<%=c%>"><%=c%></option>
									<%}
								  }%>
				        </select>
				        <button class="button" type="submit">Continuar</button>
				        </td></tr>
		        </tbody>
			</table>
			<%String clase=request.getParameter("clase");
		      }}%>
		</form>
	</div>
	<div id="myModal" class="modal">
		<div class="modal-content">
    		<span class="close">&times;</span>
   			<%if(ac.isModalAux()){
				  ac.setModalAux(false);%>
				  <p>Se ha registrado a clase con éxito!!!</p>
			<%}else if (!ac.isModal() && ac.isModalErr()){
				  ac.setModalErr(false);%>
				  <p>Ya está registrado a esa clase</p>
			<%}else if (ac.isModal() && !ac.isModalErr()){
				  ac.setModal(false);%>
				  <p>Se ha dado de baja</p>
			<%}else if (ac.isModal() && ac.isModalErr()){
				  ac.setModal(false);
				  ac.setModalErr(false);%>
				  <p>No pertenecía a esa clase</p>
			<%}%>			
		</div>
	</div>
	<svg style="display: none;">
		<symbol id="icono" x="0px" y="0px"width="30px" height="35px" viewBox="0 0 25 26" enable-background="new 0 0 25 26" xml:space="preserve">
			<path fill="#F26856" d="M10,6.978c-1.666,0-3.022,1.356-3.022,3.022S8.334,13.022,10,13.022s3.022-1.356,3.022-3.022S11.666,6.978,10,6.978M10,12.267c-1.25,0-2.267-1.017-2.267-2.267c0-1.25,1.016-2.267,2.267-2.267c1.251,0,2.267,1.016,2.267,2.267C12.267,11.25,11.251,12.267,10,12.267 M18.391,9.733l-1.624-1.639C14.966,6.279,12.563,5.278,10,5.278S5.034,6.279,3.234,8.094L1.609,9.733c-0.146,0.147-0.146,0.386,0,0.533l1.625,1.639c1.8,1.815,4.203,2.816,6.766,2.816s4.966-1.001,6.767-2.816l1.624-1.639C18.536,10.119,18.536,9.881,18.391,9.733 M16.229,11.373c-1.656,1.672-3.868,2.594-6.229,2.594s-4.573-0.922-6.23-2.594L2.41,10l1.36-1.374C5.427,6.955,7.639,6.033,10,6.033s4.573,0.922,6.229,2.593L17.59,10L16.229,11.373z">
		</symbol>
	</svg>
<%}%>
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