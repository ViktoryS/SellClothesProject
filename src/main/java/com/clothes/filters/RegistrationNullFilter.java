package com.clothes.filters;

import com.clothes.utils.UtilCloth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/registration")
public class RegistrationNullFilter implements Filter {

    public static final String REDIRECT_PAGE = "registration.jsp";
    public static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    public static final String TYPE_ERROR = "error";
    public static final String TYPE_SUCCESS = "success";
    public static final String MESSAGE_ATTRIBUTE = "message";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String SUCCESS_MESSAGE = "Congratulations! You're registered successfully";

    public void destroy() {/*NONE*/}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (!((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")) {
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }

        String message = null;
        String type = null;

        boolean isValid = false;

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        if (UtilCloth.ParamsVerification(name, email, login, password, repeatPassword)) {
            message = ERROR_WITH_PARAMETERS + " some parameter is empty!";
            type = TYPE_ERROR;
        } else {
            isValid = true;
        }
        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);

        if(isValid){
            chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
