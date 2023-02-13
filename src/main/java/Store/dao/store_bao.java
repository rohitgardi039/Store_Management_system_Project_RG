package Store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Store.bo.store_bo;

public class store_bao 
{
	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/employeemanagementproject";
			String username="root";
			String password="rohit";
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection(url,username,password);
			
	         
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
	}
	

	public static int addowner(store_bo em)
	{
		int status=0;
		try
		{
			Connection con =store_bao.getConnection();
			String Quary="insert into addowner(name,email,phone,doj,dob,adhar)values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(Quary);
			ps.setString(1,em.getName());
			ps.setString(2,em.getEmail());
			ps.setString(3,em.getPhone());
			ps.setString(4,em.getDoj());
			ps.setString(5,em.getDob());
			ps.setString(6,em.getAdhar());
			
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return status;
	}
	public static List getAllownwe()
	{
		List<store_bo>List=new ArrayList<store_bo>();
		try
		{
		Connection con =store_bao.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from addowner");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			store_bo eb=new store_bo();
			eb.setId(rs.getInt(1));
			eb.setName(rs.getString(2));
			eb.setEmail(rs.getString(3));
			eb.setPhone(rs.getString(4));
			eb.setDoj(rs.getString(5));
			eb.setDob(rs.getString(6));
			eb.setAdhar(rs.getString(7));
			
			List.add(eb);
			
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return List;
		
	}
	public static boolean getOwnerById(int id)
	{
		store_bo eb=null;
		try 
		{
			Connection con =store_bao.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select * from addowner where id=?");
			
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));
				eb.setAdhar(rs.getString(7));
				
			}
	
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
		

}
	public static store_bo getStoreById(int id) 
	{
		store_bo eb = new store_bo();
		
		try
		{
			Connection con =store_bao.getConnection();
			
			String query = "select * from addowner where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				eb.setId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setEmail(rs.getString(3));
				eb.setPhone(rs.getString(4));
				eb.setDoj(rs.getString(5));
				eb.setDob(rs.getString(6));
				eb.setAdhar(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error occure ::"+e);
		}
	return eb;	
}	
public static int delete(int id)
{		
	int status=0;
	 try
	 	{		
			  Connection con =store_bao.getConnection();
			  String elete="Delete from addowner where id=?";
			  PreparedStatement ps=con.prepareStatement(elete);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
			  
		}
		  catch (Exception e)
		  {		
			   System.out.println(e);
		  }		
		return status;	
	}
}