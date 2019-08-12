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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author moresushant48
 */
public class QuizPageRepo {
    
    private ArrayList<Questions> arr = new ArrayList<>();
    private ResultSet rs;
    private static String[] answers;
    
    public ArrayList<Questions> getQuestions(Connection con){
        try {
            String sql = "SELECT * FROM questions";
            Statement statement = con.createStatement();       
            rs = statement.executeQuery(sql);
            rs.last();
            answers = new String[rs.getRow()];
            rs.first();
            int i=0;
            do{
                Questions q = new Questions();
                q.setId(rs.getString("id"));
                q.setQuestion(rs.getString("question"));
                q.setSol1(rs.getString("sol1"));
                q.setSol2(rs.getString("sol2"));
                q.setSol3(rs.getString("sol3"));
                q.setSol4(rs.getString("sol4"));
                q.setAnswer(rs.getString("answer"));
                answers[i] = rs.getString("answer");
                i++;
                arr.add(q);
            }while(rs.next());
                    
        } catch (SQLException ex) {
            Logger.getLogger(QuizPageRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int calcResultOfQuiz(HttpServletRequest req) {
        int j=1, result=0;
        for(String answer : answers){
            String ans = req.getParameter(String.valueOf(j++));
            System.out.println("DB : " + answer + "\tUser : " + ans);
            if(ans.equals(answer))
                result++;
            System.out.println(result);
        }
        return result;
    }
    
    // Getters and Setters
    
    public static String[] getAnswers() {
        return answers;
    }

    public static void setAnswers(String[] answers) {
        QuizPageRepo.answers = answers;
    }
}