/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.gamevisual.impl;

import javax.swing.JLabel;
import observer.lightmode.LightModeListener;
import observer.lightmode.LightModeManager;
import panel.gamevisual.AbstractPanelGameInfo;
import session.Session;

/**
 *
 * @author siux
 */
public class PanelGameInfoBasic extends AbstractPanelGameInfo implements LightModeListener{

    @Override
    protected JLabel makeLblInfo() {
        return new JLabel();
    }

    @Override
    protected JLabel makeLblDescription() {
        return new JLabel();
    }

    @Override
    public void refreshView() {
        getLblInfo().setText(Session.INSTANCE.getGameSession().getCurrentGame().getInfo());
        getLblDescription().setText(Session.INSTANCE.getGameSession().getCurrentGame().getDescription());
    }

    @Override
    public void update(LightModeManager lightModeManager) {
        setBackground(lightModeManager.getColors().getBackgroundColor());
        getLblDescription().setForeground(lightModeManager.getColors().getTextColor());
        getLblInfo().setForeground(lightModeManager.getColors().getTextColor());
        
    }
    
}
