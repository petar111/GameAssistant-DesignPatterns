/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author siux
 */
public class Payoff {
    private int amount;
    private Strategy playedStrategy;

    public Payoff(){
        
    }
    
    public Payoff(int amount, Strategy playedStrategy) {
        this.amount = amount;
        this.playedStrategy = playedStrategy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Strategy getPlayedStrategies() {
        return playedStrategy;
    }
    
    
}
