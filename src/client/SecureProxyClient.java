/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import filter.Filter;
import filter.FilterFactory;
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
        
        try {
            Filter filterChain = FilterFactory.makeFilterChain();
            
            filterChain.handle();
            this.client.start();
        } catch (Exception ex) {
            Logger.getLogger(SecureProxyClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR. " + ex.toString());
            System.out.println("Aborting program in three seconds.");
            
            try {
                Thread.sleep(3000);
                System.exit(-1);
            } catch (InterruptedException ex1) {
                Logger.getLogger(SecureProxyClient.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
