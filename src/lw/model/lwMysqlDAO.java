/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.SQLException;
import java.util.List;
import lw.domain.LWException;
import lw.domain.Member;

/**
 *
 * @author adm
 */
public interface lwMysqlDAO <O,C>{

    List<O> getAll() throws LWException;

    C getOneById(String id) throws LWException, SQLException;

    void insert(O m) throws LWException;

    void update(O m, String id) throws LWException;
    
    void createTable(String id) throws LWException;
    
    void deleteTable(String id) throws LWException;
    
    void delete(String id) throws LWException;
    
    
}
