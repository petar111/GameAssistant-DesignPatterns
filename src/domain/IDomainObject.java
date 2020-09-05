/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import validator.IValidator;

/**
 *
 * @author siux
 */
public interface IDomainObject {
    String getTable();
    String getColumns();
    String getArgumentsforUpdate();
    String getValuesForInsert();
    String getJoin();
    String getIdColumn();
    Object getIdValue();
    String getStrongObjectIDColumn();
    IDomainObject getWeakObject();
    void fillWeakObjects(List<IDomainObject> weakObjects);

    List<IDomainObject> getFromResultSet(ResultSet rs);
    
    IValidator getValidator();

}
