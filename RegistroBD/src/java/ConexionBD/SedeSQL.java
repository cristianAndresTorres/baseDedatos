/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Sede;


/**
 *
 * @author aleja
 */
public class SedeSQL extends ConexionOracle{
    private Sede sede;
    private List<Sede> listaSede = new ArrayList<>();
    private List<Sede> listaSedeFiltro = new ArrayList<>();
    private static SedeSQL miSedeDao;
 
    //Contructor----------------------------------------------------------------
    private SedeSQL(){
    }
    
    //--------------------------------------------------------------------------
    //Consulta lon nombres y ubicaciones de las sedes
    public boolean seleccionarSede(){
            listaSede.removeAll(listaSede);
            this.estado = false;
            try {
            String sql = "Select NOMCOMPLEJO, DIRECCION from Sede";
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            r = consultaRegristro.executeQuery();

            while(r.next()){
                sede = new Sede();
                sede.setNOMCOMPLEJO(r.getNString(1));
                sede.setDIRECCION(r.getNString(2));
                listaSede.add(sede);
            }
            estado =true;
            System.err.println("Select sedeDao");
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error sedeDAO-seleccionarSede");
            }   
        return  estado;
    }
    
    //--------------------------------------------------------------------------
    //Consulta lon nombres y ubicaciones de las sedes a partir de un filtro
    public boolean seleccionarFiltro(String nombre, String direccion){
            listaSedeFiltro.removeAll(listaSedeFiltro);
            this.estado = false;
            try {
            miConexion = this.realizarConexionBD();
            
            String sql = "Select NOMCOMPLEJO, DIRECCION, PRESUPUESTO, IDCOMPLEJO from Sede where NOMCOMPLEJO like '"+nombre+"%' and DIRECCION like '"+direccion+"%'";
            
            consultaRegristro = miConexion.prepareStatement(sql);
            
            /*consultaRegristro.setString(1, "C");
            consultaRegristro.setString(2, "C");*/
            
            r = consultaRegristro.executeQuery();

            while(r.next()){
                sede = new Sede();
                sede.setNOMCOMPLEJO(r.getNString(1));
                sede.setDIRECCION(r.getNString(2));
                sede.setPRESUPUESTO(r.getLong(3));
                sede.setIDCOMPLEJO(r.getNString(4));
                listaSedeFiltro.add(sede);
            }
            estado =true;
            System.err.println("seleccionarFiltro");
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error sedeDAO-seleccionarFiltro");
            }   
        return  estado;
    }
    
     
    //------------------------------------------------
    //Unico punto de acceso patron singleton
    public static SedeSQL getSedeDAO() {
        if(miSedeDao == null) 
                miSedeDao = new SedeSQL();
        return miSedeDao;
    }

    //--------------------------------------------------------------------------
    public List<Sede> getListaSede() {
        return listaSede;
    }
    public List<Sede> getListaSedeFiltro() {
        return listaSedeFiltro;
    }
    
}
