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
public interface PanelVisitor {
    void visit(AbstractPanelGameAnalytics panelElement);
    void visit(AbstractPanelCommands panelElement);
    void visit(AbstractPanelGameConfig panelElement);
    void visit(AbstractPanelGameInfo panelElement);
}
