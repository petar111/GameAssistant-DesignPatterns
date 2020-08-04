/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.impl;

import form.AbstractMainForm;
import panel.commands.AbstractPanelCommands;
import panel.commands.impl.PanelCommandsBasic;
import panel.gamevisual.factory.AbstractPanelGameVisualFactory;
import panel.gamevisual.factory.impl.PanelGameVisualBasicFactory;
import panel.gamevisual.factory.impl.PanelGameVisualFactoryIntro1;

/**
 *
 * @author siux
 */
public class MainFormBasic extends AbstractMainForm{

    @Override
    protected AbstractPanelCommands makePanelCommands() {
        return new PanelCommandsBasic();
    }

    @Override
    protected AbstractPanelGameVisualFactory makePanelGameVisualFactoryIntro() {
        return new PanelGameVisualFactoryIntro1();
    }

    @Override
    protected AbstractPanelGameVisualFactory makePanelGameVisualFactoryNewGame() {
        return new PanelGameVisualBasicFactory();
    }

    
}
