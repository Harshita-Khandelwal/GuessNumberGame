import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
public class GameServlet extends HttpServlet
{
	private int c=1,n;
	private PrintWriter out;
	private HttpServletResponse res;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		out=response.getWriter();
		res=response;
		out.print("<html>");
		out.print("<body background=\"game.png\"><center>");
		out.print("<font face=\"verdana\" size=\"2\" color=\"blue\">");
		Cookie c1[]=request.getCookies();
		if(c1!=null)//since this is written before checking of AA that's why work properly in playagain apne aap... bcoz n=0,c=1will happen in AA and so previous value of cookie will be overwritten and it will work properly in playagain also
		{
			for(int i=0;i<c1.length;i++)
			{
				Cookie t=c1[i];
				if(t.getName().equals("n"))
				{
					n=Integer.parseInt(t.getValue());
				}
				else if(t.getName().equals("c"))
				{
					c=Integer.parseInt(t.getValue());
				}
			}
		}
		if(request.getParameter("yes")==null && request.getParameter("no")==null) //AA
		{
			c=1;
			n=0;
			changeLabel();
		}
		else if(request.getParameter("yes")!=null && request.getParameter("yes").equals("yes")==true)
		{
			chosen_no();
			c=c*2;
			changeLabel();
		}
		else if(request.getParameter("no")!=null && request.getParameter("no").equals("no")==true)
		{
			c=c*2;
			changeLabel();
		}
		out.print("</font></center></body>");
		out.print("</html>");
	}
	public void changeLabel()
	{
		int j,count=0;
		String s="";
		for(int i=0;i<64;i++)
		{
			j=i & c;
			if(count==0)
			{
				if(j==c)
				{
					s=""+i;
					count=1;
				}
			}
			else
			{
				if(j==c)
				{
					s=s+","+i;
				}
			}
		}
		if(c==64)
		{
			display_no();
		}
		else
		{
			out.print("Does your No exist In This List ?");
			out.print(s);
			out.print("<br><br>");
			out.print("<form method=\"get\" action=\"GS\">");
			String an,xc;
			an=n+"";
			xc=c+"";
			Cookie a=new Cookie("n",an);
			Cookie b=new Cookie("c",xc);
			res.addCookie(a);
			res.addCookie(b);
			out.print("<input type=\"submit\" name=\"yes\" value=\"yes\">      ");
			out.print("       <input type=\"submit\" name=\"no\" value=\"no\">");
			out.print("</form>");
		}
	}
	public void chosen_no()
	{
		n=n+c;
	}
	public void display_no()
	{
		out.print("Your no is:"+n);
		out.print("<br><br>");
		out.print("<form method=\"get\" action=\"GS\">");
		out.print("<input type=\"submit\" name=\"PlayAgain\" value=\"Play Again\">");
		out.print("</form>"); 
	}
}