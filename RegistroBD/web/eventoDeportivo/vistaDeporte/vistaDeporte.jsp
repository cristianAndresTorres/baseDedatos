<%-- 
    Document   : vistaSede
    Created on : 7 oct. 2021, 23:22:59
    Author     : 57301
--%>
<%@page import="modelo.Deporte"%>
<%@page import="modelo.Polideportivo"%>
<%@page import="modelo.Polideportivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%List<Deporte> listaDeporte = (List<Deporte>)request.getAttribute("listaDeportes");%>
<%List<Polideportivo> listaPoli = (List<Polideportivo>)request.getAttribute("listaPoli");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="ControladorDeporte" method="post">
            <input type="hidden" name="intruccionProducto" value="registro_p1">
            <h1>Deporte</h1>
                <select name="deporte">
                    <%for(int j=0; j<listaDeporte.size(); j++){%>
                        <%String nombre = (String)listaDeporte.get(j).getNOMDEPORTE();%>
                        <%
                            String idPOLI  = (String)listaPoli.get(j).getIDPOLI();
                            String idDEPORTE  = (String)listaPoli.get(j).getIDDEPORTE();
                            String idAREA   = (String)listaPoli.get(j).getIDAREA();
                            String idCOMPLEJO   = (String)listaPoli.get(j).getIDCOMPLEJO();
                        %>
                        <option value="<%=idPOLI+","+idDEPORTE+","+idAREA+","+idCOMPLEJO%>"><%=nombre%></option>
                    <%}%>
                </select>
                <input type="submit" class="btn-submit" value="Detalles">
        </form>        
    </body>
</html>
