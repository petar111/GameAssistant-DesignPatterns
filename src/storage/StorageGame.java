/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Game;
import java.util.List;


/**
 *
 * @author siux
 */
public enum StorageGame {
    INSTANCE;
    
    private List<Game> games;
    
    private StorageGame(){
        
    }
    public List<Game> getGames(){
        return games;
    }
}
