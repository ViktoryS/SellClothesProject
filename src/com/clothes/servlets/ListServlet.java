package com.clothes.servlets;

import com.clothes.entities.Cloth;
import com.clothes.dao.ClothesStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responceWriter = response.getWriter();

        responceWriter.print("<h1> Clothes: </h1><br>");
        if (ClothesStorage.getCountOfClothes() == 0){
            responceWriter.print("<p>There are no clothes in the list.</p>");
        } else {
            for (Cloth cloth : ClothesStorage.getAllClothes()) {
                responceWriter.print("<p>  Name: " + cloth.getName()
                        + "&nbsp Size: " + cloth.getSize() + "&nbsp Price: "
                        + cloth.getPrice() + "</p><br>");
            }
        }
        responceWriter.close();

    }

}
