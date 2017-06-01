package com.clothes.servlets;

import com.clothes.dao.ClothDAO;
import com.clothes.utils.Utils;
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
    private static final String REDIRECT_PAGE = "dashboard.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static Logger logger = Logger.getLogger(ListServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!Utils.userExists(request.getSession().getAttributeNames())){
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {

        if (!Utils.userExists(request.getSession().getAttributeNames())){
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

        if (ClothDAO.isEmpty()) {
            request.setAttribute(TYPE_ATTRIBUTE,TYPE_ERROR);
            request.setAttribute(MESSAGE_ATTRIBUTE, EMPTY_LIST_MESSAGE);
            logger.info("There are no clothes in the storage");
        } else {
            request.setAttribute(CLOTHES_ATTRIBUTE, ClothDAO.getAllClothes());
            logger.info("Displaying clothes..");
        }
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request,response);
    }

}
