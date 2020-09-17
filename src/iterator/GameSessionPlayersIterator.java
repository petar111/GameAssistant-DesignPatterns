/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import session.game.GameSession;
import session.game.player.Player;

/**
 *
 * @author petar
 */
public class GameSessionPlayersIterator implements Iterator<Player>{

    private final List<Player> players;
    private int index;
    public GameSessionPlayersIterator(GameSession gameSession){
        this.players = new ArrayList<>(gameSession.getPlayers().values()); 
        this.index = 0;
    }
    
    
    @Override
    public boolean hasNext() {
        return index < players.size();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return players.get(index++);//To change body of generated methods, choose Tools | Templates.
    }
    
}
