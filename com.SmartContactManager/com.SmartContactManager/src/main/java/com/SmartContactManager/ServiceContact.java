package com.SmartContactManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class ServiceContact {

	public List<Contact> getContact() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Gautam@123");
		Statement stmt=con.createStatement();
		String query= "Select * from contacts";
		ResultSet rs=stmt.executeQuery(query);
		List<Contact> list;
		list=new ArrayList<>();
		while(rs.next()) {
			Contact contact=new Contact();
			contact.setId(rs.getInt("id"));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setMobile_number(rs.getString("mobile_number"));
			contact.setWork(rs.getString("work"));
			list.add(contact);
		}
		return list;
	}
	
	
	public HashMap addContact(Contact contact) throws ClassNotFoundException, SQLException
	{
		String name=contact.getName();
		String email=contact.getEmail();
		String mobile_number=contact.getMobile_number();
		String work=contact.getWork();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Gautam@123");	
		String query ="insert into contacts (name,email,mobile_number,work) values(?,?,?,?)";
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setString(1,name);
		stmt.setString(2,email);
		stmt.setString(3,mobile_number);
		stmt.setString(4,work);
		int i=stmt.executeUpdate();
		HashMap map= new HashMap<>();
		System.out.println(mobile_number);
		if(i>=1)
		{
		     map.put("message", "Your Contact is added successfully");
			 return map;
		}
		else
			{
				map.put("message", "Something went wrong, please try again");
				return map;
		}
	
	}
	   
	public HashMap delete(String mobile_number) throws ClassNotFoundException, SQLException
	{
		System.out.println(mobile_number);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Gautam@123");	
		String query ="delete from contacts where mobile_number="+mobile_number+"";
		PreparedStatement stmt= con.prepareStatement(query);
		int i=stmt.executeUpdate();
		HashMap map= new HashMap<>();
		if(i>=1)
		{
		     map.put("message", "Your Contact is deleted successfully");
			 return map;
		}
		else
		{
			map.put("message", "Something went wrong, please try again");
		    return map;
		}
		
	}
	
	public HashMap updateContact(Contact contact) throws ClassNotFoundException, SQLException {
		int id=contact.getId();
		String name=contact.getName();
		String email=contact.getEmail();
		String mobile_number=contact.getMobile_number();
		String work=contact.getWork();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Gautam@123");	
		String query ="update contacts set name=?, email=?,mobile_number=?,work=? where mobile_number="+mobile_number+"";
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setInt(1,id);
		stmt.setString(1,name);
		stmt.setString(2,email);
		stmt.setString(3,mobile_number);
		stmt.setString(4,work);
		int i=stmt.executeUpdate();
		HashMap map= new HashMap<>();
		if(i>=1)
		{
		     map.put("message", "Your Contact is updated successfully");
			 return map;
		}
		else
			{
				map.put("message", "Something went wrong, please try again");
				return map;
		}
	}
	
//	feedback
	
	public Map feedbackForm(Contact contact) throws ClassNotFoundException, SQLException
	{
		   String email=contact.getEmail();
		   String feed=contact.getFeed();
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Gautam@123");	
		   String query ="insert into feedback (email,feed) values(?,?)";
		   PreparedStatement pstmt= con.prepareStatement(query);
		   pstmt.setString(1,email);
		   pstmt.setString(2, feed);
		   int i=pstmt.executeUpdate();
		   HashMap map=new HashMap();
		   if(i>=1)
		   {
			   map.put("message", "your feedback is submitted successfully!! Thank you for your submission.");
		   }
		   else
		   {
			   map.put("message", "OOps, something went wrong please, try again");
		   }
	   return map;	   
	}
	
//	search api
	
	  
	  public HashMap search(Contact req) throws ClassNotFoundException, SQLException
	   {
		   String mobile_number=req.getMobile_number();
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","Gautam@123");
		   Statement stmt=con.createStatement();
		   String query="Select* from contacts where mobile_number='"+mobile_number+"'";
		   ResultSet rs=stmt.executeQuery(query);
		   HashMap map=new LinkedHashMap();
		   if(rs.next())
		   {
			   map.put("Name ", rs.getString("name"));
			   map.put("Email", rs.getString("email"));
			   map.put("Mobile_No", rs.getString("mobile_number"));
			   
		   }
		   else
		   {
			   map.put("Sorry", "contact deatils is not available");
		   }
		   return map;
		   
	   }
}
