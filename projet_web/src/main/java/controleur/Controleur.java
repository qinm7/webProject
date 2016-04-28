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

    /**
     * Méthode utilisée après connexion de l'utilisateur Handles the HTTP
     * <code>GET</code> method.
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
        TacheDAO tacheDAO = new TacheDAO(ds);
        try {
            if (action == null) {
                actionAfficher(request, response, userDAO);
            } else if (action.equals("getPage")) {
                actionGetPage(request, response, userDAO, tacheDAO);
            } else if (action.equals("getProfil")) {
                actionGetProfil(request, response, userDAO);
            } else {
                invalidParameters(request, response);
            }
        } catch (DAOException e) {
            erreurBD(request, response, e);
        }
    }

    /**
     * Méthode utilisée pour gérer l'inscription de l'utilisateur Handles the
     * HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        UserDAO userDAO = new UserDAO(ds);
        TacheDAO tacheDAO = new TacheDAO(ds);

        try {
            if (action == null) {
                actionAfficher(request, response, userDAO);
            } else if (action.equals("inscrire")) {
                actionAjouter(request, response, userDAO);
            } else if (action.equals("modifier_loca")) {
                actionModifierLoca(request, response, userDAO);
            } else if (action.equals("modifier_skill")) {
                actionModifierSkill(request, response, userDAO);
            } else if (action.equals("engager")) {
                actionEngager(request, response, userDAO, tacheDAO);
            } else if (action.equals("facture")) {
                actionFacture(request, response, userDAO, tacheDAO);
            } else if (action.equals("avis")) {
                actionAvis(request, response, userDAO, tacheDAO);    
            } else {
                invalidParameters(request, response);
            }
        } catch (DAOException e) {
            erreurBD(request, response, e);
        }
    }

    private void actionAfficher(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
            throws DAOException, ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        } else if (action.equals("inscrire")) {
            String email = request.getParameter("email");
            request.setAttribute("utilisateur", userDAO.getUser(email));
            request.setAttribute("skills", userDAO.getUser(email).getSkill());
            request.getRequestDispatcher("/WEB-INF/indexUser.jsp").forward(request, response);
        } else if (action.equals("modifier_loca")) {
            getServletContext().getRequestDispatcher("/WEB-INF/indexLoca.jsp").forward(request, response);
        } else if (action.equals("modifier_skill")) {
            String email = request.getParameter("email");
            request.setAttribute("skills", userDAO.getUser(email).getSkill());
            getServletContext().getRequestDispatcher("/WEB-INF/indexSkill.jsp").forward(request, response);    
        } else {
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    private void actionAfficherHistorique(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("encours", tacheDAO.getListTachePosteeEnCours(email));
        request.setAttribute("nonengager", tacheDAO.getListTachePosteeNonEngagee(email));
        request.setAttribute("realiser", tacheDAO.getListTachePosteeRealisee(email));
        getServletContext().getRequestDispatcher("/WEB-INF/historique_tache.jsp").forward(request, response);
    }

    private void actionAfficherTaches(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("taches", tacheDAO.getListTacheExecutant(email));
        getServletContext().getRequestDispatcher("/WEB-INF/ListeTacheBBJob.jsp").forward(request, response);
    }
    
    private void actionAfficherTachesEnCours(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("taches", tacheDAO.getListTachePosteeEnCours(email));
        request.setAttribute("tachesEx", tacheDAO.getListTacheEngageeEnCours(email));
        getServletContext().getRequestDispatcher("/WEB-INF/ListeTache_en_cours.jsp").forward(request, response);
    }
    
    private void actionAfficherAvis(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        int idtache = Integer.parseInt(request.getParameter("idtache"));
        request.setAttribute("idtache", idtache);
        String vue = request.getParameter("view");
        request.setAttribute("vue", vue);
        getServletContext().getRequestDispatcher("/WEB-INF/AvisEx.jsp").forward(request, response);
    }
    
    private void actionAfficherHistoriqueEx(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("encours", tacheDAO.getListTacheEngageeEnCours(email));
        request.setAttribute("realiser", tacheDAO.getListTacheEngageeRealisee(email));
        getServletContext().getRequestDispatcher("/WEB-INF/tacheExecutant.jsp").forward(request, response);
    }

    /**
     * Ajout d'un ouvrage.
     */
    private void actionAjouter(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
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
            request.getRequestDispatcher("/inscrire.jsp").forward(request, response);
        }
        String email = request.getParameter("email");
        User user;
        try {
            user = userDAO.getUser(email);
        } catch (DAOException e) {
            //on rattrappe l'exception levée par getUser dans le cas où l'utilisateur n'existe pas encore dans la BD
            user = null;
        }
        if (user == null) {
            String password = request.getParameter("password");
            String nom = request.getParameter("lastname");
            String prenom = request.getParameter("firstname");
            String genre = request.getParameter("sex");
            String birth = request.getParameter("Birthday_day") + "/" + request.getParameter("Birthday_Month") + "/" + request.getParameter("Birthday_Year");
            String[] skill = request.getParameterValues("skill");
            userDAO.creerUser(email, password, nom, prenom, genre, birth, longitude, latitude, adresse, skill);
            actionAfficher(request, response, userDAO);
        } else {
            String EmailErr = email + " est déjà utilisé";
            request.setAttribute("EmailErr", EmailErr);
            request.getRequestDispatcher("/inscrire.jsp").forward(request, response);
        }
    }

    private void actionGetPage(HttpServletRequest request,
            HttpServletResponse response,
            UserDAO userDAO, TacheDAO tacheDAO) throws DAOException, ServletException, IOException {
        String vue = request.getParameter("view");
        if (vue.equals("accueil")) {
            getServletContext().getRequestDispatcher("/WEB-INF/accueil_user.jsp").forward(request, response);
        } else if (vue.equals("profil")) {
            String username = request.getParameter("id");
            User user = userDAO.getUser(username);
            request.setAttribute("utilisateur", user);
            request.setAttribute("skills", userDAO.getUser(username).getSkill());
            getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
        } else if (vue.equals("poster")) {
            getServletContext().getRequestDispatcher("/WEB-INF/creation_tache.jsp").forward(request, response);
        } else if (vue.equals("historique")) {
            actionAfficherHistorique(request, response, tacheDAO);
        } else if (vue.equals("taches")) {
            actionAfficherTaches(request, response, tacheDAO);
        } else if (vue.equals("tachesencours")) {
            actionAfficherTachesEnCours(request, response, tacheDAO);
        } else if (vue.equals("historiqueEx")) {
            actionAfficherHistoriqueEx(request, response, tacheDAO);
        } else if (vue.equals("afficheexecutant")) {
            actionAfficherExecutant(request, response, userDAO);    
        } else {
            invalidParameters(request, response);
        }
    }
    
    private void actionAfficherExecutant(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("utilisateur", userDAO.getUser(email));
        request.setAttribute("skills", userDAO.getUser(email).getSkill());
        getServletContext().getRequestDispatcher("/WEB-INF/profil_executant.jsp").forward(request, response);
    }    
        

    private void actionGetProfil(HttpServletRequest request,
            HttpServletResponse response,
            UserDAO userDAO) throws DAOException, ServletException, IOException {
        String vue = request.getParameter("view");
        if (vue.equals("localisation")) {
            getServletContext().getRequestDispatcher("/WEB-INF/modifier_adresse.jsp").forward(request, response);
        } else if (vue.equals("skill")) {
            String username = request.getParameter("id");
            User user = userDAO.getUser(username);
            request.setAttribute("utilisateur", user);
            request.setAttribute("skills", userDAO.getUser(username).getSkill());
            getServletContext().getRequestDispatcher("/WEB-INF/modifier_skill.jsp").forward(request, response);
        } else {
            invalidParameters(request, response);
        }
    }
    

    private void actionModifierLoca(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
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
            request.getRequestDispatcher("/WEB-INF/modifer_adresse.jsp").forward(request, response);
        }
        String email = request.getParameter("email");
        userDAO.modifierLoca(email, longitude, latitude);
        request.setAttribute("longitude", longitude);
        request.setAttribute("latitude", latitude);
        actionAfficher(request, response, userDAO);
    }

    private void actionModifierSkill(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO)
            throws IOException, ServletException, DAOException {
        String email = request.getParameter("email");
        String[] skill = request.getParameterValues("skill");
        userDAO.modifierListSkill(email, skill);
        actionAfficher(request, response, userDAO);
    }

    private void actionEngager(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        String email = request.getParameter("id");
        int idtache = Integer.parseInt(request.getParameter("idtache"));
        try {
            userDAO.ajouterExecutant(email);
        } catch (DAOException e) {
        };
        userDAO.engagerTache(email, idtache);
        userDAO.genererFacture(idtache);
        actionAfficherTaches(request, response, tacheDAO);
    }
    
    private void actionFacture(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        //int idtache = Integer.parseInt(request.getParameter("idtache"));
        int facture = Integer.parseInt(request.getParameter("facture"));
        request.setAttribute("price",facture);
        /*tacheDAO.editerFacture(idtache, facture);
        User user = userDAO.getEngageExecutor(idtache);
        String executant = user.getEmail();
        request.setAttribute("executant", executant);*/
        actionAfficherAvis(request, response, tacheDAO);
    }
    
    private void actionAvis(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        int idtache = Integer.parseInt(request.getParameter("idtache"));
        String commanditaire = request.getParameter("id");
        String executant = request.getParameter("executant");
        String commentaire = request.getParameter("commentaire");
        int note = Integer.parseInt(request.getParameter("note"));
        int facture = Integer.parseInt(request.getParameter("facture"));
        tacheDAO.editerFacture(idtache, facture);
        userDAO.AjouterAvis(idtache, note, commentaire, commanditaire, executant);
        String vue = request.getParameter("view");
        if (vue.equals("tachesencours")) {
            actionAfficherTachesEnCours(request, response, tacheDAO);
        } else if (vue.equals("historique")) {
            actionAfficherHistorique(request, response, tacheDAO);
        } else {
            invalidParameters(request, response);
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
    }
}
