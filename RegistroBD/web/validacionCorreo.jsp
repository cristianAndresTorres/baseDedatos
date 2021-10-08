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
                <div class="form-header">
                    <h1 class="form-tittle">C<span>onfirmar contraseña</span></h1>
                </div> 
             
                <label for="nombre" class="form-label">Sea enviado un enlace de verificacion a:</label>
                <label for="correo_2" class="form-label"><%= request.getAttribute("correo_1")%></label>
                
                
                
                
                <form action="https://mail.google.com"><input type="submit" class="btn-submit" value="Gmail"></form>
                <br> 
                <form action="index.html"><input type="submit" class="btn-submit" value="Regresar"></form>
            </div>
            
        </div>
         
    </body>
</html>
