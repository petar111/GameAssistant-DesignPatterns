/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

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
public class SecureProxyClient implements SecureClient{
    private final Client client;
    
    SecureProxyClient(Client client){
        this.client = client;
    }

    @Override
    public void start() {
        Properties secureData = new Properties();
        try {
            secureData.load(new FileInputStream("security.properties"));
            String licenceKey = secureData.getProperty("licence");
            
            
            this.client.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecureProxyClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecureProxyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
