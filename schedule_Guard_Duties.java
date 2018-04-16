import java.io.*;
import java.util.Scanner;
public class schedule_Guard_Duties {
	public void getUnscheduledGuardDutyTimes(){
		guard_Duty g = new guard_Duty();
		g.updateGuardDuties();
		g.showGuardDuties();
	}
	public void scheduleSelectedGuardDuty(int selectedGuardId){
		Scanner in = new Scanner(System.in);
		place_Duty p = new place_Duty();
		p.showEmptyPlaceDuty();
		int selectedPlaceId = in.nextInt();
		p.updateTotalSpacesLeft(selectedPlaceId);
		guard_Duty g = new guard_Duty();
		g.scheduleGuard(selectedGuardId,selectedPlaceId);
	}
}
