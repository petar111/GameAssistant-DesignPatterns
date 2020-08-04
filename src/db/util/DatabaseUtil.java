/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siux
 */
public class DatabaseUtil {
    private final static DatabaseUtil INSTANCE = new DatabaseUtil();
    
    public static DatabaseUtil getInstance(){
        return INSTANCE;
    }

    public static DatabaseUtil getINSTANCE() {
        return INSTANCE;
    }
    
    private String url;
    private String driver;
    private String username;
    private String password;

    
    
    
    
    private DatabaseUtil(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("dbconfig.properties"));
            
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            
        } catch (IOException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
