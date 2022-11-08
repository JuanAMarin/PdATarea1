<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishRSCProxyid" scope="session" class="publicadores.ControladorPublishRSCProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishRSCProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishRSCProxyid.getEndpoint();
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
        sampleControladorPublishRSCProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishRSC getControladorPublishRSC10mtemp = sampleControladorPublishRSCProxyid.getControladorPublishRSC();
if(getControladorPublishRSC10mtemp == null){
%>
<%=getControladorPublishRSC10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 41:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg044");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg146");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        sampleControladorPublishRSCProxyid.registro(arg0_1idTemp,arg1_2idTemp);
break;
case 48:
        gotMethod = true;
        java.lang.String[] listarInstituciones48mtemp = sampleControladorPublishRSCProxyid.listarInstituciones();
if(listarInstituciones48mtemp == null){
%>
<%=listarInstituciones48mtemp %>
<%
}else{
        String tempreturnp49 = null;
        if(listarInstituciones48mtemp != null){
        java.util.List listreturnp49= java.util.Arrays.asList(listarInstituciones48mtemp);
        tempreturnp49 = listreturnp49.toString();
        }
        %>
        <%=tempreturnp49%>
        <%
}
break;
case 51:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg054");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        java.lang.String[] listarActividades51mtemp = sampleControladorPublishRSCProxyid.listarActividades(arg0_3idTemp);
if(listarActividades51mtemp == null){
%>
<%=listarActividades51mtemp %>
<%
}else{
        String tempreturnp52 = null;
        if(listarActividades51mtemp != null){
        java.util.List listreturnp52= java.util.Arrays.asList(listarActividades51mtemp);
        tempreturnp52 = listreturnp52.toString();
        }
        %>
        <%=tempreturnp52%>
        <%
}
break;
case 56:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg059");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        java.lang.String[] listarClases56mtemp = sampleControladorPublishRSCProxyid.listarClases(arg0_4idTemp);
if(listarClases56mtemp == null){
%>
<%=listarClases56mtemp %>
<%
}else{
        String tempreturnp57 = null;
        if(listarClases56mtemp != null){
        java.util.List listreturnp57= java.util.Arrays.asList(listarClases56mtemp);
        tempreturnp57 = listreturnp57.toString();
        }
        %>
        <%=tempreturnp57%>
        <%
}
break;
case 61:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg070");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        publicadores.DtInstitucionDep buscarInsti61mtemp = sampleControladorPublishRSCProxyid.buscarInsti(arg0_5idTemp);
if(buscarInsti61mtemp == null){
%>
<%=buscarInsti61mtemp %>
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
if(buscarInsti61mtemp != null){
java.lang.String typedescripcion64 = buscarInsti61mtemp.getDescripcion();
        String tempResultdescripcion64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion64));
        %>
        <%= tempResultdescripcion64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(buscarInsti61mtemp != null){
java.lang.String typeurl66 = buscarInsti61mtemp.getUrl();
        String tempResulturl66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl66));
        %>
        <%= tempResulturl66 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(buscarInsti61mtemp != null){
java.lang.String typenombre68 = buscarInsti61mtemp.getNombre();
        String tempResultnombre68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre68));
        %>
        <%= tempResultnombre68 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 72:
        gotMethod = true;
        publicadores.DtActividadDep getDtad72mtemp = sampleControladorPublishRSCProxyid.getDtad();
if(getDtad72mtemp == null){
%>
<%=getDtad72mtemp %>
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
if(getDtad72mtemp != null){
java.lang.String typedescripcion75 = getDtad72mtemp.getDescripcion();
        String tempResultdescripcion75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion75));
        %>
        <%= tempResultdescripcion75 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getDtad72mtemp != null){
java.lang.Integer typeduracion77 = getDtad72mtemp.getDuracion();
        String tempResultduracion77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion77));
        %>
        <%= tempResultduracion77 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getDtad72mtemp != null){
byte[] typeimage79 = getDtad72mtemp.getImage();
        String tempimage79 = "[";        for(int iimage79=0;iimage79< typeimage79.length;iimage79++){
            tempimage79 = tempimage79 + typeimage79[iimage79] + ",";
        }
        int lengthimage79 = tempimage79.length();
        tempimage79 = tempimage79.substring(0,(lengthimage79 - 1)) + "]";
        %>
        <%=tempimage79%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getDtad72mtemp != null){
%>
<%=getDtad72mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtad72mtemp != null){
java.lang.String typenombre83 = getDtad72mtemp.getNombre();
        String tempResultnombre83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre83));
        %>
        <%= tempResultnombre83 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDtad72mtemp != null){
java.util.Calendar typefechaReg85 = getDtad72mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg85 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg85 = typefechaReg85.getTime();
        String tempResultfechaReg85 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg85.format(datefechaReg85));
        %>
        <%= tempResultfechaReg85 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 87:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0102");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        publicadores.DtClase buscarClase87mtemp = sampleControladorPublishRSCProxyid.buscarClase(arg0_6idTemp);
