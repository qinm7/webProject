package dao;

import static java.lang.Math.sqrt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import modele.Avis;
import modele.Tache;
import modele.TacheComposee;

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
    public int ajouterTache(String titre, String description, int remuneration,
            float longitude, float latitude, String datedebut, String datefin, String email)
            throws DAOException {

        Connection conn = null;
        int idTache = 0;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT id_seq.nextval FROM dual");
            ResultSet rs = st.executeQuery();
            rs.next();
            idTache = rs.getInt("nextval");
            st = conn.prepareStatement("INSERT INTO tache (idtache, titre, description,"
                    + "remuneration, longitude, latitude, datebegin, dateend, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, idTache);
            st.setString(2, titre);
            st.setString(3, description);
            st.setInt(4, remuneration);
            st.setFloat(5, longitude);
            st.setFloat(6, latitude);
            st.setString(7, datedebut);
            st.setString(8, datefin);
            st.setString(9, email);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return idTache;

    }

    /**
     * Récupère la tâche d'identifiant idTache dans la table tache.
     */
    public Tache getTache(int idtache) throws DAOException {
        Connection conn = null;
        String titre, description, datebegin, dateend, email;
        float longitude, latitude;
        int remuneration;
        List<String> skill = new ArrayList<>();
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT titre, description, remuneration, longitude, latitude, datebegin, dateend, email FROM tache WHERE idtache = ?");
            st.setInt(1, idtache);
            ResultSet rs = st.executeQuery();
            rs.next();
            titre = rs.getString("titre");
            description = rs.getString("description");
            remuneration = rs.getInt("remuneration");
            longitude = rs.getFloat("longitude");
            latitude = rs.getFloat("latitude");
            datebegin = rs.getString("datebegin");
            dateend = rs.getString("dateend");
            email = rs.getString("email");
            PreparedStatement st2 = conn.prepareStatement(
                    "SELECT idskill FROM necessite WHERE idtache = ? ");
            st2.setInt(1, idtache);
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
        return new Tache(idtache, titre, description, remuneration,
                longitude, latitude, datebegin, dateend, email, skill);
    }

    /**
     * Ajoute une nouvelle compétence dans la table NECESSITE associé à
     * l'utilisateur.
     */
    public void ajouterSkill(int idtache, int idskill) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO necessite (idtache, idskill) VALUES (?, ?)");
            st.setInt(1, idtache);
            st.setInt(2, idskill);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public int creerTache(String titre, String description, int remuneration,
            float longitude, float latitude, String datedebut, String datefin, String email, String[] skill) throws DAOException {
        // on fait un bloc try pour faire un ajout d'un utilisateur dans la BD en mode tout ou rien
        int idtache;
        try {
            idtache = ajouterTache(titre, description, remuneration,
                    longitude, latitude, datedebut, datefin, email);

            if (skill != null) {
                for (int i = 0; i < skill.length; i++) {
                    int j = Integer.parseInt(skill[i]);
                    ajouterSkill(idtache, j);
                }
            }
        } catch (DAOException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        };
        return idtache;
    }

    public List<Tache> getListTache(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT idtache FROM tache WHERE email = ?");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache
                        = getTache(rs.getInt("idtache"));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public List<Tache> getListTacheExecutant(String email) throws DAOException {

        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT idtache FROM tache WHERE email <> ? AND (idtache) NOT IN (SELECT t.idtache FROM tache t, facture f WHERE t.idtache = f.idtache) AND (idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache
                        = getTache(rs.getInt("idtache"));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;

    }

    public List<Tache> getTacheCityJob(float longitude, float latitude, int skill) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        
        float latempP = latitude + (float) 0.1;
        float latempN = latitude -(float) 0.1;
        float lotempP = longitude +(float) 0.1;
        float lotempN = longitude -(float) 0.1;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT DISTINCT t.idtache FROM tache t, necessite n WHERE n.idtache=t.idtache AND n.idskill = ? AND t.latitude<? AND ?<t.latitude AND t.longitude<? AND ?<t.longitude");
            st.setInt(1, skill);
            st.setFloat(2, latempP);
            st.setFloat(3, latempN);
            st.setFloat(4, lotempP);
            st.setFloat(5, lotempN);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache
                        = getTache(rs.getInt("idtache"));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public String getEngageExecutor(int idtache) throws DAOException {
        Connection conn = null;
        String email;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT email FROM engage WHERE idtache = ?");
            st.setInt(1, idtache);
            ResultSet rs = st.executeQuery();
            rs.next();
            email = rs.getString("email");
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return email;
    }

    public List<Tache> getListTachePosteeEnCours(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT t.idtache FROM tache t, facture f WHERE t.idtache = f.idtache AND f.facture = 0 AND email = ? AND (t.idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idtache = rs.getInt("idtache");
                String executant = getEngageExecutor(idtache);
                Tache tache
                        = new Tache(getTache(idtache), executant);
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public List<Tache> getListTachePosteeNonEngagee(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT idtache FROM tache WHERE email = ? AND (idtache) NOT IN (SELECT t.idtache FROM tache t, facture f WHERE t.idtache = f.idtache) AND (idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache
                        = getTache(rs.getInt("idtache"));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public List<Tache> getListTachePosteeRealisee(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT t.idtache FROM tache t, facture f WHERE t.idtache = f.idtache AND f.facture <> '0' AND email = ? AND (t.idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idtache = rs.getInt("idtache");
                String executant = getEngageExecutor(idtache);
                Tache tache
                        = new Tache(getTache(idtache), executant, getAvis(idtache));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public List<Tache> getListTacheEngageeEnCours(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT t.idtache FROM tache t, engage e, facture f WHERE t.idtache = f.idtache AND t.idtache = e.idtache AND f.facture = '0' AND e.email = ? AND (t.idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache
                        = getTache(rs.getInt("idtache"));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public List<Tache> getListTacheEngageeRealisee(String email) throws DAOException {
        Connection conn = null;
        List<Tache> taches = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("SELECT t.idtache FROM tache t, engage e, facture f WHERE t.idtache = f.idtache AND t.idtache = e.idtache AND f.facture <> '0' AND e.email = ? AND (t.idtache) NOT IN (SELECT idtache FROM tachecomposee)");
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idtache = rs.getInt("idtache");
                Tache tache
                        = new Tache(getTache(idtache), getAvis(idtache));
                taches.add(tache);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return taches;
    }

    public void editerFacture(int idtache, int facture) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st
                    = conn.prepareStatement("UPDATE facture SET facture = ? WHERE idtache = ?");
            st.setInt(1, facture);
            st.setInt(2, idtache);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void supprimerTache(int idtache) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "DELETE FROM necessite WHERE idtache = ?");
            st.setInt(1, idtache);
            st.executeUpdate();
            st = conn.prepareStatement(
                    "DELETE FROM tache WHERE idtache = ?");
            st.setInt(1, idtache);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public Avis getAvis(int idTache) throws DAOException {
        Connection conn = null;
        int idAvis, note;
        String commentaire, emetteur, destinataire;
        Avis avis = new Avis(-1, -1, -1, "Pas de commentaire déposé", "erreur", "erreur");
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM avis WHERE idtache = ?");
            st.setInt(1, idTache);
            ResultSet rs = st.executeQuery();
            //rs peut être null
            if (rs.next()) {
                idAvis = rs.getInt("idavis");
                note = rs.getInt("note");
                commentaire = rs.getString("commentaire");
                emetteur = rs.getString("emetteur");
                destinataire = rs.getString("destinataire");
                avis = new Avis(idAvis, idTache, note, commentaire, emetteur, destinataire);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return avis;
    }

    public void creerTacheComposee(int idtache) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO tachecomposee (idtache) values (?)");
            st.setInt(1, idtache);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void creerTacheAtomique(int idtache) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO tacheatomique (idtache) values (?)");
            st.setInt(1, idtache);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void EstComposee(int idtache, int idtacheA) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO estcomposee (idtachecomp, idtacheatom) values (?, ?)");
            st.setInt(1, idtache);
            st.setInt(2, idtacheA);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public void UpdateComposee(int idtache) throws DAOException {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT DISTINCT n.idskill FROM estcomposee e, necessite n WHERE e.idtacheatom = n.idtache AND idtachecomp = ?");
            st.setInt(1, idtache);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ajouterSkill(idtache, rs.getInt("idskill"));
            }
            st = conn.prepareStatement(
                    "SELECT remuneration FROM estcomposee e, tache t WHERE e.idtacheatom = t.idtache AND idtachecomp = ?");
            st.setInt(1, idtache);
            rs = st.executeQuery();
            int remun = 0;
            while (rs.next()) {
                remun = rs.getInt("remuneration") + remun;
            }
            st = conn.prepareStatement(
                    "UPDATE tache SET remuneration = ? WHERE idtache = ? ");
            st.setInt(1, remun);
            st.setInt(2, idtache);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public TacheComposee getTacheComposee(int idtache) throws DAOException {
        Connection conn = null;
        Tache tache = getTache(idtache);
        List<Tache> tacheAtomique = new ArrayList<Tache>();
        try {
            conn = getConnection();
            PreparedStatement st2 = conn.prepareStatement(
                    "SELECT idtacheatom FROM estcomposee WHERE idtachecomp = ? ");
            st2.setInt(1, idtache);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                tacheAtomique.add(getTache(rs2.getInt("idtacheatom")));
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return new TacheComposee(tache, tacheAtomique);
    }

    /*public Set<Tache> getListTache(List<String> skill) throws DAOException {
     Connection conn = null;
     Set<Tache> taches = new HashSet<Tache>();
     try {
     conn = getConnection();
     PreparedStatement st
     = conn.prepareStatement("SELECT idtache FROM tache");
     ResultSet rs = st.executeQuery();
     PreparedStatement st1; 
     while (rs.next()) {     
     int idtache = rs.getInt("idtache");
     st1 = conn.prepareStatement("SELECT i FROM necessite WHERE idtache = ? ");
     st1.setInt(1,idtache);
     }
     } catch (SQLException e) {
     throw new DAOException("Erreur BD " + e.getMessage(), e);
     } finally {
     closeConnection(conn);
     }
     return taches;
     }PreparedStatement st2 = conn.prepareStatement(
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
     */
}
