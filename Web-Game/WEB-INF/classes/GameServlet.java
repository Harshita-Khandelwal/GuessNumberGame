import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
public class GameServlet extends HttpServlet
{
	private int c=1,n;
	private PrintWriter out;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		out=response.getWriter();
		out.print("<html>");
		out.print("<body background=\"game.png\"><center>");
		out.print("<font face=\"verdana\" size=\"2\" color=\"blue\">");
		if(request.getParameter("yes")==null && request.getParameter("no")==null)
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