/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author petar
 */
public class LicenceFilter extends Filter {

    @Override
    protected void doFilter() throws Exception {
        Properties secureData = new Properties();

        secureData.load(new FileInputStream("security.properties"));
        String licenceKey = secureData.getProperty("licence");
        
        if(licenceKey == null || licenceKey.equals("")){
            throw new IllegalArgumentException(licenceKey);
        }
    }

}
