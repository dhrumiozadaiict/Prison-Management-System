import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class prisoner_Group {
	public void showUnscheduledPrisonergroups(int selectedActivity){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				System.out.println("Below are the unscheduled prisoner groups select one of them");
				if(selectedActivity == 1){
					PreparedStatement stmt = con.prepareStatement("SELECT groupId FROM prisoner_group WHERE (activity_1_slot IS NULL)");
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						System.out.print(rs.getInt(1) + " ");
					}
					System.out.println();
				}
				else if(selectedActivity == 2){
					PreparedStatement stmt = con.prepareStatement("SELECT groupId FROM prisoner_group WHERE (activity_2_slot IS NULL)");
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						System.out.print(rs.getInt(1) + " ");
					}
					System.out.println();
				}
				else{
					PreparedStatement stmt = con.prepareStatement("SELECT groupId FROM prisoner_group WHERE (activity_3_slot IS NULL)");
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						System.out.print(rs.getInt(1) + " ");
					}
					System.out.println();
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
	public void updateActivitySlot(int selectedActivity,int slotId,int prisonerGroupId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				if(selectedActivity == 1){
					PreparedStatement stmt = con.prepareStatement("UPDATE prisoner_group SET activity_1_slot = ? WHERE groupId = ?");
					stmt.setInt(1,slotId);
					stmt.setInt(2,prisonerGroupId);
					stmt.executeUpdate();
					System.out.println("Prisoner Group Scheduled");
				}
				else if(selectedActivity == 2){
					PreparedStatement stmt = con.prepareStatement("UPDATE prisoner_group SET activity_2_slot = ? WHERE groupId = ?");
					stmt.setInt(1,slotId);
					stmt.setInt(2,prisonerGroupId);
					stmt.executeUpdate();
					System.out.println("Prisoner Group Scheduled");
				}
				else{
					PreparedStatement stmt = con.prepareStatement("UPDATE prisoner_group SET activity_3_slot = ? WHERE groupId = ?");
					stmt.setInt(1,slotId);
					stmt.setInt(2,prisonerGroupId);
					stmt.executeUpdate();
					System.out.println("Prisoner Group Scheduled");
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
}
