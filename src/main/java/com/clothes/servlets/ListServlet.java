package com.clothes.servlets;

import com.clothes.dao.ClothesStorage;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String MESSAGE_ATTRIBUTE = "message";
    public static final String TYPE_ERROR = "error";
    public static final String EMPTY_LIST_MESSAGE = "There are no clothes in the list.";
    public static final String CLOTHES_ATTRIBUTE = "listOfClothes";
    private static Logger logger = Logger.getLogger(ListServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {
        if (ClothesStorage.isEmpty()) {
            request.setAttribute(TYPE_ATTRIBUTE,TYPE_ERROR);
            request.setAttribute(MESSAGE_ATTRIBUTE, EMPTY_LIST_MESSAGE);
            logger.info("There are no clothes in the storage");
        } else {
            request.setAttribute(CLOTHES_ATTRIBUTE, ClothesStorage.getAllClothes());
            logger.info("Displaying clothes..");
        }
        request.getRequestDispatcher("dashboard.jsp").forward(request,response);
    }

}
