/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game;

import constants.GeneralGameConstants;
import domain.Game;
import domain.Payoff;
import session.game.player.Player;
import domain.Strategy;
import iterator.Aggregate;
import iterator.GameSessionPlayersIterator;
import session.game.player.builder.PlayerBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import session.game.player.decorator.ComputerPlayer;
import session.game.player.decorator.PlayerDecorator;

/**
 *
 * @author siux
 */
public class GameSession implements Aggregate<Player>{

    public void update() {
        totalRounds++;
    }

    @Override
    public Iterator<Player> iterator() {
        return new GameSessionPlayersIterator(this);
    }
    
    public enum GameState{
        ACTIVE, INACTIVE
    }

    private List<Player> createPlayers(Game game, String playerName, String oppName) {
        List<Player> result = new ArrayList<>();
        
        for (int i = 0; i < GeneralGameConstants.NUMBER_OF_PLAYERS; i++) {
            String name;
            if(clientPlayer == i){
                name = playerName;
            }else{
                name = oppName;
            }
            PlayerBuilder playerBuilder = new PlayerBuilder();
            
            Player player = playerBuilder.createPlayer(game, i, name);
            
            result.add(player);
        }
        
        
      
        return result;
    }

    private Game currentGame;
    private List<Player> players;
    private int clientPlayer;
    
    private ComputerPlayer opponentPlayer;
    
    private int totalRounds;
    
    private String currentMessage;
    
    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    
    

    public String getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentMessage(String currentMessage) {
        this.currentMessage = currentMessage;
    }
    
    public static GameSession newInstance(Game game, String playerName, String oppName){
        GameSession result = new GameSession();
        
        result.clientPlayer = 0;
        result.currentGame = game;
        result.players = result.createPlayers(game, playerName, oppName);
        result.totalRounds = 0;
        
        result.currentMessage = "";
        result.gameState = GameState.INACTIVE;   
        
        result.opponentPlayer = new ComputerPlayer(result.players.get(1));
        
        return result;
    }
    
    private GameSession(){
        
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    
    public Player getClientPlayer(){
        return players.get(clientPlayer);
    }
    
    public ComputerPlayer getOpponentPlayer(){
        return opponentPlayer;
    }
    
    public List<Player> getPlayers() {
        return players;
    }

    public Game getCurrentGame() {
        return currentGame;
    }
    
    public void incrementTotalRounds(){
        totalRounds++;
    }
    
    
    
}
