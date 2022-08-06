/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class userConnection {
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
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return koneksi;        
    }
}
