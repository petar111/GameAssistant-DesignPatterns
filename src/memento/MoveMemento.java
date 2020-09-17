/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author petar
 */
public class MoveMemento {
    private final String clientStrategy;
    private final String opponentStrategy;
    
    public MoveMemento(String clientStrategy, String opponentStrategy){
        this.clientStrategy = clientStrategy;
        this.opponentStrategy = opponentStrategy;
    }

    public Map<String, String> getState() {
        return new HashMap<String, String>(){{
                            put("clientStrategy", clientStrategy);
                            put("opponentStrategy", opponentStrategy);
                }};
    }

    
}
