import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class guard_Duty {
	public void updateGuardDuties(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				java.sql.Statement stmt=con.createStatement(); 
				stmt.executeUpdate("DELETE FROM guard_duty where (total_Duty_Time = 9)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showGuardDuties(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				java.sql.Statement stmt=con.createStatement(); 
				ResultSet rs = stmt.executeQuery("SELECT * FROM guard_Duty");
				System.out.println("GuardId"+" "+"DeptNo."+" "+"PreviousPlaceId"+" "+"totalDutyTime");
				while(rs.next()){
					System.out.println(rs.getInt(1)+"    "+rs.getInt(2)+"       "+rs.getInt(3)+"             "+rs.getInt(4));
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
	public void scheduleGuard(int selectedGuardId,int selectedPlaceId){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				PreparedStatement stmt = con.prepareStatement("UPDATE guard_duty SET current_Place_Id = ?,total_Duty_Time = total_Duty_Time+3 WHERE guardId = ?");
				stmt.setInt(1, selectedPlaceId);
				stmt.setInt(2, selectedGuardId);
				stmt.executeUpdate();
				PreparedStatement stmt2 = con.prepareStatement("SELECT guardId,total_duty_time from guard_duty_log WHERE guardid = ?");
				stmt2.setInt(1, selectedGuardId);
				ResultSet rs = stmt2.executeQuery();
				while(rs.next()){
					//System.out.println(rs.getInt(1));
					if(rs.getInt(2) == 0){
						PreparedStatement stmt3 = con.prepareStatement("UPDATE guard_duty_log SET placeId1 = ?,total_duty_time = total_duty_time+3 WHERE guard_duty_log.guardId = ?");
						stmt3.setInt(1, selectedPlaceId);
						stmt3.setInt(2, rs.getInt(1));
						stmt3.executeUpdate();
					}
					if(rs.getInt(2) == 3){
						PreparedStatement stmt3 = con.prepareStatement("UPDATE guard_duty_log SET placeId2 = ?,total_duty_time = total_duty_time+3 WHERE guard_duty_log.guardId = ?");
						stmt3.setInt(1, selectedPlaceId);
						stmt3.setInt(2, rs.getInt(1));
						stmt3.executeUpdate();
					}
					if(rs.getInt(2) == 6){
						//System.out.println("Hiii");
						PreparedStatement stmt3 = con.prepareStatement("UPDATE guard_duty_log SET placeId3 = ?,total_duty_time = total_duty_time+3 WHERE guard_duty_log.guardId = ?");
						stmt3.setInt(1, selectedPlaceId);
						stmt3.setInt(2, rs.getInt(1));
						stmt3.executeUpdate();
					}
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
