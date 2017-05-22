package com.clothes.filters;

import com.clothes.utils.Utils;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    private static final String REDIRECT_PAGE = "login.jsp";
    private static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    private static final String TYPE_ERROR = "error";
    private static final String MESSAGE_ATTRIBUTE = "message";
    private static final String TYPE_ATTRIBUTE = "type";
    private static final Logger logger = Logger.getLogger(LoginFilter.class);

    public void destroy() {/*NONE*/}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        if (!((HttpServletRequest) request).getMethod().equalsIgnoreCase("POST")) {
            logger.debug("Get method processing..");
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }

        String message = null;
        String type = null;

        logger.debug("Get parameters..");
        String login = request.getParameter("j_username");
        String password = request.getParameter("j_password");

        if (Utils.ParamsVerification(login, password)) {
            logger.warn("Some parameter is empty!");
            message = ERROR_WITH_PARAMETERS + " some parameter is empty!";
            type = TYPE_ERROR;
        } else {
            logger.info("Parameters are OK!");
            logger.debug("The next filter..");
            chain.doFilter(request, response);
        }
        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);
        request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
