/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexiones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author 57301
 */
public class ConsultaUsuarioSQL extends ConexionOracle{    
    //Contructor
    public ConsultaUsuarioSQL(){}
    
    //--------------------------------------------------------------------------
    //Permite registrar al usuario PASO(nombre,apellido, correo, fecha de nacimiento)
    public boolean registroUsuP1(Usuario miUsuario){
        estado = false;
        try {
            //1-> realizar conexion
            miConexion = realizarConexionBD();
            //2-> Preparar Consulta-preParada
            
            String sqlResgistro = "Insert into usuario(nombre,apellido,correo,fecha_nacimiento)"+
            " values(?,?,?,to_date(?,'dd/mm/yyyy'))";
            System.out.println(miUsuario.getFecha());
            consultaRegristro = miConexion.prepareStatement(sqlResgistro);

            //3-> Pasar parametros de la consulta
            consultaRegristro.setString(1, miUsuario.getNombre());
            consultaRegristro.setString(2, miUsuario.getApellido());
            consultaRegristro.setString(3, miUsuario.getCorreo());
            consultaRegristro.setString(4, miUsuario.getFecha());
            System.out.println("Nombre : "+miUsuario.getNombre());
            //4-> realizar modificacion
            System.out.println("Estado:"+consultaRegristro.execute());
            conexionBD.close();
            estado = true;
            System.out.println("Exitos!!!-SonsultaSQL-registroUsuP1");
        } catch (Exception e) {
            System.out.println("Error-SonsultaSQL-registroUsuP1");
            estado = false;
        }
        
        return estado;
    }
    
    //--------------------------------------------------------------------------
    //Permite registrar al usuario PASO2(Contrasegna)
     public boolean registroUsuP2(Usuario miUsuario){
        estado = false;
        try {
            //1->realizar Conexion
            miConexion = realizarConexionBD();

            //2->Preparar consulta
            String sqlModificacion = "Update Usuario set contrasegna=?"+
            " where correo=? and contrasegna is null";

            consultaRegristro = conexionBD.prepareStatement(sqlModificacion);

            //3-> pasar los parametros
            consultaRegristro.setString(1, miUsuario.getContasegna());
            consultaRegristro.setString(2, miUsuario.getCorreo());

            //4->Terminar sentencia
            consultaRegristro.execute();

            conexionBD.close();

            estado = true;
            System.out.println("Exitos!!!-SonsultaSQL-registroUsuP2");
        } catch (Exception e) {
                System.out.println("ConsultaProducto-registroUsuP2 - error");
                return false;
        }
        
        return estado;
    }
     
     //-------------------------------------------------------------------------
     public Usuario estado(String correo){
         Usuario mi = null;
         try {
            String sql = "Select * from usuario";
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            r = consultaRegristro.executeQuery();

            if(r.next()){
                mi = new Usuario(r.getNString(1), "", "", "");
                System.out.println("Entre:"+mi.getNombre());
            }
            System.out.println("Aqui estoy");
         
         //System.out.println(mi.getNombre());
         // r.close();
         miConexion.close();
         } catch (Exception e) {
             System.err.println("Error Estado");
         }
         
         return mi;
     }
    
    
    
}
