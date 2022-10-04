<!DOCTYPE html>
<html lang="en">
<%@ page session = "false" %>
<head>
<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Student</title>

    <script>
        //********Aplbhabet Function ********
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
        //********Aplhabet Function ********


        //********Numeber Function ********
        function numberCheck(tempVar) {
            
            var allowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
            //alert(small.indexOf(name));
            // /alert(capital.indexOf(name));


            for (i = 0; i < tempVar.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < allowed.length; j++) {
                    if (tempVar[i] == allowed[j]) {
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
        //********Number Function ********

        //********Alphanumeric Function ********
        function alphanumericCheck(tempVar) {
            
            var allowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
            
            //alert(small.indexOf(name));
            // /alert(capital.indexOf(name));


            for (i = 0; i < tempVar.length; i++) {
                var j = 0;
                var checkFlag = false;
                for (; j < allowed.length; j++) {
                    if (tempVar[i] == allowed[j]) {
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
        //********Alphanumeric Function ********



        //********Roll Validation Function Ends here********
        function validateRollNumber() {
            
            var roll = document.searchStudentForm.studentRollNumber.value;
            
            if (!alphanumericCheck(roll)) {
                document.getElementById('studentRollNumberAns').innerHTML = " ";
                document.getElementById('studentRollNumberAns').innerHTML = "Only Alphabets & Numbers Allowed";
                return false;
            }
            document.getElementById('studentRollNumberAns').innerHTML = " ";
            return true;
        }
        //********Roll Validation Function Ends here********

        //********Validate First Name ********
        function validateFirstName() {
            var name = document.searchStudentForm.studentFirstName.value;
            
                if (!alphabetCheck(name)) {
                    //alert("Not Matche");
                    document.getElementById('studentFirstNameAns').innerHTML = " ";
                    document.getElementById('studentFirstNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            

            document.getElementById('studentFirstNameAns').innerHTML = " ";
            return true;
        }
        //********Validate First Name Ends Here********

        //********Validate Last Name ********
        function validateLastName() {
            var name = document.searchStudentForm.studentLastName.value;
            
                if (!alphabetCheck(name)) {
                    //alert("Not Matche");
                    document.getElementById('studentLastNameAns').innerHTML = " ";
                    document.getElementById('studentLastNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            

            document.getElementById('studentLastNameAns').innerHTML = " ";
            return true;
        }
        //********Validate Last Name Ends here ********


        //********Validate Last Name ********
        function validateFatherName() {
            var name = document.searchStudentForm.studentFatherName.value;
            
                if (!alphabetCheck(name)) {
                    //alert("Not Matche");
                    document.getElementById('studentFatherNameAns').innerHTML = " ";
                    document.getElementById('studentFatherNameAns').innerHTML = "Only Alphabets Allowed";
                    return false;
                }

            

            document.getElementById('studentFatherNameAns').innerHTML = " ";
            return true;
        }
        //********Validate Last Name Ends here ********

        //********Validate Phone Number  ********
        function validatePhone() {
            var phone = document.searchStudentForm.studentPhone.value;

                if (!numberCheck(phone)) {
                    //alert("Not Matche");
                    document.getElementById('studentPhoneAns').innerHTML = " ";
                    document.getElementById('studentPhoneAns').innerHTML = "Only Numbers Allowed";
                    return false;
                }

            
            if(phone!="")
            {
            if (phone.length != 11) {
                document.getElementById('studentPhoneAns').innerHTML = " ";
                document.getElementById('studentPhoneAns').innerHTML = "11 Numbers Allowed";
                return false;
            }
            }


            document.getElementById('studentPhoneAns').innerHTML = " ";
            return true;

        }
        //********Validate Phone Number Ends here ********

        //********City Validation Function********
        function validateCity() {
            var city = document.searchStudentForm.studentCity.value;
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

            var email = document.searchStudentForm.studentEmail.value;
            if (document.searchStudentForm.studentEmail.value != "") {
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
                
            }

            return false;
        }
        //********Validate Email Ends here ********

        //********Main Validation Function********
        function validate() {
                return true;         
        }
        //********Main Validation Function********
    </script>

</head>

<body>
<jsp:include page="template.jsp"/>  
    <p>*Leave all the fields empty to see the list of all students</p>
    <form action="searchStudent" method="POST" name="searchStudentForm">

        <label for="">Roll Number: </label>
        <input type="text" name="studentRollNumber" id=""  onblur="validateRollNumber()"> 
        <span id="studentRollNumberAns" style="color:red;"></span>
        <br><br>

        <label for="">First Name: </label>
        <input type="text" name="studentFirstName" id=""  onblur="validateFirstName()">
        <span id="studentFirstNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Last Name: </label>
        <input type="text" name="studentLastName" id=""  onblur="validateLastName()">
        <span id="studentLastNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Father Name: </label>
        <input type="text" name="studentFatherName" id=""  onblur="validateFatherName()">
        <span id="studentFatherNameAns" style="color:red;"></span>
        <br><br>

        <label for="">Phone Number: </label>
        <input type="tel" name="studentPhone" id=""  onblur="validatePhone()">
        <span id="studentPhoneAns" style="color:red;"></span>
        <br><br>

        <label for="">City: </label>
        <input type="text" name="studentCity" id=""  onblur="validateCity()">
        <span id="studentCityAns" style="color:red;"></span>
        <br><br>

        <label for="">Email: </label>
        <input type="text" name="studentEmail" id=""  onblur="validateEmail()">
        <span id="studentEmailAns" style="color:red;"></span>
        <br><br>

        

        <label for="">Gender:</label>
        <select name="studentGender" id="">
            <option value="" >  Both  </option>
            <option value="Male" >Male</option>
            <option value="Female" >Female</option>
        </select><br><br>

        <label for="">Hafiz-e-Quran:</label>
        <select name="studentHafizQuran" id="">
            <option value="" >  Any  </option>
            <option value="Yes" >Yes</option>
            <option value="No" >No</option>
        </select><br><br>

        <label for="">Degree:</label>
        <select name="studentDegree" id="">
            <option value="" >All</option>
            <option value="CS" >Computer Science</option>
            <option value="SE" >Software Engineering</option>
            <option value="IT" >Information Technology</option>
        </select><br><br>
           
        <label for="">Must Have:</label>
        <input type="radio" name="studentField" id="" value="AND" required > All the fields
        <input type="radio" name="studentField" id="" value="OR"  required> Any of the fields <br><br>

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


    



