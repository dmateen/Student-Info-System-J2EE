import MyPack.*;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

public class studentDAO {

	// -------- Declaring JDBC Vars --------
	String url;
	Connection con;
	Statement st;
	// -------- //Declaring JDBC Vars --------

	// -------- Default Constructor --------
	studentDAO() throws Exception {

		// -------- JDBC Connection --------
		Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://127.0.0.1/test";
		con = DriverManager.getConnection(url, "root", "root");
		st = con.createStatement();
		// -------- //JDBC Connection --------

	}
	// -------- //Default Constructor --------

	// -------- Email Duplicate DAO Function --------
	public boolean checkDuplicateEmail(String Email) throws Exception {
		// -------- Query --------
		String query = "SELECT * FROM STUDENT WHERE studentEmail=LOWER('" + Email + "')";
		// -------- //Query --------

		boolean emailCheck = false;
		// -------- Executing Query --------
		ResultSet DuplicateRS = st.executeQuery(query);
		String tempEmail;

		while (DuplicateRS.next()) {
			tempEmail = DuplicateRS.getString("studentEmail");
			if (Email.equals(tempEmail))
				emailCheck = true;
		}
		// -------- //Executing Query --------
		return emailCheck;

	}
	// -------- Email Duplicate DAO Function --------


// -------- Email Duplicate Update DAO Function --------
	public boolean checkDuplicateEmailUpdate(String Email,String roll) throws Exception {
		// -------- Query --------
		String query = "SELECT * FROM STUDENT WHERE studentEmail=LOWER('" + Email + "')";
		// -------- //Query --------

		boolean emailCheck = false;
		// -------- Executing Query --------
		ResultSet DuplicateRS = st.executeQuery(query);
		String tempEmail,tempRoll;

		while (DuplicateRS.next()) {
			tempEmail = DuplicateRS.getString("studentEmail");
			tempRoll = DuplicateRS.getString("rollNumber");
			if (Email.equals(tempEmail) && !roll.equals(tempRoll))
				emailCheck = true;
		}
		// -------- //Executing Query --------
		return emailCheck;

	}
	// -------- Email Duplicate DAO Function --------




	// -------- Phone Duplicate DAO Function --------
	public boolean checkDuplicatePhone(String phone) throws Exception {
		// -------- Query --------
		String query = "SELECT * FROM STUDENT WHERE phone=\'" + phone + "\' ";
		// -------- //Query --------

		boolean phoneCheck = false;
		// -------- Executing Query --------
		ResultSet DuplicateRS = st.executeQuery(query);
		String tempPhone;

		while (DuplicateRS.next()) {
			tempPhone = DuplicateRS.getString("phone");
			if (phone.equals(tempPhone))
				phoneCheck = true;
		}
		// -------- //Executing Query --------
		return phoneCheck;

	}
	// -------- Phone Update Duplicate DAO Function --------
	
		// -------- Phone Duplicate DAO Function --------
	public boolean checkDuplicatePhoneUpdate(String phone,String roll) throws Exception {
		// -------- Query --------
		String query = "SELECT * FROM STUDENT WHERE phone=\'" + phone + "\' ";
		// -------- //Query --------

		boolean phoneCheck = false;
		// -------- Executing Query --------
		ResultSet DuplicateRS = st.executeQuery(query);
		String tempPhone,tempRoll;

		while (DuplicateRS.next()) {
			tempPhone = DuplicateRS.getString("phone");
			tempRoll = DuplicateRS.getString("rollNumber");
			if (phone.equals(tempPhone) && !roll.equals(tempRoll))
				phoneCheck = true;
		}
		// -------- //Executing Query --------
		return phoneCheck;

	}
	// -------- Phone Update Duplicate DAO Function --------
	
	

