package com.clothes.servlets;

import com.clothes.dao.ClothesStorage;
import com.clothes.model.Cloth;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    public static final String TYPE_ATTRIBUTE = "type";
    public static final String MESSAGE_ATTRIBUTE = "message";
    public static final String TYPE_ERROR = "error";
    public static final String EMPTY_LIST_MESSAGE = "No clothes founded from parameter ";
    public static final String CLOTHES_ATTRIBUTE = "listOfClothes";
    private static Logger logger = Logger.getLogger(SearchServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameParameter = request.getParameter("name");
        logger.debug("Requet parameter: " + nameParameter);
        List<Cloth> findClothes = ClothesStorage.getClothesByName(nameParameter);
        if (findClothes.isEmpty()) {
            request.setAttribute(TYPE_ATTRIBUTE, TYPE_ERROR);
            request.setAttribute(MESSAGE_ATTRIBUTE, EMPTY_LIST_MESSAGE + nameParameter);
            logger.debug("Clothes weren't found by parameter: " + nameParameter);
        } else {
            request.setAttribute(CLOTHES_ATTRIBUTE, findClothes);

        }
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
