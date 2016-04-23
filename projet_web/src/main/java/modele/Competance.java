/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author utilisateur
 */
public class Competance {
    private boolean bricolage;
    private boolean menage;
    private boolean jardinage;
    private boolean pyro;
    private boolean peinture;
    private boolean reparation;
    private boolean cuisine;
    private boolean aide;

    public boolean isBricolage() {
        return bricolage;
    }

    public boolean isMenage() {
        return menage;
    }

    public boolean isJardinage() {
        return jardinage;
    }

    public boolean isPeinture() {
        return peinture;
    }

    public boolean isReparation() {
        return reparation;
    }

    public boolean isCuisine() {
        return cuisine;
    }

    public boolean isAide() {
        return aide;
    }

    public void setBricolage(boolean bricolage) {
        this.bricolage = bricolage;
    }

    public void setMenage(boolean menage) {
        this.menage = menage;
    }

    public void setJardinage(boolean jardinage) {
        this.jardinage = jardinage;
    }

    public void setPeinture(boolean peinture) {
        this.peinture = peinture;
    }

    public void setReparation(boolean reparation) {
        this.reparation = reparation;
    }

    public void setCuisine(boolean cuisine) {
        this.cuisine = cuisine;
    }

    public void setAide(boolean aide) {
        this.aide = aide;
    }

    public boolean isPyro() {
        return pyro;
    }

    public void setPyro(boolean pyro) {
        this.pyro = pyro;
    }

}
