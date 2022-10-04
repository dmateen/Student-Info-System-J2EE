import java.lang.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class logout extends HttpServlet{

 public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
 {
	 PrintWriter out = response.getWriter();
	HttpSession session = request.getSession(false);
			if(session!=null){
				session.invalidate();
				response.sendRedirect("index.html");  
				
			}//End of Checking Session
			else
			{
				out.println("Session Expired. Not Allowed to Visit this Page");
			}
   
 }
}















