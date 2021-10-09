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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Deporte;
import modelo.Polideportivo;


/**
 *
 * @author aleja
 */
public class PolideportivoSQL extends  ConexionOracle{   
    private static PolideportivoSQL miPolideportivoSQL;
    
    private Polideportivo polideportivo;
    private Deporte miDeporte;
    private List<Polideportivo> listaPoli = new ArrayList<>();
    private List<Deporte> listaDeporte = new ArrayList<>();
    
    /*
     * Constructor de la clase
     */
    private PolideportivoSQL(){
    }
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    //Consulta lon nombres de los deporte
    public boolean seleccionarPolideportivo(String idAREA, String idCOMPLEJO){
            listaDeporte.removeAll(listaDeporte);
            this.estado = false;
            try {
            String sql = "Select NOMDEPORTE, IDPOLI, D.IDDEPORTE from Polideportivo P, Area A, Deporte D "+
                            "where A.IDAREA = P.IDAREA and A.IDCOMPLEJO=P.IDCOMPLEJO "+
                                " and D.IDDEPORTE = P.IDDEPORTE and A.IDAREA=? and A.IDCOMPLEJO=?";
            
            System.out.println("String"+sql);
            
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            System.out.println("Area:"+idAREA);
            System.out.println("Complejo:"+idCOMPLEJO);
            consultaRegristro.setString(1, idAREA);
            consultaRegristro.setString(2, idCOMPLEJO);
            
            r = consultaRegristro.executeQuery();
            if(r.next()){
                miDeporte = new Deporte();
                miDeporte.setNOMDEPORTE(r.getNString(1));
                System.out.println("Deporte: "+miDeporte.getNOMDEPORTE());
                listaDeporte.add(miDeporte);
                
                polideportivo = new Polideportivo();
                polideportivo.setIDAREA(idAREA);
                polideportivo.setIDCOMPLEJO(idCOMPLEJO);
                polideportivo.setIDPOLI(r.getNString(2));
                polideportivo.setIDDEPORTE(r.getNString(3));
                listaPoli.add(polideportivo);
            }else{
            }
            estado =true;
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error PolideportivoSQL-seleccionarPolideportivo");
            }   
        return  estado;
    }
    
    
    //--------------------------------------------------------------------------
    //
    
    
    public List<Deporte> getListaDeporte(){
        return listaDeporte;
    }
    public List<Polideportivo> getListaPoli(){
        return listaPoli;
    }
    
    public static PolideportivoSQL getMiPolideportivoSQL(){
        if(miPolideportivoSQL==null)
            miPolideportivoSQL = new PolideportivoSQL();
        return  miPolideportivoSQL;
    }
     
}
