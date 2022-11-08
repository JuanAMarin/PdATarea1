<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishAccesoProxyid" scope="session" class="publicadores.ControladorPublishAccesoProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishAccesoProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleControladorPublishAccesoProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorPublishAccesoProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishAcceso getControladorPublishAcceso10mtemp = sampleControladorPublishAccesoProxyid.getControladorPublishAcceso();
if(getControladorPublishAcceso10mtemp == null){
%>
<%=getControladorPublishAcceso10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">institucion:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtInstitucionDep tebece0=getControladorPublishAcceso10mtemp.getInstitucion();
if(tebece0 != null){
java.lang.String typedescripcion15 = tebece0.getDescripcion();
        String tempResultdescripcion15 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion15));
        %>
        <%= tempResultdescripcion15 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtInstitucionDep tebece0=getControladorPublishAcceso10mtemp.getInstitucion();
if(tebece0 != null){
java.lang.String typeurl17 = tebece0.getUrl();
        String tempResulturl17 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl17));
        %>
        <%= tempResulturl17 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtInstitucionDep tebece0=getControladorPublishAcceso10mtemp.getInstitucion();
if(tebece0 != null){
java.lang.String typenombre19 = tebece0.getNombre();
        String tempResultnombre19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre19));
        %>
        <%= tempResultnombre19 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">modalErr:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
%>
<%=getControladorPublishAcceso10mtemp.isModalErr()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">s:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
java.util.Calendar typefechaNac25 = tebece0.getFechaNac();
        java.text.DateFormat dateFormatfechaNac25 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac25 = typefechaNac25.getTime();
        String tempResultfechaNac25 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac25.format(datefechaNac25));
        %>
        <%= tempResultfechaNac25 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
java.lang.String typenickname27 = tebece0.getNickname();
        String tempResultnickname27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname27));
        %>
        <%= tempResultnickname27 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
java.lang.String typeemail29 = tebece0.getEmail();
        String tempResultemail29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail29));
        %>
        <%= tempResultemail29 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
byte[] typeimage31 = tebece0.getImage();
        String tempimage31 = "[";        for(int iimage31=0;iimage31< typeimage31.length;iimage31++){
            tempimage31 = tempimage31 + typeimage31[iimage31] + ",";
        }
        int lengthimage31 = tempimage31.length();
        tempimage31 = tempimage31.substring(0,(lengthimage31 - 1)) + "]";
        %>
        <%=tempimage31%>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
java.lang.String typeapellido33 = tebece0.getApellido();
        String tempResultapellido33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido33));
        %>
        <%= tempResultapellido33 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtSocio tebece0=getControladorPublishAcceso10mtemp.getS();
if(tebece0 != null){
java.lang.String typenombre35 = tebece0.getNombre();
        String tempResultnombre35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre35));
        %>
        <%= tempResultnombre35 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">modal:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
%>
<%=getControladorPublishAcceso10mtemp.isModal()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">p:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
byte[] typeimage41 = tebece0.getImage();
        String tempimage41 = "[";        for(int iimage41=0;iimage41< typeimage41.length;iimage41++){
            tempimage41 = tempimage41 + typeimage41[iimage41] + ",";
        }
        int lengthimage41 = tempimage41.length();
        tempimage41 = tempimage41.substring(0,(lengthimage41 - 1)) + "]";
        %>
        <%=tempimage41%>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typedescripcion43 = tebece0.getDescripcion();
        String tempResultdescripcion43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion43));
        %>
        <%= tempResultdescripcion43 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.util.Calendar typefechaNac45 = tebece0.getFechaNac();
        java.text.DateFormat dateFormatfechaNac45 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac45 = typefechaNac45.getTime();
        String tempResultfechaNac45 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac45.format(datefechaNac45));
        %>
        <%= tempResultfechaNac45 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">sitioweb:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typesitioweb47 = tebece0.getSitioweb();
        String tempResultsitioweb47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioweb47));
        %>
        <%= tempResultsitioweb47 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typenickname49 = tebece0.getNickname();
        String tempResultnickname49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname49));
        %>
        <%= tempResultnickname49 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typeemail51 = tebece0.getEmail();
        String tempResultemail51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail51));
        %>
        <%= tempResultemail51 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typebiografia53 = tebece0.getBiografia();
        String tempResultbiografia53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia53));
        %>
        <%= tempResultbiografia53 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typenombre55 = tebece0.getNombre();
        String tempResultnombre55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre55));
        %>
        <%= tempResultnombre55 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtProfesor tebece0=getControladorPublishAcceso10mtemp.getP();
