/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author 57301
 */
public class Evento {
    
    private Long consec;
    private String fechaHora;
    private String duracion;
    private Long nPARTICIPANTES;
    private String codPersona;
    private String id_deporte;
    private String idArea;
    private String idComplejo;

    public Evento(){
        
    }
    public Long getCONSEC() {
        return consec;
    }

    public void setCONSEC(Long CONSEC) {
        this.consec = CONSEC;
    }

    public String getFECHAHORA() {
        return fechaHora;
    }

    public void setFECHAHORA(String FECHAHORA) {
        this.fechaHora = FECHAHORA;
    }

    public String getDURACION() {
        return duracion;
    }

    public void setDURACION(String DURACION) {
        this.duracion = DURACION;
    }

    public Long getNPARTICIPANTES() {
        return nPARTICIPANTES;
    }

    public void setNPARTICIPANTES(Long NPARTICIPANTES) {
        this.nPARTICIPANTES = NPARTICIPANTES;
    }

    public String getCODPERSONA() {
        return codPersona;
    }

    public void setCODPERSONA(String CODPERSONA) {
        this.codPersona = CODPERSONA;
    }

    public String getIDDEPORTE() {
        return id_deporte;
    }

    public void setIDDEPORTE(String IDDEPORTE) {
        this.id_deporte = IDDEPORTE;
    }

    public String getIDAREA() {
        return idArea;
    }

    public void setIDAREA(String IDAREA) {
        this.idArea = IDAREA;
    }

    public String getIDCOMPLEJO() {
        return idComplejo;
    }

    public void setIDCOMPLEJO(String IDCOMPLEJO) {
        this.idComplejo = IDCOMPLEJO;
    }
    
    
}
