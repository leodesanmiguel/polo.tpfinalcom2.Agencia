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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leo Martinez
 */
@Entity
@Table(name = "empleado")
public class Empleado extends Persona implements Serializable {

    /**
     * Los datos de los Empleados son de las personas. En este caso cada
     * empleado tiene su ID es el orden de los empleados
     *
     *
     */
    private int idEmpleado;

    @Temporal(TemporalType.TIME)
    private Date fechaIngreso;

    /**
     * El sueldo del empleado es calculado a base del sueldo base segun su
     * puesto.
     *
     */
    private double sueldo;

    /**
     * El puesto empleado es calculado se asigna al momento de cargar un nuevo
     * empleado. Este podria tener un sueldo base y agregarle otras
     * asignaciones. Por ejemplo que antiguedad. puesto. Para eso hay que
     * calcular la antiguedad, a base de la fecha de ingreso. Cada empleado
     * tiene uno solo puesto.
     * <p>
     * Si llegara a cambiar el puesto de un empleado, iniciaria nuevamente la
     * fecha de ingreso y su correspondiente antiguedad.
     *
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Puesto suPuesto;

    /**
     * Cada empleado tiene asignado una o mas ventas
     *
     * https://docs.oracle.com/javaee/7/api/toc.htm
     *
     * Example 1: One-to-Many association using generics
     *
     * // In Customer class:
     *
     * //@OneToMany(cascade=ALL, mappedBy="customer") 
     * 
     * public Set<Order> getOrders() { return orders; }
     *
     * // In Order class:
     *
     * //@ManyToOne //@JoinColumn(name="CUST_ID", nullable=false) 
     * 
     * public Customer getCustomer() //{ return customer; }
     */
    @OneToMany(mappedBy = "empleado")
    private List<Venta> ventas;

    public Empleado() {
    }

    public Empleado(Date fechaIngreso,
            double sueldo,
            Puesto suPuesto, List<Venta> ventas) {

        this.fechaIngreso = fechaIngreso;

        this.sueldo = sueldo;
        this.suPuesto = suPuesto;
        this.ventas = ventas;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

   

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Puesto getSuPuesto() {
        return suPuesto;
    }

    public void setSuPuesto(Puesto suPuesto) {
        this.suPuesto = suPuesto;
    }

    public List<Venta> getCompras() {
        return ventas;
    }

    public void setCompras(List<Venta> ventas) {
        this.ventas = ventas;
    }

    

}
