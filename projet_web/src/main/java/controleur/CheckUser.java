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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import modele.User;

/**
 *
 * @author qinm
 */
@WebServlet(name = "CheckUser", urlPatterns = {"/checkuser"})
public class CheckUser extends HttpServlet {
    
    @Resource(name = "jdbc/blablajob")
    private DataSource ds;
    
    private void erreurBD(HttpServletRequest request,
                HttpServletResponse response, DAOException e)
            throws ServletException, IOException {
        request.setAttribute("erreurMessage", e.getMessage());
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        request.getRequestDispatcher("/WEB-INF/bdErreur.jsp").forward(request, response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
        UserDAO userDAO = new UserDAO(ds);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if (isLoginValid (username, password, userDAO)) {
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", username);
                response.sendRedirect("index.html");
            } else {
                String message = "Votre e-mail ou votre mot de passe sont erronés";
                request.setAttribute("messageErr", message);
                request.getRequestDispatcher("/connexion.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            erreurBD(request, response, e);
        }
    }
    
    private boolean isLoginValid(String username, String password, UserDAO userDAO) throws DAOException {
        User user;
        try {
            user = userDAO.getUser(username);
        } catch (DAOException e) {
            //on rattrappe l'exception levée par getUser dans le cas où l'utilisateur n'existe pas encore dans la BD
            user = null;
        }   
        if (user == null) {
            return false;
        } else {
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
