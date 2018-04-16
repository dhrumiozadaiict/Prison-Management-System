import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class scheduling_Activities {
	public void showActivities(){
		System.out.println("For scheduling lunch press 1");
		System.out.println("For scheduling dinner press 2");
		System.out.println("For scheduling roaming time press 3");
	}
	public void showEmptySlots(int selectedActivity){
		activity_Slot a = new activity_Slot();
		a.showEmptySlots(selectedActivity);
	}
	public void showUnscheduledPrisonergroups(int selectedActivity){
		prisoner_Group p = new prisoner_Group();
		p.showUnscheduledPrisonergroups(selectedActivity);
	}
	public void schedulePrisonerGroup(int selectedActivity,int slotId,int prisonerGroupId){
		prisoner_Group p = new prisoner_Group();
		p.updateActivitySlot(selectedActivity,slotId,prisonerGroupId);
		activity_Slot a = new activity_Slot();
		a.markSlot(slotId);
	}
}
