/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;
import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;
/*
 *
 * @author Mohamed EL HADDAD
 */
public class MySqlConnexion {

    public static Connection getConnection()
    {
        try 
        {
            MysqlDataSource ds = new MysqlDataSource(); // Initialisation de la source
            ds.setURL("jdbc:mysql://localhost:3306/miniprojet?useLegacyDatetimeCode=false&serverTimezone=Europe/Amsterdam&useSSL=false");
            ds.setUser("root");
            ds.setPassword("mysql");
            Connection MyCon = ds.getConnection(); // Récupération de la connexion
            System.out.println(" Connexion établie ....");
            return MyCon;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null ;
        }
    }
    
}
