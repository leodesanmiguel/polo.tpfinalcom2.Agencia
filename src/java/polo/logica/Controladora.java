package polo.logica;

import polo.persistencia.ControladoraPersistencia;

/**
 *
 * @author Leo Martinez
 */
public class Controladora {

    ControladoraPersistencia ctrlJPA = new ControladoraPersistencia();

    //////////////////////////////////////////////////////////////
    //  CONTROL DE LA LÓGICA
    //////////////////////////////////////////////////////////////
    public boolean verificarAdmin(String usuario, String password) {

         return ctrlJPA.esAdmin(usuario, password);

    }

}
