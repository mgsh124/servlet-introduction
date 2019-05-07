package com.mum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChooseServlet")
public class ChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("radioJSPCool");
        RadioState radioJSPCoolState = new RadioState();
        String choice1 = request.getParameter("JSFwayCool");
        RadioState jsfWayCoolState = new RadioState();
        String choice2 = request.getParameter("moonCheese");
        RadioState moonCheeseState = new RadioState();

        if (choice != null) {
            System.out.println ("choice= "+ choice);
        }
        else {
            System.out.println("No choice made");
        }

        request.setAttribute("radioJSPCool", handleState(choice, radioJSPCoolState));
        request.setAttribute("jsfWayCool", handleState(choice1, jsfWayCoolState));
        request.setAttribute("moonCheese", handleState(choice2, moonCheeseState));
        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");
        dispatch.forward(request, response);
    }

    private RadioState handleState(String choice, RadioState radioState) {
        if (choice == null)
            return radioState;

        switch (choice) {
            case "1":
                radioState.setYesCheck(choice); break;
            case "0":
                radioState.setNoCheck(choice); break;
            default:
                break;
        }

        return  radioState;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatch = request.getRequestDispatcher("choose.jsp");
        dispatch.forward(request, response);
    }
}
