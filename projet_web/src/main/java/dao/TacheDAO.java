
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;


public class TacheDAO extends AbstractDataBaseDAO {

    public TacheDAO(DataSource ds) {
        super(ds);
    }
    
    public void ajoutTacheDAO(float idTaches, String titre, String description, String remuneration,
           float longitude, float latitude,String datedébut,String datefin,String email)
        throws DAOException {
        
        Connection co = null;
        
        try{
            co = getConnection();
            PreparedStatement st = 
                co.prepareStatement("INSERT INTO tache(idtache, titre, description,"+
                        " remuneration, longitude, latitude, datebegin, dateend, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
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