if(tebece0 != null){
java.lang.String typeapellido57 = tebece0.getApellido();
        String tempResultapellido57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido57));
        %>
        <%= tempResultapellido57 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">modalAux:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
%>
<%=getControladorPublishAcceso10mtemp.isModalAux()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">actividad:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
java.lang.String typedescripcion63 = tebece0.getDescripcion();
        String tempResultdescripcion63 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion63));
        %>
        <%= tempResultdescripcion63 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
java.lang.Integer typeduracion65 = tebece0.getDuracion();
        String tempResultduracion65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion65));
        %>
        <%= tempResultduracion65 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
byte[] typeimage67 = tebece0.getImage();
        String tempimage67 = "[";        for(int iimage67=0;iimage67< typeimage67.length;iimage67++){
            tempimage67 = tempimage67 + typeimage67[iimage67] + ",";
        }
        int lengthimage67 = tempimage67.length();
        tempimage67 = tempimage67.substring(0,(lengthimage67 - 1)) + "]";
        %>
        <%=tempimage67%>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
%>
<%=tebece0.getCosto()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
java.lang.String typenombre71 = tebece0.getNombre();
        String tempResultnombre71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre71));
        %>
        <%= tempResultnombre71 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtActividadDep tebece0=getControladorPublishAcceso10mtemp.getActividad();
if(tebece0 != null){
java.util.Calendar typefechaReg73 = tebece0.getFechaReg();
        java.text.DateFormat dateFormatfechaReg73 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg73 = typefechaReg73.getTime();
        String tempResultfechaReg73 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg73.format(datefechaReg73));
        %>
        <%= tempResultfechaReg73 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">clase:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
java.util.Calendar typefecha77 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha77 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha77 = typefecha77.getTime();
        String tempResultfecha77 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha77.format(datefecha77));
        %>
        <%= tempResultfecha77 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
java.lang.String typeurl79 = tebece0.getUrl();
        String tempResulturl79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl79));
        %>
        <%= tempResulturl79 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
java.util.Calendar typehoraInicio81 = tebece0.getHoraInicio();
        java.text.DateFormat dateFormathoraInicio81 = java.text.DateFormat.getDateInstance();
        java.util.Date datehoraInicio81 = typehoraInicio81.getTime();
        String tempResulthoraInicio81 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathoraInicio81.format(datehoraInicio81));
        %>
        <%= tempResulthoraInicio81 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
byte[] typeimage83 = tebece0.getImage();
        String tempimage83 = "[";        for(int iimage83=0;iimage83< typeimage83.length;iimage83++){
            tempimage83 = tempimage83 + typeimage83[iimage83] + ",";
        }
        int lengthimage83 = tempimage83.length();
        tempimage83 = tempimage83.substring(0,(lengthimage83 - 1)) + "]";
        %>
        <%=tempimage83%>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
java.lang.String typenombre85 = tebece0.getNombre();
        String tempResultnombre85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre85));
        %>
        <%= tempResultnombre85 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getControladorPublishAcceso10mtemp != null){
publicadores.DtClase tebece0=getControladorPublishAcceso10mtemp.getclase();
if(tebece0 != null){
java.util.Calendar typefechaReg87 = tebece0.getFechaReg();
        java.text.DateFormat dateFormatfechaReg87 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg87 = typefechaReg87.getTime();
        String tempResultfechaReg87 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg87.format(datefechaReg87));
        %>
        <%= tempResultfechaReg87 %>
        <%
}}%>
</TD>
</TABLE>
<%
}
break;
case 89:
        gotMethod = true;
        sampleControladorPublishAccesoProxyid.killInstancia();
break;
case 92:
        gotMethod = true;
        publicadores.DtProfesor getP92mtemp = sampleControladorPublishAccesoProxyid.getP();
