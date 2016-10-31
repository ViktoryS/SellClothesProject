package com.clothes.servlets;

import com.clothes.dao.MemoryStorage;

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

		// TODO: null & empty validation + appropriate messages for client
		String name = request.getParameter("name");
		Character size = request.getParameter("size").charAt(0);
		Double price = Double.parseDouble(request.getParameter("price"));

		if (name != null && size != null && price != 0) {
			MemoryStorage.addCloth(name, size, price);

			// TODO: Clothe <name> was added successfully
			responceWriter.print("<h1> Congradulations! Cloth "+ name +" was added successfully! </h1>");
		} else {
			responceWriter.print("<h1> Error! Parameters:&nbsp"+
					(name==null?"name&nbsp":"") +
					(size==null?"size&nbsp":"") +
					(price==0?"price&nbsp":"") +" is empty! </h1>");
		}

		responceWriter.close();
	}

}
