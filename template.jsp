<!DOCTYPE html>
<html lang="en">
<head>
<%@ page session = "false" %>
<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/dashboard.css">
    <title>Dashboard</title>
</head>
<body>
    <div class="left">
        <div class="leftText">
            <img src="img/addStu.png" height="70" width="70" alt="">
            <p>Welcome</p>
        </div>
        <div class="options">
        <a href="addStudent.jsp"><button> Add Student</button></a> <br>
        <a href="updateStudent.jsp"><button> Update Student</button></a> <br>
        <a href="searchStudent.jsp"><button> Search Student </button></a> <br>
        <a href="deleteStudent.jsp"><button> Delete Student </button></a> <br>
        <a href="logout"><button> Logout </button></a><br>
    </div>
    </div>

    <div class="right">
        <div class="welcome">
            <a href="dashboard.jsp" style="text-decoration: none;text-align:center;font-size:25px; color:black;"> <p>Student Information System</p></a>
        </div>
        <hr style="border:1px solid blueviolet;width:10%;margin-top:-15px">
       
    <%

    }
    else
    {
%>
        
        <%= "Session Expired. You are not allowed to use this page" %>
<%
    }
%>