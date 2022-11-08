<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishCUCAProxyid" scope="session" class="publicadores.ControladorPublishCUCAProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishCUCAProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishCUCAProxyid.getEndpoint();
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
        sampleControladorPublishCUCAProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishCUCA getControladorPublishCUCA10mtemp = sampleControladorPublishCUCAProxyid.getControladorPublishCUCA();
if(getControladorPublishCUCA10mtemp == null){
%>
<%=getControladorPublishCUCA10mtemp %>
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
        java.lang.String[] listarInstituciones41mtemp = sampleControladorPublishCUCAProxyid.listarInstituciones();
if(listarInstituciones41mtemp == null){
%>
<%=listarInstituciones41mtemp %>
<%
}else{
        String tempreturnp42 = null;
        if(listarInstituciones41mtemp != null){
        java.util.List listreturnp42= java.util.Arrays.asList(listarInstituciones41mtemp);
        tempreturnp42 = listreturnp42.toString();
        }
        %>
        <%=tempreturnp42%>
        <%
}
break;
case 44:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg047");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        java.lang.String[] listarClasesS44mtemp = sampleControladorPublishCUCAProxyid.listarClasesS(arg0_1idTemp);
if(listarClasesS44mtemp == null){
%>
<%=listarClasesS44mtemp %>
<%
}else{
        String tempreturnp45 = null;
        if(listarClasesS44mtemp != null){
        java.util.List listreturnp45= java.util.Arrays.asList(listarClasesS44mtemp);
        tempreturnp45 = listreturnp45.toString();
        }
        %>
        <%=tempreturnp45%>
        <%
}
break;
case 49:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg052");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarRegistros49mtemp = sampleControladorPublishCUCAProxyid.listarRegistros(arg0_2idTemp);
if(listarRegistros49mtemp == null){
%>
<%=listarRegistros49mtemp %>
<%
}else{
        String tempreturnp50 = null;
        if(listarRegistros49mtemp != null){
        java.util.List listreturnp50= java.util.Arrays.asList(listarRegistros49mtemp);
        tempreturnp50 = listreturnp50.toString();
        }
        %>
        <%=tempreturnp50%>
        <%
}
break;
case 54:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg057");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        java.lang.String[] listarClasesA54mtemp = sampleControladorPublishCUCAProxyid.listarClasesA(arg0_3idTemp);
if(listarClasesA54mtemp == null){
%>
<%=listarClasesA54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(listarClasesA54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(listarClasesA54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 59:
        gotMethod = true;
        publicadores.DtActividadDep getDtad59mtemp = sampleControladorPublishCUCAProxyid.getDtad();
if(getDtad59mtemp == null){
%>
<%=getDtad59mtemp %>
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
if(getDtad59mtemp != null){
java.lang.String typedescripcion62 = getDtad59mtemp.getDescripcion();
        String tempResultdescripcion62 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion62));
        %>
        <%= tempResultdescripcion62 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getDtad59mtemp != null){
java.lang.Integer typeduracion64 = getDtad59mtemp.getDuracion();
        String tempResultduracion64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion64));
        %>
        <%= tempResultduracion64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getDtad59mtemp != null){
byte[] typeimage66 = getDtad59mtemp.getImage();
        String tempimage66 = "[";        for(int iimage66=0;iimage66< typeimage66.length;iimage66++){
            tempimage66 = tempimage66 + typeimage66[iimage66] + ",";
        }
        int lengthimage66 = tempimage66.length();
        tempimage66 = tempimage66.substring(0,(lengthimage66 - 1)) + "]";
        %>
        <%=tempimage66%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getDtad59mtemp != null){
%>
<%=getDtad59mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtad59mtemp != null){
java.lang.String typenombre70 = getDtad59mtemp.getNombre();
        String tempResultnombre70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre70));
        %>
        <%= tempResultnombre70 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDtad59mtemp != null){
java.util.Calendar typefechaReg72 = getDtad59mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg72 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg72 = typefechaReg72.getTime();
        String tempResultfechaReg72 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg72.format(datefechaReg72));
        %>
        <%= tempResultfechaReg72 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 74:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg077");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        java.lang.String[] listarClasesN74mtemp = sampleControladorPublishCUCAProxyid.listarClasesN(arg0_4idTemp);
if(listarClasesN74mtemp == null){
%>
<%=listarClasesN74mtemp %>
<%
}else{
        String tempreturnp75 = null;
        if(listarClasesN74mtemp != null){
        java.util.List listreturnp75= java.util.Arrays.asList(listarClasesN74mtemp);
        tempreturnp75 = listreturnp75.toString();
        }
        %>
        <%=tempreturnp75%>
        <%
}
break;
case 79:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg082");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        sampleControladorPublishCUCAProxyid.buscarActividad(arg0_5idTemp);
break;
case 84:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg087");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        sampleControladorPublishCUCAProxyid.buscarClase(arg0_6idTemp);
break;
case 89:
        gotMethod = true;
        publicadores.DtClase getDtc89mtemp = sampleControladorPublishCUCAProxyid.getDtc();
