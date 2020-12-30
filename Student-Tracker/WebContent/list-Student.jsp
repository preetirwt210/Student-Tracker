<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Tracker</title>
  <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body>
	  <jsp:directive.include file="header.jsp"/>
         <div id="container">
         <div id="content">
         
           <input type="button" value="Add Student" 
                          onclick="window.location.href='add-student-form.jsp';return false;" 
                             class="add-student-button"
          						/>
              <table>
              <tr>
	                  <td>FirstName</td>
	                   <td>LastName</td>             
	                   <td>Email</td>
              
              </tr>
               <c:forEach var="tempStudent" items="${ STUDENT_LIST}">
              <tr>
	                 <td>${tempStudent.getFirstName() }</td>
	                  <td>${tempStudent.getLastName() }</td>
	                  <td>${tempStudent.getEmail()}</td>
              </tr>
              </c:forEach>
              </table>
         
         </div>
         
         
         </div>


</body>


</html>