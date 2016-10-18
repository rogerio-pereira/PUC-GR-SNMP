<%--
    Document   : consulta
    Created on : Oct 11, 2016, 4:25:08 PM
    Author     : Rogerio Eduardo Pereira
--%>

<%@page import="snmp.control.SNMP_Control"%>
<%@page import="snmp.model.SNMP_Model"%>
<%@page import="java.io.IOException;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String oid         = request.getParameter("oid"); 
    String ip          = "udp:"+request.getParameter("ip")+"/161";  
    String comunidade  = request.getParameter("comunidade"); 
    String operacao    = request.getParameter("operacao");
%>

<%
    SNMP_Model  snmp  = new SNMP_Model(".1.3.6.1.2.1.1.3.0", "udp:192.168.3.50/161", "public");
%>
<%= snmp.consulta() %>
