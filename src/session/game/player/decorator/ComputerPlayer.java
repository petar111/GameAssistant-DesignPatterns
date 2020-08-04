/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game.player.decorator;

import strategy.StrategySelector;
import strategy.builder.StrategySelectorBuilder;

/**
 *
 * @author siux
 */
public class ComputerPlayer extends PlayerDecorator{
    
    private StrategySelector strategySelector;
    
    public ComputerPlayer(PlayerComponent player) {
        super(player);
        strategySelector = StrategySelectorBuilder.createStrategySelector();
    }
    
    @Override
    public void selectStrategy() {
        String selectedStrategy = strategySelector.selectStrategy(getStrategyNames());
        setSelectedStrategy(selectedStrategy);
    }
    
}
