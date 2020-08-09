import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        /*
        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }*/
        PGDatabase db = new PGDatabase();
        // db.checkVersion();
        db.getHospitalSample();

        // Reference: http://zetcode.com/java/postgresql/
    }
}
