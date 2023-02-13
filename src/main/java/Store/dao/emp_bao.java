package Store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Store.bo.emp_bo;
import Store.bo.store_bo;

public class emp_bao 
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
	public static int signup(emp_bo em) {
		
		int status=0;
		try
		{
			Connection con =emp_bao.getConnection();
			String sql="insert into signup(name,email,number,password)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,em.getName());
			ps.setString(2,em.getEmail());
			ps.setString(3,em.getNumber());
			ps.setString(4,em.getPassword());
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return status;
	}
	public static boolean userLogin(String email, String password)
	{
		boolean status = false;
		
		try 
		{
			Connection con =emp_bao.getConnection();
			String sql="select * from signup where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (Exception m)
		{
			System.out.println(m);
		}
		return status;
	}
	public static int addowner(store_bo em)
	{
		int status=0;
		try
		{
			Connection con =emp_bao.getConnection();
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
		Connection con =emp_bao.getConnection();
		String owner="select * from addowner";
		PreparedStatement ps=con.prepareStatement(owner);
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

	

}
