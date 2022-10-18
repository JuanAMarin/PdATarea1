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
			<path fill="#F26856" d="M18.303,4.742l-1.454-1.455c-0.171-0.171-0.475-0.171-0.646,0l-3.061,3.064H2.019c-0.251,0-0.457,0.205-0.457,0.456v9.578c0,0.251,0.206,0.456,0.457,0.456h13.683c0.252,0,0.457-0.205,0.457-0.456V7.533l2.144-2.146C18.481,5.208,18.483,4.917,18.303,4.742 M15.258,15.929H2.476V7.263h9.754L9.695,9.792c-0.057,0.057-0.101,0.13-0.119,0.212L9.18,11.36h-3.98c-0.251,0-0.457,0.205-0.457,0.456c0,0.253,0.205,0.456,0.457,0.456h4.336c0.023,0,0.899,0.02,1.498-0.127c0.312-0.077,0.55-0.137,0.55-0.137c0.08-0.018,0.155-0.059,0.212-0.118l3.463-3.443V15.929z M11.241,11.156l-1.078,0.267l0.267-1.076l6.097-6.091l0.808,0.808L11.241,11.156z">
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