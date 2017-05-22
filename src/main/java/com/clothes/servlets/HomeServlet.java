package com.clothes.servlets;

import com.clothes.utils.Utils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final String REDIRECT_PAGE = "home.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final Logger logger = Logger.getLogger(HomeServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!Utils.userExists(request.getSession().getAttributeNames())){
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!Utils.userExists(request.getSession().getAttributeNames())){
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : HomeServlet");
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : HomeServlet");
        }
        response.sendRedirect("home.jsp");
    }
}
