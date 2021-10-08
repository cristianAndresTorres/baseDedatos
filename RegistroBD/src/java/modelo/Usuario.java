/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexiones.ConsultaUsuarioSQL;
import java.sql.SQLException;
import validacionCorreo.Validacion;

/**
 *
 * @author 57301
 */
public class Usuario {
    //Atributos
    private String nombre;
    private String apellido;
    private String fecha;
    private String correo;
    private String alias;
    private String contrsegna;
    //------------------------
    //Consultas sql
    private ConsultaUsuarioSQL miConsultaSQL = new ConsultaUsuarioSQL();
    
    //Constructor--------------------------------------------------------------------------
    //Registro usuario
    public Usuario(String nombre,String apellido,String fecha, String correo){
        this.apellido = apellido;  
        this.nombre = nombre;
        this.fecha = fecha;
        this.correo = correo;
    }
    public Usuario(){}
    
    //--------------------------------------------------------------------------------------
    public boolean verificarCorreo(){
        boolean estado=false;
        if(Validacion.validarCorreo(correo)){
            if(Validacion.validarFecha(fecha)){
                estado = true;}
        }
        return estado;
    }
    
    public boolean crearCuentaP1(Usuario mi){
        return miConsultaSQL.registroUsuP1(mi);
    }
    
    public boolean autenticarCuentaP2(String correo, String contrasegna){
        this.correo = correo;
        this.contrsegna = contrasegna;
        return  miConsultaSQL.registroUsuP2(this);
    }
    
    
    //---------------------------------------------------------------------------

    public String getNombre() {return nombre;}
    public String getApellido() { return apellido;}
    public String getAlias() {
        this.alias =  nombre.substring(0,2) + apellido.substring(apellido.length()-3,apellido.length());
        return alias;
    }
    public String getCorreo() {return correo;}
    public String getFecha() {return fecha;}
    public String getContasegna(){return contrsegna;}
    
    
    
}
