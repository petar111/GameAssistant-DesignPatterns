/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.GeneralGameConstants;
import db.DatabaseBroker;
import domain.Game;
import session.game.player.Player;
import form.AbstractMainForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import memento.MoveMemento;
import session.Session;
import session.game.GameSession;
import session.game.GameSessionBuilder;
import session.game.player.decorator.ComputerPlayer;
import session.game.player.decorator.PlayerComponent;
import session.game.player.decorator.PlayerDecorator;
import strategy.impl.StrategySelectorOnlyOneRandomStrategy;

/**
 *
 * @author siux
 */
public enum Controller {
    INSTANCE;


    private AbstractMainForm mainForm;
    private List<MoveMemento> strategiesInMoves;

    public void setMainForm(AbstractMainForm mainForm) {
        this.mainForm = mainForm;
    }
    
    
    
    public void startGame() {
        System.out.println("Game has started.");
        Session.INSTANCE.getGameSession().setCurrentMessage("Game has started.");
        Session.INSTANCE.getGameSession().setGameState(GameSession.GameState.ACTIVE);
        mainForm.refreshComponents();
        
    }

    public List<Game> getAllGames() {
       List<Game> result = new ArrayList<>();
        try {
            DatabaseBroker.getInstance().getAllObjects(Game.class).forEach((o) -> { result.add((Game)o);});
            DatabaseBroker.getInstance().commitTransaction();
        } catch (Exception e) {
            DatabaseBroker.getInstance().rollbackTransaction();
        }
       return result;
    }

    public void createNewGame(Game game, String playerName, String oppName) {
        GameSessionBuilder gameSessionBuilder = new GameSessionBuilder();
        
        Session.INSTANCE.setGameSession(gameSessionBuilder
                                                    .withClientPlayer(game, GeneralGameConstants.CLIENT_PLAYER_INDEX_DEFAULT, playerName)
                                                    .withOpponentPlayer(game, GeneralGameConstants.COMPUTER_PLAYER_INDEX_DEFAULT, oppName)
                                                    .withGame(game)
                                                    .build());
        strategiesInMoves = new ArrayList<>();
        System.out.println("New game has been created.");
        mainForm.refreshComponents();
    }

    public Game selectGameById(Game selectedGame) {
        try {
            Game result = (Game)DatabaseBroker.getInstance().getObjectByIdWithOneWeakObjectsType(selectedGame);
            DatabaseBroker.getInstance().commitTransaction();
            
            return result;
        } catch (Exception e) {
            DatabaseBroker.getInstance().rollbackTransaction();
        }
        
        return null;
    }

    public String changeSelectedStrategy(String selectedStrategy) {
        Session.INSTANCE.getGameSession().getClientPlayer().setSelectedStrategy(selectedStrategy);
        return Session.INSTANCE.getGameSession().getClientPlayer().getSelectedStrategy();
    }

    public void move() {
        String selectedStrategy = mainForm.getSelectedStrategy();
        
        PlayerComponent clientPlayer = Session.INSTANCE.getGameSession().getClientPlayer();
        
        clientPlayer.setSelectedStrategy(selectedStrategy);
        
        PlayerDecorator computerPlayer = Session.INSTANCE.getGameSession().getOpponentPlayer();
        computerPlayer.selectStrategy();
        
        clientPlayer.updatePlayerState(computerPlayer.getSelectedStrategy());
        computerPlayer.updatePlayerState(clientPlayer.getSelectedStrategy());
        
        Session.INSTANCE.getGameSession().update();
        
        strategiesInMoves.add(Session.INSTANCE.getGameSession().memento());
        
        Session.INSTANCE.getGameSession().setCurrentMessage("You played " + clientPlayer.getSelectedStrategy() + " strategy and your opponent played " + computerPlayer.getSelectedStrategy() + " strategy.");
        
        mainForm.refreshComponents();
        
    }
    
    public void undo(MoveMemento moveMemento){
        if(!strategiesInMoves.isEmpty()){
            Session.INSTANCE.getGameSession().undo(strategiesInMoves.get(strategiesInMoves.size() - 1));
            strategiesInMoves.remove(strategiesInMoves.size() - 1);
            Session.INSTANCE.getGameSession().setCurrentMessage("Undo");
        
            mainForm.refreshComponents();
        }
    }

    public void changeBehavior() {
        PlayerComponent oppPlayer = Session.INSTANCE.getGameSession().getOpponentPlayer();
        
        ComputerPlayer computerPlayer = Session.INSTANCE.getGameSession().getOpponentPlayer();
        
        computerPlayer.changeBehavior();
        
        Session.INSTANCE.getGameSession().setCurrentMessage("Computer behavior is changed.");
        
        mainForm.refreshComponents();
    }
    
    
}
