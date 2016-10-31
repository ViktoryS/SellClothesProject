package com.clothes.servlets;

import com.clothes.dao.Cloth;
import com.clothes.dao.MemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//TODO: Remove javadocs
/**
 * Created by Vikki on 30.10.2016.
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responceWriter = response.getWriter();

        //TODO: Show msg "List is empty" in case no product available
        responceWriter.print("<h1> Clothes: </h1><br>");
        if (MemoryStorage.getCountOfClothes() == 0){
            responceWriter.print("<p>There are no clothes in the list.</p>");
        }

        //TODO: Please use foreach
        for (Cloth cloth: MemoryStorage.getAllClothes()){
            responceWriter.print("<p>  Name: "+ cloth.getName()
                    + "&nbsp Size: " + cloth.getSize() + "&nbsp Price: "
                    + cloth.getPrice() + "</p><br>");
        }
        responceWriter.close();

    }

}
