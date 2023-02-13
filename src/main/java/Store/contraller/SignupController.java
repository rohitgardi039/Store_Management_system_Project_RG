package Store.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import Store.bo.emp_bo;
import Store.dao.emp_bao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");		
		 String number=request.getParameter("number");
		 String password=request.getParameter("password");
		 
		 //pw.print(name+" "+email+" "+number+" "+password);
		
		 emp_bo em=new emp_bo();
		 em.setName(name);
		 em.setEmail(email);
		 em.setNumber(number);
		 em.setPassword(password);
		 
		 int status=emp_bao.signup(em);
		 
		 if(status>0)
		 {
			 pw.print("scussess");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			 rd.forward(request, response);
		 }
		 else
		 {
			 pw.print("somthing went rong...!!");
			 RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		 }
		 
	}

}
