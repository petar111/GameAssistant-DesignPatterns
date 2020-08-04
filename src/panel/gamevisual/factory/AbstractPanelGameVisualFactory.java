/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel.gamevisual.factory;

import panel.gamevisual.AbstractPanelGameAnalytics;
import panel.gamevisual.AbstractPanelGameConfig;
import panel.gamevisual.AbstractPanelGameInfo;

/**
 *
 * @author siux
 */
public interface AbstractPanelGameVisualFactory {
    AbstractPanelGameAnalytics makePanelGameAnalytics();
    AbstractPanelGameConfig makePanelGameConfig();
    AbstractPanelGameInfo makePanelGameInfo();
}
