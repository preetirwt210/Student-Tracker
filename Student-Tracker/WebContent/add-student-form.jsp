<html>
<head><title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link type="text/css" rel="stylesheet" href="css/add-student-style.css"/>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>

<body>
<jsp:directive.include file="header.jsp"/>

		<form id="formLogin" action= "StudentControllerServlet" method="get">
		<input type="hidden" name="command" value="ADD"/>
		
		<table>
		      <tbody>
		           <tr>
		               <td align="right"><label>FirstName:</label></td>
		           <td align="left"><input type="text" name="firstName"/></td>
		           </tr>
		             <tr>
		               <td align="right"><label>LastName:</label></td>
		           <td align="left"><input type="text" name="lastName"/></td>
		           </tr>
		      
		              <tr>
		               <td align="right"><label>Email:</label></td>
		           <td align="left"><input type="text" name="email"/></td>
		           </tr>
		           
		           <tr>
		              
		           <td><input type="submit" value="Save" 
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
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#formLogin").validate({
			rules:{
				email: {
					required : true,
					email:true
					},
					firstName: "required",
					lastName: "required",
			},
			messages:{
				email:{
					required:"Please enter email" ,
					email:"Please enter a valid email address"
				},
				firstName: "Please enter firstname",
				lastName:"Please enter lastname"
			}
		});
	});
	  
	  
	     
	</script>
</html>