	// -------- Giving DAO Function --------
	public String giveRollNumber(String degree) throws Exception {
		String rollStart, countRollquery;
		

		// -------- Query Counting Students of CS,IT,SE --------
		String rollNumEnd = "1", splitVar;
		if (degree.equals("CS")) {
			countRollquery = "SELECT MAX(rollNumber) AS maxRoll FROM student WHERE degree='CS'";
			rollStart = "bcs";
			splitVar = "s";
		} else if (degree.equals("SE")) {
			countRollquery = "SELECT MAX(rollNumber) AS maxRoll FROM student WHERE degree='SE'";
			rollStart = "bse";
			splitVar = "e";
		} else {
			countRollquery = "SELECT MAX(rollNumber) AS maxRoll FROM student WHERE degree='IT'";
			rollStart = "bit";
			splitVar = "t";
		}
		// -------- Query Counting Students of CS --------

		// -------- Executing Query Counting Students of CS,SE,IT --------
		ResultSet rollCountRS = st.executeQuery(countRollquery);
		
		
		
		while (rollCountRS.next()) {
			rollNumEnd = rollCountRS.getString("maxRoll");
		}
				
		//boolean NotIn=true;
		if(rollNumEnd.charAt(0)=='b'){
		//if (!rollNumEnd.equals("") || !rollNumEnd.equals(null)) {
			String tempArr[] = rollNumEnd.split(splitVar);
			int tempNum = Integer.parseInt(tempArr[1]);
			tempNum++;
			rollNumEnd = String.valueOf(tempNum);
			//NotIn=false;
			
		}
		else{
			rollNumEnd = "1";
		}

		// -------- Executing Query Counting Students of CS,SE,IT --------

		String fullRollNumber = rollStart + rollNumEnd;

		return fullRollNumber;

	}
	// -------- Giving DAO Function --------

	// -------- Phone Duplicate DAO Function --------
	public int addStudent(String fullRollNumber, String Fname, String Lname, String fatherName, String gender,
			String phone, String address, String city, String email, String hifz, String degree) throws Exception {
		// -------- Retriving Data from Page --------
		String query = "insert into student(rollnumber,Fname,Lname,fatherName,gender,phone,address,city,studentEmail,hifz,degree) values('"
				+ fullRollNumber + "',UPPER('" + Fname + "'),UPPER('" + Lname + "'),UPPER('" + fatherName + "'),'"
				+ gender + "','" + phone + "',UPPER('" + address + "'),UPPER('" + city + "'),LOWER('" + email + "'),'"
				+ hifz + "','" + degree + "')";
		// -------- Retriving Data from Page --------

		// -------- Executing Query --------
		int rs = st.executeUpdate(query);

		return rs;

	}
	// -------- Phone Duplicate DAO Function --------

	// -------- Delete Student DAO Function --------
	public int deleteStudent(String roll) throws Exception {
		// -------- Query for Deleting Data --------
		String query = "DELETE FROM student WHERE rollnumber='" + roll + "'";
		// -------- Query for Deleting Data --------

		// -------- Query for Deleting Data --------
		int rs = st.executeUpdate(query);

		return rs;

	}
	// -------- Delete Student DAO Function --------

	// -------- 	 Student DAO Function --------
	public ArrayList searchStudent(String roll, String Fname, String Lname, String fatherName, String phone,
			String city, String gender, String email, String hifz, String degree, String field) throws Exception {
		// -------- Query for Searching Data --------
		String query = createSearchQuery(roll, Fname, Lname, fatherName, phone, city, gender, email, hifz, degree,
				field);
		// -------- Query for Searching Data --------

		// -------- Executing Query --------
		ResultSet rs = st.executeQuery(query);
		String tempRoll, tempFname, tempLname, tempFather, tempPhone, tempCity, tempGender, tempEmail, tempHifz,
				tempDegree, tempAddress;

		ArrayList stuList = new ArrayList();

		while (rs.next()) {

			tempRoll = rs.getString("rollnumber");
			tempFname = rs.getString("Fname");
			tempLname = rs.getString("Lname");
			tempFather = rs.getString("fatherName");
			tempPhone = rs.getString("phone");
			tempAddress = rs.getString("address");
			tempCity = rs.getString("city");
			tempGender = rs.getString("gender");
			tempEmail = rs.getString("studentEmail");
			tempHifz = rs.getString("hifz");
			tempDegree = rs.getString("degree");

			student tempStudent = new student();
					tempStudent.setRoll(tempRoll);
					tempStudent.setFname(tempFname);
					tempStudent.setLname(tempLname);
					tempStudent.setFatherName(tempFather);
					tempStudent.setGender(tempGender);
					tempStudent.setPhone(tempPhone);
					tempStudent.setAddress(tempAddress);
					tempStudent.setCity(tempCity);
					tempStudent.setEmail(tempEmail);
					tempStudent.setHifz(tempHifz);
					tempStudent.setDegree(tempDegree);
					
			/*
			 * //Test
			 * out.println( tempStudent.getRoll());
			 * out.println( tempStudent.getFname());
			 * out.println( tempStudent.getLname());
			 * out.println( tempStudent.getFatherName());
			 * out.println( tempStudent.getPhone());
			 * out.println( tempStudent.getCity());
			 * out.println( tempStudent.getAddress());
			 * out.println( tempStudent.getGender());
			 * out.println( tempStudent.getEmail());
			 * out.println( tempStudent.getHifz());
			 * out.println( tempStudent.getDegree());
			 */

			stuList.add(tempStudent);

		}

		// -------- Query for Searching Data --------

		return stuList;

	}
	// -------- Search Student DAO Function --------

