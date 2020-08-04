/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.gamevisual.impl.intro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import panel.gamevisual.AbstractPanelGameInfo;

/**
 *
 * @author siux
 */
public class PanelGameInfoIntro1 extends AbstractPanelGameInfo{

    @Override
    protected JLabel makeLblInfo() {
        return new JLabel();
    }

    @Override
    protected JLabel makeLblDescription() {
        
        JLabel result = new JLabel("Choose a new game.");
        result.setForeground(Color.red);
        
        return result;
    }

    @Override
    public void refreshView() {
        
    }
    
}
