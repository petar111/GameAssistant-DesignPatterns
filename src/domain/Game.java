/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import validator.GameValidator;
import validator.IValidator;

/**
 *
 * @author siux
 */
public class Game implements IDomainObject{

    private long ID;
    private String name;
    private String info;
    private String description;
    private List<PlayerConfiguration> playerConfigurations;

//    private Game(GameBuilder gameBuilder) {
//        this.ID = gameBuilder.ID;
//        this.name = gameBuilder.name;
//        this.info = gameBuilder.info;
//        this.description = gameBuilder.description;
//        this.playerConfigurations = gameBuilder.playerConfigurations;
//    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlayerConfigurations(List<PlayerConfiguration> playerConfigurations) {
        this.playerConfigurations = playerConfigurations;
    }
    
    
   

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getDescription() {
        return description;
    }

    public List<PlayerConfiguration> getPlayerConfigurations() {
        return playerConfigurations;
    }

    


    @Override
    public String getTable() {
        return "game g";
    }

    @Override
    public String getColumns() {
        return "g.Id as GameId, g.Name as GameName, g.Info as GameInfo, g.Description as GameDescription";
    }

    @Override
    public String getArgumentsforUpdate() {
        return String.format("Id = %d, Name = '%s', Info = '%s', Description = '%s'", ID, name, info, description);
    }

    @Override
    public String getValuesForInsert() {
        return String.format("%d,'%s','%s','%s'", ID, name, info, description);
    }

    @Override
    public String getJoin() {
        return "";
    }

    @Override
    public List<IDomainObject> getFromResultSet(ResultSet rs) {
        List<IDomainObject> result = new ArrayList<>();
        
        try {
            while(rs.next()){
                long gameId = rs.getLong("GameId");
                String gameName = rs.getString("GameName");
                String gameInfo = rs.getString("GameInfo");
                String gameDescription = rs.getString("GameDescription");
                
                Game game = new Game();
                
                game.setID(gameId);
                game.setDescription(gameDescription);
                game.setInfo(gameInfo);
                game.setName(gameName);
                
                result.add(game);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return result;
    }

    @Override
    public String getIdColumn() {
        return "Id";
    }

    @Override
    public Object getIdValue() {
        return ID;
    }

    @Override
    public IDomainObject getWeakObject() {
        return new PlayerConfiguration();
    }

    @Override
    public void fillWeakObjects(List<IDomainObject> weakObjects) {
        List<PlayerConfiguration> filler = new ArrayList<>();
        
        weakObjects.forEach((pc) -> filler.add((PlayerConfiguration)pc));
        
        this.playerConfigurations = filler;
        
    }

//    public static class GameBuilder {
//
//        private long ID;
//        private String name;
//        private String info = "";
//        private List<PlayerConfiguration> playerConfigurations;
//        private String description = "";
//
//        public GameBuilder(){
//            this.ID = 0;
//            this.name = null;
//            this.playerConfigurations = null;
//        }
//        
//        public GameBuilder(long ID, String name, List<PlayerConfiguration> playerConfigurations) {
//            this.ID = ID;
//            this.name = name;
//            this.playerConfigurations = playerConfigurations;
//        }
//
//        public GameBuilder withInfo(String info) {
//            this.info = info;
//            return this;
//        }
//        
//        public GameBuilder withDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public Game build() {
//            return new Game(this);
//        }
//
//    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getStrongObjectIDColumn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IValidator getValidator() {
        return new GameValidator(this);
    }


    
    
    
    

}
