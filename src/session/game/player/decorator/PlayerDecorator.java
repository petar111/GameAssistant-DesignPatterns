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
public abstract class PlayerDecorator implements PlayerComponent{
    protected PlayerComponent player;

    public PlayerDecorator(PlayerComponent player){
        this.player = player;
    }

    @Override
    public void updatePlayerState(String oppSelectedStrategy) {
        player.updatePlayerState(oppSelectedStrategy);
    }

    @Override
    public String[] getStrategyNames() {
        return player.getStrategyNames();
    }

    @Override
    public String getSelectedStrategy() {
        return player.getSelectedStrategy();
    }
    
    

    @Override
    public void setSelectedStrategy(String selectedStrategy) {
        player.setSelectedStrategy(selectedStrategy);
    }
    
    
    

    @Override
    public abstract void selectStrategy();

    
}
