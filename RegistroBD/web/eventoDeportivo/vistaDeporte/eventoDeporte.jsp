<%-- 
    Document   : eventoDeporte
    Created on : 9 oct. 2021, 12:25:39
    Author     : 57301
--%>
<%@page import="modelo.Deporte"%>
<%@page import="modelo.Polideportivo"%>
<%@page import="modelo.Polideportivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%List<Polideportivo> listaPoli = (List<Polideportivo>)request.getAttribute("listaDatos");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registroEvento</title>
    </head>
    <link rel="stylesheet" href="./css/estilos_1.css">
    
    <body>
        <div class="contenedor">
             <form action="ControladorDeporte" class="form" method="post">
                <input type="hidden" name="intruccionProducto" value="registro_2">
                <div class="form-header">
                    <h1 class="form-tittle">R<span>esgistro evento</span></h1>
                </div> 
                
                <label for="nombre" class="form-label">Sede:</label>
                <input type="text" id="sede" class="form-input" value="<%=listaPoli.get(0).getIDCOMPLEJO()%>" readonly onmousedown="return false;">
                <input type="hidden" name="sede_1" value="<%=listaPoli.get(1).getIDCOMPLEJO()%>">
                
                <label for="apellido" class="form-label">Área:</label>
                <input type="text" id="area" class="form-input" value="<%=listaPoli.get(0).getIDAREA()%>" readonly onmousedown="return false;">
                <input type="hidden" name="area_1" value="<%=listaPoli.get(1).getIDAREA()%>">
                
                <label for="correo" class="form-label">Deporte:</label>
                <input type="text" id="deporte" class="form-input" value="<%=listaPoli.get(0).getIDDEPORTE()%>" readonly onmousedown="return false;">
                <input type="hidden" name="deporte_1" value="<%=listaPoli.get(1).getIDDEPORTE()%>">
                
                <label for="correo" class="form-label">Fecha:</label>
                <input type="text" id="fecha" class="form-input" value="11/10/2021" name="n_fecha">
                
                <label for="correo" class="form-label">Duración:</label>
                <input type="text" id="duracion" class="form-input" value="11/10/2021:10:34:24" name="n_duracion">
                
                <label for="correo" class="form-label">N participantes:</label>
                <input type="text" id="n_participantes" class="form-input" placeholder="Digite su número" name="n_participantes">
                
                
                <input type="submit" class="btn-submit" value="Registrar Evento">
            </form>
        </div>        
    </body>
</html>
