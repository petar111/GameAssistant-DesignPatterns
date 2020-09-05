/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import domain.PlayerConfiguration;

/**
 *
 * @author siux
 */
public class PlayerConfigurationValidator implements IValidator{
    private final PlayerConfiguration playerConfiguration;

    public PlayerConfigurationValidator(PlayerConfiguration playerConfiguration) {
        this.playerConfiguration = playerConfiguration;
    }
  
    
    @Override
    public void validate() {
        if(playerConfiguration.getId()< 1){
            throw new RuntimeException("The playerConfiguration id is not positive.");
        }
        if(playerConfiguration.getPayoffs() == null){
            throw new RuntimeException("The player configuration payoffs is null.");
        }
    }
}
