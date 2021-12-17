
package polo.persistencia;

/**
 *
 * @author Leo Martinez
 */
public class ControladoraPersistencia {
    //////////////////////////////////////////////////////////////
    //  CONTROL DE PERSISTENCIA
    //////////////////////////////////////////////////////////////
    // personas clientes --> Podria estar Package Clientes
    PersonaJpaController persJPA = new PersonaJpaController();
    FormaDPagoJpaController frmPaJPA = new FormaDPagoJpaController();
    ClienteJpaController clieJPA = new ClienteJpaController();
    // Empleados y usuarios --> Podria estar Package Empleados
    PuestoJpaController puestJPA = new PuestoJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController userJPA = new UsuarioJpaController();
    // Productos y Servicios --> Podria estar Package Productos
    ServicioJpaController serviJPA = new ServicioJpaController();
    PaqueteJpaController paqueJPA = new PaqueteJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    //////////////////////////////////////////////////////////////
    
    
    
    
}
