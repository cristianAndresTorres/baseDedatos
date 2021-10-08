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
public class Sede {
    
    private String idComplejo;
    private String nomComplejo;
    private Long presupuesto;
    private String direccion;

    public Sede(){
    }
    
    //--------------------------------------------------------------------------
    public String getIDCOMPLEJO() { return idComplejo;
    }

    public void setIDCOMPLEJO(String IDCOMPLEJO) {this.idComplejo = IDCOMPLEJO;
    }

    public String getNOMCOMPLEJO() {return nomComplejo;
    }

    public void setNOMCOMPLEJO(String NOMCOMPLEJO) {this.nomComplejo = NOMCOMPLEJO;
    }

    public Long getPRESUPUESTO() {return presupuesto;
    }

    public void setPRESUPUESTO(Long PRESUPUESTO) {this.presupuesto = PRESUPUESTO;
    }

    public String getDIRECCION() {return direccion;
    }

    public void setDIRECCION(String DIRECCION) {this.direccion = DIRECCION;
    }
    
    
    
    
}
