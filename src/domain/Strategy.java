/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author siux
 */
public class Strategy {
    private String name;
    private List<Payoff> payoffs;

    
    public Strategy(){
        
    }
    
    public Strategy(String name, List<Payoff> payoffs) {
        this.name = name;
        this.payoffs = payoffs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Payoff> getPayoffs() {
        return payoffs;
    }

    public void setPayoffs(List<Payoff> payoffs) {
        this.payoffs = payoffs;
    }
    
    
    
}
