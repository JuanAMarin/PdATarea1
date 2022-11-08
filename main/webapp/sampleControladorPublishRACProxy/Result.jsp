<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishRACProxyid" scope="session" class="publicadores.ControladorPublishRACProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishRACProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishRACProxyid.getEndpoint();
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
        sampleControladorPublishRACProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublishRAC getControladorPublishRAC10mtemp = sampleControladorPublishRACProxyid.getControladorPublishRAC();
if(getControladorPublishRAC10mtemp == null){
%>
<%=getControladorPublishRAC10mtemp %>
<%
}else{
        if(getControladorPublishRAC10mtemp!= null){
        String tempreturnp11 = getControladorPublishRAC10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        int[] obtCantRegistros13mtemp = sampleControladorPublishRACProxyid.obtCantRegistros();
if(obtCantRegistros13mtemp == null){
%>
<%=obtCantRegistros13mtemp %>
<%
}else{
        String tempreturnp14 = "[";        for(int ireturnp14=0;ireturnp14< obtCantRegistros13mtemp.length;ireturnp14++){
            tempreturnp14 = tempreturnp14 + obtCantRegistros13mtemp[ireturnp14] + ",";
        }
        int lengthreturnp14 = tempreturnp14.length();
        tempreturnp14 = tempreturnp14.substring(0,(lengthreturnp14 - 1)) + "]";
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 16:
        gotMethod = true;
        publicadores.DtClase[] obtRankClasesDT16mtemp = sampleControladorPublishRACProxyid.obtRankClasesDT();
if(obtRankClasesDT16mtemp == null){
%>
<%=obtRankClasesDT16mtemp %>
<%
}else{
        String tempreturnp17 = null;
        if(obtRankClasesDT16mtemp != null){
        java.util.List listreturnp17= java.util.Arrays.asList(obtRankClasesDT16mtemp);
        tempreturnp17 = listreturnp17.toString();
        }
        %>
        <%=tempreturnp17%>
        <%
}
break;
case 19:
        gotMethod = true;
        publicadores.DtActividadDep[] rankActividadesDT19mtemp = sampleControladorPublishRACProxyid.rankActividadesDT();
if(rankActividadesDT19mtemp == null){
%>
<%=rankActividadesDT19mtemp %>
<%
}else{
        String tempreturnp20 = null;
        if(rankActividadesDT19mtemp != null){
        java.util.List listreturnp20= java.util.Arrays.asList(rankActividadesDT19mtemp);
        tempreturnp20 = listreturnp20.toString();
        }
        %>
        <%=tempreturnp20%>
        <%
}
break;
case 22:
        gotMethod = true;
        int[] obtCantClases22mtemp = sampleControladorPublishRACProxyid.obtCantClases();
if(obtCantClases22mtemp == null){
%>
<%=obtCantClases22mtemp %>
<%
}else{
        String tempreturnp23 = "[";        for(int ireturnp23=0;ireturnp23< obtCantClases22mtemp.length;ireturnp23++){
            tempreturnp23 = tempreturnp23 + obtCantClases22mtemp[ireturnp23] + ",";
        }
        int lengthreturnp23 = tempreturnp23.length();
        tempreturnp23 = tempreturnp23.substring(0,(lengthreturnp23 - 1)) + "]";
        %>
        <%=tempreturnp23%>
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