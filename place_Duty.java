import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
public class place_Duty {
	public void showEmptyPlaceDuty(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				java.sql.Statement stmt = con.createStatement();
				System.out.println("Below are the empty placeIds,select one of them");
				ResultSet rs = stmt.executeQuery("SELECT PlaceId FROM place_duty WHERE no_Of_Spaces_Filled < max_Capacity");
				while(rs.next()){
					System.out.print(rs.getString(1)+" ");
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
	public void	updateTotalSpacesLeft(int selectedPlaceId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				java.sql.PreparedStatement stmt = con.prepareStatement("UPDATE place_Duty SET no_Of_Spaces_Filled = no_Of_Spaces_Filled + 1 WHERE PlaceId = ?");
				stmt.setInt(1,selectedPlaceId);
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
