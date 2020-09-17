/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.game;

import constants.GeneralGameConstants;
import domain.Game;
import session.game.player.Player;
import session.game.player.builder.PlayerBuilder;
import session.game.player.decorator.ComputerPlayer;

/**
 *
 * @author petar
 */
public class GameSessionBuilder {
    private final GameSession gameSession;
    private final PlayerBuilder playerBuilder = new PlayerBuilder();

    public GameSessionBuilder() {
        this.gameSession = new GameSession();
    }
    
    
    
    public GameSessionBuilder withClientPlayer(Game game, int index, String name){
        Player clientPlayer = playerBuilder.createPlayer(game, index, name);
        gameSession.getPlayers().put(GeneralGameConstants.CLIENT_PLAYER_LABEL, clientPlayer);
        gameSession.setClientPlayer(clientPlayer);
        
        return this;
    }
    
    public GameSessionBuilder withOpponentPlayer(Game game, int index, String name){
        Player computerPlayer = playerBuilder.createPlayer(game, index, name);
        gameSession.getPlayers().put(GeneralGameConstants.COMPUTER_PLAYER_LABEL, computerPlayer);
        gameSession.setOpponentPlayer(new ComputerPlayer(computerPlayer));
        
        return this;
    }
    
    public GameSessionBuilder withGame(Game game){
        gameSession.setCurrentGame(game);
        return this;
    }
    
    public GameSessionBuilder withGameState(GameSession.GameState gameState){
        return this;
    }
    
    public GameSession build(){
        return gameSession;
    }
}
