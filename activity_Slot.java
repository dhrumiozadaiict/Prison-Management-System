import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class activity_Slot {
	public void showEmptySlots(int selectedActivity){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				System.out.println("Below are the empty slots select one of them");
				PreparedStatement stmt = con.prepareStatement("SELECT slotId FROM activity_slots WHERE activityId = ? AND status = 0"); 
				stmt.setInt(1, selectedActivity);
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
	public void markSlot(int slotId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				PreparedStatement stmt = con.prepareStatement("UPDATE activity_Slots SET status = 1 WHERE slotId = ?"); 
				stmt.setInt(1, slotId);
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
