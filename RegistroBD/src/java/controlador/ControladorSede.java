/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexiones.ConsultaUsuarioSQL;
import conexiones.SedeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Sede;

/**
 *
 * @author 57301
 */
@WebServlet(name = "ControladorSede", urlPatterns = {"/ControladorSede"})
public class ControladorSede extends HttpServlet{
    //Atributos
    private SedeDAO miSedeDao = SedeDAO.getSedeDAO();

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //-------------------------------------------------------------------
        String opcion = request.getParameter("instruccion");
        switch(opcion){
            case "registro_p1":
                this.listarOpcionesSede(request, response);
            break;
            case "filtrar":
                this.filtrarSede(request, response);
            break;    
        }
    }
    
    //Permite obtener la lista de nombres y ubicaciones de las sedes
    public void listarOpcionesSede(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{     
        if(miSedeDao.seleccionarSede()){
            //2->Agregar(atributo) Lista de nombres y ubicaciones al request
            request.setAttribute("listaSedes", miSedeDao.getListaSede()); 
            //3->Establecer el puente/conexion para el paso de los recursos
            RequestDispatcher miPuente = request.getRequestDispatcher("/vistaSede/vistaSede.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        } 
    }
    
    //Permite obtener la lista con todos los atributos de las sedes a partir de un filtro
    public void filtrarSede(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{     
        if(miSedeDao.seleccionarFiltro(request.getParameter("nombre"), request.getParameter("direccion"))){
            //2->Agregar(atributo) al request
            request.setAttribute("ListaSedesFiltro", miSedeDao.getListaSedeFiltro());
            miSedeDao.seleccionarSede();
            request.setAttribute("listaSedes", miSedeDao.getListaSede()); 
            
            //3->Establecer el puente/conexion para el paso de los recursos
            RequestDispatcher miPuente = request.getRequestDispatcher("/vistaSede/vistaSedeFiltrar.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        } 
    }

}
