/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author qinm
 */
public class TacheComposee extends Tache {
    
    private List<Tache> tacheAtomique;
    
    public TacheComposee (Tache tache, List<Tache> tacheAtomique) {
        super(tache);
        this.tacheAtomique = tacheAtomique;
    }
    
    public List<Tache> getTacheAtomique() {
       return this.tacheAtomique;
    }
}
