import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.mysql.jdbc.PreparedStatement;

public class register_requests {
	public void addNewRecord(int prisonerId,int courseId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//int p = prisonerId;
				//int q = courseId;
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				String sql = "INSERT INTO register_requests "+"VALUES(?,?)";
				java.sql.PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,prisonerId);
				stmt.setInt(2,courseId);
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
	public void deleteRecord(int prisonerId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//int p = prisonerId;
				//int q = courseId;
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				String sql = "DELETE FROM register_requests WHERE prisonerId = ?";
				java.sql.PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,prisonerId);
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
	public HashSet<Integer> showRequests(int courseId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				System.out.println("Below are the registered prisonerIds for selected course, select prisonerIds which you want to approve this course one by one for complete the process press 0");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				java.sql.PreparedStatement stmt = con.prepareStatement("SELECT prisonerId FROM register_requests WHERE courseId = ?");
				stmt.setInt(1,courseId);
				ResultSet rs = stmt.executeQuery();
				HashSet<Integer> h = new HashSet<Integer>();
				while(rs.next()){
					System.out.print(rs.getInt(1)+" ");
					//System.out.println("Hii....");
					h.add(rs.getInt(1));
				}
				System.out.println();
				return h;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
