/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.util.DatabaseUtil;
import domain.Game;
import domain.IDomainObject;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siux
 */
public class DatabaseBroker {
    private Connection connection;
    
    private static final DatabaseBroker INSTANCE = new DatabaseBroker();
    
    private DatabaseBroker(){
        uspostaviKonekciju();
    }
    
    private void uspostaviKonekciju(){
        Driver driver;
        try {
            driver = (Driver) Class.forName(DatabaseUtil.getInstance().getDriver()).newInstance();
            
            String url = DatabaseUtil.getInstance().getUrl();
            String user = DatabaseUtil.getInstance().getUsername();
            String password = DatabaseUtil.getInstance().getPassword();
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            
            connection = driver.connect(url, properties);
            connection.setAutoCommit(false);
            
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection to database unsuccessful. Aborting!");
            return;
        }

        System.out.println("Connection to database successful.");
    }
    
    public static DatabaseBroker getInstance(){
        return INSTANCE;
    } 
    
    
    public void commitTransaction(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollbackTransaction(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<IDomainObject> getAllObjects(IDomainObject domainObject){

        try {
            String query = String.format("SELECT %s FROM %s %s", domainObject.getColumns(), domainObject.getTable(), domainObject.getJoin());
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            
            List<IDomainObject> result = domainObject.getFromResultSet(rs);
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;    
    }
    
    public List<IDomainObject> getAllObjects(Class<? extends IDomainObject> classObject){

        
        
        try {
            IDomainObject domainObject = (IDomainObject) classObject.getConstructor().newInstance();
            
            String query = String.format("SELECT %s FROM %s %s", domainObject.getColumns(), domainObject.getTable(), domainObject.getJoin());
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            
            List<IDomainObject> result = domainObject.getFromResultSet(rs);
            
            
            
            return result;
        } catch (Exception ex) {
            
        }
            return null;    
    }

    public IDomainObject getObjectByIdWithOneWeakObjectsType(IDomainObject domainObject) throws Exception{
        
            String query = String.format("SELECT %s FROM %s %s where %s = %s", domainObject.getColumns(), domainObject.getTable(), domainObject.getJoin(),
                                                                                        domainObject.getIdColumn(), domainObject.getIdValue().toString());
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            
            List<IDomainObject> result = domainObject.getFromResultSet(rs);
            
            if(result.size() != 1){
                throw new Exception("Database select\n Expected results: 1; Output: " + result.size());
            }
            
            IDomainObject resultObject = result.get(0);
            
            List<IDomainObject> weakObjects = getWeakObjects(resultObject);
            
            resultObject.fillWeakObjects(weakObjects);
        
            return resultObject;
    }

    private List<IDomainObject> getWeakObjects(IDomainObject resultObject) {
       
        IDomainObject weakObject = resultObject.getWeakObject();

        try {
            String query = String.format("SELECT %s FROM %s WHERE %s", weakObject.getColumns(), weakObject.getTable(), weakObject.getStrongObjectIDColumn() + "=" + resultObject.getIdValue());
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            
            List<IDomainObject> result = weakObject.getFromResultSet(rs);
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
        
        
    }
    
    
}
