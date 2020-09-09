/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.panel;

import panel.commands.AbstractPanelCommands;
import panel.gamevisual.AbstractPanelGameAnalytics;
import panel.gamevisual.AbstractPanelGameConfig;
import panel.gamevisual.AbstractPanelGameInfo;

/**
 *
 * @author petar
 */
public class PanelVisitorRefresh implements PanelVisitor{

    @Override
    public void visit(AbstractPanelGameAnalytics panelElement) {
        panelElement.refreshView();
    }

    @Override
    public void visit(AbstractPanelCommands panelElement) {
        panelElement.refreshView();
    }

    @Override
    public void visit(AbstractPanelGameConfig panelElement) {
        panelElement.refreshView();
    }

    @Override
    public void visit(AbstractPanelGameInfo panelElement) {
        panelElement.refreshView();
    }

    
    
}