if(getP92mtemp == null){
%>
<%=getP92mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getP92mtemp != null){
byte[] typeimage95 = getP92mtemp.getImage();
        String tempimage95 = "[";        for(int iimage95=0;iimage95< typeimage95.length;iimage95++){
            tempimage95 = tempimage95 + typeimage95[iimage95] + ",";
        }
        int lengthimage95 = tempimage95.length();
        tempimage95 = tempimage95.substring(0,(lengthimage95 - 1)) + "]";
        %>
        <%=tempimage95%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typedescripcion97 = getP92mtemp.getDescripcion();
        String tempResultdescripcion97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion97));
        %>
        <%= tempResultdescripcion97 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(getP92mtemp != null){
java.util.Calendar typefechaNac99 = getP92mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac99 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac99 = typefechaNac99.getTime();
        String tempResultfechaNac99 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac99.format(datefechaNac99));
        %>
        <%= tempResultfechaNac99 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sitioweb:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typesitioweb101 = getP92mtemp.getSitioweb();
        String tempResultsitioweb101 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioweb101));
        %>
        <%= tempResultsitioweb101 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typenickname103 = getP92mtemp.getNickname();
        String tempResultnickname103 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname103));
        %>
        <%= tempResultnickname103 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typeemail105 = getP92mtemp.getEmail();
        String tempResultemail105 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail105));
        %>
        <%= tempResultemail105 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typebiografia107 = getP92mtemp.getBiografia();
        String tempResultbiografia107 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia107));
        %>
        <%= tempResultbiografia107 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typenombre109 = getP92mtemp.getNombre();
        String tempResultnombre109 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre109));
        %>
        <%= tempResultnombre109 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(getP92mtemp != null){
java.lang.String typeapellido111 = getP92mtemp.getApellido();
        String tempResultapellido111 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido111));
        %>
        <%= tempResultapellido111 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 113:
        gotMethod = true;
        publicadores.DtClase getclase113mtemp = sampleControladorPublishAccesoProxyid.getclase();
if(getclase113mtemp == null){
%>
<%=getclase113mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(getclase113mtemp != null){
java.util.Calendar typefecha116 = getclase113mtemp.getFecha();
        java.text.DateFormat dateFormatfecha116 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha116 = typefecha116.getTime();
        String tempResultfecha116 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha116.format(datefecha116));
        %>
        <%= tempResultfecha116 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getclase113mtemp != null){
java.lang.String typeurl118 = getclase113mtemp.getUrl();
        String tempResulturl118 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl118));
        %>
        <%= tempResulturl118 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(getclase113mtemp != null){
java.util.Calendar typehoraInicio120 = getclase113mtemp.getHoraInicio();
        java.text.DateFormat dateFormathoraInicio120 = java.text.DateFormat.getDateInstance();
        java.util.Date datehoraInicio120 = typehoraInicio120.getTime();
        String tempResulthoraInicio120 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathoraInicio120.format(datehoraInicio120));
        %>
        <%= tempResulthoraInicio120 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getclase113mtemp != null){
byte[] typeimage122 = getclase113mtemp.getImage();
        String tempimage122 = "[";        for(int iimage122=0;iimage122< typeimage122.length;iimage122++){
            tempimage122 = tempimage122 + typeimage122[iimage122] + ",";
        }
        int lengthimage122 = tempimage122.length();
        tempimage122 = tempimage122.substring(0,(lengthimage122 - 1)) + "]";
        %>
        <%=tempimage122%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getclase113mtemp != null){
java.lang.String typenombre124 = getclase113mtemp.getNombre();
        String tempResultnombre124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre124));
        %>
        <%= tempResultnombre124 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getclase113mtemp != null){
java.util.Calendar typefechaReg126 = getclase113mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg126 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg126 = typefechaReg126.getTime();
        String tempResultfechaReg126 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg126.format(datefechaReg126));
        %>
        <%= tempResultfechaReg126 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 128:
        gotMethod = true;
        publicadores.DtActividadDep getActividad128mtemp = sampleControladorPublishAccesoProxyid.getActividad();
