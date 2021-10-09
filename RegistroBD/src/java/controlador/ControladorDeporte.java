/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ConexionBD.PolideportivoSQL;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Polideportivo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import modelo.Evento;

/**
 *
 * @author 57301
 */
@WebServlet(name = "ControladorDeporte", urlPatterns = {"/ControladorDeporte"})

public class ControladorDeporte extends HttpServlet{
    private PolideportivoSQL polideportivoSQL = PolideportivoSQL.getMiPolideportivoSQL();
    private Polideportivo polideportivo;
    private Evento miEvento;
    
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
            case "registro_p1":
                this.mostrarDatos(request, response);
            break; 
            case "registro_2":
                this.registrarEvento(request, response);
            break;        
        }
    }
    //Permite traer los nombres de los deportes y encapsular los datos para el evento
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
            RequestDispatcher miPuente = request.getRequestDispatcher("/eventoDeportivo/vistaDeporte/vistaDeporte.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        }
        
    }
    
    //Permite traer el nombre de la sede,area y deporte para asignación del evento
    protected void mostrarDatos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        //---------------------------------------------------------------------
        String datos[] = (request.getParameter("deporte")).split(",");
        polideportivo = new Polideportivo();
        polideportivo.setIDAREA(datos[2]);
        polideportivo.setIDCOMPLEJO(datos[3]);
        polideportivo.setIDPOLI(datos[0]);
        polideportivo.setIDDEPORTE(datos[1]);
        //---------------------------------------------------------------------
        //Consulta sql
        //Realiza la consulta sql para traer los datos 
        if(polideportivoSQL.seleccionarEvento(polideportivo)){
            //2->Agregar(atributo) al request            
            request.setAttribute("listaDatos", polideportivoSQL.getListaPoli()); 
            //3->Establecer el puente/conexion para el paso de los recursos
            RequestDispatcher miPuente = request.getRequestDispatcher("/eventoDeportivo/vistaDeporte/eventoDeporte.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        }
        
    }
    
    //Permite registrar un nuevo evento a partir de una serie de datos dados por el usuario
    protected void registrarEvento(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        //---------------------------------------------------------------------
        String sede_1 = request.getParameter("sede_1");
        String area_1 = request.getParameter("area_1");
        String deporte_1 = request.getParameter("deporte_1");
        String n_fecha = request.getParameter("n_fecha");
        String n_duracion = request.getParameter("n_duracion");
        String n_participantes = request.getParameter("n_participantes");
        String n_id = "1004";
        
        /*String datosFecha[] = (request.getParameter("n_fecha")).split("/");
        String datosFecha_2[] = (request.getParameter("n_duracion")).split("/");
        String datos[] = (datosFecha_2[2]).split(":");*/
        
       //-----------------------------------------------------------------------------------------------------
        System.out.println(sede_1+" "+area_1+" "+deporte_1+" "+n_fecha+" "+n_duracion+" "+n_participantes);
        miEvento = new Evento();
        miEvento.setCODPERSONA(n_id);
        miEvento.setDURACION(n_duracion);
        miEvento.setFECHAHORA(n_fecha);
        miEvento.setIDAREA(area_1);
        miEvento.setIDCOMPLEJO(sede_1);
        miEvento.setIDDEPORTE(deporte_1);
        miEvento.setNPARTICIPANTES(Long.parseLong(n_participantes));
        //----------------------------------------------------------------------------------------------------
        polideportivoSQL.agendamiento(miEvento);
        /*
        //---------------------------------------------------------------------
        //Consulta sql
        //Realiza la consulta sql para traer los datos 
        if(polideportivoSQL.seleccionarEvento(polideportivo)){
            //2->Agregar(atributo) al request            
            request.setAttribute("listaDatos", polideportivoSQL.getListaPoli()); 
            //3->Establecer el puente/conexion para el paso de los recursos
            RequestDispatcher miPuente = request.getRequestDispatcher("/vistaDeporte/eventoDeporte.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp
            miPuente.forward(request, response);
        }*/
    }
}
