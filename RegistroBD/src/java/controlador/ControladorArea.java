/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ConexionBD.AreaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 57301
 */
@WebServlet(name = "ControladorArea", urlPatterns = {"/ControladorArea"})
public class ControladorArea extends HttpServlet{
    private AreaDAO miAreaDao = AreaDAO.getAreaDAO();
     //Entrada de datos por metodo doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        //-------------------------------------------------------------------
        String opcion = request.getParameter("instruccionArea");
        switch(opcion){
            case "area":
                this.listarOpcionesArea(request, response);
            break;
            case "filtrar":
                this.filtrarArea(request, response);
            break;    
        }
    }
    
    //--------------------------------------------------------------------------
    //Permite obtener la lista de nombres y ubicaciones de las areas
    protected void listarOpcionesArea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //Se obtiene el id de la Sede
        String idCOMPLEJO = request.getParameter("idCOMPLEJO");
        idCOMPLEJO = idCOMPLEJO.substring(7,idCOMPLEJO.length());
        //Se realiza la busqueda de las areas y ubicaciones que pertenece a Sede
        if(miAreaDao.seleccionarArea(idCOMPLEJO)){
            request.setAttribute("listaArea", miAreaDao.getListaArea());
            System.out.println("Tamagno"+miAreaDao.getListaArea().size());
        }
        
                
    }
    protected void filtrarArea(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }  
}
