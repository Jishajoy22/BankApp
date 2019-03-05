package P1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet
{
	String userid;
	String pwd;
	boolean value;
	int accno;
	HttpSession session;
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		userid=request.getParameter("userid");
		pwd=request.getParameter("pwd");
		
		Model m=new Model();
		m.setPwd(pwd);
		m.setUserid(userid);
		
		try
		{
			value=m.login();
			accno=m.getAccno();
			if(value==true)
			{
				session=request.getSession(true);
				session.setAttribute("accno",accno);
				response.sendRedirect("/Bank/Home.jsp");
			}
			else
			{
				response.sendRedirect("/Bank/loginfail.jsp");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	