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
import validator.IValidator;
import validator.PlayerConfigurationValidator;

/**
 *
 * @author siux
 */
public class PlayerConfiguration implements IDomainObject{
    private final long gameId;
    private final long id;
    private final String strategies;
    private final String payoffs;

    public PlayerConfiguration(){
        this.gameId = 0;
        this.id = 0;
        this.strategies = null;
        this.payoffs = null;
    }
    
    public PlayerConfiguration(long gameId, long id, String strategies, String payoffs) {
        this.gameId = gameId;
        this.id = id;
        this.strategies = strategies;
        this.payoffs = payoffs;
    }

    public long getGameId() {
        return gameId;
    }

    public long getId() {
        return id;
    }

    public String getStrategies() {
        return strategies;
    }

    public String getPayoffs() {
        return payoffs;
    }

    @Override
    public String getTable() {
        return "PlayerConfiguration pc";
    }

    @Override
    public String getColumns() {
        return "pc.GameId as pcGameID, pc.Id as pcId, pc.Strategies as pcStrategies, pc.Payoffs as pcPayoffs";
    }

    @Override
    public String getArgumentsforUpdate() {
        return String.format("GameId = %d, Id = %d, Strategies = '%s', Payoffs = '%s'", gameId, id, strategies, payoffs);
    }

    @Override
    public String getValuesForInsert() {
        return String.format("%d,%d,'%s','%s'", gameId, id, strategies, payoffs);
    }

    @Override
    public String getJoin() {
        return "JOIN game g on pc.GameId = g.Id";
    }

    @Override
    public List<IDomainObject> getFromResultSet(ResultSet rs) {
        List<IDomainObject> result = new ArrayList<>();
        
        try {
            while(rs.next()){
                long PlayerConfGameId = rs.getLong("pcGameId");
                long PlayerConfId = rs.getLong("pcId");
                String PlayerConfStrategies = rs.getString("pcStrategies");
                String PlayerConfPayoffs = rs.getString("pcPayoffs");
                
                
                PlayerConfiguration playerConfiguration = new PlayerConfiguration(PlayerConfGameId, PlayerConfId, PlayerConfStrategies, PlayerConfPayoffs);
                result.add(playerConfiguration);
                
            }
        } catch (SQLException ex) {
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
        return id;
    }

    @Override
    public IDomainObject getWeakObject() {
        return null;
    }

    @Override
    public void fillWeakObjects(List<IDomainObject> weakObjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStrongObjectIDColumn() {
        return "GameId";
    }

    @Override
    public IValidator getValidator() {
        return new PlayerConfigurationValidator(this);
    }
    
    
}
