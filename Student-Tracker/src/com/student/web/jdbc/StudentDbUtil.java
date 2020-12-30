package com.student.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.student.web.entity.Student;

public class StudentDbUtil {

		private DataSource dataSource;
		
		public StudentDbUtil(DataSource theDataSource) {
			dataSource = theDataSource;
		}
		
	public List<Student> getStudents() throws Exception{
			List<Student> students= new ArrayList<>();
			
			Connection myConn= null;
			Statement stmt= null;
			ResultSet rs= null;
		
			try {
				   myConn=dataSource.getConnection();
				   
				   String sql= "select * from student order by last_name";
				   
				   stmt=myConn.createStatement();
				   
				   rs=stmt.executeQuery(sql);
				   
				   while(rs.next()) {
					   int id=rs.getInt("id");
					   String firstName=rs.getString("first_name");
					   String lastName=rs.getString("last_name");
					   String email=rs.getString("email");
					   
					   Student tempStudent=new Student(id, firstName, lastName, email);
					   
					   students.add(tempStudent);
				   }
			
					return students;
			    }
			finally {
			          close(myConn,stmt,rs);
			}
		
	}

	private void close(Connection myConn, Statement stmt, ResultSet rs) {
		 
		try {
				if(rs !=null) {
					rs.close();
				}
				if(stmt !=null) {
					stmt.close();
				}
				if(myConn !=null) {
					myConn.close();
				}
			
		}
		catch(Exception e) {
			      e.printStackTrace();
		}
		
		
		
		
	}

	public void addStudents(Student theStudents) throws SQLException {
		      Connection myConn=null;
		      PreparedStatement stmt=null;
		      
		      try {
		    	  
		    	  myConn=dataSource.getConnection();
		    	  
		    	  String sql="insert into student"
		    			  + "(first_name , last_name, email)"
		    			  +  "values(?,?,?)";
		    	  
		    	  stmt=myConn.prepareStatement(sql);
		    	  
		    	  stmt.setString(1,theStudents.getFirstName());
		    	  stmt.setString(2,theStudents.getLastName());
		    	  stmt.setString(3,theStudents.getEmail());
		    	  
		    	  stmt.execute();
		      }
		      finally {
		    	  close(myConn,stmt,null);
		      }
		
		
	}
}