if(getActividad128mtemp == null){
%>
<%=getActividad128mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getActividad128mtemp != null){
java.lang.String typedescripcion131 = getActividad128mtemp.getDescripcion();
        String tempResultdescripcion131 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion131));
        %>
        <%= tempResultdescripcion131 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getActividad128mtemp != null){
java.lang.Integer typeduracion133 = getActividad128mtemp.getDuracion();
        String tempResultduracion133 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion133));
        %>
        <%= tempResultduracion133 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getActividad128mtemp != null){
byte[] typeimage135 = getActividad128mtemp.getImage();
        String tempimage135 = "[";        for(int iimage135=0;iimage135< typeimage135.length;iimage135++){
            tempimage135 = tempimage135 + typeimage135[iimage135] + ",";
        }
        int lengthimage135 = tempimage135.length();
        tempimage135 = tempimage135.substring(0,(lengthimage135 - 1)) + "]";
        %>
        <%=tempimage135%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getActividad128mtemp != null){
%>
<%=getActividad128mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getActividad128mtemp != null){
java.lang.String typenombre139 = getActividad128mtemp.getNombre();
        String tempResultnombre139 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre139));
        %>
        <%= tempResultnombre139 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getActividad128mtemp != null){
java.util.Calendar typefechaReg141 = getActividad128mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg141 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg141 = typefechaReg141.getTime();
        String tempResultfechaReg141 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg141.format(datefechaReg141));
        %>
        <%= tempResultfechaReg141 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 143:
        gotMethod = true;
        publicadores.DtSocio getS143mtemp = sampleControladorPublishAccesoProxyid.getS();
if(getS143mtemp == null){
%>
<%=getS143mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(getS143mtemp != null){
java.util.Calendar typefechaNac146 = getS143mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac146 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac146 = typefechaNac146.getTime();
        String tempResultfechaNac146 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac146.format(datefechaNac146));
        %>
        <%= tempResultfechaNac146 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(getS143mtemp != null){
java.lang.String typenickname148 = getS143mtemp.getNickname();
        String tempResultnickname148 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname148));
        %>
        <%= tempResultnickname148 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getS143mtemp != null){
java.lang.String typeemail150 = getS143mtemp.getEmail();
        String tempResultemail150 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail150));
        %>
        <%= tempResultemail150 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getS143mtemp != null){
byte[] typeimage152 = getS143mtemp.getImage();
        String tempimage152 = "[";        for(int iimage152=0;iimage152< typeimage152.length;iimage152++){
            tempimage152 = tempimage152 + typeimage152[iimage152] + ",";
        }
        int lengthimage152 = tempimage152.length();
        tempimage152 = tempimage152.substring(0,(lengthimage152 - 1)) + "]";
        %>
        <%=tempimage152%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(getS143mtemp != null){
java.lang.String typeapellido154 = getS143mtemp.getApellido();
        String tempResultapellido154 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido154));
        %>
        <%= tempResultapellido154 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getS143mtemp != null){
java.lang.String typenombre156 = getS143mtemp.getNombre();
        String tempResultnombre156 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre156));
        %>
        <%= tempResultnombre156 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 158:
        gotMethod = true;
        String descripcion_2id=  request.getParameter("descripcion163");
            java.lang.String descripcion_2idTemp = null;
        if(!descripcion_2id.equals("")){
         descripcion_2idTemp  = descripcion_2id;
        }
        String url_3id=  request.getParameter("url165");
            java.lang.String url_3idTemp = null;
        if(!url_3id.equals("")){
         url_3idTemp  = url_3id;
        }
        String nombre_4id=  request.getParameter("nombre167");
            java.lang.String nombre_4idTemp = null;
        if(!nombre_4id.equals("")){
         nombre_4idTemp  = nombre_4id;
        }
        %>
        <jsp:useBean id="publicadores1DtInstitucionDep_1id" scope="session" class="publicadores.DtInstitucionDep" />
        <%
        publicadores1DtInstitucionDep_1id.setDescripcion(descripcion_2idTemp);
        publicadores1DtInstitucionDep_1id.setUrl(url_3idTemp);
        publicadores1DtInstitucionDep_1id.setNombre(nombre_4idTemp);
        sampleControladorPublishAccesoProxyid.setInstitucion(publicadores1DtInstitucionDep_1id);
