<%-- 
    Document   : vistaSedeFiltrar
    Created on : 8 oct. 2021, 1:31:52
    Author     : 57301
--%>
<%@page import="modelo.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <%List<Area> listaArea_1 = (List<Area>)request.getAttribute("listaAreaFiltro");%>
    <body>
        <form action="ControladorArea" method="post">
            <input type="hidden" name="instruccionArea" value="Filtrar">
            <input type="hidden" name="<%=request.getAttribute("IDCOMPLEJO")%>" value="id">
            <h1><%=request.getAttribute("IDCOMPLEJO")%></h1>
            <table>          
                <tr>
                    <th class="">Id Area</th>
                    <th class="">Nombre Area</th>
                    <th class="">Ubicacion</th>
                    <th class="">Id Complejo</th>
                    <th class="">Modulo</th>
              <%for(int j=0; j<listaArea_1.size();j++){%>            
                    <tr>
                        <td class="filas"><%=listaArea_1.get(j).getIDAREA()%></td>
                        <td class="filas"><%=listaArea_1.get(j).getNOMAREA()%></td>
                        <td class="filas"><%=listaArea_1.get(j).getUBICACION()%></td>
                        <td class="filas"><%=listaArea_1.get(j).getIDCOMPLEJO() %></td>
                        <td class="filas"><input type="submit" name="idCOMPLEJO" value="Deporte <%=listaArea_1.get(j).getIDAREA()%>"></td>
                    </tr> 
                <%}%>
            </table>
        </form
    </body>
</html>
