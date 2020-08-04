/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import form.AbstractMainForm;
import form.factory.MainFormFactory;

/**
 *
 * @author siux
 */
public class Client {

    
    private AbstractMainForm mainForm;
    
    public void start(){
        mainForm = MainFormFactory.getMainForm();
        mainForm.construct();
        mainForm.pack();
        controller.Controller.INSTANCE.setMainForm(mainForm);
        
        mainForm.setVisible(true);
    }
    
}
