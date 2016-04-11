package modele;

public class utilisateur {

	private String email;
	private String mdp;
	private String nom;
	private String prenom;
	private String genre;
	private String dateNaissance;
	private String coordonnees;	
	
	/**** définition de toutes les méthodes get ****/
	
	public String getEmail() {
		return this.email;
	}
	
	public String getMdp() {
		return this.mdp;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getDateNaissance() {
		return this.dateNaissance;
	}
	
	public String getCoordonnees() {
		return this.coordonnees;
	}

	
/**** définition de toutes les méthodes set ****/
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public void setNom( String nom) {
		this.nom = nom;
	}
	
	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setDateNaissance( String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public void setCoordonnees(String coordonnes) {
		this.coordonnees = coordonnes;
	}
	
}
