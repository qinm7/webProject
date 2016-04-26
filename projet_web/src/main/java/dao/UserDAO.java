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
import java.util.ArrayList;
import java.util.List;
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
     * Ajoute le nouveau utilisateur dans la table utilisateur.
     */
    public void ajouterUser(String email, String password, String name, String Fname,
            String gender, String birthdate, float longitude, float latitude) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO utilisateur (email, motdepasse, nom, "
                            + "prenom, sexe, datenaissance, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, name);
            st.setString(4, Fname);
            st.setString(5, gender);
            st.setString(6, birthdate);
            st.setFloat(7, longitude);
            st.setFloat(8, latitude);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Ajoute l'utilisateur dans la table Executant.
     */
    public void ajouterExecutant(String email) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO executant (email) values (?) ");
            st.setString(1, email);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Ajoute l'utilisateur dans la table Executant.
     */
    public void ajouterCommanditaire(String email) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO commanditaire (email) values (?) ");
            st.setString(1, email);
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
        String nom, prenom, genre, birth, password;
        List<String> skill = new ArrayList<>();
        float longitude = 0, latitude = 0;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT motdepasse, nom, prenom, sexe, datenaissance, longitude, latitude FROM utilisateur WHERE email = ?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            rs.next();
            password = rs.getString("motdepasse");
            nom = rs.getString("nom");
            prenom = rs.getString("prenom");
            genre = rs.getString("sexe");
            birth = rs.getString("datenaissance");
            longitude = rs.getFloat("longitude");
            latitude = rs.getFloat("latitude");
            /*PreparedStatement st1 = conn.prepareStatement(
             "SELECT adresse FROM adresse WHERE longitude = ? AND latitude = ?");
             st1.setFloat(1,longitude );
             st1.setFloat(2,latitude);
             ResultSet rs1 = st1.executeQuery();
             rs1.next();
             address = rs1.getString("adresse");*/
            PreparedStatement st2 = conn.prepareStatement(
                    "SELECT idskill FROM possede WHERE email = ? ");
            st2.setString(1, email);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                PreparedStatement st3 = conn.prepareStatement(
                        "SELECT skill FROM competence WHERE idskill = ? ");
                st3.setInt(1, rs2.getInt("idskill"));
                ResultSet rs3 = st3.executeQuery();
                rs3.next();
                skill.add(rs3.getString("skill"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return new User(email, password, nom, prenom, genre, birth, longitude, latitude, skill);
    }

    /**
     * Ajoute une nouvelle compétence dans la table COMPETENCE associé à
     * l'utilisateur.
     */
    public void ajouterSkill(String email, int idskill) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO possede (email, idskill) VALUES (?, ?)");
            st.setString(1, email);
            st.setInt(2, idskill);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void modifierLoca(String email, float longitude, float latitude) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE utilisateur SET longitude = ?, latitude = ? WHERE email = ?");
            st.setFloat(1, longitude);
            st.setFloat(2, latitude);
            st.setString(3, email);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void modifierListSkill(String email, String[] skill) throws DAOException {
        if (skill != null) {
            try {
                ajouterExecutant(email);
            } catch (DAOException e) {
                //executant existe deja
            };
        }
        for (int i = 0; i < skill.length; i++) {
            int j = Integer.parseInt(skill[i]);
            try {
                ajouterSkill(email, j);
            } catch (DAOException e) {
                //skill déjà ajouté
            }
        }
    }

    /**
     * Ajoute une nouvelle adresse dans la table ADRESSE associé aux coordonnées
     * de l'utilisateur.
     */
    public void ajouterAddr(String address, float longitude, float latitude) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO adresse (adresse, longitude, latitude) VALUES (?, ?, ?)");
            st.setString(1, address);
            st.setFloat(2, longitude);
            st.setFloat(3, latitude);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void creerUser(String email, String password, String name, String Fname, String gender, String birthdate, float longitude, float latitude, String address, String[] skill) throws DAOException {
        // on fait un bloc try pour faire un ajout d'un utilisateur dans la BD en mode tout ou rien
        try {
            ajouterUser(email, password, name, Fname, gender, birthdate, longitude, latitude);
            if (skill != null) {
                ajouterExecutant(email);
                for (int i = 0; i < skill.length; i++) {
                    int j = Integer.parseInt(skill[i]);
                    ajouterSkill(email, j);
                }
            }
            /*try {
             ajouterAddr(address,longitude,latitude);
             } catch (DAOException e) {
             //adresse déjà existante dans la BD, donc on ne fait rien
             };*/
        } catch (DAOException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        };
    }
}
