<%-- 
    Document   : Datos
    Created on : 17-may-2021, 15:24:18
    Author     : 57301
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista validacion</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
    </head>
    <link rel="stylesheet" href="css/estilos_1.css">
    <body>
        <div class="contenedor">
            <div  action="" class="form">
                <form action="controladorRegistro" method="POST">
                    
                    <div class="form-header">
                        <h1 class="form-tittle">V<span>alidación</span></h1>
                    </div> 
                
                    <label for="nombre_usu" class="form-label">Nombre: <%= request.getParameter("nom")%></label>
                    <label for="apellido_usu" class="form-label">Apellido: <%= request.getParameter("ap")%></label>
                    <label for="alias_usu" class="form-label">Usuario: <%= request.getParameter("usu")%></label>
                    <br>
                    <label for="contrasegna" class="form-label">Contraseña:</label>
                    <input type="password" id="contrasegna" class="form-input" placeholder="Digite su contraseña" name="pass_1">

                    <label for="contrasegna_1" class="form-label">Confirmación:</label>
                    <input type="password" id="contrasegna_1" class="form-input" placeholder="Digite su contraseña nuevamente" name="pass_2">
                    
                    
                    <input type="hidden" name="instruccion" value="registro_p2">
                    <input type="hidden" name="correo" value="<%= request.getParameter("correo")%>">
                    <input type="submit" class="btn-submit" value="Confirmar">
                    
                 </form>    
                <br> 
                <form action="index.html"><input type="submit" class="btn-submit" value="Inicio"></form>
            </div>
            
        </div>
         
    </body>
</html>
