package polo.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaquete;
    /**
     * El costo del paquete es igual a la suma de los costos de los servicios
     * que lo componen menos un 10% de descuento por contratarlos en forma de
     * paquete.
     *
     * En caso que el paquete contenga un solo servicio. Este porcentaje no se
     * aplica
     */
    private double costoPaquete;

    /**
     * El descuento está asignado inicialmente al 10%
     * <p>
     * Se podrá cambar este valor desde la administración.
     *
     */
    private double descuento;

    /**
     * Cada paquete contiene una lista de servicios que tiene cada uno un valor
     * del mismo.
     *
     * Como se pide que las ventas tengan un servicio o un paquete, puede un
     * paquete tener un solo servicio o puede tener una lista de servicios
     */
    @ManyToMany
    @JoinTable(name = "PAQUETE_SERVICIO")
    private List<Servicio> servicios;

    /**
     *
     *
     * Puede contener un solo servicio o mas de uno.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPaquete", nullable = false, updatable = false)
    private List<Venta> pedidos;

    public Paquete() {
    }

    public Paquete(double costoPaquete, double descuento,
             List<Servicio> servicios) {
        this.costoPaquete = costoPaquete;
        this.descuento = descuento;
        this.servicios = servicios;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

   

    public double getCostoPaquete() {
        return costoPaquete;
    }



    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<Servicio> getServicios() {
        
        
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        // al asignar los servicios se debe consignar el costo del paquete
        
        double costo=0;
        List<Servicio> sserv = new ArrayList<>();
        
        for (Servicio s: servicios){

            
        }
        
        
        this.servicios = servicios;
    }

    public List<Venta> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Venta> pedidos) {
        this.pedidos = pedidos;
    }

}
