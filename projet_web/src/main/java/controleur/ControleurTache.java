/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import dao.DAOException;
import dao.TacheDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.valueOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modele.Competance;
import modele.Tache;
import modele.User;

@WebServlet(name = "ControleurTache", urlPatterns = {"/controleurtache"})
public class ControleurTache extends HttpServlet {

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
            out.println("<title>Servlet ControleurTache</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleurTache at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        TacheDAO tacheDAO = new TacheDAO(ds);
        UserDAO userDAO = new UserDAO(ds);
        try {
            if (action == null) {
                actionAfficher(request, response, tacheDAO);
            } else if (action.equals("poster")) {
                actionAjouter(request, response, userDAO, tacheDAO);
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

    private void actionAfficher(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        } else if (action.equals("poster")) {
            getServletContext().getRequestDispatcher("/WEB-INF/indexTache.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    /**
     * Ajout d'un ouvrage.
     */
    private void actionAjouter(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAcffx6gRrhEOWEtNtIgqU2HdAqihPxgUw");
        GeocodingResult[] results = null;
        float latitude = 0;
        float longitude = 0;
        String adresse = request.getParameter("address") + " " + request.getParameter("codeP") + " " + request.getParameter("city");
        request.setAttribute("adresse", adresse);
        try {
            //results =  GeocodingApi.geocode(context, "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            results = GeocodingApi.geocode(context, adresse).await();
            //System.out.println(results[0].formattedAddress);
            latitude = (float) (results[0].geometry.location.lat);
            longitude = (float) (results[0].geometry.location.lng);
        } catch (Exception e) {
            //on rattrape l'exception dans le cas où l'API de Google n'arrive pas à associer une coordonnée géographique à l'adresse saisie
            String adr = "Adresse mal saisie";
            request.setAttribute("AdrErreur", adr);
            request.getRequestDispatcher("/WEB-INF/creation_tache.jsp").forward(request, response);
        }
        String titre = request.getParameter("title");
        String description = request.getParameter("description");
        int remuneration = Integer.parseInt(request.getParameter("price"));
        String datebegin = request.getParameter("begin_date");
        String dateend = request.getParameter("end_date");
        String email = request.getParameter("email");
        String[] skill = request.getParameterValues("skill");
        try {
            userDAO.ajouterCommanditaire(email);
        } catch (DAOException e) {            
        };
        int idtache = tacheDAO.creerTache(titre, description, remuneration,
                longitude, latitude, datebegin, dateend, email,skill);
        Tache tache = tacheDAO.getTache(idtache);
        request.setAttribute("tache", tache);
        request.setAttribute("skills", tache.getSkill());
        /*Tache tache = new Tache(idtache, titre, description, remuneration,
            longitude, latitude, datebegin, dateend, email);
        request.setAttribute("tache", tache);*/
        actionAfficher(request, response, tacheDAO);
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
