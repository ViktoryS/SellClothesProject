package com.clothes.filters;

import com.clothes.model.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class AuthentificationFilter implements Filter {

    private static final String REDIRECT_PAGE = "home.jsp";
    private static final Logger logger = Logger.getLogger(AuthentificationFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String message = null;
        String type = null;
        logger.debug("Casting request..");
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        logger.debug("Get session..");
        HttpSession session = httpRequest.getSession();

        User sessionUser = null;
        logger.debug("Try to get user attribute from session..");
        if(session.getAttribute("user") != null){
            logger.debug("Attribute was found!");
            sessionUser = (User)session.getAttribute("user");
        }else{
            logger.debug("Attribute does not found! The next filter..");
            chain.doFilter(request, response);
        }

        String cookieUserHashCode = null;
        logger.debug("Trying to find user cookie..");
        for(Cookie sCookie:httpRequest.getCookies()){
            if(sCookie.getName().equals("user")){
                logger.debug("Cookie was found!");
                cookieUserHashCode = sCookie.getValue();
                break;
            }
        }
        logger.debug("Validation..");
        if(cookieUserHashCode!=null && cookieUserHashCode.equals(""+sessionUser.hashCode())){
            logger.debug("Validation is OK! Redirecting..");
            request.getRequestDispatcher(REDIRECT_PAGE).forward(request, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
