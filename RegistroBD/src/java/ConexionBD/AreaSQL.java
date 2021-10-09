/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import conexiones.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Area;

/**
 *
 * @author aleja
 */
public class AreaSQL extends ConexionOracle{
    private static AreaSQL miAreaDAO;
    private List<Area> miListaArea = new ArrayList<>();
    private List<Area> miListaAreaFiltro = new ArrayList<>();
    private Area area;
    /*
     * Constructor de la clase
     */
    private AreaSQL(){
    }
    
    //--------------------------------------------------------------------------
    //Consulta lon nombres y ubicaciones de las areas
    public boolean seleccionarArea(String idComplejo){
            miListaArea.removeAll(miListaArea);
            this.estado = false;
            try {
            String sql = "Select NOMAREA, UBICACION from Area where IDCOMPLEJO = ?";
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            //Pasar parametros de la consulta
            consultaRegristro.setString(1, idComplejo);
            
            r = consultaRegristro.executeQuery();

            while(r.next()){
                area = new Area();
                area.setNOMAREA(r.getNString(1));
                area.setUBICACION(r.getNString(2));
                miListaArea.add(area);
            }
            estado =true;
            System.err.println("Select seleccionarArea");
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error AreaDAO-seleccionarArea");
            }   
        return  estado;
    }
    //--------------------------------------------------------------------------
    //Consulta lon nombres y ubicaciones de las areas a partir de un filtro
    public boolean seleccionarFiltro(String nombre, String direccion, String id){
            miListaAreaFiltro.removeAll(miListaAreaFiltro);
            this.estado = false;
            try {
            miConexion = this.realizarConexionBD();
            
            String sql = "Select IDAREA, NOMAREA, UBICACION, IDCOMPLEJO from Area where NOMAREA like '"+nombre+"%' and UBICACION like '"+direccion+"%' and"
                    + " IDCOMPLEJO=?";
                System.out.println("ID___:"+id);
            consultaRegristro = miConexion.prepareStatement(sql);
            
            consultaRegristro.setString(1, id);
            /*consultaRegristro.setString(1, "C");
            consultaRegristro.setString(2, "C");*/
            
            r = consultaRegristro.executeQuery();
                
                System.out.println("________AaAa_");
            while(r.next()){
                area = new Area();
                area.setIDAREA(r.getNString(1));
                area.setNOMAREA(r.getNString(2));
                area.setUBICACION(r.getNString(3));
                area.setIDCOMPLEJO(r.getNString(4));
                miListaAreaFiltro.add(area);
            }
            estado =true;
            System.err.println("seleccionarFiltro_2");
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error areaDAO-seleccionarFiltro");
            }   
        return  estado;
    }
    
    
    
    public List<Area> getListaArea(){
        return miListaArea;
    }
    
    public List<Area> getmiListaAreaFiltro(){
        return miListaAreaFiltro;
    }
    
    //--------------------------------------------------------------------------
    public static AreaSQL getAreaDAO(){
        if(miAreaDAO == null)
            miAreaDAO = new AreaSQL();
        return miAreaDAO;
    }
    
}
