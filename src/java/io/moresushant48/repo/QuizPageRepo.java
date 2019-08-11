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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moresushant48
 */
public class QuizPageRepo {
    
    private ArrayList<Questions> arr = new ArrayList<>();
    private ResultSet rs;
    
    public ArrayList<Questions> getQuestions(Connection con){
        try {
            String sql = "select * from questions";
            Statement statement = con.createStatement();       
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Questions q = new Questions();
                q.setId(rs.getString("id"));
                q.setQuestion(rs.getString("question"));
                q.setSol1(rs.getString("sol1"));
                q.setSol2(rs.getString("sol2"));
                q.setSol3(rs.getString("sol3"));
                q.setSol4(rs.getString("sol4"));
                arr.add(q);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuizPageRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}