import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        try {

            // -------- Getting Parameters --------
            String Email = request.getParameter("loginEmail");
            String password = request.getParameter("loginPassword");
            // -------- //Getting Parameters --------

            // -------- DAO Handling --------
            boolean EmailPasswordFlag = false;

            employeeDAO emp= new employeeDAO();
            EmailPasswordFlag = emp.login(Email, password);
            // -------- //DAO Handling --------

            // -------- Displaying --------
            if (EmailPasswordFlag) {
                HttpSession session = request.getSession(true);
                RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
                rd.forward(request, response);
            } else {
				out.println("<html><body><p>Email or Password Not Found!<p>");
				RequestDispatcher rdOne = request.getRequestDispatcher("login.jsp");
                rdOne.include(request, response);
                
            }
            // -------- //Displaying --------

        } catch (ServletException obj) {
            out.println("ServletException");
        } catch (SQLException obj) {
            out.println("SQL Exception");
        } catch (Exception obj) {
            out.println("Exception");
        }
        out.close();

    }

    // public static void main(String args[])
    // {
    // System.out.println("Here");
    // }
}
