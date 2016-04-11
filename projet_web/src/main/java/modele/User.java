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
public class User {
        
   private String email;
   private String nom; 
   private String prenom;
   private String genre; 
   private String birth; 

   public User(String email, String nom, String prenom, String genre, String birth) {
      this.email = email;
      this.nom = nom; 
      this.prenom = prenom;
      this.genre = genre;
      this.birth = birth;
   }

   public String getEmail() {
      return this.email; 
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
   
   public String getBirth() {
       return this.birth;
   }

    @Override
    public String toString() {
        return "User{" + "e-mail=" + email + ", nom=" + nom + ", prénom=" + prenom + ", genre=" + genre + ", date de naissance=" + birth + '}';
    }
}

