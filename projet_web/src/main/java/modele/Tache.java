/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

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
    private List<String> skill;
    private String executant;
    private Avis avis;

    public Tache() {
        super();
    }

    public Tache(int idTache, String titre, String description, int remuneration,
            float longitude, float latitude, String datedebut, String datefin, String email, List<String> skill) {

        this.idTache = idTache;
        this.titre = titre;
        this.description = description;
        this.remuneration = remuneration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.email = email;
        this.skill = skill;
    }
    
    /*Utiliser pour retrouver les taches postées en cours de realisation (elles ont donc un executant)
    **
    */
    public Tache(Tache tache, String executant) {
        this.idTache = tache.idTache;
        this.titre = tache.titre;
        this.description = tache.description;
        this.remuneration = tache.remuneration;
        this.longitude = tache.longitude;
        this.latitude = tache.latitude;
        this.datedebut = tache.datedebut;
        this.datefin = tache.datefin;
        this.email = tache.email;
        this.skill = tache.skill;
        this.executant = executant;
    }
    
    /*Utiliser pour retrouver les taches postees et realisees (elles ont donc un executant et un commentaire)
    **
    */
    public Tache(Tache tache, String executant, Avis avis) {
        this.idTache = tache.idTache;
        this.titre = tache.titre;
        this.description = tache.description;
        this.remuneration = tache.remuneration;
        this.longitude = tache.longitude;
        this.latitude = tache.latitude;
        this.datedebut = tache.datedebut;
        this.datefin = tache.datefin;
        this.email = tache.email;
        this.skill = tache.skill;
        this.executant = executant;
        this.avis = avis;
    }
    
    /*Utiliser pour retrouver les taches engagees et realisees (elles ont donc un executant et un commentaire)
    **
    */
    public Tache(Tache tache, Avis avis) {
        this.idTache = tache.idTache;
        this.titre = tache.titre;
        this.description = tache.description;
        this.remuneration = tache.remuneration;
        this.longitude = tache.longitude;
        this.latitude = tache.latitude;
        this.datedebut = tache.datedebut;
        this.datefin = tache.datefin;
        this.email = tache.email;
        this.skill = tache.skill;
        this.avis = avis;
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

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getEmail() {
        return email;
    }
    
    public String getExecutant() {
        return this.executant;
    }
    
    public List<String> getSkill() {
       return this.skill;
   }
    
    public Avis getAvis() {
       return this.avis;
   }
}
