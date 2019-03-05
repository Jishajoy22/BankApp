package P1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transfer extends HttpServlet
{
	String amt1;
	int amt;
	int accno;
	boolean value;
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		amt1=request.getParameter("amt");
		amt=Integer.parseInt(amt1);
		HttpSession session=request.getSession();
		accno=(int)session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		try
		{
			value=m.amountTransfer(amt);
			if(value==true)
			{
				response.sendRedirect("/Bank/transfersuccess.html");
			}
			else
			{
				response.sendRedirect("/Bank/transferfail.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}