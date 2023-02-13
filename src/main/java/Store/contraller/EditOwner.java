package Store.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import Store.bo.store_bo;
import Store.dao.store_bao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditOwner
 */
@WebServlet("/EditOwner")
public class EditOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditOwner() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
         
	      int eid= Integer.parseInt(id);
	    
	      store_bo eb=  store_bao.getStoreById(eid)  ;
	    
	      pw.print("<form  action='Updatecontroller' method='get'> ");
		    
			pw.print("<table>");
			pw.print("<tr><td></td><td><input type='hidden' name='account_id' value='"+eb.getId()+"'/></td></tr>");  
			pw.print("<tr><td>Name: </td> <td><input type='text'  name='client_name'  value='"+eb.getName()+"'/></td></tr>");
			pw.print("<tr><td>Email : </td> <td><input type='text'  name='contact_name'  value='"+eb.getEmail()+"'/></td></tr>");
		   	pw.print("<tr><td>Phone:</td> <td><input type='text'  name='phone' value='"+eb.getPhone()+"'/></td></tr>");
		   	pw.print("<tr><td>DOJ: </td> <td><input type='text'  name='city' value='"+eb.getDoj()+"'/></td></tr>");
		   	pw.print("<tr><td>DOB: </td> <td><input type='text'  name='state' value='"+eb.getDob()+"'/></td></tr>");
		   	pw.print("<tr><td>ADHAR: </td> <td><input type='text'  name='country' value='"+eb.getAdhar()+"'/></td></tr>");
		    pw.print("<tr><td><input type='submit' value='Update '/></td></tr>"); 
		   	pw.print("</table>");
			pw.print("</form>");
	}

}
