/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.game.impl;

import command.game.AbstractGameCommand;

/**
 *
 * @author siux
 */
public class GameCommandChangeBehavior implements AbstractGameCommand{

    @Override
    public void execute() {
        controller.Controller.INSTANCE.changeBehavior();
    }
    
}
