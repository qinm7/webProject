package modele;

public class tache {

		private Integer num;
		private String titre;
		private String description;
		private String remuneration;
		private String coordonnees;
		private String dateDebutPlusTot;
		private String dateDebutPlusTard;
		private boolean atomique;
		
/**** définition de toutes les méthodes get ****/
		
		public Integer getNum() {
			return this.num;
		}
		
		public String getTitre() {
			return this.titre;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public String getRemuneration() {
			return this.remuneration;
		}
		
		public String getCoordonnes() {
			return this.coordonnees;
		}
		
		public String getDateDebutPlusTot() {
			return this.dateDebutPlusTot;
		}
		
		public String getDateDebutPlusTard() {
			return this.dateDebutPlusTard;
		}
		
		public boolean isAtomique() {
			return this.atomique;
		}

/**** définition des méthodes set ****/
		
		
		public void setNum( Integer num) {
			this.num = num;
		}
		
		public void setTitre (String titre) {
			this.titre = titre;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setRemuneration( String remuneration) {
			this.remuneration = remuneration;
		}
		
		public void setCoordonnes( String coordonnees) {
			this.coordonnees = coordonnees;
		}
		
		public void setDateDebutPlusTot( String datePlusTot) {
			this.dateDebutPlusTot = datePlusTot;
		}
		
		public void setDateDebutPlusTard( String datePlusTard) {
			this.dateDebutPlusTard = datePlusTard;
		}
		
		public void setAtomique( boolean atomique) {
			this.atomique = true;
		}
}





















