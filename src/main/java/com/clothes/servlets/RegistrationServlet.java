package com.clothes.servlets;

import com.clothes.dao.UserStorage;
import com.clothes.model.UserBuilder;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final String REDIRECT_PAGE = "registration.jsp";
    private static final String TYPE_SUCCESS = "success";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final String SUCCESS_MESSAGE = "Congratulations! You're registered successfully";
    private static final Logger logger = Logger.getLogger(RegistrationServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(REDIRECT_PAGE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String type = null;

        logger.debug("Get parameters..");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserStorage.addUser(new UserBuilder().setName(name).setEmail(email).
                setLogin(login).setPassword(password).buildUser());
        logger.debug("User was built!");

        message = SUCCESS_MESSAGE;
        type = TYPE_SUCCESS;

        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }
}
