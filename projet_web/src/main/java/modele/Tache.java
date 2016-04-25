/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author charles
 */
public class Tache {
    
    private float idTaches;
    private String titre;
    private String description;
    private String remuneration;
    private float longitude;
    private float latitude; 
    private String datedébut;
    private String datefin;
    private String email;
    
    private Competance competance;

    
    public Tache() {
       super();       
   }

   public Tache(float idTaches, String titre, String description, String remuneration,
           float longitude, float latitude,String datedébut,String datefin,String email) {
       
      this.idTaches = idTaches;
      this.titre = titre;
      this.description = description; 
      this.remuneration = remuneration;
      this.longitude = longitude;
      this.latitude = latitude;
      this.datedébut = datedébut;
      this.datefin = datefin;
      this.email = email;
   }
   
   public float getIdTaches(){
       return this.idTaches;
   }
   
   public String getTitre(){
       return this.titre;
   }
   
   public String getDescription(){
       return this.description;
   }
   
   public String getRemuneration() {
        return remuneration;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getDatedébut() {
        return datedébut;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getEmail() {
        return email;
    }

    public void setIdTaches(float idTaches) {
        this.idTaches = idTaches;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setDatedébut(String datedébut) {
        this.datedébut = datedébut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Competance getCompetance() {
        return competance;
    }

    public void setCompetance(Competance competance) {
        this.competance = competance;
    }
    
    
}
