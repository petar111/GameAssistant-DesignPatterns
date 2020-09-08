/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import form.AbstractMainForm;
import form.factory.MainFormFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petar
 */
public class ViewConfigFilter extends Filter {

    @Override
    protected void doFilter() throws Exception {
        Properties properties = new Properties();
        
        properties.load(new FileInputStream("viewconfig.properties"));
        String formClassName = properties.getProperty("formchoice");

        Class<?> formClass = Class.forName(formClassName);

        Constructor<?> formConstructor = formClass.getConstructor();
        
        AbstractMainForm amf = (AbstractMainForm)formConstructor.newInstance();

    }

}
