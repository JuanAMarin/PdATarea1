<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishMUProxyid" scope="session" class="publicadores.ControladorPublishMUProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishMUProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishMUProxyid.getEndpoint();
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
        sampleControladorPublishMUProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishMU getControladorPublishMU10mtemp = sampleControladorPublishMUProxyid.getControladorPublishMU();
if(getControladorPublishMU10mtemp == null){
%>
<%=getControladorPublishMU10mtemp %>
<%
}else{
        if(getControladorPublishMU10mtemp!= null){
        String tempreturnp11 = getControladorPublishMU10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg028");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        publicadores.DtSocio obtenerSocio13mtemp = sampleControladorPublishMUProxyid.obtenerSocio(arg0_1idTemp);
if(obtenerSocio13mtemp == null){
%>
<%=obtenerSocio13mtemp %>
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
if(obtenerSocio13mtemp != null){
java.util.Calendar typefechaNac16 = obtenerSocio13mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac16 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac16 = typefechaNac16.getTime();
        String tempResultfechaNac16 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac16.format(datefechaNac16));
        %>
        <%= tempResultfechaNac16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(obtenerSocio13mtemp != null){
java.lang.String typenickname18 = obtenerSocio13mtemp.getNickname();
        String tempResultnickname18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname18));
        %>
        <%= tempResultnickname18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(obtenerSocio13mtemp != null){
java.lang.String typeemail20 = obtenerSocio13mtemp.getEmail();
        String tempResultemail20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail20));
        %>
        <%= tempResultemail20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(obtenerSocio13mtemp != null){
byte[] typeimage22 = obtenerSocio13mtemp.getImage();
        String tempimage22 = "[";        for(int iimage22=0;iimage22< typeimage22.length;iimage22++){
            tempimage22 = tempimage22 + typeimage22[iimage22] + ",";
        }
        int lengthimage22 = tempimage22.length();
        tempimage22 = tempimage22.substring(0,(lengthimage22 - 1)) + "]";
        %>
        <%=tempimage22%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerSocio13mtemp != null){
java.lang.String typeapellido24 = obtenerSocio13mtemp.getApellido();
        String tempResultapellido24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido24));
        %>
        <%= tempResultapellido24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerSocio13mtemp != null){
java.lang.String typenombre26 = obtenerSocio13mtemp.getNombre();
        String tempResultnombre26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre26));
        %>
        <%= tempResultnombre26 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 30:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg051");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        publicadores.DtProfesor obtenerProfesor30mtemp = sampleControladorPublishMUProxyid.obtenerProfesor(arg0_2idTemp);
if(obtenerProfesor30mtemp == null){
%>
<%=obtenerProfesor30mtemp %>
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
if(obtenerProfesor30mtemp != null){
byte[] typeimage33 = obtenerProfesor30mtemp.getImage();
        String tempimage33 = "[";        for(int iimage33=0;iimage33< typeimage33.length;iimage33++){
            tempimage33 = tempimage33 + typeimage33[iimage33] + ",";
        }
        int lengthimage33 = tempimage33.length();
        tempimage33 = tempimage33.substring(0,(lengthimage33 - 1)) + "]";
        %>
        <%=tempimage33%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typedescripcion35 = obtenerProfesor30mtemp.getDescripcion();
        String tempResultdescripcion35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion35));
        %>
        <%= tempResultdescripcion35 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.util.Calendar typefechaNac37 = obtenerProfesor30mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac37 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac37 = typefechaNac37.getTime();
        String tempResultfechaNac37 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac37.format(datefechaNac37));
        %>
        <%= tempResultfechaNac37 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sitioweb:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typesitioweb39 = obtenerProfesor30mtemp.getSitioweb();
        String tempResultsitioweb39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioweb39));
        %>
        <%= tempResultsitioweb39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typenickname41 = obtenerProfesor30mtemp.getNickname();
        String tempResultnickname41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname41));
        %>
        <%= tempResultnickname41 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typeemail43 = obtenerProfesor30mtemp.getEmail();
        String tempResultemail43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail43));
        %>
        <%= tempResultemail43 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typebiografia45 = obtenerProfesor30mtemp.getBiografia();
        String tempResultbiografia45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia45));
        %>
        <%= tempResultbiografia45 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typenombre47 = obtenerProfesor30mtemp.getNombre();
        String tempResultnombre47 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre47));
        %>
        <%= tempResultnombre47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(obtenerProfesor30mtemp != null){
java.lang.String typeapellido49 = obtenerProfesor30mtemp.getApellido();
        String tempResultapellido49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido49));
        %>
        <%= tempResultapellido49 %>
        <%
}%>
</TD>
</TABLE>
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