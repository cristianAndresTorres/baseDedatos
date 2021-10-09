<%-- 
    Document   : vistaSede
    Created on : 7 oct. 2021, 23:22:59
    Author     : 57301
--%>
<%@page import="modelo.Sede"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%List<Sede> listaSede = (List<Sede>)request.getAttribute("listaSedes");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="ControladorSede" method="post">
            <input type="hidden" name="instruccion" value="filtrar">
            <%request.setAttribute("opcionesss", listaSede);%>
            <h1>Sedes</h1>
                <select name="nombre">
                    <option value="">Todos</option>
                    <%for(int j=0; j<listaSede.size(); j++){%>
                        <%String nombre = (String)listaSede.get(j).getNOMCOMPLEJO();%>
                        <option value="<%=nombre%>"><%=nombre%></option>
                    <%}%>
                </select>
                <select name="direccion">
                    <option value="">Todos</option>
                    <%for(int k=0; k<listaSede.size(); k++){%>
                        <%String direccion = (String)listaSede.get(k).getDIRECCION();%>
                        <option value="<%=direccion%>"><%=direccion%></option>
                    <%}%>
                </select>
                <input type="submit" class="btn-submit" value="Buscar">
        </form>        
    </body>
</html>
