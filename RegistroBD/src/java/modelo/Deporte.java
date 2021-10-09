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
public class Deporte {
    
    private String idDeporte;
    private String nomDeporte;
    private Long nMAXINTEGRANTES;

    public String getIDDEPORTE() {
        return idDeporte;
    }

    public void setIDDEPORTE(String IDDEPORTE) {
        this.idDeporte = IDDEPORTE;
    }

    public String getNOMDEPORTE() {
        return nomDeporte;
    }

    public void setNOMDEPORTE(String NOMDEPORTE) {
        this.nomDeporte = NOMDEPORTE;
    }

    public Long getNMAXINTEGRANTES() {
        return nMAXINTEGRANTES;
    }

    public void setNMAXINTEGRANTES(Long NMAXINTEGRANTES) {
        this.nMAXINTEGRANTES = NMAXINTEGRANTES;
    }
    
    
    
}
