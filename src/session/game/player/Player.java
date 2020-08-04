/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game.player;

import java.util.Map;
import session.game.player.decorator.PlayerComponent;


/**
 *
 * @author siux
 */
public class Player implements PlayerComponent{
    
    private int payoffs[][];
    private Map<String, Integer> strategies;
    private Map<String, Integer> strategiesOpponent;
    
    private String[] strategyNames;
    
    private Map<String, Integer> playedStrategies;
    private String selectedStrategy;
    
    private int totalPayoff;
    
    
    private String name;

    public void setStrategyNames(String[] strategyNames) {
        this.strategyNames = strategyNames;
    }

    public String[] getStrategyNames() {
        return strategyNames;
    }

    
    
    public Player(int[][] payoffs, Map<String, Integer> strategies, Map<String, Integer> strategiesOpponent, String name, Map<String, Integer> playedStrategies) {
        this.payoffs = payoffs;
        this.strategies = strategies;
        this.strategiesOpponent = strategiesOpponent;
        this.name = name;
        this.playedStrategies = playedStrategies;
        totalPayoff = 0;
    }

    public Map<String, Integer> getPlayedStrategies() {
        return playedStrategies;
    }

    public String getSelectedStrategy() {
        return selectedStrategy;
    }

    public int getTotalPayoff() {
        return totalPayoff;
    }

    @Override
    public void setSelectedStrategy(String selectedStrategy) {
        this.selectedStrategy = selectedStrategy;
    }
    
    public void addToTotalPayoff(int amount){
        this.totalPayoff += amount;
    }
    
    public void incrementPlayedStrategy(){
        playedStrategies.put(selectedStrategy, playedStrategies.get(selectedStrategy) + 1);
    }

    public int[][] getPayoffs() {
        return payoffs;
    }

    public Map<String, Integer> getStrategies() {
        return strategies;
    }

    public Map<String, Integer> getStrategiesOpponent() {
        return strategiesOpponent;
    }

    public String getName() {
        return name;
    }

    @Override
    public void updatePlayerState(String oppSelectedStrategy) {
        int outcomePayoff = payoffs[strategies.get(selectedStrategy)][strategiesOpponent.get(oppSelectedStrategy)];
        
        addToTotalPayoff(outcomePayoff);
        incrementPlayedStrategy();
        
    }

    @Override
    public void selectStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
