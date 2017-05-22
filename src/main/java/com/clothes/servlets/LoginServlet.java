package com.clothes.servlets;

import com.clothes.dao.UserStorage;
import com.clothes.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String REDIRECT_PAGE = "login.jsp";
    private static final String TYPE_SUCCESS = "success";
    public static final String TYPE_ERROR = "error";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final String SUCCESS_MESSAGE = "Congratulations! You're registered successfully";
    public static final String NULL_USER_ERROR = "No such user is the storage! Login is wrong!";
    public static final String WRONG_PASSWORD_ERROR = "Password is wrong!";
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(REDIRECT_PAGE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String type = null;

        logger.debug("Get parameters..");
        String login = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        User user = null;

        for(User sUser: UserStorage.getAllUsers()){
            if(sUser.getLogin().equals(login)){
                user = sUser;
                break;
            }
        }
        if(user != null){
            if(user.getPassword().equals(password)) {
                Cookie cookie = new Cookie("user" , "" + user.hashCode());
                response.addCookie(cookie);
                logger.debug("Add cookie with user!");

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                logger.debug("The user's attribute was added in the session!");

                message = SUCCESS_MESSAGE;
                type = TYPE_SUCCESS;
            }else {
                type = TYPE_ERROR;
                message = WRONG_PASSWORD_ERROR;
            }
        }else{
            type = TYPE_ERROR;
            message = NULL_USER_ERROR;
        }

        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }
}
