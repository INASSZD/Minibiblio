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

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserManager um;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		um=new UserManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
		out.print(" <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback\">");
			
				out.print(" <link rel=\"stylesheet\" href=\"plugins/fontawesome-free/css/all.min.css\">");
				
						out.print("<link rel=\"stylesheet\" href=\"dist/css/adminlte.min.css\">");
		User ut=(User) ses.getAttribute("user");
		

		
		out.print("<h1 style='text-align:center'>List Users </h1>");
	
		if(request.getParameter("op")!=null)
		{
			if(request.getParameter("op").equals("delete"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				um.deleteUser(id);
			}
			
			
		}
		
			
		List<User> us=um.allUsers();
		out.print("<table width='60%' class='table table-dark' >");
		out.print("<thead><th>ID</th><th>Login</th><th>Password</th><th>Role</th><th>delete</th><th>Action</th></thead>");
		for (User u : us) {
			
			out.print("<tbody>");
			out.print("<tr class='table-active'>");
			out.print("<td>"+u.getId()+"</td>");
			out.print("<td>"+u.getLog()+"</td>");
			out.print("<td>"+u.getPass()+"</td>");
			out.print("<td>"+u.getRole()+"</td>");
			if(ut.getRole().equalsIgnoreCase("admin"))
			out.print("<td><a href='?op=delete&id="+u.getId()+"'>delete</a></td>");
			out.print("<td><a href='?op=edit&id="+u.getId()+"'>edit</a></td>");
			out.print("</tr>");
			out.print("<tbody>");
			
		}
		
		out.print("  <form  action='Adduser' method='post' > <div class='row col-md-9 offset-md-1'> "
				+"<div class='col'><h5> add new user</h5></div>"
				+" <div class='col'> <input type='text' name='log' class='form-control' placeholder=\"username\">"
				+ " </div><div class=\"col\"> <input name='pass'  class=\"form-control\" placeholder=\"password\">"
				+ "</div><div class=\"col\"> <input type=\"text\" name=\"role\" class=\"form-control\" placeholder=\"role\"> "
				
				+ "</div> <button type=\"submit\" class=\"btn btn-primary\">valider</button></div> </form>");
		out.print("<br><br> ");
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession();
	out.print("</table action='Adduser' method='post'>");
	out.print("<br >");
	out.print("<form >");
	out.print("<input type='text' name='log' placeholder='enter new name' >");
	out.print("<input type='password' name='pass' placeholder='enter a password' >");
	out.print("<select  name='role'><option name='admin'>admin</option><option name='guest'>guest</option></select>");
	out.print("<input type='submit'value='valider' />" );
	out.print("<form />" );
	
	

}}