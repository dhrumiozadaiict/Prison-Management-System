import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class course_details {
	public void showCourseDetails(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				System.out.println("Here is the details of the course, select one of the courseId to register");
				Statement stmt = con.createStatement();   
				ResultSet rs = stmt.executeQuery("SELECT * FROM course_details");
				System.out.println("courseId"+" "+"courseName"+"         "+"noOfEmptySeats"+" "+"description");
				while(rs.next()){
					System.out.printf("%-8s %-18s %-14s %-13s\n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateNoOfEmptySeats(int courseId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				PreparedStatement stmt = con.prepareStatement("UPDATE course_details SET noOfEmptySeats = noOfEmptySeats-1 WHERE courseId = ?");
				stmt.setInt(1, courseId);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showCourses(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				System.out.println("Below are the courseIds select one of them");
				PreparedStatement stmt = con.prepareStatement("SELECT courseId FROM course_details WHERE noOfEmptySeats>0");
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					System.out.print(rs.getInt(1)+" ");
				}
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
