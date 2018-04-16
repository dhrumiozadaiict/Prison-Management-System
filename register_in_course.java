
public class register_in_course {
	public void showCourseDetails(){
		course_details c = new course_details();
		c.showCourseDetails();
	}
	public int check(int prisonerId){
		approvedPrisoners a = new approvedPrisoners();
		if(a.check(prisonerId)!=0){
			return a.check(prisonerId);
		}
		else return 0;
	}
	public void addRequest(int prisonerId, int courseId){
		register_requests r = new register_requests();
		r.addNewRecord(prisonerId,courseId);;
	}
}