	// -------- Update Student DAO Function --------
	public ArrayList updateStudent(String roll) throws Exception {
		// -------- Query for Updating Data --------
		String query = "Select * FROM student WHERE rollnumber='" + roll + "'";
		// -------- Query for Updating Data --------

		// -------- Executing Query --------
		ResultSet rs = st.executeQuery(query);
		String tempRoll, tempFname, tempLname, tempFather, tempPhone, tempCity, tempGender, tempEmail, tempHifz,
				tempDegree, tempAddress;

		ArrayList stuList = new ArrayList();

		while (rs.next()) {

			tempRoll = rs.getString("rollnumber");
			tempFname = rs.getString("Fname");
			tempLname = rs.getString("Lname");
			tempFather = rs.getString("fatherName");
			tempPhone = rs.getString("phone");
			tempAddress = rs.getString("address");
			tempCity = rs.getString("city");
			tempGender = rs.getString("gender");
			tempEmail = rs.getString("studentEmail");
			tempHifz = rs.getString("hifz");
			tempDegree = rs.getString("degree");
			
			
			
			  //Test
			  /*
			  out.println( tempStudent.getRoll());
			  out.println( tempStudent.getFname());
			  out.println( tempStudent.getLname());
			  out.println( tempStudent.getFatherName());
			  out.println( tempStudent.getPhone());
			  out.println( tempStudent.getCity());
			  out.println( tempStudent.getAddress());
			  out.println( tempStudent.getGender());
			  out.println( tempStudent.getEmail());
			  out.println( tempStudent.getHifz());
			  out.println( tempStudent.getDegree());
			 */
			

			student tempStudent = new student();
					
					tempStudent.setRoll(tempRoll);
					tempStudent.setFname(tempFname);
					tempStudent.setLname(tempLname);
					tempStudent.setFatherName(tempFather);
					tempStudent.setGender(tempGender);
					tempStudent.setPhone(tempPhone);
					tempStudent.setAddress(tempAddress);
					tempStudent.setCity(tempCity);
					tempStudent.setEmail(tempEmail);
					tempStudent.setHifz(tempHifz);
					tempStudent.setDegree(tempDegree);
					
			stuList.add(tempStudent);
		}

		return stuList;

	}
	// -------- Update Student DAO Function --------
	
	// -------- UpdateADD Student DAO Function --------
	public int updateADD(String roll, String Fname, String Lname, String fatherName, String phone,
			String address, String city, String email, String gender, String hifz) throws Exception
	{
		//Query
		String UpdateQuery=createUpdateQuery(roll,Fname,Lname,fatherName,phone,address,city,email,gender,hifz);
		//Query
		
		int rs=0;
		if(UpdateQuery!="none")
		{
			rs = st.executeUpdate(UpdateQuery);
		}
		
		return rs;
		
	}
	// -------- UpdateADD Student DAO Function --------

	// -------- ************************** //Seperate Functions Using DAO
	// ************************** --------

