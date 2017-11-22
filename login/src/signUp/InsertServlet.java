package signUp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String strEmail=request.getParameter("useremail");
		String strPass=request.getParameter("userpass");
		String strConfirmPass=request.getParameter("confirm_pass");
		
		
		if(strConfirmPass.equals(strPass) && SignUpDao.save(strEmail, strPass))
		{
			RequestDispatcher rd=request.getRequestDispatcher("login");
			rd.forward(request,response);
		}
		
		else
		{
			if(!strConfirmPass.equals(strPass))
				out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>Passwords do not match.</b>"
					+ "</div>");
			else
				out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>That email address is already in use. Please try another.</b>"
					+ "</div>");
			
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request,response);	
		}
		
		out.close();
	}

}