package com.clothes.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/registration")
public class RegistrationPasswordFilter implements Filter {

    private static final String REDIRECT_PAGE = "registration.jsp";
    private static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    private static final String TYPE_ERROR = "error";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final Logger logger = Logger.getLogger(RegistrationPasswordFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (!((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")) {
            logger.debug("Get method processing..");
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }

        String message = null;
        String type = null;

        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        logger.debug("Get parameters..");

        if (!password.equalsIgnoreCase(repeatPassword) && Pattern.matches("//S{4,25}", password)){
            logger.warn("Error with passwords!");
            message = ERROR_WITH_PARAMETERS + " passwords is not the same!";
            type = TYPE_ERROR;
        }else{
            logger.info("Passwords are OK! The next filter..");
            chain.doFilter(request, response);
        }
        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request,response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
