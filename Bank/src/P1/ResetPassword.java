package P1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetPassword extends HttpServlet
{
	String opwd;
	String npwd;
	boolean value;
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		opwd=request.getParameter("opwd");
		npwd=request.getParameter("npwd");
		Model m=new Model();
		m.setPassword(opwd);
		try
		{
		value=m.resetPassword(npwd);
		if(value==true)
		{
			response.sendRedirect("/Bank/resetsuccess.html");
		}
		else
		{
			response.sendRedirect("/Bank/resetfail.html");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
	
}
