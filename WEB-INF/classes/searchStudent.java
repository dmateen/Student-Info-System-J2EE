import MyPack.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class searchStudent extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				// -------- JDBC Connection --------
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1/test";
				Connection con = DriverManager.getConnection(url, "root", "root");
				Statement st = con.createStatement();
				// -------- JDBC Connection --------

				// -------- Retriving Data from Page --------
				String roll = request.getParameter("studentRollNumber");
				String Fname = request.getParameter("studentFirstName");
				String Lname = request.getParameter("studentLastName");
				String fatherName = request.getParameter("studentFatherName");
				String phone = request.getParameter("studentPhone");
				String city = request.getParameter("studentCity");
				String gender = request.getParameter("studentGender");
				String email = request.getParameter("studentEmail");
				String hifz = request.getParameter("studentHafizQuran");
				String degree = request.getParameter("studentDegree");
				String field = request.getParameter("studentField");
				// -------- Retriving Data from Page --------

				ArrayList data = new ArrayList();

				studentDAO stu = new studentDAO();

				// out.println("Here");
				data = stu.searchStudent(roll, Fname, Lname, fatherName, phone, city, gender, email, hifz, degree,
						field);

				RequestDispatcher rdOne = request.getRequestDispatcher("template.jsp");
				rdOne.include(request, response);
				out.println("<table style=\"border:1px solid black;width:100%;\">");

				int size = data.size();

				// Retrieve items from ArrayList
				if (size == 0)
					out.println("Student Not Found!");
				else {
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

				out.println("</table></body></html>");

				
				// -------- Executing Query --------

			} catch (SQLException obj) {
				out.println("SQL Exception");
			} catch (Exception obj) {
				out.println("Exception");
			}
		} // End of session
		else {
			out.println("Session Expired. Not Allowed to Visit this Page");
		}
		out.close();

	}

	// public static void main(String args[])
	// {
	// System.out.println("Here");
	// }
}
