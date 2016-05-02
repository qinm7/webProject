/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author qinm
 */
public class Avis {
    
    private int idAvis;
    private int idTache;
    private int note;
    private String commentaire;
    private String emetteur;
    private String destinataire;

    public Avis() {
        super();
    }

    public Avis(int idAvis, int idTache, int note, String commentaire, String emetteur, String destinataire) {
        this.idAvis = idAvis;
        this.idTache = idTache;
        this.note = note;
        this.commentaire = commentaire;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
    }

    public int getIdAvis() {
        return this.idAvis;
    }
    
    public int getIdTache() {
        return this.idTache;
    }

    public String getDestinataire() {
        return this.destinataire;
    }

    public int getNote() {
        return this.note;
    }
    
    public String getCommentaire() {
        return this.commentaire;
    }

    public String getEmetteur() {
        return this.emetteur;
    }
    
}
