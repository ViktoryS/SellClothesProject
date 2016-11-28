package com.clothes.servlets;

import com.clothes.dao.ClothesStorage;
import com.clothes.model.ClothBuilder;
import com.clothes.utils.UtilCloth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    public static final String TYPE_ERROR = "error";
    public static final String TYPE_SUCCESS = "success";
    public static final String PRICE_ERROR = "The price must be a number! Please, input number.";
    public static final String ERROR_WITH_PARAMETERS = "Error with parameters:";
    public static final String SUCCESS_MESSAGE_BEGIN = "Congradulations! Cloth ";
    public static final String SUCCESS_MESSAGE_END = " was added successfully!";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String MESSAGE_ATTRIBUTE = "message";

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AddCloth.jsp");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String message = null;
        String type = null;

        String rqName = request.getParameter("name");
        String rqSize = request.getParameter("size");
        String rqPrice = request.getParameter("price");

        if (UtilCloth.ParamsVerification(rqName, rqPrice, rqSize)) {
            message = ERROR_WITH_PARAMETERS + "&nbsp name = " + rqName +
                    ", size = " + rqSize + ", price = " + rqPrice;
            type = TYPE_ERROR;
        } else {
            String name = rqName;
            Character size = rqSize.charAt(0);
            Double price = null;
            try {
                price = Double.parseDouble(rqPrice);
                ClothesStorage.addCloth(new ClothBuilder().buildName(name).
                        buildSize(size).buildPrice(price).buildCloth());
                message = SUCCESS_MESSAGE_BEGIN + name + SUCCESS_MESSAGE_END;
                type = TYPE_SUCCESS;

            } catch (NumberFormatException e) {
                message = PRICE_ERROR;
                type = TYPE_ERROR;
            }
        }
        request.setAttribute(MESSAGE_ATTRIBUTE, message);
        request.setAttribute(TYPE_ATTRIBUTE, type);

        request.getRequestDispatcher("/AddCloth.jsp").forward(request, response);
    }

}
