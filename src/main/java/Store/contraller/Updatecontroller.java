package Store.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.Store;

import Store.bo.store_bo;
import Store.dao.store_bao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatecontroller
 */
@WebServlet("/Updatecontroller")
public class Updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Updatecontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		 String email=request.getParameter("email");		
		 String phone=request.getParameter("phone");
		 String doj=request.getParameter("doj");
		 String dob=request.getParameter("dob");		
		 String adhar=request.getParameter("adhar");
		 
		 
		 
		 store_bo rt=new store_bo(name, email, phone, doj, dob, adhar);
		 
		 
		 
		 
		 
		 int status = store_bo.Update(rt);
		 
		 System.out.println("updatedController:");
		 
		 if(status>0) 
		 {
			 
			 System.out.println("Data updated");
      	   
			 RequestDispatcher rd=request.getRequestDispatcher("Allownwe");
       	     rd.forward(request, response);
       	    
         }
	}

}