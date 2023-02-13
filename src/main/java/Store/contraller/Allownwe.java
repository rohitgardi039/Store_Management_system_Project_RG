package Store.contraller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Store.bo.store_bo;
import Store.dao.store_bao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Allownwe
 */
@WebServlet("/Allownwe")
public class Allownwe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Allownwe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		pw.print("<link rel='stylesheet' href='css/table.css'>");
		pw.print("<a href='Home.html'>Back</a>");
		
		 pw.print("<table border='1px' width='100%'>");
		 pw.print("<tr> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining</th> <th> Date Of Birth</th> <th> Adhar Details</th><th> Action</th><th> Action</th></tr>");
	
	  List<store_bo> list=store_bao.getAllownwe();
			  
			  for(store_bo eb:list)
				  
			  {
				  pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getDob()+"</td><td>"+eb.getAdhar()+"</td>  <td><a href='EditOwner?id="+eb.getId()+"'>edit</a></td>   <td><a href='DeleteController?id="+eb.getId()+"'>delete</a></td></tr>");
	
	}

	}
}
