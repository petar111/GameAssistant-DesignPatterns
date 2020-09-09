/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator.panel;

import constants.GameCommandsConstant;
import java.util.logging.Level;
import java.util.logging.Logger;
import panel.commands.impl.PanelCommandsBasic;
import panel.commands.mandatory.PanelBasicCommandsMandatory;

/**
 *
 * @author petar
 */
public enum PanelGameCommandsMediator {
    
    INSTANCE;
    
    private PanelBasicCommandsMandatory panelBasicCommandsMandatory;
    private PanelCommandsBasic panelCommandsBasic;

    public void setPanelBasicCommandsMandatory(PanelBasicCommandsMandatory panelBasicCommandsMandatory) {
        this.panelBasicCommandsMandatory = panelBasicCommandsMandatory;
    }

    public void setPanelCommandsBasic(PanelCommandsBasic panelCommandsBasic) {
        this.panelCommandsBasic = panelCommandsBasic;
    }

    public void refreshView(){
        panelBasicCommandsMandatory.refreshView();
    }
    public void makeAndInvokeCommand(GameCommandsConstant gameCommandsConstant){
        try {
            panelCommandsBasic.makeCommand(gameCommandsConstant);
            panelCommandsBasic.invokeCommand();
        } catch (Exception ex) {
            Logger.getLogger(PanelGameCommandsMediator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
}
