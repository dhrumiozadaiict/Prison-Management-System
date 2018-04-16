import java.util.HashSet;
import java.util.Scanner;

public class HOSDD {
	public void showMethods(){
		System.out.println("For logout, press 0");
		System.out.println("For Approving prisoner requests, press 1");
	}
	public void selectMethod(int i){
		switch(i){
			case 1:
				while(true){
					System.out.println("If you want to be out of approving prisoner requests press 0,for continue press 1");
					Scanner in = new Scanner(System.in);
					if(in.nextInt() == 0)
						break;
					else{ 
						approve_Request a = new approve_Request();
						a.showCourses();
						System.out.println("Enter courseId for approving requests");
						int courseId = in.nextInt();
						HashSet<Integer> h = a.showRequests(courseId);
						while(true){
							int ne = in.nextInt();
							if(ne == 0)
								break;
							else{
								//System.out.println("Hiii....");
								//System.out.println("Please select from above list of prisonerIds");
								if(h.contains(ne)){
									//System.out.println("Hii...");
									a.giveApproval(ne,courseId);
									System.out.println("Prisoner-Course Approved");
								}
								else
									System.out.println("Please select from list of above entries");
							}
						}
					}
				}
			break;
		}
	}
}
