/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.builder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import strategy.StrategySelector;

/**
 *
 * @author siux
 */
public class StrategySelectorBuilder {
    public static StrategySelector createStrategySelector(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("compPlayerConfig.properties"));
            
            Class<?> selectorClass = Class.forName(prop.getProperty("StrategySelector"));
            
            return (StrategySelector)selectorClass.getConstructor().newInstance();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(StrategySelectorBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
