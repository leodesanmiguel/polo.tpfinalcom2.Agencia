package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import polo.logica.Controladora;
import polo.logica.Persona;
import polo.logica.Usuario;

/**
 *
 * @author profl
 */
@WebServlet(name = "SvCrearAdmin", urlPatterns = {"/SvCrearAdmin"})
public class SvCrearAdmin extends HttpServlet {

    Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Persona
        Persona pers = new Persona();
        pers.setApellidoP((String) request.getParameter("frmApellido"));
        pers.setNombreP(request.getParameter("frmNombre"));
        pers.setDireccionP((String) request.getParameter("frmDomicilio"));
        pers.setDni((int) Integer.parseInt(request.getParameter("frmDNI")));
        pers.setNacionalidad((String) request.getParameter("frmNacional"));
        pers.setCelular((String) request.getParameter("frmCelular"));
        pers.setEmail((String) request.getParameter("frmemail"));

        //  Usuario
        Usuario usua = new Usuario();
        usua.setActivo(true);
        // fecha alta
        LocalDate fe = LocalDate.now();
        ZoneId dZ = ZoneId.systemDefault();
        usua.setAltaU(Date.from(fe.atStartOfDay(dZ).toInstant()));
        usua.setNombreUsr((String) request.getSession().getAttribute("user"));
        usua.setPassword((String) request.getSession().getAttribute("pass"));

        ctrl.crearAdmin(pers, "admin", usua);
        
        
        request.getSession().setAttribute("user", usua.getNombreUsr());
        request.getSession().setAttribute("pass", usua.getPassword());
        request.getSession().setAttribute("nombrePer", pers.getNombreP());
        request.getSession().setAttribute("apellidoPer", pers.getApellidoP());
        request.getSession().setAttribute("domicilioPer", pers.getDireccionP());
        request.getSession().setAttribute("dniPer", pers.getDni());
        request.getSession().setAttribute("nacionalPer", pers.getNacionalidad());
        request.getSession().setAttribute("celularPer", pers.getCelular());
        request.getSession().setAttribute("emailPer", pers.getEmail());

        response.sendRedirect("mostrarAdmin.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
