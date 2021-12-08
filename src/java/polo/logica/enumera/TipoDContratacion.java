/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica.enumera;

/**
 *
 * @author Leo Martinez
 */
public enum TipoDContratacion {
    IND("individual"),
    PAQ("paquete");
    
    private String tipo;
    
    private TipoDContratacion(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipoContratacion(){
        return this.tipo;
        
    }
    
}
