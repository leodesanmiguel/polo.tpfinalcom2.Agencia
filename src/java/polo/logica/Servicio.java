
package polo.logica;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import polo.logica.enumera.TipoDServicios;

/** 
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;
    
    @Enumerated(EnumType.ORDINAL)
    private TipoDServicios nombreServ;
    
    private String descripcionServ;
    private String destinoS;

    @Temporal(TemporalType.DATE)
    private Date fechaServicio;

    private double costoS;

    /**
     * Cada Servicio puede estar en uno o mas paquetes.
     */
    @ManyToMany(mappedBy="servicio")
     private List<Paquete> paquetes;

    public Servicio() {
    }

   

   

}
