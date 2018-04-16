import java.util.Scanner;

public class Prisoner {
	public void showMethods(){
		System.out.println("For logout,press 0");
		System.out.println("For registering in a course,press 1");
	}
	public void selectMethod(int i,int id){
		switch(i){
			case 1:
				while(true){
					System.out.println("If you want to be out of registering for course press 0,for continue press 1");
					Scanner in = new Scanner(System.in);
					if(in.nextInt() == 0)
						break;
					else{
						register_in_course r = new register_in_course();
						int prisonerId = id;
						if(r.check(prisonerId)!=0){
							System.out.println("You have already approved for"+r.check(prisonerId)+",so you can't register in another course");
							break;
						}
						else{
							r.showCourseDetails();
							int courseId = in.nextInt();
							r.addRequest(prisonerId,courseId);
							System.out.println("Your have successfully registered for the course:"+courseId);
						}
					}
				}
			break;
		}
	}
}
