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
import modelo.Evento;
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
    
    private Evento miEvento;
    
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
            listaPoli.removeAll(listaPoli);
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
            while(r.next()){
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
            }
            estado =true;
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error PolideportivoSQL-seleccionarPolideportivo");
            }   
        return  estado;
    }
    
    //Consulta los datos del evento
    public boolean seleccionarEvento(Polideportivo miPoli){
            listaPoli.remove(listaPoli);
            this.estado = false;
            try {
            String sql = "Select A.NOMAREA, S.NOMCOMPLEJO, D.NOMDEPORTE, A.UBICACION from Polideportivo P, Area A, Deporte D, Sede S "+
                            "where S.IDCOMPLEJO = A.IDCOMPLEJO and A.IDAREA =P.IDAREA and A.IDCOMPLEJO = P.IDCOMPLEJO and D.IDDEPORTE=P.IDDEPORTE and "+
                                    "S.IDCOMPLEJO =? and A.IDAREA=? and D.IDDEPORTE=? and P.IDPOLI=? ";
            
            System.out.println("String"+sql);
            
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            
            consultaRegristro.setString(1, miPoli.getIDCOMPLEJO());
            consultaRegristro.setString(2, miPoli.getIDAREA());
            consultaRegristro.setString(3, miPoli.getIDDEPORTE());
            consultaRegristro.setString(4, miPoli.getIDPOLI());
            
            r = consultaRegristro.executeQuery();
            if(r.next()){
                polideportivo = new Polideportivo();
                polideportivo.setIDAREA(r.getNString(1)+" en "+r.getNString(4));
                polideportivo.setIDCOMPLEJO(r.getNString(2));
                polideportivo.setIDDEPORTE(r.getNString(3));
                
                listaPoli.add(polideportivo);
                listaPoli.add(miPoli);
            }else{
            }
            estado =true;
            r.close();
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error PolideportivoSQL-seleccionarEvento");
            }   
        return  estado;
    }
    
    public boolean agendamiento(Evento evento){
            this.estado = false;
            try {
            String sql = "INSERT INTO evento(FECHAHORA, DURACION, NPARTICIPANTES, CODPERSONA, IDDEPORTE, IDAREA, IDCOMPLEJO) " +
		" values(?,TO_DATE(?,'DD/MM/YYYY:HH24:MI:SS'),?,?,?,?,?)";
            
            System.out.println("String"+sql);
            
            miConexion = this.realizarConexionBD();
            consultaRegristro = miConexion.prepareStatement(sql);
            
            consultaRegristro.setString(1, evento.getFECHAHORA());
            consultaRegristro.setString(2, evento.getDURACION());
            consultaRegristro.setLong(3, evento.getNPARTICIPANTES());
            consultaRegristro.setString(4, evento.getCODPERSONA());
            consultaRegristro.setString(5, evento.getIDDEPORTE());
            consultaRegristro.setString(6, evento.getIDAREA());
            consultaRegristro.setString(7, evento.getIDCOMPLEJO());
            
            estado =!(consultaRegristro.execute());
            
            System.out.println(estado+":estado");
            
           
            miConexion.close();
            } catch (Exception e) {
                System.err.println("Error PolideportivoSQL-agendamiento");
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
