<%-- 
    Document   : vistaSede
    Created on : 7 oct. 2021, 23:22:59
    Author     : 57301
--%>
<%@page import="modelo.Deporte"%>
<%@page import="modelo.Polideportivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%List<Deporte> listaDeporte = (List<Deporte>)request.getAttribute("listaDeportes");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="" method="">
            <input type="hidden" name="instruccionDeporte" value="filtrar">
            <h1>Deporte</h1>
                <select name="area_nombre">
                    <option value="">Todos</option>
                    <%for(int j=0; j<listaDeporte.size(); j++){%>
                        <%String nombre = (String)listaDeporte.get(j).getNOMDEPORTE();%>
                        <option value="<%=nombre%>"><%=nombre%></option>
                    <%}%>
                </select>
                <input type="submit" class="btn-submit" value="Detalles">
        </form>        
    </body>
</html>
