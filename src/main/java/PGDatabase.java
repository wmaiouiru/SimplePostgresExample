import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PGDatabase {
    String url = "jdbc:postgresql://localhost:5432/geo_analysis";
    String user = "postgres";
    String password = "";
    public void checkVersion(){
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void getHospitalSample(){
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             Statement st = con.createStatement();

             ResultSet rs = st.executeQuery("SELECT latitude, longitude, zip fid, id, name FROM covid.hospitals LIMIT 10")
        ) {
            if (rs.next()) {
                System.out.println(rs.getFloat(1));
                System.out.println(rs.getFloat(2));
                System.out.println(rs.getLong(3));
                System.out.println(rs.getLong(4));
                System.out.println(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
