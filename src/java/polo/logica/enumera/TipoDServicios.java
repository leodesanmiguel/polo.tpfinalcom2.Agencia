/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica.enumera;

/**
 *
 * @author Leo martinez
 */
public enum TipoDServicios {
    
    HOT("Noche de hotel"),
    AUT("Alquiler de auto"),
    PCO("Pasaje de bus"),
    PAV("Pasaje de avión"),
    PTR("Pasaje de tren"),
    EXC("Excursión"),
    EVE("Evento"),
    ;
    
    private String tipo;
    
    private TipoDServicios(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipoServicio(){
        return this.tipo;
        
    }
}
