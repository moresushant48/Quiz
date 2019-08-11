/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.moresushant48.repo;

import io.moresushant48.Model.Questions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moresushant48
 */
public class QuizPageRepo {
    
    private ResultSet rs;
    
    public ResultSet getQuestions(Connection con){
        try {
            String sql = "select * from questions";
            Statement statement = con.createStatement();       
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(QuizPageRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
