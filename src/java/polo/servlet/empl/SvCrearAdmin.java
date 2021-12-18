package polo.servlet.empl;

import polo.servlet.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import polo.logica.Controladora;

/**
 *
 * @author Leo Martinez
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvCrearAdmin extends HttpServlet {

    Controladora ctrl = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String nombrePer = request.getParameter("frmNombre");
        String apellidoPer = request.getParameter("frmApellido");
        String domicilioPer = request.getParameter("frmDomicilio");
        String dniPer = request.getParameter("frmDNI");
        String nacionalPer = request.getParameter("frmNacional");
        String celularPer = request.getParameter("frmCelular");
        String emailPer = request.getParameter("frmemail");

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        System.out.println("Ahora podemos crear la "
                + "\n persona  : "+ apellidoPer 
                + "\n empleado : ADMIN" 
                + "\n PASSWORD : " + password );
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
