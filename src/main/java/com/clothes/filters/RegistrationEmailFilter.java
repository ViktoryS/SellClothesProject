package com.clothes.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(filterName = "RegistrationEmailFilter")
public class RegistrationEmailFilter implements Filter {

    private static final String REDIRECT_PAGE = "registration.jsp";
    private static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    private static final String TYPE_ERROR = "error";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String message = null;
        String type = null;

        String email = request.getParameter("email");
        if(!Pattern.matches("^([\\w\\.]*)([\\w\\+]*)@([\\w\\.\\+]*)$", email)){
            message = ERROR_WITH_PARAMETERS + " your e-mail is not valid!";
            type = TYPE_ERROR;
        }else {
            chain.doFilter(request, response);
        }

        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
