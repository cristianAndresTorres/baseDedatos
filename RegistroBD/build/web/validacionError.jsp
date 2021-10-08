<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista RegistroError</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
    </head>
    <link rel="stylesheet" href="css/estilos_1.css"> 
    <body>
        <div class="contenedor">
            <form action="controladorRegistro" class="form" method="post">
                <div class="form-header">
                    <h1 class="form-tittle">D<span>atos erroneos</span></h1>
                </div> 
                <label for="datos" class="form-label">Ingrese nuevamente los datos.</label>
            </form>
        </div>
        <jsp:include page="index.html"></jsp:include></br>
    </body>
</html>
