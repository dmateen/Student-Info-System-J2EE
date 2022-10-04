import MyPack.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class signup extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        try {
            // -------- Retriving Data from Page --------
            String Fname = request.getParameter("signupFirstName");
            String Lname = request.getParameter("signupLastName");
            String gender = request.getParameter("signupGender");
            String id = request.getParameter("signupId");
            String email = request.getParameter("signupEmail");
            String password = request.getParameter("signupPassword");
            // -------- Retriving Data from Page --------

            // -------- HTML & Body -------
            out.println("<html><head><head/><body>");
            // -------- //HTML & Body -------

            // -------- Employee DAO Obj -------
            employeeDAO emp = new employeeDAO();
            // -------- //Employee DAO Obj -------

            // -------- Checking if Employee is Eligible --------
            boolean EmployeeEligibleCheck = emp.isEmployeeEligible(id);

            if (!EmployeeEligibleCheck)
                out.println("Error; Employee Not a Part of Institute. Please Enter a Valid ID<br>");
            // -------- Checking if Employee is Eligible --------

            // -------- Checking Email and ID --------
            boolean emailCheck = emp.isEmailDuplicate(email);
            boolean idCheck = emp.isIdDuplicate(id);

            if (idCheck)
                out.println("Error; ID Already Exsists.<br>");
            if (emailCheck)
                out.println("Error; Email Already Exsists.<br>");

            if (emailCheck || idCheck || !EmployeeEligibleCheck)
			{//out.println("<a href=\"signup.jsp\">Click Here to signup again.</a>");
			
					RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
		}
            // -------- Checking Email and ID --------

            // -------- Adding Records --------
            if (!emailCheck && !idCheck && EmployeeEligibleCheck) {
                employee emp01 = new employee();
				
				emp01.setFname(Fname);
				emp01.setLname(Lname);
				emp01.setGender(gender);
				emp01.setId(id);
				emp01.setEmail(email);
				emp01.setPassword(password);

                if (emp.signupEmployee(emp01)) {
					out.println("Signed up Successfully. Login to view the dashboard<br>");
                    
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
                } else {
                    out.println("Record could not inserted.");
                }
            } // End of Already Exsist if
              // -------- Adding Records --------

            // -------- HTML & Body -------//
            out.println("</body></html>");
            // -------- HTML & Body -------//

        } // End of Try

        catch (Exception obj) {
            out.println("<h1> Exception Occured</h1>");
        }

        out.close();

    }// End of DoPOst

} // End of class