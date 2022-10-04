<!DOCTYPE html>
<html lang="en">

<head>
<%@ page session = "false" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/signupForm.css">
    <link rel="stylesheet" href="css/signup.css">

<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
        RequestDispatcher obj= request.getRequestDispatcher("dashboard.jsp");
        obj.forward(request, response);

    }
%>

    <script>

        //********Validate First Name ********
        function validateFirstName() {
            var name = document.signupForm.signupFirstName.value;
            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',' '];
            //alert(small.indexOf(name));
            // /alert(capital.indexOf(name));

            for (i = 0; i < name.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < small.length; j++) {
                    if (name[i] == small[j] || name[i] == capital[j]) {
                        // alert("mactehd");
                        checkFlag = true;
                        break;
                    }

                }
                if (!checkFlag) {
                    //alert("Not Matche");
                    document.getElementById('signupNameAns').innerHTML = " ";
                    document.getElementById('signupNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            }

            document.getElementById('signupNameAns').innerHTML = " ";
            return true;
        }
        //********Validate First Name Ends Here********

        //********Validate First Name ********
        function validateLastName() {
            var name = document.signupForm.signupLastName.value;
            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',' '];
            //alert(small.indexOf(name));
            // /alert(capital.indexOf(name));

            for (i = 0; i < name.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < small.length; j++) {
                    if (name[i] == small[j] || name[i] == capital[j]) {
                        // alert("mactehd");
                        checkFlag = true;
                        break;
                    }

                }
                if (!checkFlag) {
                    //alert("Not Matche");
                    document.getElementById('signupLastNameAns').innerHTML = " ";
                    document.getElementById('signupLastNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            }

            document.getElementById('signupLastNameAns').innerHTML = " ";
            return true;
        }
        //********Validate Second Name Ends Here********

        //********Validate Email ********
        function validateEmail() {

            var email = document.signupForm.signupEmail.value;
            if (document.signupForm.signupEmail.value != "") {
                var at = email.indexOf("@");
                var dot = email.indexOf(".");
                var atArr = email.split("@");
                //alert(at);

                if (at != -1 && at != 0 && at != email.length - 1 && atArr[1].indexOf(".") != -1 && atArr[1].indexOf(".") != 0 && atArr[1].indexOf(".") != atArr[1].length - 1) {
                    document.getElementById("emailOk").innerHTML = "";
                    document.getElementById("emailOutput").innerHTML = "";
                    //document.getElementById("answerOk").innerHTML="Email Correct";


                    return true;
                }
                else {
                    document.getElementById("emailOk").innerHTML = "";
                    document.getElementById("emailOutput").innerHTML = "";
                    document.getElementById("emailOutput").innerHTML = " Email Incorrect";

                    return false;
                }


            }
            else {
                document.getElementById('answer').innerHTML = "Email Field is Empty"
            }

            return false;
        }
        //********Validate Email Ends here ********


        //******** Validate Password ********
        function validatePassword() {
            if (document.signupForm.signupPassword.value != document.signupForm.signupConfirmPassword.value) {
                document.getElementById('passwordOutput').innerHTML = "Password Dont match";
                return false;
            }
            else {
                document.getElementById('passwordOutput').innerHTML = "";
            }
            return true;
        }
        //******** Validate Password Ends here ********

        //******** Main Validation Function ********
        function validate() {
            if (validatePassword() && validateEmail() && validateFirstName() && validateLastName()) {
                return true;
            }
            return false;
        }
    </script>

    <title>Signup</title>
</head>


<!--******************************* BODY ******************************* -->

<body>
    <div class="left">
        <p>Welcome</p>
    </div>

    <div class="right">

        <div class="welcome">
            <a href="index.html" style="text-decoration: none; color:black;"> <p>Student Information System</p></a>
        </div>
        <hr style="border:1px solid blueviolet;width:10%;margin-top:-15px">
        <div class="title">
            <p>Signup</p>
        </div>

        <div class="signupFormDiv">
           
            <form action="signup" method="Post" name="signupForm">

                <div class="signupFormDivLeft">
                    <label for="">First Name:</label><br>
                    <input type="text" name="signupFirstName" id="" required   onblur="return validateFirstName()"> 
                    <span id="signupNameAns" style="color:red;"></span><br><br>

                    <label for="">Last Name:</label><br>
                    <input type="text" name="signupLastName" id="" required  onblur="return validateLastName()"> <span
                        id="signupLastNameAns" style="color:red;"></span><br><br>

                    <label for="">Gender:</label>
                    <input type="radio" name="signupGender" id="" value="Male" required>
                    <label for="">Male</label>
                    <input type="radio" name="signupGender" id="" value="Female" required>
                    <label for="">Female</label><br><br>

                    <label for="">ID:</label><br>
                    <input type="text" name="signupId" placeholder="Enter assigned ID" required><br><br>

                </div>

                <div class="signupFormDivRight">

                    <label for="">Email:</label><br>
                    <input type="text" name="signupEmail" id="" required placeholder="abc@xyz.com">
                    <span id="emailOk"></span>
                    <span id="emailOutput" style="color:red;font-weight: bold;"></span><br><br>

                    <label for="">Password:</label><br>
                    <input type="password" name="signupPassword" id="" required><br><br>

                    <label for="">Confirm Password:</label><br>
                    <input type="password" name="signupConfirmPassword" id="" required onblur="return validatePassword()">
                    <span id="passwordOutput" style="color:red;"></span><br><br>

                    <input type="submit" name="loginSubmit" id="" value="SIGNUP" onclick="return validate()">
                    <p>Already a Member? <a href="login.jsp">Login</a></p>
                </div>
            </form>
        </div>
    </div>
</body>

</html>