	// -------- Search Student Query Function --------
	public String createSearchQuery(String roll, String Fname, String Lname, String fatherName, String phone,
			String city, String gender, String email, String hifz, String degree, String field) throws Exception {
		// -------- Creating Search Query --------

		boolean whereCheck = true;
		String appendQuery = "";
		if (hifz.equals("null"))
			hifz = "";
		if (degree.equals("null"))
			hifz = "";

		if (!roll.equals("") && !roll.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "rollnumber = LOWER(\'" + roll + "\') ";
			whereCheck = true;
		}
		if (!Fname.equals("") && !Fname.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "Fname =UPPER(\'" + Fname + "\') ";
			whereCheck = true;
		}
		if (!Lname.equals("") && !Lname.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "Lname = UPPER(\'" + Lname + "\') ";
			whereCheck = true;
		}
		if (!fatherName.equals("") && !fatherName.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "fatherName = UPPER(\'" + fatherName + "\') ";
			whereCheck = true;
		}
		if (!gender.equals("") && !gender.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "gender =\'" + gender + "\' ";
			whereCheck = true;
		}
		if (!phone.equals("") && !phone.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "phone =\'" + phone + "\' ";
			whereCheck = true;
		}
		if (!city.equals("") && !city.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "city = UPPER(\'" + city + "\') ";
			whereCheck = true;
		}
		if (!email.equals("") && !email.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "studentEmail =LOWER(\'" + email + "\') ";
			whereCheck = true;
		}
		if (!hifz.equals("") && !hifz.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "hifz =\'" + hifz + "\' ";
			whereCheck = true;
		}
		if (!degree.equals("") && !degree.equals("null")) {
			if (appendQuery != "")
				appendQuery = appendQuery + field + " ";
			appendQuery = appendQuery + "degree =\'" + degree + "\' ";
			whereCheck = true;
		}
		// -------- Selecting Query --------
		if (appendQuery != "")
			appendQuery = "Where " + appendQuery;
		// out.println(appendQuery);

		// -------- Query --------
		String query = "SELECT * FROM STUDENT " + appendQuery;

		// -------- Query --------

		return query;

	}
	// -------- Search Student Query Function --------
	
	
	// -------- Update Student Query Function --------
	public String createUpdateQuery(String roll, String Fname, String Lname, String fatherName, String phone,
			String address, String city, String email, String gender, String hifz) throws Exception {
			
			boolean updateTableNameCheck = false;
			
			String updateQueryTablePart = "Update Student ";
			String updateQuerySetPart = "Set ";
			String updateQueryWherePart = " Where ";
			String updateQueryWherePartExtended = "";			
			
			
			if (!Fname.equals("") && !Fname.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "Fname =UPPER(\'" + Fname + "\') ";
						updateTableNameCheck = true;
					}
					if (!Lname.equals("") && !Lname.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "Lname = UPPER(\'" + Lname + "\') ";
						updateTableNameCheck = true;
					}
					if (!fatherName.equals("") && !fatherName.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "fatherName = UPPER(\'" + fatherName + "\') ";
						updateTableNameCheck = true;
					}
					if (!gender.equals("") && !gender.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "gender =\'" + gender + "\' ";
						updateTableNameCheck = true;
					}
					if (!phone.equals("") && !phone.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "phone =\'" + phone + "\' ";
						updateTableNameCheck = true;
					}
					if (!address.equals("") && !address.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "address = UPPER(\'" + address + "\') ";
						updateTableNameCheck = true;
					}
					if (!city.equals("") && !city.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "city = UPPER(\'" + city + "\') ";
						updateTableNameCheck = true;
					}
					if (!email.equals("") && !email.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "studentEmail =LOWER(\'" + email + "\') ";
						updateTableNameCheck = true;
					}
					if (!hifz.equals("") && !hifz.equals("null")) {
						if (updateQuerySetPart != "Set ")
							updateQuerySetPart = updateQuerySetPart + ", ";
						updateQuerySetPart = updateQuerySetPart + "hifz =\'" + hifz + "\' ";
						updateTableNameCheck = true;
					}
					
					String UpdateQuery;
					
					if (updateTableNameCheck) {
						// ------- Assembling Query --------
						UpdateQuery = updateQueryTablePart + updateQuerySetPart + updateQueryWherePart
								+ updateQueryWherePartExtended + "rollNumber= \'" + roll + "\'";
					}
					else
					{
						UpdateQuery="none";
					}
					
					return UpdateQuery;
	}				
	
	// -------- Update Student Query Function --------
	

}// End of DAOClass
