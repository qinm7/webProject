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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modele.Tache;

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
            } else if (action.equals("supprimer")) {
                actionSuppTache(request, response, tacheDAO);
            } else if (action.equals("tacheComposee")) {
                actionAjouterTacheComposee(request, response, userDAO, tacheDAO);
            } else if (action.equals("tacheatomique")) {
                actionTacheAtomique(request, response, userDAO, tacheDAO);
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

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        TacheDAO tacheDAO = new TacheDAO(ds);
        try {
            if (action == null) {
                actionAfficher(request, response, tacheDAO);
            } else if (action.equals("rechercher")) {
                actionRechercher(request, response, tacheDAO);
            } else if (action.equals("rechercher2")) {
                actionRechercher2(request, response, tacheDAO);
            } else {
                invalidParameters(request, response);
            }
        } catch (DAOException e) {
            erreurBD(request, response, e);
        } catch (Exception ex) {
            Logger.getLogger(ControleurTache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actionAfficher(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/accueil_user.jsp").forward(request, response);
        } else if (action.equals("poster")) {
            getServletContext().getRequestDispatcher("/WEB-INF/indexTache.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/accueil_user.jsp").forward(request, response);
        }
    }

    private void actionAjouterTacheComposee(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
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
            request.getRequestDispatcher("/WEB-INF/demande_type_tache.jsp").forward(request, response);
        }
        String email = request.getParameter("email");
        String titre = request.getParameter("title");
        String description = request.getParameter("description");
        String datebegin = request.getParameter("begin_date");
        String dateend = request.getParameter("end_date");
        try {
            userDAO.ajouterCommanditaire(email);
        } catch (DAOException e) {
        };
        int idtache = tacheDAO.creerTache(titre, description, -1, longitude, latitude, datebegin, dateend, email, null);
        tacheDAO.creerTacheComposee(idtache);
        request.setAttribute("idtache", idtache);
        getServletContext().getRequestDispatcher("/WEB-INF/creation_tachecomposee.jsp").forward(request, response);
        //getServletContext().getRequestDispatcher("/WEB-INF/creation_tache.jsp").forward(request, response);
    }

    private void actionTacheAtomique(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String choix = request.getParameter("choix");
        if (choix == null) {
            invalidParameters(request, response);
        } else if (choix.equals("Ajouter")) {
            actionAjouterTacheAtomique(request, response, userDAO, tacheDAO);
            getServletContext().getRequestDispatcher("/WEB-INF/creation_tachecomposee.jsp").forward(request, response);
        } else if (choix.equals("Poster")) {
            actionAjouterTacheAtomique(request, response, userDAO, tacheDAO);
            int idtache = Integer.parseInt(request.getParameter("idtache"));
            tacheDAO.UpdateComposee(idtache);
            request.setAttribute("tacheC", tacheDAO.getTacheComposee(idtache));
            request.setAttribute("tacheAs", tacheDAO.getTacheComposee(idtache).getTacheAtomique());
            getServletContext().getRequestDispatcher("/WEB-INF/indexTacheComposee.jsp").forward(request, response);
        } else {
            invalidParameters(request, response);
        }
    }

    private void actionAjouterTacheAtomique(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO, TacheDAO tacheDAO)
            throws IOException, ServletException, DAOException {
        request.setAttribute("adresse", request.getParameter("adresse"));
        int idtache = Integer.parseInt(request.getParameter("idtache"));
        Tache tache = tacheDAO.getTache(idtache);
        float latitude = tache.getLatitude();
        float longitude = tache.getLongitude();
        String datebegin = tache.getDatedebut();
        String dateend = tache.getDatefin();
        String email = tache.getEmail();
        String titre = request.getParameter("title");
        String description = request.getParameter("description");
        int remuneration = Integer.parseInt(request.getParameter("price"));
        String[] skill = request.getParameterValues("skill");
        try {
            userDAO.ajouterCommanditaire(email);
        } catch (DAOException e) {
        };
        int idtacheA = tacheDAO.creerTache(titre, description, remuneration,
                longitude, latitude, datebegin, dateend, email, skill);
        tacheDAO.creerTacheAtomique(idtacheA);
        tacheDAO.EstComposee(idtache, idtacheA);
        request.setAttribute("idtache", idtache);
    }

    /**
     * Ajout d'une tache.
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
                longitude, latitude, datebegin, dateend, email, skill);
        Tache tache = tacheDAO.getTache(idtache);
        request.setAttribute("tache", tache);
        request.setAttribute("skills", tache.getSkill());
        /*Tache tache = new Tache(idtache, titre, description, remuneration,
         longitude, latitude, datebegin, dateend, email);
         request.setAttribute("tache", tache);*/
        actionAfficher(request, response, tacheDAO);
    }

    private void actionRechercher(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException, Exception {

        String cityV = request.getParameter("city");
        int skill = Integer.parseInt(request.getParameter("skill"));

        float longitude = 0, latitude = 0;
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAcffx6gRrhEOWEtNtIgqU2HdAqihPxgUw");
        GeocodingResult[] results = GeocodingApi.geocode(context, cityV).await();
        latitude = (float) (results[0].geometry.location.lat);
        longitude = (float) (results[0].geometry.location.lng);
        
        request.setAttribute("sk",skill);
        request.setAttribute("lo",longitude);
        request.setAttribute("la",latitude);
        
        List<Tache> taches = tacheDAO.getTacheCityJob(longitude, latitude, skill);
        
        request.setAttribute("taches", taches);
        
        Iterator<Tache> it = taches.iterator();
        int i =0;
        
        while(it.hasNext()){
            Tache t = it.next();
            request.setAttribute("t"+i,t.getSkill());
            i++;
        }   
        
        getServletContext().getRequestDispatcher("/WEB-INF/afficheTache.jsp").forward(request, response);

    }
    private void actionRechercher2(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException, Exception {

        String cityV = request.getParameter("city");
        int skill = Integer.parseInt(request.getParameter("skill"));

        float longitude = 0, latitude = 0;
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAcffx6gRrhEOWEtNtIgqU2HdAqihPxgUw");
        GeocodingResult[] results = GeocodingApi.geocode(context, cityV).await();
        latitude = (float) (results[0].geometry.location.lat);
        longitude = (float) (results[0].geometry.location.lng);
        
        request.setAttribute("city",cityV);
        request.setAttribute("lo",longitude);
        request.setAttribute("la",latitude);
        
        List<Tache> taches = tacheDAO.getTacheCityJob(longitude, latitude, skill);
        
        request.setAttribute("taches", taches);
        
        Iterator<Tache> it = taches.iterator();
        int i =0;
        
        while(it.hasNext()){
            Tache t = it.next();
            request.setAttribute("t"+i,t.getSkill());
            i++;
        }   
        
        getServletContext().getRequestDispatcher("/WEB-INF/affichetache2.jsp").forward(request, response);

    }

    private void actionSuppTache(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        int idtache = Integer.parseInt(request.getParameter("idtache"));
        tacheDAO.supprimerTache(idtache);
        actionAfficherHistorique(request, response, tacheDAO);

    }

    private void actionAfficherHistorique(HttpServletRequest request, HttpServletResponse response, TacheDAO tacheDAO)
            throws DAOException, ServletException, IOException {
        String email = request.getParameter("id");
        request.setAttribute("encours", tacheDAO.getListTachePosteeEnCours(email));
        request.setAttribute("nonengager", tacheDAO.getListTachePosteeNonEngagee(email));
        request.setAttribute("realiser", tacheDAO.getListTachePosteeRealisee(email));
        getServletContext().getRequestDispatcher("/WEB-INF/historique_tache.jsp").forward(request, response);
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
