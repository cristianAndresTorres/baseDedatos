<%-- 
    Document   : vistaSedeFiltrar
    Created on : 8 oct. 2021, 1:31:52
    Author     : 57301
--%>
<%@page import="modelo.Sede"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%List<Sede> listaSede = (List<Sede>)request.getAttribute("ListaSedesFiltro");%>
    <body>
        <form action="" method="get">
            <table>          
                <tr>
                    <th class="">NOMCOMPLEJO</th>
                    <th class="">PRESUPUESTO</th>
                    <th class="">DIRECCION</th>
                    <th class="">Área</th>
              <%for(int j=0; j<listaSede.size();j++){%>            
                    <tr>
                        <td class="filas"><%=listaSede.get(j).getNOMCOMPLEJO()%></td>
                        <td class="filas"><%=listaSede.get(j).getPRESUPUESTO()%></td>
                        <td class="filas"><%=listaSede.get(j).getDIRECCION()%></td>
                        <td class="filas"><input type="submit" name="area" value="Modulo <%=listaSede.get(j).getIDCOMPLEJO()%>"></td>
                    </tr>  
                <%}%>
            </table>
        </form
        <jsp:include page="vistaSede.jsp"></jsp:include></br>
    </body>
</html>
