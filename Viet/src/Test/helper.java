/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Laptop Lenovo
 */
public class helper {
    public static Connection ketnoi() {
        Dotenv dotenv = Dotenv.load();
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String name = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://"+host+":"+port+";databaseName="+name+"";
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
