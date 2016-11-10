package com.clothes.servlets;

import com.clothes.dao.ClothesStorage;
import com.clothes.model.ClothBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter responceWriter = response.getWriter();

		String rqName = request.getParameter("name");
		String rqSize = request.getParameter("size");
		String rqPrice = request.getParameter("price");

		//TODO: Remove comments
		//responceWriter.print("name = |" + rqName + "|        size = |" + rqSize + "|      price = |" + rqPrice + "|");
		
		//TODO: Create Util class for null value verification
		if (rqName == null || rqName.equals("") || rqSize == null || rqSize.equals("") || rqPrice == null || rqPrice.equals("")){
			responceWriter.print("<h1> Error with parameters:&nbsp name = " + rqName +
					", size = " + rqSize + ", price = " + rqPrice + "</h1>");
		}else {
			String name = rqName;
			Character size = rqSize.charAt(0);
			Double price = null;
			try {
				price = Double.parseDouble(rqPrice);
			}catch (NumberFormatException e){
				responceWriter.print("<h1>The price must be a number! Please, input number.</h1>");
			}
			//TODO: Fix this bug
			ClothesStorage.addCloth(new ClothBuilder().buildName(name).
					buildSize(size).buildPrice(price).buildCloth());

			responceWriter.print("<h1> Congradulations! Cloth " + name + " was added successfully! </h1>");
		}
		responceWriter.close();
	}

}
