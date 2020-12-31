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

	public Student getStudent(String theStudentId) throws Exception {
		
		Student theStudent=null;
		
		Connection myConn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int studentId;
		
		try {
			
			 studentId= Integer.parseInt(theStudentId);
			 
			 myConn=dataSource.getConnection();
			 
			 String sql="select * from student where id=?";
			 
			 stmt=myConn.prepareStatement(sql);
			 
			 stmt.setInt(1, studentId);
			 
			 rs=stmt.executeQuery();
			 
			 if(rs.next()) {
				 String firstName=rs.getString("first_name");
				 String lastName=rs.getString("last_name");
				 String email=rs.getString("email");
				 
				 theStudent =new Student(studentId, firstName, lastName,email);
				 
			 }
			 else{
				 throw new Exception("Could not find StudentId: "+ studentId);
			 }
			 return theStudent;
		}
		finally {
			close(myConn,stmt,rs);
		}
		
	}

	public void updateStudent(Student theStudent) throws Exception{
		
		Connection myConn= null;
		
		PreparedStatement stmt= null;
		
		
		
		try {
			
			myConn=dataSource.getConnection();
			
			String sql= "update student " 
			         +"SET first_name=?, last_name=?, email=? "
					+ "where id =?";
			
			stmt=myConn.prepareStatement(sql);
			
			stmt.setString(1,theStudent.getFirstName());
			stmt.setString(2,theStudent.getLastName());
			stmt.setString(3,theStudent.getEmail());
			stmt.setInt(4,theStudent.getId());
			
			stmt.execute();
			
		}
		finally {
			close(myConn,stmt,null);
		}
		
		
		
	}

	public void deleteStudent(String theStudentId) throws SQLException {
		
		Connection myConn=null;
		PreparedStatement stmt=null;
		
		try {
			int id=Integer.parseInt(theStudentId);
			
			myConn=dataSource.getConnection();
			
			String sql="delete from student where id=?";
			
			stmt=myConn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			
			
		}
		finally {
			close(myConn,stmt,null);
		}
		
	}
}
