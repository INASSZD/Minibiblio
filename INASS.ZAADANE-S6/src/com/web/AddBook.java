package com.web;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.util.UserManager;
import com.util.bookManager;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   bookManager um;

    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		um=new bookManager();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String category=request.getParameter("category");
		String des=request.getParameter("des");
		
		int nb=um.addBook(name, author, category,des);
		if(nb!=0)
		{
			response.sendRedirect("books.jsp");
		}
		
		
	}

}