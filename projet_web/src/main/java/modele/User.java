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
public class User {
        
   private String email;
   private String password;
   private String nom; 
   private String prenom;
   private String genre; 
   private String birth; 
   private float longitude;
   private float latitude;
   private List<String> skill;
   
   public User() {
       super();       
   }

   public User(String email, String password, String nom, String prenom, String genre, String birth, float longitude, float latitude, List<String> skill) {
      this.email = email;
      this.password = password;
      this.nom = nom; 
      this.prenom = prenom;
      this.genre = genre;
      this.birth = birth;
      this.longitude = longitude;
      this.latitude = latitude;
      this.skill = skill;
   }
   
   public User(User user) {
       this(user.email, user.password, user.nom, user.prenom, user.genre, user.birth, user.longitude, user.latitude, user.skill);
   }

   public String getEmail() {
      return this.email; 
   }
   
   public String getPassword() {
       return this.password;
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
   
   public float getLongitude() {
       return this.longitude;
   }
   
   public float getLatitude() {
       return this.latitude;
   }
   public List<String> getSkill() {
       return this.skill;
   }

    @Override
    public String toString() {
        return "User{" + "e-mail=" + email + ", nom=" + nom + ", prénom=" + prenom + ", genre=" + genre + ", date de naissance=" + birth + '}';
    }
}

