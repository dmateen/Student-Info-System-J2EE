<!DOCTYPE html>
<html lang="en">
<%@ page session = "false" %>
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>

<%
    HttpSession session=request.getSession(false);  
    
    if(session != null)
    {
%>
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

            var allowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

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

            var roll = document.updateStudentForm.studentRollNumber.value;

            if (!alphanumericCheck(roll)) {
                document.getElementById('studentRollNumberAns').innerHTML = " ";
                document.getElementById('studentRollNumberAns').innerHTML = "Only Alphabets & Numbers Allowed";
                return false;
            }
            document.getElementById('studentRollNumberAns').innerHTML = " ";
            return true;
        }
        //********Roll Validation Function Ends here********

        //********Main Validation Function********
        function validate() {
            return true;
        }
        //********Main Validation Function********
    </script>

</head>

<body>
<jsp:include page="template.jsp"/>
    <form action="updateStudent" method="POST" name="updateStudentForm">
        <label for="">Roll Number: </label>
        <input type="text" name="studentRollNumber" id="" onblur="validateRollNumber()">
        <span id="studentRollNumberAns" style="color:red;"></span>
        <br><br>

        <input type="submit" value="Submit" onclick="return validate()">
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