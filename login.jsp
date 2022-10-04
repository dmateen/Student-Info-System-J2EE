<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page session = "false" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/signupForm.css">
    <title>Login</title>

</head>
<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
        RequestDispatcher obj= request.getRequestDispatcher("dashboard.jsp");
        obj.forward(request, response);

    }
%>
<body>

    <!-- Login Form -->
    <div class="left">
        <p>Welcome</p>
    </div>

    <div class="right">
        <div class="welcome">
            <a href="index.html" style="text-decoration: none; color:black;"> <p>Student Information System</p></a>
        </div>
        <hr style="border:1px solid blueviolet;width:10%;margin-top:-10px">
        <div class="title">
            <p>Login</p>
        </div>

        <div class="loginFormDiv">
            <form action="login" name="loginForm" method="Post">
                <label for="">Email:</label><br>
                <input type="text" name="loginEmail" id="" placeholder="Enter Email" required><br><br>

                <label for="">Password:</label><br>
                <input type="password" name="loginPassword" id="" placeholder="Enter Password" required><br>

                <input type="submit" name="loginSubmit" id="" value="GET STARTED">
                <p>Not a Member? <a href="signup.jsp">Signup</a></p>
            </form>
        </div>
    </div>
    <!-- Login Form Ends here-->
</body>

</html>