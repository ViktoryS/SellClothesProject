package com.clothes.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/registration")
public class RegistrationEmailFilter implements Filter {

    private static final String REDIRECT_PAGE = "registration.jsp";
    private static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    private static final String TYPE_ERROR = "error";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final Logger logger = Logger.getLogger(RegistrationEmailFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        if (!((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")) {
            logger.debug("Get method processing..");
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }

        String message = null;
        String type = null;

        String email = request.getParameter("email");
        logger.debug("Filtering email parameter..");
        if(!Pattern.matches("^([\\w\\.]*)([\\w\\+]*)@([\\w\\.\\+]*)$", email)){
            logger.warn("Email is wrong!");
            message = ERROR_WITH_PARAMETERS + " your e-mail is not valid!";
            type = TYPE_ERROR;
        }else {
            chain.doFilter(request, response);
            logger.info("Email is OK! The next filter..");
        }

        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
