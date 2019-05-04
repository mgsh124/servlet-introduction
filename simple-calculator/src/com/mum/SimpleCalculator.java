package com.mum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SimpleCalculator")
public class SimpleCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> req = request.getParameterMap();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Integer sum = 0, product = 1;
        List<String> sumArray = new ArrayList<>();
        List<String> productArray = new ArrayList<>();
        for (String key : req.keySet()) {
            if (req.get(key)[0].equals("")) continue;
//            out.println("key: " + key + " value: " + req.get(key)[0]);
            Integer value = Integer.parseInt(req.get(key)[0]);
            if (key.matches("add.")) {
                sum += value;
                sumArray.add(value.toString());
            } else {
                product *= value;
                productArray.add(value.toString());
            }
        }

        if (sumArray.size() > 1) {
            out.println("<br/><div>" + sumArray.get(0) + " + " + sumArray.get(1) + " = " + sum + "</div>");
        }

        if (productArray.size() > 1) {
            out.println("<br/><div>" + productArray.get(0) + " * " + productArray.get(1) + " = " + product + "</div>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
