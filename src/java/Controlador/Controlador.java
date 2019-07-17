package Controlador;

import dao.DaoDepartamento;
import dao.DaoMunicipio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.Municipio;

public class Controlador extends HttpServlet {

    String listar = "jsp/consulta.jsp";
    String registrar = "jsp/agregar.jsp";
    String edit = "jsp/Editar.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void cargarDepartamentos(HttpServletRequest request) {
        DaoDepartamento dp = new DaoDepartamento();
        List lstDepartamentos = dp.obtenerDepartamentos();
        request.setAttribute("lstDepartamentos", lstDepartamentos);
    }

    public void cargarMunicipios(HttpServletRequest request) {
        DaoMunicipio dp = new DaoMunicipio();
        List lstMunicipios = dp.obtenerMunicipios();
        request.setAttribute("lstMunicipios", lstMunicipios);
    }

    public void buscarMunicipio(HttpServletRequest request) {
        int idMunicipio = Integer.parseInt(request.getParameter("idMncp"));
        DaoMunicipio dp = new DaoMunicipio();
        Municipio mncp = dp.obtenerMunicipio(idMunicipio);
        request.setAttribute("municipio", mncp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redir_Listar = "listar";
        boolean redirect = false;
        boolean forward = false;
        
        DaoMunicipio dm = new DaoMunicipio();

        String goTo = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            cargarMunicipios(request);
            goTo = listar;
            forward = true;
        }
               
        if (action.equalsIgnoreCase("registrar")) {
            cargarDepartamentos(request);
            goTo = registrar;
            forward = true;
        } 
        
        if (action.equalsIgnoreCase("Agregar")) {

            String mncp_iddepto = request.getParameter("somDeptos");
            String mncp_codigo = request.getParameter("txtMncp_Codigo");
            String mncp_nombre = request.getParameter("txtMncp_Nombre");
            String mncp_observacion = request.getParameter("txtMncp_Observacion");

            int idDpto = Integer.parseInt(mncp_iddepto);
            Municipio m = new Municipio(idDpto, mncp_codigo, mncp_nombre, mncp_observacion);

            dm.registrarMunicipio(m);
            
            goTo = redir_Listar;
            redirect = true;
        } 
        
        if (action.equalsIgnoreCase("editar")) {
            cargarDepartamentos(request);
            buscarMunicipio(request);
            goTo = edit;
            forward = true;
        } 
                
        if (action.equalsIgnoreCase("Actualizar")) {

            int idMunicipio = Integer.parseInt(request.getParameter("txtMncp_IdMunicipio"));
            String mncp_codigo = request.getParameter("txtMncp_Codigo");
            String mncp_nombre = request.getParameter("txtMncp_Nombre");
            String mncp_observacion = request.getParameter("txtMncp_Observacion");
            int mncp_iddepto =  Integer.parseInt(request.getParameter("somDeptos") );

            Municipio mn = new Municipio();
            mn.setIdMunicipio(idMunicipio);
            mn.setCodigo(mncp_codigo);
            mn.setNombre(mncp_nombre);
            mn.setObservacion(mncp_observacion);
            mn.setIdDepartamento(mncp_iddepto);
            
            dm.actualizarMunicipio(mn);

            goTo = redir_Listar;
            redirect = true;
        } 
        
        if (action.equalsIgnoreCase("eliminar")) {
            
            int idMunicipio = Integer.parseInt(request.getParameter("idMncp"));
            dm.borrarMunicipio(idMunicipio);

            goTo = redir_Listar;
            redirect = true; 
        }

        if (redirect) {
            response.sendRedirect(request.getContextPath() + "/Controlador?accion=" + goTo);
        }
        if (forward) {
            RequestDispatcher view = request.getRequestDispatcher(goTo);
            view.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
