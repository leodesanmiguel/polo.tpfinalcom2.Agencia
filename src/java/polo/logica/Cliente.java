/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;


import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

    /**
     * Este Id se genera solo. Solo se puede recuperar el nro
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    * */
    /**
     * Cada Cliente tiene una mas formas de Pago. deberán asignarle a cada
     * cliente la forma de pagar.
     */
    @OneToMany(cascade = CascadeType.ALL)
    List<FormaDPago> formasDPago;

    /**
     * Los clientes realizan compras puede haber una o varias Las compras son
     * las ventas de la AGENCIA
     *
     */
    @OneToMany
    List<Venta> compras;

    public Cliente() {
    }

    public Cliente(List<FormaDPago> formasDPago,
             List<Venta> compras,
             String nombreP, String apellidoP, String direccionP, int dni,
             Date fechaNacio, String nacionalidad, String celular,
             String email) {
        super(nombreP, apellidoP, direccionP, dni, fechaNacio, nacionalidad,
                 celular, email);
        this.formasDPago = formasDPago;

        this.compras = compras;
    }

    

    public List<FormaDPago> getFormasDPago() {
        return formasDPago;
    }

    public void setFormasDPago(List<FormaDPago> formasDPago) {
        this.formasDPago = formasDPago;
    }

    public List<Venta> getCompras() {
        return compras;
    }

    public void setCompras(List<Venta> compras) {
        this.compras = compras;
    }

}
