import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class approvedPrisoners {
	public int check(int prisonerId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				Statement stmt = con.createStatement();   
				ResultSet rs = stmt.executeQuery("SELECT * FROM approvedprisoners");
				while(rs.next()){
					if(rs.getInt(1) == prisonerId)
						return rs.getInt(2);
					else
						continue;
				}
				return 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void addNewRecord(int prisonerId, int courseId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				String sql = "INSERT INTO approvedprisoners "+"VALUES(?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, prisonerId);
				stmt.setInt(2, courseId);
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
}