break;
case 169:
        gotMethod = true;
        String descripcion_6id=  request.getParameter("descripcion174");
            java.lang.String descripcion_6idTemp = null;
        if(!descripcion_6id.equals("")){
         descripcion_6idTemp  = descripcion_6id;
        }
        String fechaNac_7id=  request.getParameter("fechaNac176");
            java.util.Calendar fechaNac_7idTemp = null;
        if(!fechaNac_7id.equals("")){
        java.text.DateFormat dateFormatfechaNac176 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaNac176  = dateFormatfechaNac176.parse(fechaNac_7id);
         fechaNac_7idTemp = new java.util.GregorianCalendar();
        fechaNac_7idTemp.setTime(dateTempfechaNac176);
        }
        String sitioweb_8id=  request.getParameter("sitioweb178");
            java.lang.String sitioweb_8idTemp = null;
        if(!sitioweb_8id.equals("")){
         sitioweb_8idTemp  = sitioweb_8id;
        }
        String nickname_9id=  request.getParameter("nickname180");
            java.lang.String nickname_9idTemp = null;
        if(!nickname_9id.equals("")){
         nickname_9idTemp  = nickname_9id;
        }
        String email_10id=  request.getParameter("email182");
            java.lang.String email_10idTemp = null;
        if(!email_10id.equals("")){
         email_10idTemp  = email_10id;
        }
        String biografia_11id=  request.getParameter("biografia184");
            java.lang.String biografia_11idTemp = null;
        if(!biografia_11id.equals("")){
         biografia_11idTemp  = biografia_11id;
        }
        String nombre_12id=  request.getParameter("nombre186");
            java.lang.String nombre_12idTemp = null;
        if(!nombre_12id.equals("")){
         nombre_12idTemp  = nombre_12id;
        }
        String apellido_13id=  request.getParameter("apellido188");
            java.lang.String apellido_13idTemp = null;
        if(!apellido_13id.equals("")){
         apellido_13idTemp  = apellido_13id;
        }
        %>
        <jsp:useBean id="publicadores1DtProfesor_5id" scope="session" class="publicadores.DtProfesor" />
        <%
        publicadores1DtProfesor_5id.setDescripcion(descripcion_6idTemp);
        publicadores1DtProfesor_5id.setFechaNac(fechaNac_7idTemp);
        publicadores1DtProfesor_5id.setSitioweb(sitioweb_8idTemp);
        publicadores1DtProfesor_5id.setNickname(nickname_9idTemp);
        publicadores1DtProfesor_5id.setEmail(email_10idTemp);
        publicadores1DtProfesor_5id.setBiografia(biografia_11idTemp);
        publicadores1DtProfesor_5id.setNombre(nombre_12idTemp);
        publicadores1DtProfesor_5id.setApellido(apellido_13idTemp);
        sampleControladorPublishAccesoProxyid.setP(publicadores1DtProfesor_5id);
break;
case 190:
        gotMethod = true;
        boolean isModal190mtemp = sampleControladorPublishAccesoProxyid.isModal();
        String tempResultreturnp191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(isModal190mtemp));
        %>
        <%= tempResultreturnp191 %>
        <%
break;
case 193:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg0196");
        boolean arg0_14idTemp  = Boolean.valueOf(arg0_14id).booleanValue();
        sampleControladorPublishAccesoProxyid.setModal(arg0_14idTemp);
break;
case 198:
        gotMethod = true;
        publicadores.DtInstitucionDep getInstitucion198mtemp = sampleControladorPublishAccesoProxyid.getInstitucion();
if(getInstitucion198mtemp == null){
%>
<%=getInstitucion198mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getInstitucion198mtemp != null){
java.lang.String typedescripcion201 = getInstitucion198mtemp.getDescripcion();
        String tempResultdescripcion201 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion201));
        %>
        <%= tempResultdescripcion201 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getInstitucion198mtemp != null){
java.lang.String typeurl203 = getInstitucion198mtemp.getUrl();
        String tempResulturl203 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl203));
        %>
        <%= tempResulturl203 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getInstitucion198mtemp != null){
java.lang.String typenombre205 = getInstitucion198mtemp.getNombre();
        String tempResultnombre205 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre205));
        %>
        <%= tempResultnombre205 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 207:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg0210");
        boolean arg0_15idTemp  = Boolean.valueOf(arg0_15id).booleanValue();
        sampleControladorPublishAccesoProxyid.setModalErr(arg0_15idTemp);
