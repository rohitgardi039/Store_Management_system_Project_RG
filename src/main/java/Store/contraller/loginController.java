package Store.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import Store.dao.emp_bao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("email");				 
		 String password=request.getParameter("password");
		 
		 
		 if(emp_bao.userLogin(email,password))
		 {
			
			 RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			 rd.forward(request, response);
		 }
		 else
		 {
			 pw.print("worong");
			 RequestDispatcher rd=request.getRequestDispatcher("login.html");
			 rd.include(request, response);
		 }
	}

}
