/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.Iterator;
import session.game.GameSession;
import session.game.player.Player;

/**
 *
 * @author petar
 */
public class GameSessionPlayersIterator implements Iterator<Player>{

    private final GameSession gameSession;
    private int index;
    public GameSessionPlayersIterator(GameSession gameSession){
        this.gameSession = gameSession; 
        this.index = 0;
    }
    
    
    @Override
    public boolean hasNext() {
        return index < gameSession.getPlayers().size();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player next() {
        return gameSession.getPlayers().get(index++);//To change body of generated methods, choose Tools | Templates.
    }
    
}
