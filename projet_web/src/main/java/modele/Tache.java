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

    private int idTache;
    private String titre;
    private String description;
    private int remuneration;
    private float longitude;
    private float latitude;
    private String datedebut;
    private String datefin;
    private String email;

    private Competance competance;

    public Tache() {
        super();
    }

    public Tache(int idTache, String titre, String description, int remuneration,
            float longitude, float latitude, String datedebut, String datefin, String email) {

        this.idTache = idTache;
        this.titre = titre;
        this.description = description;
        this.remuneration = remuneration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.email = email;
    }

    public int getIdTache() {
        return this.idTache;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }

    public int getRemuneration() {
        return remuneration;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getDatedébut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getEmail() {
        return email;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRemuneration(int remuneration) {
        this.remuneration = remuneration;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompetance(Competance competance) {
        this.competance = competance;
    }

    
}