if(buscarClase87mtemp == null){
%>
<%=buscarClase87mtemp %>
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
if(buscarClase87mtemp != null){
java.util.Calendar typefecha90 = buscarClase87mtemp.getFecha();
        java.text.DateFormat dateFormatfecha90 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha90 = typefecha90.getTime();
        String tempResultfecha90 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha90.format(datefecha90));
        %>
        <%= tempResultfecha90 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(buscarClase87mtemp != null){
java.lang.String typeurl92 = buscarClase87mtemp.getUrl();
        String tempResulturl92 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl92));
        %>
        <%= tempResulturl92 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(buscarClase87mtemp != null){
java.util.Calendar typehoraInicio94 = buscarClase87mtemp.getHoraInicio();
        java.text.DateFormat dateFormathoraInicio94 = java.text.DateFormat.getDateInstance();
        java.util.Date datehoraInicio94 = typehoraInicio94.getTime();
        String tempResulthoraInicio94 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathoraInicio94.format(datehoraInicio94));
        %>
        <%= tempResulthoraInicio94 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(buscarClase87mtemp != null){
byte[] typeimage96 = buscarClase87mtemp.getImage();
        String tempimage96 = "[";        for(int iimage96=0;iimage96< typeimage96.length;iimage96++){
            tempimage96 = tempimage96 + typeimage96[iimage96] + ",";
        }
        int lengthimage96 = tempimage96.length();
        tempimage96 = tempimage96.substring(0,(lengthimage96 - 1)) + "]";
        %>
        <%=tempimage96%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(buscarClase87mtemp != null){
java.lang.String typenombre98 = buscarClase87mtemp.getNombre();
        String tempResultnombre98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre98));
        %>
        <%= tempResultnombre98 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(buscarClase87mtemp != null){
java.util.Calendar typefechaReg100 = buscarClase87mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg100 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg100 = typefechaReg100.getTime();
        String tempResultfechaReg100 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg100.format(datefechaReg100));
        %>
        <%= tempResultfechaReg100 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 104:
        gotMethod = true;
        publicadores.DtClase getDtc104mtemp = sampleControladorPublishRSCProxyid.getDtc();
if(getDtc104mtemp == null){
%>
<%=getDtc104mtemp %>
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
if(getDtc104mtemp != null){
java.util.Calendar typefecha107 = getDtc104mtemp.getFecha();
        java.text.DateFormat dateFormatfecha107 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha107 = typefecha107.getTime();
        String tempResultfecha107 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha107.format(datefecha107));
        %>
        <%= tempResultfecha107 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getDtc104mtemp != null){
java.lang.String typeurl109 = getDtc104mtemp.getUrl();
        String tempResulturl109 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl109));
        %>
        <%= tempResulturl109 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(getDtc104mtemp != null){
java.util.Calendar typehoraInicio111 = getDtc104mtemp.getHoraInicio();
        java.text.DateFormat dateFormathoraInicio111 = java.text.DateFormat.getDateInstance();
        java.util.Date datehoraInicio111 = typehoraInicio111.getTime();
        String tempResulthoraInicio111 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathoraInicio111.format(datehoraInicio111));
        %>
        <%= tempResulthoraInicio111 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getDtc104mtemp != null){
byte[] typeimage113 = getDtc104mtemp.getImage();
        String tempimage113 = "[";        for(int iimage113=0;iimage113< typeimage113.length;iimage113++){
            tempimage113 = tempimage113 + typeimage113[iimage113] + ",";
        }
        int lengthimage113 = tempimage113.length();
        tempimage113 = tempimage113.substring(0,(lengthimage113 - 1)) + "]";
        %>
        <%=tempimage113%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtc104mtemp != null){
java.lang.String typenombre115 = getDtc104mtemp.getNombre();
        String tempResultnombre115 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre115));
        %>
        <%= tempResultnombre115 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDtc104mtemp != null){
java.util.Calendar typefechaReg117 = getDtc104mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg117 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg117 = typefechaReg117.getTime();
        String tempResultfechaReg117 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg117.format(datefechaReg117));
        %>
        <%= tempResultfechaReg117 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 119:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0122");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        sampleControladorPublishRSCProxyid.buscarActividad(arg0_7idTemp);
break;
case 124:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0127");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        String arg1_9id=  request.getParameter("arg1129");
            java.lang.String arg1_9idTemp = null;
        if(!arg1_9id.equals("")){
         arg1_9idTemp  = arg1_9id;
        }
        boolean socioYaRegistrado124mtemp = sampleControladorPublishRSCProxyid.socioYaRegistrado(arg0_8idTemp,arg1_9idTemp);
        String tempResultreturnp125 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(socioYaRegistrado124mtemp));
        %>
        <%= tempResultreturnp125 %>
        <%
break;
case 131:
        gotMethod = true;
        java.lang.String[] listarSocios131mtemp = sampleControladorPublishRSCProxyid.listarSocios();
if(listarSocios131mtemp == null){
%>
<%=listarSocios131mtemp %>
<%
}else{
        String tempreturnp132 = null;
        if(listarSocios131mtemp != null){
        java.util.List listreturnp132= java.util.Arrays.asList(listarSocios131mtemp);
        tempreturnp132 = listreturnp132.toString();
        }
        %>
        <%=tempreturnp132%>
        <%
}
break;
case 134:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0137");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        String arg1_11id=  request.getParameter("arg1139");
            java.lang.String arg1_11idTemp = null;
        if(!arg1_11id.equals("")){
         arg1_11idTemp  = arg1_11id;
        }
        sampleControladorPublishRSCProxyid.eliminarRegistro(arg0_10idTemp,arg1_11idTemp);
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