/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aleja
 */
public class Area {
    private String idArea;
    private String nombreArea;
    private String ubicacion;
    private String idComplejo;
    //string es varchar,long es number,date es date libreria sqljava
    
    public Area(){
        
    }
    
    //--------------------------------------------------------------------------
    public String getIDAREA() {
        return idArea;
    }

    public String getNOMAREA() {
        return nombreArea;
    }

    public String getUBICACION() {
        return ubicacion;
    }

    public String getIDCOMPLEJO() {
        return idComplejo;
    }

    public void setIDAREA(String IDAREA) {
        this.idArea = IDAREA;
    }

    public void setNOMAREA(String NOMAREA) {
        this.nombreArea = NOMAREA;
    }

    public void setUBICACION(String UBICACION) {
        this.ubicacion = UBICACION;
    }

    public void setIDCOMPLEJO(String IDCOMPLEJO) {
        this.idComplejo = IDCOMPLEJO;
    }
    
    
}
