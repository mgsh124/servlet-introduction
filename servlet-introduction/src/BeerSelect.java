import model.BeerExpert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BeerSelect")
public class BeerSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert expert = new BeerExpert();
        List<String> brands = expert.getBrands(c);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Beer Selection Advice</h1>");
        out.println("Got beer color <strong>" + c + "</strong><br/>");

        for (String brand: brands) {
            out.println("<br/>");
            out.println("Try: " + brand);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
