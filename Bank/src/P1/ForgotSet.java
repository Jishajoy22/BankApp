package P1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotSet extends HttpServlet
{
	boolean value;
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		String pwd=request.getParameter("npw");
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		
	Model m=new Model();
	m.setPassword(pwd);
	m.setEmail(email);
	try
	{
	if(value==true)
	{
		response.sendRedirect("/Bank/forgotsuccess.html");
	}
	else
	{
		response.sendRedirect("/Bank/forgotfail.html");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}