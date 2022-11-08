<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishACProxyid" scope="session" class="publicadores.ControladorPublishACProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishACProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishACProxyid.getEndpoint();
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
        sampleControladorPublishACProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishAC getControladorPublishAC10mtemp = sampleControladorPublishACProxyid.getControladorPublishAC();
if(getControladorPublishAC10mtemp == null){
%>
<%=getControladorPublishAC10mtemp %>
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
case 27:
        gotMethod = true;
        java.lang.String[] listarInstituciones27mtemp = sampleControladorPublishACProxyid.listarInstituciones();
if(listarInstituciones27mtemp == null){
%>
<%=listarInstituciones27mtemp %>
<%
}else{
        String tempreturnp28 = null;
        if(listarInstituciones27mtemp != null){
        java.util.List listreturnp28= java.util.Arrays.asList(listarInstituciones27mtemp);
        tempreturnp28 = listreturnp28.toString();
        }
        %>
        <%=tempreturnp28%>
        <%
}
break;
case 30:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg033");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        java.lang.String[] listarActividades30mtemp = sampleControladorPublishACProxyid.listarActividades(arg0_1idTemp);
if(listarActividades30mtemp == null){
%>
<%=listarActividades30mtemp %>
<%
}else{
        String tempreturnp31 = null;
        if(listarActividades30mtemp != null){
        java.util.List listreturnp31= java.util.Arrays.asList(listarActividades30mtemp);
        tempreturnp31 = listreturnp31.toString();
        }
        %>
        <%=tempreturnp31%>
        <%
}
break;
case 35:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg038");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarProfesores35mtemp = sampleControladorPublishACProxyid.listarProfesores(arg0_2idTemp);
if(listarProfesores35mtemp == null){
%>
<%=listarProfesores35mtemp %>
<%
}else{
        String tempreturnp36 = null;
        if(listarProfesores35mtemp != null){
        java.util.List listreturnp36= java.util.Arrays.asList(listarProfesores35mtemp);
        tempreturnp36 = listreturnp36.toString();
        }
        %>
        <%=tempreturnp36%>
        <%
}
break;
case 40:
        gotMethod = true;
        java.lang.String[] listarClases40mtemp = sampleControladorPublishACProxyid.listarClases();
if(listarClases40mtemp == null){
%>
<%=listarClases40mtemp %>
<%
}else{
        String tempreturnp41 = null;
        if(listarClases40mtemp != null){
        java.util.List listreturnp41= java.util.Arrays.asList(listarClases40mtemp);
        tempreturnp41 = listreturnp41.toString();
        }
        %>
        <%=tempreturnp41%>
        <%
}
break;
case 43:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg046");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        sampleControladorPublishACProxyid.buscarActividad(arg0_3idTemp);
break;
case 48:
        gotMethod = true;
        publicadores.DtActividadDep getDtad48mtemp = sampleControladorPublishACProxyid.getDtad();
if(getDtad48mtemp == null){
%>
<%=getDtad48mtemp %>
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
if(getDtad48mtemp != null){
java.lang.String typedescripcion51 = getDtad48mtemp.getDescripcion();
        String tempResultdescripcion51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion51));
        %>
        <%= tempResultdescripcion51 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getDtad48mtemp != null){
java.lang.Integer typeduracion53 = getDtad48mtemp.getDuracion();
        String tempResultduracion53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion53));
        %>
        <%= tempResultduracion53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getDtad48mtemp != null){
byte[] typeimage55 = getDtad48mtemp.getImage();
        String tempimage55 = "[";        for(int iimage55=0;iimage55< typeimage55.length;iimage55++){
            tempimage55 = tempimage55 + typeimage55[iimage55] + ",";
        }
        int lengthimage55 = tempimage55.length();
        tempimage55 = tempimage55.substring(0,(lengthimage55 - 1)) + "]";
        %>
        <%=tempimage55%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getDtad48mtemp != null){
%>
<%=getDtad48mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtad48mtemp != null){
java.lang.String typenombre59 = getDtad48mtemp.getNombre();
        String tempResultnombre59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre59));
        %>
        <%= tempResultnombre59 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDtad48mtemp != null){
java.util.Calendar typefechaReg61 = getDtad48mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg61 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg61 = typefechaReg61.getTime();
        String tempResultfechaReg61 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg61.format(datefechaReg61));
        %>
        <%= tempResultfechaReg61 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 63:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg072");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        publicadores.DtInstitucionDep buscarInsti63mtemp = sampleControladorPublishACProxyid.buscarInsti(arg0_4idTemp);
if(buscarInsti63mtemp == null){
%>
<%=buscarInsti63mtemp %>
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
if(buscarInsti63mtemp != null){
java.lang.String typedescripcion66 = buscarInsti63mtemp.getDescripcion();
        String tempResultdescripcion66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion66));
        %>
        <%= tempResultdescripcion66 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(buscarInsti63mtemp != null){
java.lang.String typeurl68 = buscarInsti63mtemp.getUrl();
        String tempResulturl68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl68));
        %>
        <%= tempResulturl68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(buscarInsti63mtemp != null){
java.lang.String typenombre70 = buscarInsti63mtemp.getNombre();
        String tempResultnombre70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre70));
        %>
        <%= tempResultnombre70 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 74:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg077");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        boolean existeClase74mtemp = sampleControladorPublishACProxyid.existeClase(arg0_5idTemp);
        String tempResultreturnp75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeClase74mtemp));
        %>
        <%= tempResultreturnp75 %>
        <%
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