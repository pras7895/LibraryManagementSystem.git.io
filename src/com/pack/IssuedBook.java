package com.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IssuedBook
 */
@WebServlet("/IssuedBook")
public class IssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuedBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callno=request.getParameter("CallNo");
		String studentname=request.getParameter("StudentName");
		String sid=request.getParameter("StudentId");
	    int id=Integer.parseInt(sid);
	    String mobilename=request.getParameter("MobileNumber");
	    IssuedBean issuebean=new IssuedBean(callno,studentname,id,mobilename);
	    int status=IssuedDao.IssueBook(issuebean);
	    System.out.println("status="+status);
	    RequestDispatcher rd=request.getRequestDispatcher("issuebookform.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
