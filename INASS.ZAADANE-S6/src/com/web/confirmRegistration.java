package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.User;
import com.util.UserManager;

@WebServlet(
		description = "un test de servlet", 
		urlPatterns = { 
				"/Test", 
				"/pop"
		})
public class confirmRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
       
       UserManager um;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmRegistration () {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
	   String lg=request.getParameter("log");
	   String ps=request.getParameter("pass");
	   String ps2=request.getParameter("pass2");
	   HttpSession ses = request.getSession(true);

	
	   if(lg!=null&&ps!=null&&ps2!=null)
	   {
		 um.addUser(lg,ps,"guest");
		   
		   ses.setAttribute("user", um);
		   
		   response.sendRedirect("books.jsp");
	   }else
		  
		   {
		
		   	response.sendRedirect("register.jsp");
		   }
		
		
		
		
		
	}

	

	
}
