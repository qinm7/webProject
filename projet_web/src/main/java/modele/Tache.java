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
}
