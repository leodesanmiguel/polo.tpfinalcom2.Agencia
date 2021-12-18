package polo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import polo.logica.Controladora;

/**
 *
 * @author Leo Martinez
 */
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    

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
        
        System.out.println("Ingresó al proceso de REspuesta");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        try {
                    String usuario = request.getParameter("frmNombre");
        String password = request.getParameter("frmPassword");
        
        //request.getSession(true);
        System.out.println("\n "
                + "evaluando usuario: " + usuario + " y Password: " + password);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("usuario", usuario);
        miSession.setAttribute("password", password);
        
        
        Controladora ctrl = new Controladora();
        
        
        switch (usuario) {

            case "admin":
                if (ctrl.verificarAdmin(usuario, password)) {
                    System.out.println("Ok reconice al admiinistrador");
                    response.sendRedirect("html/empleados/cargaAdmin.jsp");
                }else{
                    System.out.println("U.U. hay que cargar el adminsitrador");
                    response.sendRedirect("html/empleados/crearAdmin.jsp");
                }
                break;

        }
        } catch (IOException e) {
            System.out.println("ALGO NO FUNCIONO \n"
                    + e );
        }
    
        



    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
