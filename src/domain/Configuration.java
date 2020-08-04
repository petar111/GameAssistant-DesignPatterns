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

/**
 *
 * @author siux
 */
public class Configuration implements IDomainObject {

    private final long gameId;
    private final long ID;
    
    private final String[] strategiesPlayer1;
    private final int[][] payoffsPlayer1;
    private final String[] strategiesPlayer2;
    private final int[][] payoffsPlayer2;
    
    //raw data
    private final String strategiesPlayer1Raw;
    private final String payoffsPlayer1Raw;
    private final String strategiesPlayer2Raw;
    private final String payoffsPlayer2Raw;

    public Configuration(long gameId, long ID, String strategiesPlayer1Raw, String payoffsPlayer1Raw, String strategiesPlayer2Raw, String payoffsPlayer2Raw) {
        this.gameId = gameId;
        this.ID = ID;
        this.strategiesPlayer1Raw = strategiesPlayer1Raw;
        this.payoffsPlayer1Raw = payoffsPlayer1Raw;
        this.strategiesPlayer2Raw = strategiesPlayer2Raw;
        this.payoffsPlayer2Raw = payoffsPlayer2Raw;
        
        this.strategiesPlayer1 = extractStrategiesPlayer1();
        this.payoffsPlayer1 = extractPayoffsPlayer1();
        this.strategiesPlayer2 = extractStrategiesPlayer2();
        this.payoffsPlayer2 = extractPayoffsPlayer2();
        
    }

    private String[] extractStrategiesPlayer1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int[][] extractPayoffsPlayer1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String[] extractStrategiesPlayer2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int[][] extractPayoffsPlayer2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTable() {
        return "configuration conf";
    }

    @Override
    public String getColumns() {
        return "GameId as ConfGameId, Id as ConfId, PayoffsPlayer1 as ConfPayoffsPlayer1, StrategiesPlayer1 as ConfStrategiesPlayer1, PayoffsPlayer2 as ConfPayoffsPlayer2, StrategiesPlayer2 as ConfStrategiesPlayer2";
    }

    @Override
    public String getArgumentsforUpdate() {
        return String.format("GameId = %d, Id = %d, PayoffsPlayer1 = %s, StrategiesPlayer1 = %s, PayoffsPlayer2 = %s, StrategiesPlayer2 = %s", gameId, ID, payoffsPlayer1Raw, strategiesPlayer1Raw, payoffsPlayer2Raw, strategiesPlayer2Raw);
    }

    @Override
    public String getValuesForInsert() {
        return String.format("%d,%d,%s,%s,%s,%s", gameId, ID, payoffsPlayer1Raw, strategiesPlayer1Raw, payoffsPlayer2Raw, strategiesPlayer2Raw);
    }

    @Override
    public String getJoin() {
        return "JOIN Game g on conf.GameId = g.Id";
    }

    @Override
    public List<IDomainObject> getFromResultSet(ResultSet rs) {
        List<IDomainObject> result = new ArrayList<>();
        
        try {
            while(rs.next()){
                long ConfGameId = rs.getLong("ConfGameId");
                long ConfId = rs.getLong("ConfId");
                String ConfPayoffsPlayer1= rs.getString("ConfPayoffsPlayer1");
                String ConfStrategiesPlayer1 = rs.getString("ConfStrategiesPlayer1");
                String ConfPayoffsPlayer2= rs.getString("ConfPayoffsPlayer2");
                String ConfStrategiesPlayer2 = rs.getString("ConfStrategiesPlayer2");
                
                Configuration configuration = new Configuration(ConfGameId, ConfId, ConfStrategiesPlayer1, ConfPayoffsPlayer1, ConfStrategiesPlayer2, ConfPayoffsPlayer2);
                result.add(configuration);
                
            }
        } catch (SQLException ex) {
            return null;
        }
        
        return result;
    }

    @Override
    public String getIdColumn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getIdValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomainObject getWeakObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillWeakObjects(List<IDomainObject> weakObjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStrongObjectIDColumn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    

    

}
