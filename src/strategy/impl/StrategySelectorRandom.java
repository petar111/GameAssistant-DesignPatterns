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
public class StrategySelectorRandom implements StrategySelector{

    @Override
    public String selectStrategy(String[] strategies) {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        
        int selectedIndex = tlr.nextInt(strategies.length);
        
        return strategies[selectedIndex];
    }


    
}
