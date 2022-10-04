import MyPack.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class employeeDAO {

    // -------- Declaring JDBC Vars --------
    String url;
    Connection con;
    Statement st;
    // -------- //Declaring JDBC Vars --------

    // -------- Default Constructor --------
    employeeDAO() throws Exception {
		
        // -------- JDBC Connection --------
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://127.0.0.1/test";
        con = DriverManager.getConnection(url, "root", "root");
        st = con.createStatement();
        // -------- //JDBC Connection --------

    }
    // -------- //Default Constructor --------

    // -------- Login DAO Function --------
    public boolean login(String Email, String password) throws Exception {
        // -------- Query --------
        String query = "SELECT * FROM SIGNUP WHERE signupEmail='" + Email + "' AND SIGNUPPASSWORD='" + password + "'";
        // -------- //Query --------

        // -------- Executing Query --------
        ResultSet rs = st.executeQuery(query);
        String loginEmail, loginPassword;
        boolean EmailPasswordFlag = false;
        while (rs.next()) {
            loginEmail = rs.getString("signupEmail");
            loginPassword = rs.getString("signupPassword");
            if (Email.equals(loginEmail) && password.equals(loginPassword)) {
                EmailPasswordFlag = true;
                break;
            }
        }
        // -------- //Executing Query --------
        return EmailPasswordFlag;

    }
    // -------- //Login DAO Function --------

    // -------- Signup Employee DAO Function --------
    public boolean signupEmployee(MyPack.employee emp) throws Exception {
        // -------- Query --------
        String query = "insert into signup(fname,lname,signupGender,signupId,signupEmail,signupPassword) values(UPPER('"
                + emp.getFname() + "'), UPPER('" + emp.getLname() + "'),'" + emp.getGender() + "','" + emp.getId() + "',LOWER('" + emp.getEmail() + "'),'"
                + emp.getPassword() + "')";
        // -------- //Query --------

        // -------- Executing Query --------
        int rs = st.executeUpdate(query);
        // -------- //Executing Query --------

        if (rs > 0)
            return true;
        else
            return false;
    }
    // -------- //Signup Employee DAO Function --------

    // -------- ************************** Seperate Functions Using DAO ************************** --------
    
    boolean isEmailDuplicate(String email) throws Exception {
        // -------- Query --------
        String VerifyDuplicateQuery = "SELECT * FROM SIGNUP WHERE SIGNUPEMAIL='" + email + "'";
        // -------- //Query --------

        boolean emailCheck = false;

        ResultSet DuplicateRS = st.executeQuery(VerifyDuplicateQuery);
        String tempEmail;

        // -------- Executing Query --------
        while (DuplicateRS.next()) {
            tempEmail = DuplicateRS.getString("signupEmail");
            if (email.equals(tempEmail))
                emailCheck = true;
        }
        // -------- //Executing Query --------
        return emailCheck;
    }

    boolean isIdDuplicate(String id) throws Exception {
        // -------- Query --------
        String VerifyDuplicateQuery = "SELECT * FROM SIGNUP WHERE SIGNUPID='" + id + "' ";
        // -------- //Query --------

        // -------- Executing Query --------
        boolean idCheck = false;

        ResultSet DuplicateRS = st.executeQuery(VerifyDuplicateQuery);
        String tempID;

        while (DuplicateRS.next()) {
            tempID = DuplicateRS.getString("signupId");
            if (id.equals(tempID))
                idCheck = true;
        }
        // -------- //Executing Query --------
        return idCheck;
    }

    boolean isEmployeeEligible(String id) throws Exception {
        // -------- Query --------
        String EmployeeEligibleQuery = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID='" + id + "'";
        // -------- //Query --------

        // -------- Executing Query --------
        ResultSet EmployeeEligibleRS = st.executeQuery(EmployeeEligibleQuery);
        String tempEmpID;
        boolean EmployeeEligibleCheck = false;
        while (EmployeeEligibleRS.next()) {
            tempEmpID = EmployeeEligibleRS.getString("employeeID");

            if (tempEmpID.equals(id))
                EmployeeEligibleCheck = true;
        }
        // -------- //Executing Query --------
        return EmployeeEligibleCheck;
    }
    // -------- ************************** //Seperate Functions Using DAO ************************** --------
    

}// End of DAOClass
