package P1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Balance extends HttpServlet
{
	HttpSession session;
	int accno;
	boolean value;
	int balance;
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		session=request.getSession();
		accno=(int)session.getAttribute("accno");
			
		try
		{
			Model m=new Model();
			m.setAccno(accno);
			value=m.balanceCheck();
			balance=m.getBalance();
			session.setAttribute("balance",balance);
			if(value==true)
			{
				response.sendRedirect("/Bank/balance.jsp");
			}
			else
			{
				response.sendRedirect("/Bank/balancefail.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
}