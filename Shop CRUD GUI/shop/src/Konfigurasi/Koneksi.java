package Konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pandya
 */
public class Koneksi {

    public static Connection getConnection(int selection) {
        Connection conn = null;
        String url=  null;
        switch (selection){
            case 0:
                url = "jdbc:mysql://localhost:3306/customer";
                break;
            case 1:
                url = "jdbc:mysql://localhost:3306/seller";
                break;
            case 2:
                url = "jdbc:mysql://localhost:3306/logistics";
                break;
        }
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection c = Koneksi.getConnection(2);
            System.out.println(String.format("Connected to database %s " + "successfully.", c.getCatalog()));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}