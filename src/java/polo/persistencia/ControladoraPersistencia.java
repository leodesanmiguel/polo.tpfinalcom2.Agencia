/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polo.persistencia;

/**
 *
 * @author Leo Martinez
 */
public class ControladoraPersistencia {

    ClienteJpaController clieJPA = new ClienteJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    FormaDPagoJpaController frmPaJPA = new FormaDPagoJpaController();
    PagoJpaController pagoJPA = new PagoJpaController();
    PaqueteJpaController paqueJPA = new PaqueteJpaController();
    PuestoJpaController puestJPA = new PuestoJpaController();
    ServicioJpaController serviJPA = new ServicioJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();

}