if(getDtc89mtemp == null){
%>
<%=getDtc89mtemp %>
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
if(getDtc89mtemp != null){
java.util.Calendar typefecha92 = getDtc89mtemp.getFecha();
        java.text.DateFormat dateFormatfecha92 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha92 = typefecha92.getTime();
        String tempResultfecha92 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha92.format(datefecha92));
        %>
        <%= tempResultfecha92 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getDtc89mtemp != null){
java.lang.String typeurl94 = getDtc89mtemp.getUrl();
        String tempResulturl94 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl94));
        %>
        <%= tempResulturl94 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(getDtc89mtemp != null){
java.util.Calendar typehoraInicio96 = getDtc89mtemp.getHoraInicio();
        java.text.DateFormat dateFormathoraInicio96 = java.text.DateFormat.getDateInstance();
        java.util.Date datehoraInicio96 = typehoraInicio96.getTime();
        String tempResulthoraInicio96 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormathoraInicio96.format(datehoraInicio96));
        %>
        <%= tempResulthoraInicio96 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(getDtc89mtemp != null){
byte[] typeimage98 = getDtc89mtemp.getImage();
        String tempimage98 = "[";        for(int iimage98=0;iimage98< typeimage98.length;iimage98++){
            tempimage98 = tempimage98 + typeimage98[iimage98] + ",";
        }
        int lengthimage98 = tempimage98.length();
        tempimage98 = tempimage98.substring(0,(lengthimage98 - 1)) + "]";
        %>
        <%=tempimage98%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtc89mtemp != null){
java.lang.String typenombre100 = getDtc89mtemp.getNombre();
        String tempResultnombre100 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre100));
        %>
        <%= tempResultnombre100 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDtc89mtemp != null){
java.util.Calendar typefechaReg102 = getDtc89mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg102 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg102 = typefechaReg102.getTime();
        String tempResultfechaReg102 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg102.format(datefechaReg102));
        %>
        <%= tempResultfechaReg102 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 104:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0107");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        java.lang.String[] listarActividadesI104mtemp = sampleControladorPublishCUCAProxyid.listarActividadesI(arg0_7idTemp);
if(listarActividadesI104mtemp == null){
%>
<%=listarActividadesI104mtemp %>
<%
}else{
        String tempreturnp105 = null;
        if(listarActividadesI104mtemp != null){
        java.util.List listreturnp105= java.util.Arrays.asList(listarActividadesI104mtemp);
        tempreturnp105 = listreturnp105.toString();
        }
        %>
        <%=tempreturnp105%>
        <%
}
break;
case 109:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0112");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        java.lang.String[] listarActividadesP109mtemp = sampleControladorPublishCUCAProxyid.listarActividadesP(arg0_8idTemp);
if(listarActividadesP109mtemp == null){
%>
<%=listarActividadesP109mtemp %>
<%
}else{
        String tempreturnp110 = null;
        if(listarActividadesP109mtemp != null){
        java.util.List listreturnp110= java.util.Arrays.asList(listarActividadesP109mtemp);
        tempreturnp110 = listreturnp110.toString();
        }
        %>
        <%=tempreturnp110%>
        <%
}
break;
case 114:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0117");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        java.lang.String[] listarClases114mtemp = sampleControladorPublishCUCAProxyid.listarClases(arg0_9idTemp);
if(listarClases114mtemp == null){
%>
<%=listarClases114mtemp %>
<%
}else{
        String tempreturnp115 = null;
        if(listarClases114mtemp != null){
        java.util.List listreturnp115= java.util.Arrays.asList(listarClases114mtemp);
        tempreturnp115 = listreturnp115.toString();
        }
        %>
        <%=tempreturnp115%>
        <%
}
break;
case 119:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0122");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        java.lang.String[] listarRegistrosC119mtemp = sampleControladorPublishCUCAProxyid.listarRegistrosC(arg0_10idTemp);
if(listarRegistrosC119mtemp == null){
%>
<%=listarRegistrosC119mtemp %>
<%
}else{
        String tempreturnp120 = null;
        if(listarRegistrosC119mtemp != null){
        java.util.List listreturnp120= java.util.Arrays.asList(listarRegistrosC119mtemp);
        tempreturnp120 = listreturnp120.toString();
        }
        %>
        <%=tempreturnp120%>
        <%
}
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