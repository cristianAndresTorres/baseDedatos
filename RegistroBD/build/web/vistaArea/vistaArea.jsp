<%-- 
    Document   : vistaSede
    Created on : 7 oct. 2021, 23:22:59
    Author     : 57301
--%>
<%@page import="modelo.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%List<Area> listaArea = (List<Area>)request.getAttribute("listaArea");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="ControladorArea" method="post">
            <input type="hidden" name="instruccionArea" value="filtrar">
            <input type="hidden" name="<%=request.getAttribute("IDCOMPLEJO")%>" value="idComplejo_1">
            <h1><%=request.getAttribute("IDCOMPLEJO")%></h1>
            <h1>Areas</h1>
                <select name="area_nombre">
                    <option value="">Todos</option>
                    <%for(int j=0; j<listaArea.size(); j++){%>
                        <%String nombre = (String)listaArea.get(j).getNOMAREA();%>
                        <option value="<%=nombre%>"><%=nombre%></option>
                    <%}%>
                </select>
                <select name="area_ubicacion">
                    <option value="">Todos</option>
                    <%for(int k=0; k<listaArea.size(); k++){%>
                        <%String direccion = (String)listaArea.get(k).getUBICACION();%>
                        <option value="<%=direccion%>"><%=direccion%></option>
                    <%}%>
                </select>
                <input type="submit" class="btn-submit" value="Buscar">
        </form>        
    </body>
</html>
