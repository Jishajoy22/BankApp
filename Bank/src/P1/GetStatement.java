package P1;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetStatement extends HttpServlet
{
	int accno;
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
	try
	{
		ArrayList al=new ArrayList();
		
		if(al==null)
		{
			response.sendRedirect("/Bank/getstatementfail.jsp");
		}
		else
		{
			session.setAttribute("al",al);
			response.sendRedirect("/Bank/getstatementsuccess.jsp");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	
	}
	//public void service(HttpServletRequest request,)
}