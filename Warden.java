import java.io.*;
import java.util.*;
public class Warden {
	public void showMethods(){
		System.out.println("For logout press 0");
		System.out.println("For scheduling guard duties press 1");
		System.out.println("For scheduling prisoners' primary activities press2");
	}
	public void selectMethod(int i){
		switch(i){
			case 1:
				while(true){
					System.out.println("If you want to be out of scheduling guard duties press 0,for continue press 1");
					Scanner in = new Scanner(System.in);
					if(in.nextInt() == 0)
						break;
					else{
						schedule_Guard_Duties s = new schedule_Guard_Duties();
						s.getUnscheduledGuardDutyTimes();
						System.out.println("Select a guardId from above entries to schedule");
						int selectedGuardId = in.nextInt();
						s.scheduleSelectedGuardDuty(selectedGuardId);
						System.out.println("Prisoner Duty Scheduled");
					}
				}
			break;
			case 2:
				while(true){
					System.out.println("If you want to be out of scheduling prisoner activities press 0,for continue press 1");
					Scanner in = new Scanner(System.in);
					if(in.nextInt() == 0)
						break;
					else{
						scheduling_Activities s1 = new scheduling_Activities();
						s1.showActivities();
						int selectedActivity = in.nextInt();
						s1.showEmptySlots(selectedActivity);
						int slotId = in.nextInt();
						s1.showUnscheduledPrisonergroups(selectedActivity);
						int prisonerGroupId = in.nextInt();
						s1.schedulePrisonerGroup(selectedActivity,slotId,prisonerGroupId);
 					}
				}
			break;
		}
			
	}
}
