package com.pack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssuedDao {
	
	
	public static int IssueBook(IssuedBean issuebean)
	{
		int status=0;
		if(checkIssue(issuebean.getCallNo()))
		{
		Connection con=null;
		try
		{
			con=DB.getconnection();
		PreparedStatement ps=con.prepareStatement("Insert Into E_ISSUEBOOK(CALLNO,STUDENTNAME,STUDENTID,MOBILE,RETURNSTATUS,STARTDATE) Values(?,?,?,?,?,?)");
	    ps.setString(1,issuebean.getCallNo());
	    ps.setString(2,issuebean.getStudentName());
	    ps.setInt(3,issuebean.getStudentId());
	    ps.setString(4, issuebean.getMobile());
	    ps.setString(5,"No");
	    Date currentdate=new Date(System.currentTimeMillis());
	    ps.setDate(6, currentdate);
	    status=ps.executeUpdate();
	    
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		}
		
	    if(status>0)
	    {
	    	Connection con=null;
	    	try
	    	{
	    		con=DB.getconnection();
	    	PreparedStatement ps1=con.prepareStatement("Update E_BOOK1 set Issued=? where Callno=?");
	    	ps1.setInt(1, getIssued(issuebean.getCallNo())+1);
	        ps1.setString(2,issuebean.getCallNo());
	    status=ps1.executeUpdate();
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	    }
		return status;
		}
	
		public static boolean checkIssue(String callno)
	{
		boolean status=false;
		Connection con=null;
	PreparedStatement ps;
		try {
			
			con=DB.getconnection();
			ps = con.prepareStatement("Select * from E_BOOK1 where Callno=? and 'Quantity'>'Issued' ");
			ps.setString(1,callno);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				status=true;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return status;
	    }
		public static int getIssued (String Callno)
		{
			int issued = 0;
			Connection con=null;
			PreparedStatement ps;
				try {
					con=DB.getconnection();
					ps = con.prepareStatement("Select Issued from E_BOOK1 where Callno=?");
					ps.setString(1,Callno);
					ResultSet rs= ps.executeQuery();
					while(rs.next())
					{
					
				  		issued=rs.getInt("Issued");
				  		
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					return issued;
		            }
		public static List<IssuedBean> ViewIssuedBook()
		{
			List<IssuedBean> IssueBookList=new ArrayList<IssuedBean>();
			Connection con=null;
			con=DB.getconnection();
			try
			{
			PreparedStatement ps=con.prepareStatement("Select * From E_ISSUEBOOK");
			ResultSet rs = ps.executeQuery();
		  	while(rs.next()) {
		  		IssuedBean bean= new IssuedBean();
		  		bean.setCallNo(rs.getString("CallNo"));
		  		bean.setStudentName(rs.getString("StudentName"));
		  		bean.setReturnstatus(rs.getString("Returnstatus"));
		  		bean.setStudentId(rs.getInt("StudentId"));
		  		bean.setMobile(rs.getString("MOBILE"));
		  		
		  		bean.setDate(rs.getDate("StartDate"));
		  		IssueBookList.add(bean);
		  	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return IssueBookList;
		}

		public static int ReturnBook(String callno, String sid) {
			int status=0;
			Connection con=null;
			con=DB.getconnection();
			try
			{
			if(setIssued(callno))
			{
				PreparedStatement ps=con.prepareStatement("Update E_ISSUEBOOK set ReturnStatus='yes' where CallNO=? and StudentId=?");	
		        ps.setString(1, callno);
		        ps.setString(2, sid);
		        status=ps.executeUpdate();
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			if(status>0)
			{
			try
			{
				PreparedStatement ps=con.prepareStatement("Update E_BOOK1 set Issued=? where CallNo=?");
				ps.setInt(1, (changeIssued(callno))-1);
				ps.setString(2, callno);
				status=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}
			return status;
		}
		
		public static boolean setIssued(String callno)
		{
					
			
			boolean status=false;
			Connection con=null;
			con=DB.getconnection();
			try
			{
			PreparedStatement ps=con.prepareStatement("Select * From E_BOOK1 Where CallNo=? and Issued>'0' ");
			ps.setString(1, callno);
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
		public static int changeIssued(String callno)
		{
			
			int issued=0;
			Connection con=null;
			con=DB.getconnection();
			try
			{
			PreparedStatement ps=con.prepareStatement("Select Issued From E_BOOK1 Where CallNo=?");
			ps.setString(1, callno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			issued=rs.getInt("Issued");
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return issued;
			}
}