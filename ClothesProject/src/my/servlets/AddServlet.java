package my.servlets;


import dao.layer.ClothesClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by Vikki on 30.10.2016.
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responceWriter = response.getWriter();

        String name = request.getParameter("name");
        Character size = request.getParameter("size").charAt(0);
        Double price = Double.parseDouble(request.getParameter("price"));

        if (name != null && size != null && price != 0) {
            ClothesClass.cNames.add(name);
            ClothesClass.cSizes.add(size);
            ClothesClass.cPrices.add(price);
            responceWriter.print("<h1> Ok! </h1>");
        }else responceWriter.print("<h1> Error! Some parameter is empty! </h1>");

        responceWriter.close();
    }

}
