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
@WebServlet("/list")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responceWriter = response.getWriter();

        responceWriter.print("<h1> Clothes: </h1><br>");
        for (int i = 0; i< ClothesClass.cPrices.size(); i++){
            responceWriter.print("<p>  Name: "+ ClothesClass.cNames.get(i)
                    + "&nbsp Size: " + ClothesClass.cSizes.get(i) + "&nbsp Price: "
                    + ClothesClass.cPrices.get(i) + "</p><br>");
        }
        responceWriter.close();

    }

}
