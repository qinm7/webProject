package controleur;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.utilisateur;

@WebServlet(name = "CreationUtilisateur", urlPatterns = {"/creationutilisateur"})
public class CreationUtilisateur extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* récupération avec le bon typage de toutes les données utilisateur */
		
		String nom = request.getParameter("nomUtilisateur");
		String prenom = request.getParameter("prenomUtilisateur");
		String dateNaissance = request.getParameter("dateNaissanceUtilisateur");
		String email = request.getParameter("emailUtilisateur");
		String mdp = request.getParameter("mdpUtilisateur");
		String adresse = request.getParameter("adresseUtilisateur");
		String genre = request.getParameter("genreUtilisateur");
		
		String msgConfirmation; //message de confirmation ou d'erreur
		
		if(nom.trim().isEmpty() || prenom.trim().isEmpty() || dateNaissance.trim().isEmpty() || email.trim().isEmpty() || mdp.trim().isEmpty() || adresse.trim().isEmpty() || genre.trim().isEmpty() ) {
			msgConfirmation = "ERREUR - un des champs du formulaire n'est pas rempli. <br> <a href=\"creerUtilisateur.jsp\">Cliquez ici </a> pour accéder au formulaire de création d'un compte utilisateur.";
		}
		else {
			msgConfirmation = "compte client créé avec succès";
		}
		
		/* on "rempli" alors les paramètres du bean de l'utilisateur */
		
		utilisateur utilisateur = new utilisateur();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setDateNaissance(dateNaissance);
		utilisateur.setEmail(email);
		utilisateur.setMdp(mdp);
		utilisateur.setCoordonnees(adresse);
		utilisateur.setGenre(genre);
		
		/* construction de l'objet requête avec les infos */
		
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("message", msgConfirmation);
		
		/* envoi à la jsp */
		
		this.getServletContext().getRequestDispatcher("/afficherUtilisateur.jsp").forward(request,  response);	
	
	}
}
