package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.User;
import com.util.UserManager;
import com.util.book;
import com.util.bookManager;

@WebServlet("/books")
public class books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       bookManager um;
       UserManager uma;
 
    public books() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		um=new bookManager();
		uma=new UserManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		
		User ut=(User) ses.getAttribute("user");
		out.print("<h1>Bonjour Mr. "+ut.getLog()+" vous eteS connecté entant que "+ut.getRole());
		if(request.getParameter("op")!=null)
		{
			if(request.getParameter("op").equals("delete"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				um.deleteBook(id);
			}
			
			
		}
		
		
		List<book> us=um.allBooks();
		out.print("<table width='60%' bgcolor='gold' border='2'>");
		out.print("<thead><th>ID</th><th>Name</th><th>Author</th><th>Category</th><th></th></thead>");
		for (book u : us) {
			
			out.print("<tbody>");
			out.print("<tr>");
			out.print("<td>"+u.getId()+"</td>");
			out.print("<td>"+u.getName()+"</td>");
			out.print("<td>"+u.getAuthor()+"</td>");
			out.print("<td>"+u.getCategory()+"</td>");
			if(ut.getRole().equalsIgnoreCase("admin"))
			out.print("<td><a href='?op=delete&id="+u.getId()+"'>delete</a></td>");
			
			out.print("</tr>");
			out.print("<tbody>");
		}
		out.print("</table>");
	}
	

}
