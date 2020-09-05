/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.impl;

import java.util.concurrent.ThreadLocalRandom;
import strategy.StrategySelector;

/**
 *
 * @author siux
 */
public class StrategySelectorOnlyOneRandomStrategy implements StrategySelector{

    int randStrategyIndex;
    
    public StrategySelectorOnlyOneRandomStrategy() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        randStrategyIndex = tlr.nextInt(1000000);
    }
    
    
    
    
    @Override
    public String selectStrategy(String[] strategies) {
        return strategies[randStrategyIndex % strategies.length];
    }
}
