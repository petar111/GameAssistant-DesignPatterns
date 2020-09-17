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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import memento.MoveMemento;
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

    public MoveMemento memento() {
        return new MoveMemento(getClientPlayer().getSelectedStrategy(), getOpponentPlayer().getSelectedStrategy());
    }

    public void undo(MoveMemento moveMemento) {
        Map<String, String> state = moveMemento.getState();
        // TODO: Perform undo state modification to game session and players
        this.totalRounds--;
        this.getClientPlayer().undoUpdatePlayerState(state.get("clientPlayer"), state.get("opponentPlayer"));
        this.players.get(GeneralGameConstants.COMPUTER_PLAYER_LABEL).undoUpdatePlayerState(state.get("opponentPlayer"), state.get("clientPlayer"));
    }
    
    public enum GameState{
        ACTIVE, INACTIVE
    }

    private List<Player> createPlayers(Game game, String playerName, String oppName) {
        List<Player> result = new ArrayList<>();
        
        for (int i = 0; i < GeneralGameConstants.NUMBER_OF_PLAYERS; i++) {
            String name;
            if(GeneralGameConstants.CLIENT_PLAYER_INDEX_DEFAULT == i){
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
    private Map<String, Player> players;
    private Player clientPlayer;
    
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
//        GameSession result = new GameSession();
//        
//        
//        result.currentGame = game;
//        result.players = result.createPlayers(game, playerName, oppName);
//        result.totalRounds = 0;
//        
//        result.currentMessage = "";
//        result.gameState = GameState.INACTIVE;   
//        
//        result.clientPlayer = result.getPlayers().get(GeneralGameConstants.CLIENT_PLAYER_INDEX_DEFAULT);
//        result.opponentPlayer = new ComputerPlayer(result.players.get(GeneralGameConstants.COMPUTER_PLAYER_INDEX_DEFAULT));
//        
//        return result;
            return null;
    }
    
    GameSession(){
        this.players = new HashMap<>();
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    
    public Player getClientPlayer(){
        return this.clientPlayer;
    }
    
    public ComputerPlayer getOpponentPlayer(){
        return opponentPlayer;
    }
    
    public Map<String, Player> getPlayers() {
        return players;
    }

    public Game getCurrentGame() {
        return currentGame;
    }
    
    private void incrementTotalRounds(){
        totalRounds++;
    }

    void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    void setClientPlayer(Player clientPlayer) {
        this.clientPlayer = clientPlayer;
    }

    void setOpponentPlayer(ComputerPlayer opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }
    
    
    
    
}
