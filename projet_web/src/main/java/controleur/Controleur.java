/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.DAOException;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modele.User;

/**
 *
 * @author qinm
 */
@WebServlet(name = "Controleur", urlPatterns = {"/controleur"})
public class Controleur extends HttpServlet {
    
    @Resource(name = "jdbc/blablajob")
    private DataSource ds;
    
    /* pages d’erreurs */
    private void invalidParameters(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/controleurErreur.jsp").forward(request, response);        
    }

    private void erreurBD(HttpServletRequest request,
                HttpServletResponse response, DAOException e)
            throws ServletException, IOException {
        request.setAttribute("erreurMessage", e.getMessage());
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        request.getRequestDispatcher("/WEB-INF/bdErreur.jsp").forward(request, response);
    }
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controleur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controleur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        UserDAO userDAO = new UserDAO(ds);

        try {
            if (action == null) {
                actionAfficher(request, response, userDAO);
            } else if (action.equals("ajout-user")){
                actionAjouter(request, response, userDAO);               
            } else {
                invalidParameters(request, response);
            }
        } catch (DAOException e) {
            erreurBD(request, response, e);
        }
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
    
    private void actionAfficher(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO) 
            throws DAOException, ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("ajout-user")) {
            String email = request.getParameter("email");
            request.setAttribute("utilisateur", userDAO.getUser(email));               
            request.getRequestDispatcher("/WEB-INF/indexUser.jsp").forward(request, response);
        }    
    }

    /**
     * Ajout d'un ouvrage.
     */
    private void actionAjouter(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
            throws IOException, ServletException, DAOException {
        String email = request.getParameter("email");
        User user;
        try {
            user = userDAO.getUser(email);
        } catch (DAOException e) {
            user = null;
        }     
        if(user == null) {    
            String password = request.getParameter("password");
            String nom = request.getParameter("lastname");
            String prenom = request.getParameter("firstname");
            String genre = request.getParameter("sex");
            String birth = request.getParameter("Birthday_day") + "/" + request.getParameter("Birthday_Month") + "/" + request.getParameter("Birthday_Year");
            userDAO.ajouterUser(email, password, nom, prenom, genre, birth);
            actionAfficher(request, response, userDAO);
        }
        else {
            request.setAttribute("email", user.getEmail());           
            request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        }
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

}
