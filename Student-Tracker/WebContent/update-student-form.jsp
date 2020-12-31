<html>
<head><title>Update Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link type="text/css" rel="stylesheet" href="css/add-student-style.css"/>


</head>

<body>
<jsp:directive.include file="header.jsp"/>
		<form action= "StudentControllerServlet" method="get">
		<input type="hidden" name="command" value="UPDATE"/>
		<input type="hidden" name="studentId" value="${THE_STUDENT.id}"/>
		<table>
		      <tbody>
		           <tr>
		               <td><label>FirstName:</label></td>
		           <td><input type="text" name="firstName"
		                         value="${THE_STUDENT.firstName }"
		           /></td>
		           </tr>
		             <tr>
		               <td><label>LastName:</label></td>
		           <td><input type="text" name="lastName"
		            value="${THE_STUDENT.lastName }"/></td>
		           </tr>
		      
		              <tr>
		               <td><label>Email:</label></td>
		           <td><input type="text" name="email"
		            value="${THE_STUDENT.email }"/></td>
		           </tr>
		           
		           <tr>
		              
		           <td><input type="submit" value="Update" 
		                  class="save"/></td> 
		          <td><input type="submit" value="Cancel" 
		                  class="cancel"/></td>
		           </tr>
		      
		      </tbody>
		
		</table>
		
		</form>
		<div style="clear:both"></div>
		
		<p>
		<a href="StudentControllerServlet">Back To List</a>
		</p>

</body>

</html>