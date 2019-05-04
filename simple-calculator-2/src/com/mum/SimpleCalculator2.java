package com.mum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "SimpleCalculator2")
public class SimpleCalculator2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> req = request.getParameterMap();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Integer sum = 0, product = 1;
        for (String key : req.keySet()) {
            if (req.get(key)[0].equals("")) continue;
//            out.println("key: " + key + " value: " + req.get(key)[0]);
            Integer value = Integer.parseInt(req.get(key)[0]);
            if (key.matches("add[^(Result)]")) {
                sum += value;
            }

            if (key.matches("times[^(Result)]")) {
                product *= value;
            }
        }

        out.print("<html><head><title>Simple Calculator 2</title></head><body>");
        out.print("<form method='post'>");
        out.print("<div>\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"add1\" value=\"" + req.get("add1")[0] + "\"> +\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"add2\" value=\"" + req.get("add2")[0] + "\"> =\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"addResult\" value=\"" + ((sum == 0) ? "" : sum) + "\">\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"times1\" value=\"" + req.get("times1")[0] + "\"> *\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"times2\" value=\"" + req.get("times2")[0] + "\"> =\n" +
                "        <input type=\"text\" pattern=\"\\d*\" size=\"5\" name=\"timesResult\" value=\"" + ((product == 1) ? "" : product) + "\">\n" +
                "    </div>\n" +
                "\n" +
                "    <button type=\"submit\">Submit</button>");
        out.print("</form>");
        out.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
