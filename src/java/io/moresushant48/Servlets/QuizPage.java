/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.moresushant48.Servlets;

import io.moresushant48.DBManager;
import io.moresushant48.Model.Questions;
import io.moresushant48.repo.QuizPageRepo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moresushant48
 */
public class QuizPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        RequestDispatcher rd = req.getRequestDispatcher("quiz.jsp");
        
        Connection c = DBManager.getCon();
        QuizPageRepo repo = new QuizPageRepo();
        ResultSet rs = repo.getQuestions(c);
        
        ArrayList<Questions> arr = new ArrayList<Questions>();
        
        try {
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
            Logger.getLogger(QuizPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.setAttribute("questions", arr);
        
        rd.include(req, resp);
    }
}