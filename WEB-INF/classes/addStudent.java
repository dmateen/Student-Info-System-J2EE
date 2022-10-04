import java.lang.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class addStudent extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false);
			if(session!=null){
		try{
			
			//-------- Retriving Data from Page --------
			String Fname=request.getParameter("studentFirstName");
			String Lname=request.getParameter("studentLastName");
			String fatherName=request.getParameter("studentFatherName");
			String gender=request.getParameter("studentGender");
			String phone=request.getParameter("studentPhone");
			String address=request.getParameter("studentAddress");
			String city=request.getParameter("studentCity");
			String email=request.getParameter("studentEmail");
			String hifz=request.getParameter("studentHafizQuran");
			String degree=request.getParameter("studentDegree");
			//-------- Retriving Data from Page --------
			
			//-------- HTML & Body -------//
			//out.println("<html><head><head/><body>");
			RequestDispatcher rdOne = request.getRequestDispatcher("template.jsp");
                rdOne.include(request, response);
			//-------- HTML & Body -------//
			
		/*	out.println(Fname);
			out.println(Lname);
			out.println(fatherName);
			out.println(gender);
			out.println(phone);
			out.println(address);
			out.println(city);
			out.println(email);
			out.println(hifz);
			out.println(degree);*/
		
			//-------- Duplicate Email & Phone Handling --------
			
			//-------- Duplicate Email & Phone Handling --------
			
			//-------- Student DAO Function --------
			studentDAO stu=new studentDAO();
			//-------- Student DAO Function --------
			
			//-------- Duplicate Email & Phone Handling --------
					
			//-------- Executing Query to Email & ID --------
			boolean emailCheck=false,phoneCheck=false;
			
			emailCheck=stu.checkDuplicateEmail(email);
			phoneCheck=stu.checkDuplicatePhone(phone);
			
			if(phoneCheck)
				out.println("Error; Phone Already Exsists.<br>");
			if(emailCheck)
				out.println("Error; Email Already Exsists.<br>");
			
			if(emailCheck || phoneCheck)
				out.println("<a href=\"addStudent.jsp\">Click Here to Add Student again.</a>");
			//-------- Executing Query to Email & ID --------
			
		
			if(!emailCheck && !phoneCheck){
			String fullRollNumber= stu.giveRollNumber(degree);
			
				
			//-------- Retriving Data from Page --------	
			
			//-------- Retriving Data from Page --------
			
			int rs= stu.addStudent(fullRollNumber,Fname,Lname,fatherName,gender,phone,address,city,email,hifz,degree);
			
			if(rs > 0){
				out.println("<p>Record Inserted Successfully</p>");
				//RequestDispatcher rdAdd = request.getRequestDispatcher("dashboard.jsp");
                //rdAdd.include(request, response);
			}
			else{
				out.println("Record could not inserted.");
			}
			//-------- Executing Query --------
		
			}//End of Already Exsist if
		
			//-------- HTML & Body -------//
			out.println("</div></body></html>");
			//-------- HTML & Body -------//
		
		}//End of Try
		catch(SQLException obj){
			out.println("<h1> SQL Occured</h1>");
		}
		catch(Exception obj)
		{
			out.println("<h1> Exception Occured</h1>");
		}
			}//End of Checking Session
			else{
					out.println("<h1> Session Expired.You are not allowed to visit this page</h1>");
				
			}
		
		
		out.close();
		

		
	}//End of DoPOst
	
	
	//public static void main(String args[])
	//{
	//}
} //End of class