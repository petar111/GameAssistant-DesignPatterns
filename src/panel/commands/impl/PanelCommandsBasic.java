/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.commands.impl;

import javax.swing.JPanel;
import panel.commands.AbstractPanelCommands;
import panel.commands.mandatory.PanelBasicCommandsMandatory;
import panel.defaults.PanelExtendedCommandsDefault;

/**
 *
 * @author siux
 */
public class PanelCommandsBasic extends AbstractPanelCommands{

    private PanelBasicCommandsMandatory pnlBasicCmdMandatory;
    private PanelExtendedCommandsDefault pnlExtendedCmdDefault;
    
    @Override
    protected JPanel makePanelMandatoryCommands() {
        pnlBasicCmdMandatory = new PanelBasicCommandsMandatory(this);
        return pnlBasicCmdMandatory;
    }

    @Override
    protected JPanel makePanelExtendedCommands() {
        pnlExtendedCmdDefault = new PanelExtendedCommandsDefault();
        return pnlExtendedCmdDefault;
    }

    @Override
    public void refreshView() {
        pnlBasicCmdMandatory.refreshView();
        pnlExtendedCmdDefault.refreshView();
    }
    
}
