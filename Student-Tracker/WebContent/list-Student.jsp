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
	                   <td>Action</td>
              
              </tr>
               <c:forEach var="tempStudent" items="${ STUDENT_LIST}">
               <c:url var="tempLink" value="StudentControllerServlet">
               <c:param name="command" value="Load"/>
               <c:param name="studentId" value="${tempStudent.id }"/>
               </c:url>
               
               <c:url var="deleteLink" value="StudentControllerServlet">
               <c:param name="command" value="DELETE"/>
               <c:param name="studentId" value="${tempStudent.id }"/>
               </c:url>
              <tr>
	                 <td>${tempStudent.getFirstName() }</td>
	                  <td>${tempStudent.getLastName() }</td>
	                  <td>${tempStudent.getEmail()}</td>
	                  <td><a href="${tempLink }">Update</a>
	                  |
	                  <a href="${deleteLink }"onclick="if(!(confirm('Are You Sure.You wwant to delete this student?'))) return false">Delete</a></td>
              </tr>
              </c:forEach>
              </table>
         
         </div>
         
         
         </div>


</body>


</html>