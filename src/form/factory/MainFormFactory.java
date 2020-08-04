/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.factory;

import form.AbstractMainForm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siux
 */
public class MainFormFactory {
    public static AbstractMainForm getMainForm(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("viewconfig.properties"));
            String formClassName = properties.getProperty("formchoice");
            
            Class<?> formClass = Class.forName(formClassName);
            
            Constructor<?> formConstructor = formClass.getConstructor();
            
            AbstractMainForm result = (AbstractMainForm)formConstructor.newInstance();
            
            return result;
        } catch (Exception ex) {
            Logger.getLogger(MainFormFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
