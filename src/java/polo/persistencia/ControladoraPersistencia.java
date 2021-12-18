package polo.persistencia;

import java.util.List;
import polo.logica.Usuario;

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

    /**
     * INICIANDO
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * <<<  Esto tiene tres niveles de seguridad solo para este trabajo  >>>
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 
     * ADMIN: puede crear a los JEFEs
     * 
     * esAdmin: Si está creado admin, verifica su contraseña.
     *          Sino Crear un admin con nombre y apellido y datos de la persona
     * 
     * 
     * 
     **/
    
    public boolean esAdmin(String usuario, String password) {

        boolean seCreoAdmin = false;
        List<Usuario> users = userJPA.findUsuarioEntities();
        for (Usuario u : users) {
            if (u.getNombreUsr().equals(usuario) || u.getPassword().equals(password)) {
                return true;
            }
        }
        
        return false;
    }

}
