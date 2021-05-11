package com.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToStore
 */
@WebServlet("/AddToStore")
public class AddToStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String callno=request.getParameter("Callno");
	String name=request.getParameter("Name");
	String publisher=request.getParameter("Publisher");
	String author=request.getParameter("Author");
	String sq=request.getParameter("Quantity");
	int quantity=Integer.parseInt(sq);
	BookBean bean=new BookBean(callno,name,publisher,author,quantity);
	int status;
	status=BookDao.save(bean);
	RequestDispatcher rd=request.getRequestDispatcher("addbookform.jsp");
	rd.forward(request, response);
	if(status>0)
	{
		request.setAttribute("successmsg", "Add book successfully");
	}
	else
	{
		request.setAttribute("errormsg", "Please try again!!");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
