package com.clothes.filters;

import com.clothes.utils.UtilCloth;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {
    public static final String REDIRECT_PAGE = "registration.jsp";
    public static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    public static final String TYPE_ERROR = "error";
    public static final String TYPE_SUCCESS = "success";
    public static final String MESSAGE_ATTRIBUTE = "message";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String SUCCESS_MESSAGE = "Congratulations! You're registered successfully";

    public void destroy() {/*NONE*/}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
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
            //"\\S[^@]+@\\S[^@]+\\.\\S[^@]+");
            if(!Pattern.matches("^([\\w\\.]*)([\\w\\+]*)@([\\w\\.\\+]*)$", email)){
                message = ERROR_WITH_PARAMETERS + " your e-mail is not valid!";
                type = TYPE_ERROR;
            }else if(!password.equals(repeatPassword)){
                message = ERROR_WITH_PARAMETERS + " password repetition is not valid!";
                type = TYPE_ERROR;
            }else {
                isValid = true;
                type = TYPE_SUCCESS;
                message = SUCCESS_MESSAGE;
            }
        }
        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        //request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        if(isValid){
            chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
