package com.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditLibrarianForm
 */
@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLibrarian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String sid=request.getParameter("Id");
         int Id=Integer.parseInt(sid);
         String name=request.getParameter("Name");
 		String email=request.getParameter("Email");
 		String password=request.getParameter("Password");
 		String mobile=request.getParameter("Mobile");
 		LibrarianBean bean=new LibrarianBean(Id,name,email,password,mobile);
 		int status;
 			status = LibrarianDao.update(bean);
 			System.out.println("status="+status);
 			response.sendRedirect("ViewLibrarianServlet");
 		
	}
		
		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
