import MyPack.*;
import java.lang.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class updateStudent extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			try {

				// -------- Retriving Data from Page --------
				String roll = request.getParameter("studentRollNumber");
				// -------- Retriving Data from Page --------

				session.setAttribute("updateRollNumber", roll);

				RequestDispatcher rdOne = request.getRequestDispatcher("template.jsp");
				rdOne.include(request, response);

				//RequestDispatcher rdJavaScript = request.getRequestDispatcher("/updateJavascript");
				//rdJavaScript.include(request, response);

				out.println("</head><body>");

				ArrayList data = new ArrayList();
				studentDAO stu = new studentDAO();

				data = stu.updateStudent(roll);
				int size = data.size();

				// Retrieve items from ArrayList
				if (size == 0)
					out.println("Student Not Found!");
				else {
					out.println("<table style=\"border:1px solid black;width:100%;\">");
					out.println("<tr>");
					out.println(
							"<th>Roll Number</th> <th>First Name</th> <th>Last Name</th> <th>Father Name</th> <th>Phone</th> <th>City</th> <th>Address</th> <th>Gender</th> <th>  studentEmail</th> <th>Hifz</th> <th>Degree</th>");
					out.println("</tr>");
				}

				int i = 0;
				while (i < size) {
					student obj = (student) data.get(i);

					out.println("<tr>");
					out.println("<td>" + obj.getRoll() + "</td>");
					out.println("<td>" + obj.getFname() + "</td>");
					out.println("<td>" + obj.getLname() + "</td>");
					out.println("<td>" + obj.getFatherName() + "</td>");
					out.println("<td>" + obj.getPhone() + "</td>");
					out.println("<td>" + obj.getCity() + "</td>");
					out.println("<td>" + obj.getAddress() + "</td>");
					out.println("<td>" + obj.getGender() + "</td>");
					out.println("<td>" + obj.getEmail() + "</td>");
					out.println("<td>" + obj.getHifz() + "</td>");
					out.println("<td>" + obj.getDegree() + "</td>");
					out.println("</tr>");
					i++;

				}

				if (size != 0) {
					out.println("</table>");
					RequestDispatcher rdAdd = request.getRequestDispatcher("updateExtendedForm.jsp");
					rdAdd.include(request, response);
				}
				out.println("</body></html>");

			} // End of Try
			catch (NullPointerException obj) {
				out.println("<h1> Null PTR Occured</h1>");
			} catch (SQLException obj) {
				out.println("<h1> SQL Exception Occured</h1>");
			} catch (Exception obj) {
				out.println("<h1> Exception Occured</h1>");
			}
		} // End of Checking Session
		out.close();

	}// End of DoPOst

	// public static void main(String args[])
	// {
	// }
} // End of class