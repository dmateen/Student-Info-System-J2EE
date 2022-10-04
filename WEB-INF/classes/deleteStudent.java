import java.lang.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class deleteStudent extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false);
			if(session!=null){
		try{
			
			//--------  JDBC Connection --------  
		
			//-------- Retriving Data from Page --------
			String roll=request.getParameter("studentRollNumber");
			//-------- Retriving Data from Page --------
			
			//-------- HTML & Body -------//
			RequestDispatcher rdOne = request.getRequestDispatcher("template.jsp");
				rdOne.include(request,response);
			//-------- HTML & Body -------//
				
			
			//-------- Deleting Data --------
			studentDAO stu=new studentDAO();
			
			int rs = stu.deleteStudent(roll);
			if(rs > 0){
				out.println("Record Deleted successfully.");
			}
			else{
				out.println("No Student Found");
			}
			//-------- Deleting Data --------
			
			//-------- HTML & Body -------//
			out.println("</body></html>");
			//-------- HTML & Body -------//
		
		}//End of Try
		catch(Exception obj)
		{
			out.println("<h1> Exception Occured</h1>");
		}
			}//end of session check
			else{
				out.println("Session Expired. Not Allowed to Visit this Page");
			}
		
		out.close();
		

		
	}//End of DoPOst
	
	
	//public static void main(String args[])
	//{
	//}
} //End of class