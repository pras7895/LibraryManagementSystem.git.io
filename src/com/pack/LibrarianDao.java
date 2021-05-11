package com.pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.LibrarianBean;
public class LibrarianDao
{
	
	public static List<LibrarianBean> view()
	{
		List<LibrarianBean>LibrarianList=new ArrayList<LibrarianBean>();
		Connection con=DB.getconnection();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from E_LIBRARIAN");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				LibrarianBean bean=new LibrarianBean();
				bean.setId(rs.getInt("Id"));
				bean.setName(rs.getString("Name"));
				bean.setEmail(rs.getString("Email"));
				bean.setPassword(rs.getString("Password"));
				bean.setMobile(rs.getString("Mobile"));
				LibrarianList.add(bean);
				
			}
		}
 catch (SQLException e) {
			// TODO Auto-generated catch block
			
	 	
		}
		return LibrarianList;
		
		
		/* LibrarianBean l1=new LibrarianBean(1,"Prashant","prashantcool9211@gmail.com","pras@123","7895444606");
		LibrarianBean l2=new LibrarianBean(2,"Swapan","swapancool9211@gmail.com","swapan@123","7895444605");
		LibrarianBean l3=new LibrarianBean(3,"preet","preetcool9211@gmail.com","preet@123","7895444654");
		LibrarianBean l4=new LibrarianBean(4,"viaks","vikascool9211@gmail.com","vikas@123","7895444633");
		LibrarianBean l5=new LibrarianBean(5,"ashu","ashucool9211@gmail.com","ashu@123","7895444632");
		LibrarianBean l6=new LibrarianBean(6,"sumit","sumitcool9211@gmail.com","sumit@123","7895444206");
		LibrarianList.add(l1);
		LibrarianList.add(l2);
		LibrarianList.add(l3);
		LibrarianList.add(l4);
		LibrarianList.add(l5);
		LibrarianList.add(l6); */
		
		
	}

	public static int save(LibrarianBean bean)  {
		
			int status=0;
			Connection con=DB.getconnection();
				try
				{
				PreparedStatement	ps = con.prepareStatement("Insert into E_LIBRARIAN(Name,Email,Password,Mobile) Values(?,?,?,?)");
				
				ps.setString(1, bean.getName());
				ps.setString(2, bean.getEmail());
				ps.setString(3, bean.getPassword());
				ps.setString(4, bean.getMobile());
				status=ps.executeUpdate();
				System.out.println("Name="+bean.getName());
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		
		return status;
	}

	public static LibrarianBean viewById(int id) {
		LibrarianBean bean= null;
		Connection con=DB.getconnection();
		try {
			PreparedStatement ps=con.prepareStatement("Select * From E_LIBRARIAN where id=?");
			ps.setInt(1,id);
		  	ResultSet rs = ps.executeQuery();
		  	while(rs.next()) {
		  		bean= new LibrarianBean();
		  		bean.setId(rs.getInt("ID"));
		  		bean.setName(rs.getString("NAME"));
		  		bean.setEmail(rs.getString("EMAIL"));
		  		bean.setPassword(rs.getString("PASSWORD"));
		  		bean.setMobile(rs.getString("MOBILE"));
		  	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}

	public static int delete(int id) {
		// TODO Auto-generated method stub
		Connection con=DB.getconnection();
		int status=0;
		try {
			
			String Query="delete from E_LIBRARIAN where Id=?";
			PreparedStatement ps=con.prepareStatement(Query);
		  ps.setInt(1,id);
		  status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public static int update(LibrarianBean bean) 
	{
		// TODO Auto-generated method stub
			int status=0;
			Connection con=DB.getconnection();
				try
				{
				PreparedStatement	ps = con.prepareStatement("Update E_LIBRARIAN SET Name=?,Email=?,Password=?,Mobile=? where Id=?");
	            ps.setString(1, bean.getName());
				ps.setString(2, bean.getEmail());
				ps.setString(3, bean.getPassword());
				ps.setString(4, bean.getMobile());
				ps.setInt(5, bean.getId());
				status=ps.executeUpdate();
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		
		return status;
			
		}

	public static List<LibrarianBean> search(String searchtext) {
		// TODO Auto-generated method stub
		Connection con=DB.getconnection();
		List<LibrarianBean> bean=null;
		try
		{
			PreparedStatement	ps = con.prepareStatement("Select * from E_LIBRARIAN Where Name Like '%?%' or Email Like '%?%' ");
	       ps.setString(1, searchtext);
	       ps.setString(2, searchtext);
	       	    ResultSet rs=ps.executeQuery();
	       	    }
	
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return bean;
	
	}

public static boolean Authenticate(String Email,String Password)
{
	boolean status=false;
	Connection con=null;
	try
	{
	   con=DB.getconnection();
	   PreparedStatement ps=con.prepareStatement("Select * from E_LIBRARIAN Where Email=? and Password=?");
	   ps.setString(1, Email);
	   ps.setString(2, Password);
	   ResultSet rs=ps.executeQuery();
	   while(rs.next())
	   {
		   status=true;
	   }
	   }
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	
return status;	
}

}		


	
