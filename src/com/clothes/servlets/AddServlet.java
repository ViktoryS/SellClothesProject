package com.clothes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothes.dao.ClothesStorage;
import com.clothes.entities.Cloth;
import com.clothes.entities.clothbuilder.ClothBuilder;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter responceWriter = response.getWriter();

		//TODO: Please use readable names of variables
		String n = request.getParameter("name");
		String s = request.getParameter("size");
		String p = request.getParameter("price");

		if (n == null || s == null || p == null){
			responceWriter.print("<h1> Error with parameters:&nbsp name = " + n +
					", size = " + s + ", price = " + p + "</h1>");
		}else {
			//TODO: Avoid dublication of code 
			String name = request.getParameter("name");
			Character size = request.getParameter("size").charAt(0);
			Double price = Double.parseDouble(request.getParameter("price"));
			
			//TODO: Add Builder here

			ClothesStorage.addCloth(name, size, price);

			responceWriter.print("<h1> Congradulations! Cloth " + name + " was added successfully! </h1>");
		}
		responceWriter.close();
	}

}
