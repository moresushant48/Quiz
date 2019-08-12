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
import java.sql.Connection;
import java.util.ArrayList;
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

    private Connection c = DBManager.getCon();
    private QuizPageRepo repo = new QuizPageRepo();
    private ArrayList<Questions> arr = repo.getQuestions(c);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        RequestDispatcher rd = req.getRequestDispatcher("quiz.jsp");
        req.setAttribute("questions", arr);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("quiz.jsp");
        req.setAttribute("questions", arr);
        req.setAttribute("result", repo.calcResultOfQuiz(req));
        rd.forward(req, resp);
    }
}