/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game.player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import prototype.Prototype;
import session.game.player.decorator.PlayerComponent;


/**
 *
 * @author siux
 */
public class Player implements PlayerComponent, Prototype<Player>{
    
    private int payoffs[][];
    private Map<String, Integer> strategies;
    private Map<String, Integer> strategiesOpponent;
    
    private String[] strategyNames;
    
    private Map<String, Integer> playedStrategies;
    private String selectedStrategy;
    
    private int totalPayoff;
    
    
    private String name;
    
    public Player(Player player){
        for (int i = 0; i < player.payoffs.length; i++) {
            this.payoffs[i] = Arrays.copyOf(player.payoffs[i], player.payoffs[i].length);
        }
        
        
        this.strategies = new HashMap<>(player.strategies);
        
        this.strategiesOpponent = new HashMap<>(player.strategiesOpponent);
        
        this.strategyNames = Arrays.copyOf(player.strategyNames, player.strategyNames.length);
        
        this.playedStrategies = new HashMap<>(player.playedStrategies);
        
        this.selectedStrategy = String.valueOf(player.selectedStrategy);
        
        this.totalPayoff = player.totalPayoff;
        
        this.name = String.valueOf(player.name);
    }
    

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
    
    public void undoUpdatePlayerState(String myStrategy, String opponentStrategy){
        int outcomePayoff = payoffs[strategies.get(myStrategy)][strategiesOpponent.get(opponentStrategy)];
        
        subtractToTotalPayoff(outcomePayoff);
        decrementPlayerStrategy(myStrategy);
    }

    @Override
    public void selectStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player cloneObject() {
        return new Player(this);
    }

    private void subtractToTotalPayoff(int amount) {
        this.totalPayoff -= amount;
    }

    private void decrementPlayerStrategy(String myStrategy) {
        playedStrategies.put(myStrategy, playedStrategies.get(myStrategy) - 1);
    }

}
