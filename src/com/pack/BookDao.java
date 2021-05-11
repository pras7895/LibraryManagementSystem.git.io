package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
public static int save(BookBean bean)
{
	int status=0;
	Connection con=null;
	try
	{
		con=DB.getconnection();
    PreparedStatement ps=con.prepareStatement("Insert INTO E_BOOK1(CAllNO,NAME,PUBLISHERNAME,AUTHORNAME,QUANTITY) VALUES(?,?,?,?,?)");
	ps.setString(1, bean.getCallno());
	ps.setString(2, bean.getName());
	ps.setString(3, bean.getPublisher());
	ps.setString(4, bean.getAuthor());
	ps.setInt(5, bean.getQuantity());
	status=ps.executeUpdate();
	}
	catch(SQLException e)
	{
	e.printStackTrace();	
	}
	return status;
}
	
	public static List<BookBean> View()
	{
		List<BookBean> Bookbean=new ArrayList<BookBean>();
		Connection con=null;
		try
		{
			con=DB.getconnection();
		PreparedStatement ps=con.prepareStatement("Select * From E_BOOK1");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			BookBean bean=new BookBean();
			bean.setCallno(rs.getString("Callno"));
			bean.setName(rs.getString("Name"));
			bean.setPublisher(rs.getString("PublisherName"));
			bean.setAuthor(rs.getString("AuthorName"));
			bean.setQuantity(rs.getInt("Quantity"));
			bean.setIssued(rs.getInt("Issued"));
			Bookbean.add(bean);
			}
		}
		catch(SQLException e)
		{
			
		e.printStackTrace();
		}
		return Bookbean;	
		}
}