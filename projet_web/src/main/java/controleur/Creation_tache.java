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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author utilisateur
 */
public class Creation_tache extends HttpServlet {

    
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
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8");
        String submit_tache = request.getParameter("submit_tache");

        try {
            
            String idTaches;
            String titre = request.getParameter("title");
            String description = request.getParameter("description");
            String rémunération = request.getParameter("price");
            String[] competance = request.getParameterValues("competence");
            
            String adresse = request.getParameter("adress");
            String cp = request.getParameter("CodeP");
            String ville = request.getParameter("city");
            //La il va falloir convertir l'adresse, le CP et la ville en une longitude et une latitude
            //float longitude = ;
            //float latitude = ;
               
            String datedébut = request.getParameter("begin_date");
            String datefin = request.getParameter("end_date");
            String email = request.getParameter("email");
            
            
            
        } catch (DAOException e) {
            erreurBD(request, response, e);
        }
    }
    
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
