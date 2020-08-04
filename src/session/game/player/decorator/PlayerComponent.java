/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game.player.decorator;

/**
 *
 * @author siux
 */
public interface PlayerComponent {
    public void selectStrategy();
    public void setSelectedStrategy(String selectedStrategy);
    public String getSelectedStrategy();
    public void updatePlayerState(String oppSelectedStrategy);
    public String[] getStrategyNames();
}
