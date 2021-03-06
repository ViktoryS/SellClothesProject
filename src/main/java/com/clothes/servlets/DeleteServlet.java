package com.clothes.servlets;

import com.clothes.dao.ClothDAO;
import com.clothes.utils.Utils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    public static final String CLOTHES_ATTRIBUTE = "listOfClothes";
    private static Logger logger = Logger.getLogger(DeleteServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deletedClothParameter = request.getParameter("deleteCloth");
        logger.debug("Request parameter: " + deletedClothParameter);
        if (!Utils.ParamsVerification(deletedClothParameter)) {
            long deletedClothId = Long.parseLong(deletedClothParameter);
            ClothDAO.removeCloth(ClothDAO.getCloth(deletedClothId));
            logger.debug("Cloth with id = " + deletedClothId + " deleted.");
        }
        request.setAttribute(CLOTHES_ATTRIBUTE, ClothDAO.getAllClothes());
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
