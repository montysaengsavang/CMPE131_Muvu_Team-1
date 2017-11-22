package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("useremail");
		String p=request.getParameter("userpass");
		if(LoginDao.validate(n, p)){
			RequestDispatcher rd = request.getRequestDispatcher("loggedin");
			rd.forward(request,response);
		}
		else{
			out.print("<br><div style=\"text-align:center; color:red; font-size:90%\">"
					+ "<b>Your e-mail address or password is incorrect. Please try again.</b>"
					+ "</div>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		
		out.close();
	}

}
