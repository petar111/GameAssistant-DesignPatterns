/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import domain.Game;
import domain.PlayerConfiguration;
import java.util.List;

/**
 *
 * @author siux
 */
public class GameValidator implements IValidator{

    private Game game;

    public GameValidator(Game game) {
        this.game = game;
    }
  
    
    @Override
    public void validate() {
        if(game.getID() < 1){
            throw new RuntimeException("The game id is not positive.");
        }
        if(game.getName() == null){
            throw new RuntimeException("The game name is null.");
        }
        if(game.getPlayerConfigurations() == null){
            throw new RuntimeException("The player configurations is null.");
        }
        
        if(game.getPlayerConfigurations().size() < 2){
            throw new RuntimeException("The player configurations size is less than 2.");
        }
    }
    
}
