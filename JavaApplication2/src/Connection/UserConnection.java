/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import View.LoginPage;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.swing.JOptionPane;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserConnection {
    public Connection koneksi = null;
    public Connection getConnection(){
        try {
        MysqlDataSource user = new MysqlDataSource();
        user.setServerName("localhost");
        user.setPortNumber(3306);
        user.setUser("root");
        user.setPassword("");
        user.setDatabaseName("db_pedes");
        koneksi = user.getConnection();
          //koneksi = DriverManager.getConnection("jdbc:mysql://sql108.epizy.com/epiz_32552430_db_pedes","epiz_32552430","DSSvGk5JKu");
            System.out.println("koneksi berhasil!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new LoginPage() , "Periksa koneksi internet anda");
        }
        return koneksi;        
    }
}
//$conn = mysqli_connect("sql108.epizy.com","epiz_32552430","DSSvGk5JKu","epiz_32552430_db_pedes");
/*
epiz_32552430
DSSvGk5JKu
db = epiz_32552430_db_pedes
mysql username = epiz_32552430
hostname = sql108.epizy.com
*/