package com.clothes.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    public static final String REDIRECT_PAGE = "registration.jsp";
    public static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    public static final String TYPE_ERROR = "error";
    public static final String TYPE_SUCCESS = "success";
    public static final String MESSAGE_ATTRIBUTE = "message";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String SUCCESS_MESSAGE = "Congratulations! You're registered successfully";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(REDIRECT_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String message = null;
//        String type = null;
//
//        String rqName = request.getParameter("name");
//        String rqEmail = request.getParameter("email");
//        String rqLogin = request.getParameter("login");
//        String rqPassword = request.getParameter("password");
//        String rqRepeatPassword = request.getParameter("repeatPassword");
//
//
//        if (UtilCloth.ParamsVerification(rqName, rqEmail, rqLogin, rqPassword, rqRepeatPassword)) {
//            message = ERROR_WITH_PARAMETERS + "&nbsp name = " + rqName +
//                    ", email = " + rqEmail + ", login = " + rqLogin;
//            type = TYPE_ERROR;
//        } else {
//            type = TYPE_SUCCESS;
//            message = SUCCESS_MESSAGE;
//        }
//        request.setAttribute(MESSAGE_ATTRIBUTE, request.getAttribute());
//        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }
}
