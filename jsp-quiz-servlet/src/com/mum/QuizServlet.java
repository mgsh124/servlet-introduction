package com.mum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizModel quiz = (QuizModel) session.getAttribute("quiz");
        RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");

        request.setAttribute("questions", QuizModel.getQuestions());
        request.setAttribute("invalid", "");

        if (quiz.isCompleted()) {
            dispatcher = request.getRequestDispatcher("finish.jsp");
            dispatcher.forward(request, response);
        }

        String userAnswer = request.getParameter("answer");
        String userAge = request.getParameter("age");

        if (userAge == null || userAge == "") {
            request.setAttribute("invalid", "Please input your age.");
        } else {
            if (quiz.validateAge(Integer.parseInt(userAge))) {
                if (userAnswer != null) {
                    quiz.updateScore(Integer.parseInt(userAnswer));
                    quiz.setAge(Integer.parseInt(userAge));
                    session.setAttribute("quiz", quiz);
                }

                if (quiz.isCompleted()) {
                    dispatcher = request.getRequestDispatcher("finish.jsp");
                }
            } else {
                request.setAttribute("invalid", "Your age should be between 4 and 100.");
            }
        }

        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        QuizModel quiz = (QuizModel) session.getAttribute("quiz");
        if (quiz == null) {
            System.out.println("Quiz is null");
            quiz = new QuizModel();
            session.setAttribute("quiz", quiz);
        }

        request.setAttribute("questions", QuizModel.getQuestions());
        request.setAttribute("invalid", "");
        RequestDispatcher dispatcher = request.getRequestDispatcher("quiz.jsp");
        dispatcher.forward(request, response);
    }
}