break;
case 212:
        gotMethod = true;
        boolean pIsNull212mtemp = sampleControladorPublishAccesoProxyid.pIsNull();
        String tempResultreturnp213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pIsNull212mtemp));
        %>
        <%= tempResultreturnp213 %>
        <%
break;
case 215:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg0218");
        boolean arg0_16idTemp  = Boolean.valueOf(arg0_16id).booleanValue();
        sampleControladorPublishAccesoProxyid.setModalAux(arg0_16idTemp);
break;
case 220:
        gotMethod = true;
        boolean iIsNull220mtemp = sampleControladorPublishAccesoProxyid.iIsNull();
        String tempResultreturnp221 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(iIsNull220mtemp));
        %>
        <%= tempResultreturnp221 %>
        <%
break;
case 223:
        gotMethod = true;
        boolean aIsNull223mtemp = sampleControladorPublishAccesoProxyid.aIsNull();
        String tempResultreturnp224 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(aIsNull223mtemp));
        %>
        <%= tempResultreturnp224 %>
        <%
break;
case 226:
        gotMethod = true;
        boolean cIsNull226mtemp = sampleControladorPublishAccesoProxyid.cIsNull();
        String tempResultreturnp227 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(cIsNull226mtemp));
        %>
        <%= tempResultreturnp227 %>
        <%
break;
case 229:
        gotMethod = true;
        boolean isModalErr229mtemp = sampleControladorPublishAccesoProxyid.isModalErr();
        String tempResultreturnp230 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(isModalErr229mtemp));
        %>
        <%= tempResultreturnp230 %>
        <%
break;
case 232:
        gotMethod = true;
        boolean sIsNull232mtemp = sampleControladorPublishAccesoProxyid.sIsNull();
        String tempResultreturnp233 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sIsNull232mtemp));
        %>
        <%= tempResultreturnp233 %>
        <%
break;
case 235:
        gotMethod = true;
        String fechaNac_18id=  request.getParameter("fechaNac240");
            java.util.Calendar fechaNac_18idTemp = null;
        if(!fechaNac_18id.equals("")){
        java.text.DateFormat dateFormatfechaNac240 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaNac240  = dateFormatfechaNac240.parse(fechaNac_18id);
         fechaNac_18idTemp = new java.util.GregorianCalendar();
        fechaNac_18idTemp.setTime(dateTempfechaNac240);
        }
        String nickname_19id=  request.getParameter("nickname242");
            java.lang.String nickname_19idTemp = null;
        if(!nickname_19id.equals("")){
         nickname_19idTemp  = nickname_19id;
        }
        String email_20id=  request.getParameter("email244");
            java.lang.String email_20idTemp = null;
        if(!email_20id.equals("")){
         email_20idTemp  = email_20id;
        }
        String apellido_21id=  request.getParameter("apellido246");
            java.lang.String apellido_21idTemp = null;
        if(!apellido_21id.equals("")){
         apellido_21idTemp  = apellido_21id;
        }
        String nombre_22id=  request.getParameter("nombre248");
            java.lang.String nombre_22idTemp = null;
        if(!nombre_22id.equals("")){
         nombre_22idTemp  = nombre_22id;
        }
        %>
        <jsp:useBean id="publicadores1DtSocio_17id" scope="session" class="publicadores.DtSocio" />
        <%
        publicadores1DtSocio_17id.setFechaNac(fechaNac_18idTemp);
        publicadores1DtSocio_17id.setNickname(nickname_19idTemp);
        publicadores1DtSocio_17id.setEmail(email_20idTemp);
        publicadores1DtSocio_17id.setApellido(apellido_21idTemp);
        publicadores1DtSocio_17id.setNombre(nombre_22idTemp);
        sampleControladorPublishAccesoProxyid.setS(publicadores1DtSocio_17id);
break;
case 250:
        gotMethod = true;
        boolean isModalAux250mtemp = sampleControladorPublishAccesoProxyid.isModalAux();
        String tempResultreturnp251 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(isModalAux250mtemp));
        %>
        <%= tempResultreturnp251 %>
        <%
