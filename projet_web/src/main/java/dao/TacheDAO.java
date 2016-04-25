/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author qinm
 */
public class TacheDAO extends AbstractDataBaseDAO {

    public TacheDAO(DataSource ds) {
        super(ds);
    }

    /**
     * Ajoute la nouvelle tache dans la table tache.
     */
    public void ajouterTache(int idTache, String titre, String description, int remuneration,
            float longitude, float latitude, String datedebut, String datefin, String email)
            throws DAOException {

        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO tache (idtache, titre, description,"
                            + " remuneration, longitude, latitude, datebein, dateend, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, idTache);
            st.setString(2, titre);
            st.setString(3, description);
            st.setInt(4, remuneration);
            st.setFloat(5, longitude);
            st.setFloat(6, latitude);
            st.setString(7, datedebut);
            st.setString(8, datefin);
            st.setString(9, email);
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }

    }
}
