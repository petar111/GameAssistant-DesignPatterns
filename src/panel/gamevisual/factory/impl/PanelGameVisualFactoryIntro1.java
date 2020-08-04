/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.gamevisual.factory.impl;

import panel.gamevisual.AbstractPanelGameAnalytics;
import panel.gamevisual.AbstractPanelGameConfig;
import panel.gamevisual.AbstractPanelGameInfo;
import panel.gamevisual.factory.AbstractPanelGameVisualFactory;
import panel.gamevisual.impl.intro.PanelGameAnalyticsIntro1;
import panel.gamevisual.impl.intro.PanelGameConfigIntro1;
import panel.gamevisual.impl.intro.PanelGameInfoIntro1;

/**
 *
 * @author siux
 */
public class PanelGameVisualFactoryIntro1 implements AbstractPanelGameVisualFactory{

    @Override
    public AbstractPanelGameAnalytics makePanelGameAnalytics() {
        return new PanelGameAnalyticsIntro1();
    }

    @Override
    public AbstractPanelGameConfig makePanelGameConfig() {
        return new PanelGameConfigIntro1();
    }

    @Override
    public AbstractPanelGameInfo makePanelGameInfo() {
        return new PanelGameInfoIntro1();
    }
    
}
