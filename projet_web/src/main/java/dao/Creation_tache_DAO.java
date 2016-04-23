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
import modele.Tache;


/**
 *
 * @author utilisateur
 */
public class Creation_tache_DAO extends AbstractDataBaseDAO {
    
    public Creation_tache_DAO(DataSource ds) {
        super(ds);
    }
    
    public void ajoutTacheDAO(float idTaches, String titre, String description, String remuneration,
           float longitude, float latitude,String datedébut,String datefin,String email)
        throws DAOException {
        
        Connection co = null;
        
        try{
            co = getConnection();
            PreparedStatement st = 
                co.prepareStatement("INSERT INTO taches (idtaches, titre, description,"+
                        " remuneration, longitude, latitude, datedébut, datefin, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            st.setFloat(1,idTaches);
            st.setString(2,titre);
            st.setString(3,description);
            st.setString(4,remuneration);
            st.setFloat(5,longitude);
            st.setFloat(6,latitude);
            st.setString(7,datedébut);
            st.setString(8,datefin);
            st.setString(9,email);
            
        }catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(co);
        }
        
    }

    
}
