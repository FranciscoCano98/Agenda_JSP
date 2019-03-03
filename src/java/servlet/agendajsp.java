package servlet;

import clases.Telefono;
import clases.TelefonoDB;
import clases.Usuario;
import clases.UsuarioDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class agendajsp extends HttpServlet {

    private Connection conexion;
    private final String url = "jdbc:mysql://localhost/agenda";
    private final String user = "root";
    private final String password = "";

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, user, password);
            UsuarioDB.conectar(conexion);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(agendajsp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion;
        String url = "/index.jsp";

        accion = request.getParameter("accion");
        if (accion != null) {
            accion = accion.toLowerCase().replace(" ", "");
            switch (accion) {
                case "ver": {
                    try {
                        mostrarTelefonos(request);
                        url = "/telefonos.jps";
                    } catch (SQLException ex) {
                        Logger.getLogger(agendajsp.class.getName()).log(Level.SEVERE, null, ex);
                        url = "/error.jsp";
                    }
                break;
                }

            }
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mostrarTelefonos(HttpServletRequest request) throws SQLException {

        String login;
        ResultSet rs;

        login = request.getParameter("usuario");
        rs = TelefonoDB.getTelefonos(login);
        request.setAttribute("telefono", rs);
    }
}
