/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import modele.User;

/**
 *
 * @author qinm
 */
public class UserDAO extends AbstractDataBaseDAO {

    public UserDAO(DataSource ds) {
        super(ds);
    }
    
    /**
     * Ajoute le nouveau utilisateur dans la table
     * utilisateur.
     */
    public void ajouterUser(String email, String password, String name, String Fname, String gender, String birthdate) throws DAOException {
        Connection conn = null ;
        try {
            conn = getConnection();
            PreparedStatement st =
                conn.prepareStatement("INSERT INTO bibliographie (email, motdepasse, nom, prenom, sexe, datenaissance) VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, name);
            st.setString(4, Fname);
            st.setString(5, gender);
            st.setString(6, birthdate);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }
    
    /**
     * Récupère l'utilisateur d'identifiant email dans la table utilisateur.
     */
    public User getUser(String email) throws DAOException {
        Connection conn = null;
        String nom, prenom, genre, birth;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                "SELECT nom, prenom, sexe, datenaissance FROM utilisateur WHERE email = ?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            rs.next();
            nom = rs.getString("nom");
            prenom = rs.getString("prenom");
            genre = rs.getString("sexe");
            birth = rs.getString("datenaissance");
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }

        return new User(email, nom, prenom, genre, birth);
    }
}
