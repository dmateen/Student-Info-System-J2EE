import java.lang.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class UpdateExtendedFormCheck extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session != null) {

			Enumeration attributeNames = session.getAttributeNames();
			String roll = "";
			while (attributeNames.hasMoreElements()) {
				String name = attributeNames.nextElement().toString();
				roll = session.getAttribute("updateRollNumber").toString();

			}

			try {
				// -------- DAO Object --------
				studentDAO stu=new studentDAO();
				// -------- //DAO Object --------

				// -------- Retriving Data from Page --------
				String Fname = request.getParameter("studentFirstName");
				String Lname = request.getParameter("studentLastName");
				String fatherName = request.getParameter("studentFatherName");
				String gender = request.getParameter("studentGender");
				String phone = request.getParameter("studentPhone");
				String address = request.getParameter("studentAddress");
				String city = request.getParameter("studentCity");
				String email = request.getParameter("studentEmail");
				String hifz = request.getParameter("studentHafizQuran");

				// -------- Retriving Data from Page --------

				// -------- HTML & Body -------//
				RequestDispatcher rdOne = request.getRequestDispatcher("template.jsp");
				rdOne.include(request, response);

				// -------- HTML & Body -------//

				/*
				 * out.println(Fname);
				 * out.println(Lname);
				 * out.println(fatherName);
				 * out.println(gender);
				 * out.println(phone);
				 * out.println(address);
				 * out.println(city);
				 * out.println(email);
				 * out.println(hifz);
				 */

				boolean phoneCheck = false;
				boolean emailCheck = false;

				if (email != "") {
					emailCheck=stu.checkDuplicateEmailUpdate(email,roll);
					if (emailCheck)
						out.println("Error; Email Already Exsists.<br>");
					// -------- Executing Query to Email --------

				} // End of if Email not null


				// -------- Executing Query to Phone --------

				if (phone != "") {
					phoneCheck=stu.checkDuplicatePhoneUpdate(phone,roll);
					if (phoneCheck)
						out.println("Error; Phone Already Exsists.<br>");

					// -------- Executing Query to Phone --------
				} // End of if phone not null

				if (emailCheck || phoneCheck)
					out.println("<a href=\"updateStudent.jsp\">Click Here to Add Student again.</a>");

				// *****************************************************************************************************

				// -------- Updating Data --------
				

				// ------ Creating Update Query --------
				if (!emailCheck && !phoneCheck) {
					
					int rs=stu.updateADD(roll,Fname,Lname,fatherName,phone,address,city,email,gender,hifz);
					
					

					

					// Checking if any Field is entered
					
						

						if (rs > 0) {
							out.println("<p style=\"margin:30px 30px 30px 30px;\">Record Inserted Successfully</p>");

						} else {
							out.println("No Fields Entered");
						}
						

					
					// ------ Creating Update Query --------

				} // End of Already Exsist if
					// -------- Updating Data --------

				// -------- HTML & Body -------//
				out.println("</body></html>");
				// -------- HTML & Body -------//

			} // End of Try
			catch (Exception obj) {
				out.println("<h1> Exception Occured</h1>");
			}
		} else {
			out.println("Session Expired. Not Allowed to Visit this Page");
		}
		out.close();
	}// End of DoPost
}// End of Class