break;
case 253:
        gotMethod = true;
        String descripcion_24id=  request.getParameter("descripcion258");
            java.lang.String descripcion_24idTemp = null;
        if(!descripcion_24id.equals("")){
         descripcion_24idTemp  = descripcion_24id;
        }
        String duracion_25id=  request.getParameter("duracion260");
            java.lang.Integer duracion_25idTemp = null;
        if(!duracion_25id.equals("")){
         duracion_25idTemp  = java.lang.Integer.valueOf(duracion_25id);
        }
        String costo_26id=  request.getParameter("costo262");
        float costo_26idTemp  = Float.parseFloat(costo_26id);
        String nombre_27id=  request.getParameter("nombre264");
            java.lang.String nombre_27idTemp = null;
        if(!nombre_27id.equals("")){
         nombre_27idTemp  = nombre_27id;
        }
        String fechaReg_28id=  request.getParameter("fechaReg266");
            java.util.Calendar fechaReg_28idTemp = null;
        if(!fechaReg_28id.equals("")){
        java.text.DateFormat dateFormatfechaReg266 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaReg266  = dateFormatfechaReg266.parse(fechaReg_28id);
         fechaReg_28idTemp = new java.util.GregorianCalendar();
        fechaReg_28idTemp.setTime(dateTempfechaReg266);
        }
        %>
        <jsp:useBean id="publicadores1DtActividadDep_23id" scope="session" class="publicadores.DtActividadDep" />
        <%
        publicadores1DtActividadDep_23id.setDescripcion(descripcion_24idTemp);
        publicadores1DtActividadDep_23id.setDuracion(duracion_25idTemp);
        publicadores1DtActividadDep_23id.setCosto(costo_26idTemp);
        publicadores1DtActividadDep_23id.setNombre(nombre_27idTemp);
        publicadores1DtActividadDep_23id.setFechaReg(fechaReg_28idTemp);
        sampleControladorPublishAccesoProxyid.setActividad(publicadores1DtActividadDep_23id);
break;
case 268:
        gotMethod = true;
        String fecha_30id=  request.getParameter("fecha273");
            java.util.Calendar fecha_30idTemp = null;
        if(!fecha_30id.equals("")){
        java.text.DateFormat dateFormatfecha273 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha273  = dateFormatfecha273.parse(fecha_30id);
         fecha_30idTemp = new java.util.GregorianCalendar();
        fecha_30idTemp.setTime(dateTempfecha273);
        }
        String url_31id=  request.getParameter("url275");
            java.lang.String url_31idTemp = null;
        if(!url_31id.equals("")){
         url_31idTemp  = url_31id;
        }
        String horaInicio_32id=  request.getParameter("horaInicio277");
            java.util.Calendar horaInicio_32idTemp = null;
        if(!horaInicio_32id.equals("")){
        java.text.DateFormat dateFormathoraInicio277 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemphoraInicio277  = dateFormathoraInicio277.parse(horaInicio_32id);
         horaInicio_32idTemp = new java.util.GregorianCalendar();
        horaInicio_32idTemp.setTime(dateTemphoraInicio277);
        }
        String nombre_33id=  request.getParameter("nombre279");
            java.lang.String nombre_33idTemp = null;
        if(!nombre_33id.equals("")){
         nombre_33idTemp  = nombre_33id;
        }
        String fechaReg_34id=  request.getParameter("fechaReg281");
            java.util.Calendar fechaReg_34idTemp = null;
        if(!fechaReg_34id.equals("")){
        java.text.DateFormat dateFormatfechaReg281 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaReg281  = dateFormatfechaReg281.parse(fechaReg_34id);
         fechaReg_34idTemp = new java.util.GregorianCalendar();
        fechaReg_34idTemp.setTime(dateTempfechaReg281);
        }
        %>
        <jsp:useBean id="publicadores1DtClase_29id" scope="session" class="publicadores.DtClase" />
        <%
        publicadores1DtClase_29id.setFecha(fecha_30idTemp);
        publicadores1DtClase_29id.setUrl(url_31idTemp);
        publicadores1DtClase_29id.setHoraInicio(horaInicio_32idTemp);
        publicadores1DtClase_29id.setNombre(nombre_33idTemp);
        publicadores1DtClase_29id.setFechaReg(fechaReg_34idTemp);
        sampleControladorPublishAccesoProxyid.setclase(publicadores1DtClase_29id);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>