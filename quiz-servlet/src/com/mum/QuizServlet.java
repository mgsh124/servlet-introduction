package com.mum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        int count = quiz.getCount();

        if (count >= 5) {
            displaySuccess(response, quiz);
        }

        String userAnswer = request.getParameter("answer");

        if (Quiz.getAnswers()[count] == Integer.parseInt(userAnswer)) {
            quiz.setScore(quiz.getScore() + 1);
        }

        quiz.setCount(++count);
        session.setAttribute("quiz", quiz);

        if (count < 5) {
            display(response, quiz);
        } else  {
            displaySuccess(response, quiz);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = new Quiz();
        if (session.isNew()) {
            session.setAttribute("quiz", quiz);
        } else {
            quiz = (Quiz) session.getAttribute("quiz");
        }

        display(response, quiz);
    }

    private void display(HttpServletResponse response, Quiz quiz) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Quiz Servlet Lab</title></head><body>");
        out.println("<h1>The Number Quiz</h1>\n" +
                "    <p>Your current score is <strong>" + quiz.getScore() + "</strong>.</p>\n" +
                "    <p>Guess the next number in the sequence.</p>\n" +
                "    <p>" + Quiz.getQuestions()[quiz.getCount()] + "</p>\n" +
                "    <form method=\"post\">\n" +
                "        <div class=\"row\">\n" +
                "            <label for=\"answer\">Your answer:</label>\n" +
                "            <input type=\"text\" name=\"answer\" id=\"answer\" pattern=\"\\d*\" size=\"10\" title=\"Please input a number\">\n" +
                "        </div><br/>\n" +
                "\n" +
                "        <button type=\"submit\">Submit</button>\n" +
                "    </form>");
        out.print("</body></html>");
    }

    private void displaySuccess(HttpServletResponse response, Quiz quiz) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Quiz Servlet Lab</title></head><body>");
        out.println("<h1>The Number Quiz</h1>\n" +
                "    <p>Your current score is <strong>" + quiz.getScore() + "</strong>.</p>\n" +
                "    <p>You have completed the Number Quiz, with a score <strong>" + quiz.getScore() + "</strong> out of <strong>" + quiz.getCount() + "</strong>.</p>\n");
        out.print("</body></html>");
    }
}
