<%@ page import="java.util.*, com.student.web.jdbc.* , com.student.web.entity.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Tracker</title>
</head>

<%
      List<Student> theStudents=
                      (List<Student>) request.getAttribute("STUDENT_LIST");
   
%>
<body>
	<%=theStudents %>



</body>


</html>