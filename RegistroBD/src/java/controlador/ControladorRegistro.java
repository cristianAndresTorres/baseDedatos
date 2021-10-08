/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import conexiones.ConexionOracle;
import conexiones.ConsultaUsuarioSQL;
import validacionCorreo.Correo;
import modelo.Usuario;
import validacionCorreo.Validacion;

/**
 *
 * @author 57301
 */
@WebServlet(name = "ControladorRegistro", urlPatterns = {"/ControladorRegistro"})
public class ControladorRegistro extends HttpServlet{
    //Atributos
    public Usuario miUsuario;

    //Entrada de datos por metodo doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ConsultaUsuarioSQL  consultaSQL= new ConsultaUsuarioSQL();
        consultaSQL.estado("cc1999torres@gmail.com");
        //--------------c------------------------
        //this.verificarCorreo(request, response, correo);
        //-------------------------------------------------------------------
        /*String opcion = request.getParameter("instruccion");
        switch(opcion){
            case "registro_p1":
                this.realizarPaso_1(request, response);
            break;
            case "registro_p2":
                this.realizarPaso_2(request, response);
        }
        
        //this.datosErroneos(request, response);*/
    }        
    
    
    //-----------------------------------------------------------------------------------
    public void realizarPaso_1(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //Validación de los datos de entrada
        //Entrada de datos
        String nombre = ""+request.getParameter("nombre");
        String apellido = ""+request.getParameter("apellido");
        String fecha =  ""+request.getParameter("fecha");
        String correo = ""+request.getParameter("correo");
        
        Usuario miUsuario = new Usuario(nombre, apellido, fecha, correo);
        
        boolean estadoCuenta = false;
        if(miUsuario.verificarCorreo()){
            if(miUsuario.crearCuentaP1(miUsuario)){
                System.out.println("Creado Correctamente"); 
                //Enviar correo al usuario
                Correo.enviarCorreo(miUsuario);
                estadoCuenta = true;
                this.datosCorrectos(request, response, correo);
            }    
        }
        //Datos Erroneos de ingreso ERRONEOS
        if(!estadoCuenta)
            this.datosErroneos(request, response);
   
    }
  
    //--------------------------------------------------------------------------
    //Paso 1-Creacion de cuentas
    public void datosErroneos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher miPuesnte = request.getRequestDispatcher("/validacionError.jsp");     
        //4->Enviar/Reenviar ese request a la pagina jsp
        miPuesnte.forward(request, response);
    }
    public void datosCorrectos(HttpServletRequest request, HttpServletResponse response, String correo)
        throws ServletException, IOException {
        //2->Agregar(atributo) correo al request
        request.setAttribute("correo_1", correo); 
        //3->Establecer el puente/conexion para el paso de los recursos
        RequestDispatcher miPuesnte = request.getRequestDispatcher("/validacionCorreo.jsp");     
        //4->Enviar/Reenviar ese request a la pagina jsp
        miPuesnte.forward(request, response);
    }
    //--------------------------------------------------------------------------
  
    public void realizarPaso_2(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        
        String contrasegna = request.getParameter("pass_1"); 
        String contrasegna_1 = request.getParameter("pass_2"); 
        String correo = request.getParameter("correo");
        RequestDispatcher miPuesnte; 
        
        //Validación de la contrasegna
        if(Validacion.validarContrasegna(contrasegna, contrasegna_1)){
            miUsuario = new Usuario();
             miUsuario.autenticarCuentaP2(correo, contrasegna_1);
            //3->Establecer el puente/conexion para el paso de los recursos
            miPuesnte = request.getRequestDispatcher("/index.html");     
            //4->Enviar/Reenviar ese request a la pagina jsp
        }else{
            //2->Agregar(atributo) correo al request
            request.setAttribute("correo_1", correo); 
            //3->Establecer el puente/conexion para el paso de los recursos
            miPuesnte = request.getRequestDispatcher("/validacionCorreo.jsp");     
            //4->Enviar/Reenviar ese request a la pagina jsp  
        }
         miPuesnte.forward(request, response);        
    }
}
