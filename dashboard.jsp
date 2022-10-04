<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page session = "false" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/dashboard.css">
    <title>Dashboard</title>
</head>
<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
%>
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
       <a href="addStudent.jsp"> <div class="add"><p>Add Student</p></div></a>
       <a href="searchStudent.jsp"> <div class="search"><p>Search Student</p></div></a>
       <a href="updateStudent.jsp"> <div class="update"><p>Update Student</p></div></a>
       <a href="deleteStudent.jsp"> <div class="delete"><p>Delete Student</p></div></a>
       <a href="logout"> <div class="logout"><p>Logout User</p></div></a>
    </div>
<%

    }
    else
    {
%>
        
        <%= "Session Expired. You are not allowed to use this page" %>
<%
    }
%>
</body>
</html>