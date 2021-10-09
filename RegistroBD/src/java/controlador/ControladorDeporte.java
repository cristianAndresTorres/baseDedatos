/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ConexionBD.PolideportivoSQL;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 57301
 */
@WebServlet(name = "ControladorDeporte", urlPatterns = {"/ControladorDeporte"})

public class ControladorDeporte extends HttpServlet{
    private PolideportivoSQL polideportivoSQL = PolideportivoSQL.getMiPolideportivoSQL();
    
    //Entrada de datos por metodo doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       
        //-------------------------------------------------------------------
        
        String opcion = request.getParameter("intruccionProducto");
        switch(opcion){
            case "Filtrar":
                this.listarDeportes(request, response);
            break;
            case "detalles":
                
            break;    
        }
    }
    protected void listarDeportes(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String BTN_1 =  request.getParameter("BTN_1");
        BTN_1 = BTN_1.substring(18,BTN_1.length());
        //----------------------------------------------------------------------
        //Datos para la busqueda
        String idArea_1 = BTN_1.substring(0,3);
        String idComplejo = BTN_1.substring(4,BTN_1.length());
        //----------------------------------------------------------------------
        if(polideportivoSQL.seleccionarPolideportivo(idArea_1, idComplejo)){
            
            //2->Agregar(atributo) al request
            request.setAttribute("listaDeportes", polideportivoSQL.getListaDeporte());
            
            request.setAttribute("listaPoli", polideportivoSQL.getListaPoli()); 
            
            //3->Establecer el puente/conexion para el paso de los recursos
            RequestDispatcher miPuente = request.getRequestDispatcher("/vistaDeporte/vistaDeporte.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        }
        
    }
    
}
