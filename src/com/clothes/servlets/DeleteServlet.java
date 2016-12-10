package com.clothes.servlets;

import com.clothes.dao.ClothesStorage;
import com.clothes.utils.UtilCloth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    public static final String CLOTHES_ATTRIBUTE = "listOfClothes";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] deletedClothes = request.getParameterValues("deleteClothes");
        if(!UtilCloth.ParamsVerification(deletedClothes)){
            for (String deleteClothName : deletedClothes) {
                ClothesStorage.removeCloth(ClothesStorage.getCloth(deleteClothName));
            }
        }
        request.setAttribute(CLOTHES_ATTRIBUTE, ClothesStorage.getAllClothes());
        request.getRequestDispatcher("List.jsp").forward(request, response);
    }
}
