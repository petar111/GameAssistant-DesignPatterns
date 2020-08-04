/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DatabaseBroker;
import domain.Game;
import session.game.player.Player;
import form.AbstractMainForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import session.Session;
import session.game.GameSession;
import session.game.player.decorator.ComputerPlayer;
import session.game.player.decorator.PlayerDecorator;

/**
 *
 * @author siux
 */
public enum Controller {
    INSTANCE;


    private AbstractMainForm mainForm;

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
        Session.INSTANCE.setGameSession(GameSession.newInstance(game, playerName, oppName));
        System.out.println("New game has been created.");
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
        Random tlr = new Random();
        
        Player clientPlayer = Session.INSTANCE.getGameSession().getClientPlayer();
        
        clientPlayer.setSelectedStrategy(selectedStrategy);
        
        Player oppPlayer = Session.INSTANCE.getGameSession().getPlayers().get(1);
        
        PlayerDecorator computerPlayer = new ComputerPlayer(oppPlayer);
        
        computerPlayer.selectStrategy();
        
        clientPlayer.updatePlayerState(computerPlayer.getSelectedStrategy());
        computerPlayer.updatePlayerState(clientPlayer.getSelectedStrategy());
        
        Session.INSTANCE.getGameSession().update();
        
        Session.INSTANCE.getGameSession().setCurrentMessage("You played " + clientPlayer.getSelectedStrategy() + " strategy and your opponent played " + computerPlayer.getSelectedStrategy() + " strategy.");
        
        mainForm.refreshComponents();
        
    }
    
    
}
