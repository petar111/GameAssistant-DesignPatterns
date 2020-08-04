/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.game.factory;

import command.game.AbstractGameCommand;
import command.game.impl.GameCommandMove;
import command.game.impl.GameCommandStartGame;
import constants.GameCommandsConstant;

/**
 *
 * @author siux
 */
public class GameCommandFactory {
    public static AbstractGameCommand createGameCommand(GameCommandsConstant gameCommandsConstant){
        if(gameCommandsConstant == GameCommandsConstant.START_GAME){
            return new GameCommandStartGame();
        }
        if(gameCommandsConstant == GameCommandsConstant.MOVE){
            return new GameCommandMove();
        }
        
        return null;
    }
}
