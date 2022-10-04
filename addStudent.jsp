<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page session = "false" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>

    <%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
%>
    
    
    <script>
        //********Alphabet Check Function ********
        function alphabetCheck(tempVar) {

            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '];
            //alert(small.indexOf(name));
            // /alert(capital.indexOf(name));

            for (i = 0; i < tempVar.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < small.length; j++) {
                    if (tempVar[i] == small[j] || tempVar[i] == capital[j]) {
                        
                        checkFlag = true;
                        break;
                    }

                }
                if (!checkFlag) {
                    return false;
                }


            }
            return true;
        }
        //********Alphabet Check Function ********

        //********Validate First Name ********
        function validateFirstName() {
            var name = document.addStudentForm.studentFirstName.value;
            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '];
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
                    document.getElementById('studentFirstNameAns').innerHTML = " ";
                    document.getElementById('studentFirstNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            }

            document.getElementById('studentFirstNameAns').innerHTML = " ";
            return true;
        }
        //********Validate First Name Ends Here********

        //********Validate Last Name ********
        function validateLastName() {
            var name = document.addStudentForm.studentLastName.value;
            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '];
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
                    document.getElementById('studentLastNameAns').innerHTML = " ";
                    document.getElementById('studentLastNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            }

            document.getElementById('studentLastNameAns').innerHTML = " ";
            return true;
        }
        //********Validate Last Name Ends here ********


        //********Validate Last Name ********
        function validateFatherName() {
            var name = document.addStudentForm.studentFatherName.value;
            var small = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '];
            var capital = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
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
                    document.getElementById('studentFatherNameAns').innerHTML = " ";
                    document.getElementById('studentFatherNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            }

            document.getElementById('studentFatherNameAns').innerHTML = " ";
            return true;
        }
        //********Validate Last Name Ends here ********

        //********Validate Phone Number  ********
        function validatePhone() {
            var phone = document.addStudentForm.studentPhone.value;

            var allowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

            for (i = 0; i < phone.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < allowed.length; j++) {
                    if (phone[i] == allowed[j]) {
                        //alert("mactehd");
                        checkFlag = true;
                        break;
                    }
                }
                if (!checkFlag) {
                    //alert("Not Matche");
                    document.getElementById('studentPhoneAns').innerHTML = " ";
                    document.getElementById('studentPhoneAns').innerHTML = "Only Numbers Allowed";
                    return false;
                }

            }

            if (phone.length != 11) {
                document.getElementById('studentPhoneAns').innerHTML = " ";
                document.getElementById('studentPhoneAns').innerHTML = "11 Numbers Allowed";
                return false;
            }


            document.getElementById('studentPhoneAns').innerHTML = " ";
            return true;

        }
        //********Validate Phone Number Ends here ********

        //********City Validation Function********
        function validateCity() {
            var city = document.addStudentForm.studentCity.value;
            if (!alphabetCheck(city)) {
                document.getElementById('studentCityAns').innerHTML = " ";
                document.getElementById('studentCityAns').innerHTML = "Only Alphabets Allowed";
                return false;
            }
            document.getElementById('studentCityAns').innerHTML = " ";
            return true;
        }
        //********City Validation Function Ends here********

        //********Validate Email ********
        function validateEmail() {

            var email = document.addStudentForm.studentEmail.value;
            if (document.addStudentForm.studentEmail.value != "") {
                var at = email.indexOf("@");
                var dot = email.indexOf(".");
                var atArr = email.split("@");
                //alert(at);

                if (at != -1 && at != 0 && at != email.length - 1 && atArr[1].indexOf(".") != -1 && atArr[1].indexOf(".") != 0 && atArr[1].indexOf(".") != atArr[1].length - 1) {
                    
                    document.getElementById("studentEmailAns").innerHTML = "";
                    //document.getElementById("answerOk").innerHTML="Email Correct";


                    return true;
                }
                else {
                    
                    document.getElementById("studentEmailAns").innerHTML = "";
                    document.getElementById("studentEmailAns").innerHTML = " Email Incorrect";

                    return false;
                }
            }
            else {
                document.getElementById('studentEmailAns').innerHTML = "Email Field is Empty"
            }

            return false;
        }
        //********Validate Email Ends here ********

        //********Main Validation Function********
        function validate() {
            if (validateFirstName() && validateLastName() && validateFatherName() && validateEmail() && validateCity() && validatePhone()) {
                return true;
            }
            return false;
        }
        //********Main Validation Function********
    </script>

</head>

<body>

    <jsp:include page="template.jsp"/>

    <form action="addStudent" method="POST" name="addStudentForm">

        <label for="">First Name: </label>
        <input type="text" name="studentFirstName" id="" required onblur="validateFirstName()">
        <span id="studentFirstNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Last Name: </label>
        <input type="text" name="studentLastName" id="" required onblur="validateLastName()">
        <span id="studentLastNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Father Name: </label>
        <input type="text" name="studentFatherName" id="" required onblur="validateFatherName()">
        <span id="studentFatherNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Phone Number: </label>
        <input type="tel" name="studentPhone" id="" required onblur="validatePhone()">
        <span id="studentPhoneAns" style="color:red;"></span>
        <br><br>

        <label for="">Address: </label>
        <input type="text" name="studentAddress" id="" required> <br><br>

        <label for="">City: </label>
        <input type="text" name="studentCity" id="" required onblur="validateCity()">
        <span id="studentCityAns" style="color:red;"></span>
        <br><br>

        <label for="">Email: </label>
        <input type="text" name="studentEmail" id="" required onblur="validateEmail()">
        <span id="studentEmailAns" style="color:red;"></span>
        <br><br>

        <label for="">Gender</label>
        <input type="radio" name="studentGender" id="" value="Male" required> Male
        <input type="radio" name="studentGender" id="" value="Female" required> Female <br><br>

        <label for="">Hafiz-e-Quran: </label>
        <input type="radio" name="studentHafizQuran" id="" value="Yes" required> Yes
        <input type="radio" name="studentHafizQuran" id="" value="No" required> No <br><br>

        <label for="">Degree:</label>
        <select name="studentDegree" id="">
            <option value="CS" required>Computer Science</option>
            <option value="SE" required>Software Engineering</option>
            <option value="IT" required>Information Technology</option>
        </select><br><br>

        <input type="submit" onclick="return validate()">
    </form>
    
</body>
<%

    }
    else
    {
%>
        
        <%= "Session Expired. You are not allowed to use this page" %>
<%
    }
%>
</html>