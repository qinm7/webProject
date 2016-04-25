/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.Creation_tache_DAO;
import dao.DAOException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.valueOf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modele.Competance;
import modele.Tache;

/**
 *
 * @author utilisateur
 */
public class Creation_tache extends HttpServlet {
    
    @Resource(name = "jdbc/blablajob")
    private DataSource ds;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet creation_tache</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet creation_tache at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void erreurBD(HttpServletRequest request,
                HttpServletResponse response, DAOException e)
            throws ServletException, IOException {
        request.setAttribute("erreurMessage", e.getMessage());
        String action = request.getParameter("action");
        request.setAttribute("action", action);
        request.getRequestDispatcher("/WEB-INF/bdErreur.jsp").forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            request.setCharacterEncoding("UTF-8");
            
            // Reagrder par rapport a la duree de vie de la servlet pour incrementer idTaches
            float idTaches = 0;
            idTaches++;
            String titre = request.getParameter("title");
            String description = request.getParameter("description");
            String remuneration = request.getParameter("price");
            
            
        //Partie sur le sous bean compétance
            boolean bricolage = valueOf(request.getParameter("Bricolage"));
            boolean menage = valueOf(request.getParameter("Menage"));
            boolean jardinage = valueOf(request.getParameter("Jardinage"));
            boolean pyro = valueOf(request.getParameter("Pyrogravure"));
            boolean peinture = valueOf(request.getParameter("peinture"));
            boolean reparation = valueOf(request.getParameter("Reparation"));
            boolean cuisine = valueOf(request.getParameter("Cuisine"));
            boolean aide = valueOf(request.getParameter("Aide"));
            
            Competance competance = new Competance();
            
            competance.setBricolage(bricolage);
            competance.setMenage(menage);
            competance.setJardinage(jardinage);
            competance.setPyro(pyro);
            competance.setPeinture(peinture);
            competance.setReparation(reparation);
            competance.setCuisine(cuisine);
            competance.setAide(aide);
        //Fin de la sous partie
            
            
            String adresse = request.getParameter("adress");
            String cp = request.getParameter("CodeP");
            String ville = request.getParameter("city");
            //La il va falloir convertir l'adresse, le CP et la ville en une longitude et une latitude
            float longitude = 0;
            float latitude = 0;   
            String datedébut = request.getParameter("begin_date");
            String datefin = request.getParameter("end_date");
            String email = request.getParameter("email");
        
            Tache tache = new Tache();
            
            tache.setTitre(titre);
            tache.setDescription(description);
            tache.setRemuneration(remuneration);
            tache.setDatedébut(datedébut);
            tache.setDatefin(datefin);
            tache.setEmail(email);
            tache.setCompetance(competance);
            
            Creation_tache_DAO ctDAO = new Creation_tache_DAO(ds);
            
        try {
            ctDAO.ajoutTacheDAO(idTaches,titre,description,remuneration,longitude, latitude,
                    datedébut, datefin, email);
        } catch (DAOException ex) {
            Logger.getLogger(Creation_tache.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           request.setAttribute("nouvelleTache",tache);
           
           getServletContext().getRequestDispatcher("/WEB-INF/affiche_tache.jsp").forward(request,response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
   
}
