
package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.tache;
import modele.utilisateur;

@WebServlet(name = "CreationTache", urlPatterns = {"/creationtache"})
public class CreationTache extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**** récupératiopn de toutes les données de la tâche ****/
		
		String nom = request.getParameter("nomUtilisateur");
		String prenom = request.getParameter("prenomUtilisateur");
		String email = request.getParameter("emailUtilisateur");
		String adresse = request.getParameter("adresseUtilisateur");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String remuneration = request.getParameter("remuneration");
		String dateDebutPlusTot = request.getParameter("dateDebutPlusTot");
		String dateDebutPlusTard = request.getParameter("dateDebutPlusTard");
		String atomique = request.getParameter("atomique");
		
		String msgConfirmationTache;  //message de confirmation ou d'erreur
		
		if(nom.trim().isEmpty() || prenom.trim().isEmpty() || email.trim().isEmpty() || adresse.trim().isEmpty() || titre.trim().isEmpty() || description.trim().isEmpty() || remuneration.trim().isEmpty() || dateDebutPlusTot.trim().isEmpty() || dateDebutPlusTard.trim().isEmpty() || atomique.trim().isEmpty() ) {
			msgConfirmationTache = "ERREUR - un des champs du formulaire n'est pas rempli. <br> <a href=\"creerTache.jsp\">Cliquez ici </a> pour accéder au formulaire de création d'une tâche.";
		}
		else {
			msgConfirmationTache = "Tâche créée avec succès";
		}
		
		/* on "rempli" alors les paramètres du bean de l'utilisateur */
		
		tache tache = new tache();
		tache.setTitre(titre);
		tache.setDescription(description);
		//tache.setRemuneration(remuneration);
		tache.setDateDebutPlusTot(dateDebutPlusTot);
		tache.setDateDebutPlusTard(dateDebutPlusTard);
		
		request.setAttribute("tache", tache);
		request.setAttribute("message1", msgConfirmationTache);
		
		/* envoi à la jsp */
		
		this.getServletContext().getRequestDispatcher("/AfficherTache.jsp").forward(request,  response);

}
}
