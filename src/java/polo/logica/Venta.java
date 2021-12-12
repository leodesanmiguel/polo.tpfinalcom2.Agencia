/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.logica;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import polo.logica.enumera.TipoDContratacion;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @Temporal(TemporalType.TIME)
    private Date horaVenta;

    private double importe;
    private boolean estaPago;
    
    /**
     * Cada venta tiene un cliente como comprador
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente comprador;

    /**
     * Cada venta tiene un empleado como vendedor
     *
     * 
     * https://docs.oracle.com/javaee/7/api/toc.htm
     *
     * Example 1: One-to-Many association using generics
     *
     * // In Customer class:
     *
     * //@OneToMany(cascade=ALL, mappedBy="customer") public Set<Order>
     * //getOrders() { return orders; }
     *
     * In Order class:
     *
     * //@ManyToOne //@JoinColumn(name="CUST_ID", nullable=false) public
     * //Customer getCustomer() //{ return customer; }
     *
     *
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Empleado vendedor;

    /**
     * Cada venta se realiza en forma individual o de forma de paquete.
     */
    @Enumerated(EnumType.ORDINAL)
    private TipoDContratacion tipoContratacion;

    /**
     * Un paquete puede tener un solo servicio o puede tener varios servicios
     * juntos. De forma que todas las ventas tienen un paquete.<p>
     * Todas las ventas tienen un solo paquete
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Paquete paquete;

    

    public Venta() {
    }

    public Venta(int idVenta, Date fechaVenta, Date horaVenta
            , Cliente comprador, Empleado vendedor
            , TipoDContratacion tipoContratacion
            , Paquete paquete) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.tipoContratacion = tipoContratacion;
        this.paquete = paquete;
        
    }

    public double getImporte() {
        return importe;
    }

    public boolean isEstaPago() {
        return estaPago;
    }
    
    
    

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Date horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public TipoDContratacion getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(TipoDContratacion tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fechaVenta=" + fechaVenta 
                + ", horaVenta=" + horaVenta + ", comprador=" + comprador 
                + ", vendedor=" + vendedor 
                + ", tipoContratacion=" + tipoContratacion 
                + ", paquete=" + paquete + "}";
    }
    
    
    /**
     * TODO  Falta carlular el importe del paquete y determinar si está pago 
     *      Enter otras cosas
     * 
     */

}
