/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.DAOException;
import dao.TacheDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        TacheDAO tacheDAO = new TacheDAO(ds);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (isLoginValid(username, password, userDAO)) {
            Cookie[] cookies = request.getCookies();
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            try {
                actionRecommander(request, response, userDAO, tacheDAO);
            } catch (DAOException e) {
                erreurBD(request, response, e);
            }
            request.getRequestDispatcher("/WEB-INF/accueil_user.jsp").forward(request, response);
        } else {
            String message = "Votre e-mail ou votre mot de passe sont erronés";
            request.setAttribute("messageErr", message);
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }
    }

    private boolean isLoginValid(String username, String password, UserDAO userDAO) {
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

    private void actionRecommander(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("username");
        User user = userDAO.getUser(email);
        float latitudeUser = user.getLatitude(), longitudeUser = user.getLongitude();
        List<String> skillUser = new ArrayList<String>();
        skillUser = user.getSkill();
        //List<Tache> taches = tacheDAO.getListTache(skillUser);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
