<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishLoginProxyid" scope="session" class="publicadores.ControladorPublishLoginProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishLoginProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishLoginProxyid.getEndpoint();
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
        sampleControladorPublishLoginProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishLogin getControladorPublishLogin10mtemp = sampleControladorPublishLoginProxyid.getControladorPublishLogin();
if(getControladorPublishLogin10mtemp == null){
%>
<%=getControladorPublishLogin10mtemp %>
<%
}else{
        if(getControladorPublishLogin10mtemp!= null){
        String tempreturnp11 = getControladorPublishLogin10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg118");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        boolean existePBoolean13mtemp = sampleControladorPublishLoginProxyid.existePBoolean(arg0_1idTemp,arg1_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existePBoolean13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg035");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        String arg1_4id=  request.getParameter("arg137");
            java.lang.String arg1_4idTemp = null;
        if(!arg1_4id.equals("")){
         arg1_4idTemp  = arg1_4id;
        }
        publicadores.DtSocio existeS20mtemp = sampleControladorPublishLoginProxyid.existeS(arg0_3idTemp,arg1_4idTemp);
if(existeS20mtemp == null){
%>
<%=existeS20mtemp %>
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
if(existeS20mtemp != null){
java.util.Calendar typefechaNac23 = existeS20mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac23 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac23 = typefechaNac23.getTime();
        String tempResultfechaNac23 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac23.format(datefechaNac23));
        %>
        <%= tempResultfechaNac23 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(existeS20mtemp != null){
java.lang.String typenickname25 = existeS20mtemp.getNickname();
        String tempResultnickname25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname25));
        %>
        <%= tempResultnickname25 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(existeS20mtemp != null){
java.lang.String typeemail27 = existeS20mtemp.getEmail();
        String tempResultemail27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail27));
        %>
        <%= tempResultemail27 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(existeS20mtemp != null){
byte[] typeimage29 = existeS20mtemp.getImage();
        String tempimage29 = "[";        for(int iimage29=0;iimage29< typeimage29.length;iimage29++){
            tempimage29 = tempimage29 + typeimage29[iimage29] + ",";
        }
        int lengthimage29 = tempimage29.length();
        tempimage29 = tempimage29.substring(0,(lengthimage29 - 1)) + "]";
        %>
        <%=tempimage29%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(existeS20mtemp != null){
java.lang.String typeapellido31 = existeS20mtemp.getApellido();
        String tempResultapellido31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido31));
        %>
        <%= tempResultapellido31 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(existeS20mtemp != null){
java.lang.String typenombre33 = existeS20mtemp.getNombre();
        String tempResultnombre33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre33));
        %>
        <%= tempResultnombre33 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 39:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg060");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        String arg1_6id=  request.getParameter("arg162");
            java.lang.String arg1_6idTemp = null;
        if(!arg1_6id.equals("")){
         arg1_6idTemp  = arg1_6id;
        }
        publicadores.DtProfesor existeP39mtemp = sampleControladorPublishLoginProxyid.existeP(arg0_5idTemp,arg1_6idTemp);
if(existeP39mtemp == null){
%>
<%=existeP39mtemp %>
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
if(existeP39mtemp != null){
byte[] typeimage42 = existeP39mtemp.getImage();
        String tempimage42 = "[";        for(int iimage42=0;iimage42< typeimage42.length;iimage42++){
            tempimage42 = tempimage42 + typeimage42[iimage42] + ",";
        }
        int lengthimage42 = tempimage42.length();
        tempimage42 = tempimage42.substring(0,(lengthimage42 - 1)) + "]";
        %>
        <%=tempimage42%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typedescripcion44 = existeP39mtemp.getDescripcion();
        String tempResultdescripcion44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion44));
        %>
        <%= tempResultdescripcion44 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.util.Calendar typefechaNac46 = existeP39mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac46 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac46 = typefechaNac46.getTime();
        String tempResultfechaNac46 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac46.format(datefechaNac46));
        %>
        <%= tempResultfechaNac46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sitioweb:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typesitioweb48 = existeP39mtemp.getSitioweb();
        String tempResultsitioweb48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioweb48));
        %>
        <%= tempResultsitioweb48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typenickname50 = existeP39mtemp.getNickname();
        String tempResultnickname50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname50));
        %>
        <%= tempResultnickname50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typeemail52 = existeP39mtemp.getEmail();
        String tempResultemail52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail52));
        %>
        <%= tempResultemail52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typebiografia54 = existeP39mtemp.getBiografia();
        String tempResultbiografia54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia54));
        %>
        <%= tempResultbiografia54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typenombre56 = existeP39mtemp.getNombre();
        String tempResultnombre56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre56));
        %>
        <%= tempResultnombre56 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(existeP39mtemp != null){
java.lang.String typeapellido58 = existeP39mtemp.getApellido();
        String tempResultapellido58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido58));
        %>
        <%= tempResultapellido58 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 64:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg067");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        String arg1_8id=  request.getParameter("arg169");
            java.lang.String arg1_8idTemp = null;
        if(!arg1_8id.equals("")){
         arg1_8idTemp  = arg1_8id;
        }
        boolean existeSBoolean64mtemp = sampleControladorPublishLoginProxyid.existeSBoolean(arg0_7idTemp,arg1_8idTemp);
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeSBoolean64mtemp));
        %>
        <%= tempResultreturnp65 %>
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