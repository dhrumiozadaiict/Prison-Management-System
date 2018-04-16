import java.util.HashSet;
import java.util.Queue;
public class approve_Request {
	public void showCourses(){
		course_details c = new course_details();
		c.showCourses();
	}
	public HashSet<Integer> showRequests(int courseId){
		//System.out.println("Hii");
		register_requests r = new register_requests();
		HashSet<Integer> h = r.showRequests(courseId);
		return h;
	}
	public void giveApproval(int prisonerId,int courseId){
		approvedPrisoners a = new approvedPrisoners();
		a.addNewRecord(prisonerId, courseId);
		register_requests r = new register_requests();
		r.deleteRecord(prisonerId);
		course_details c = new course_details();
		c.updateNoOfEmptySeats(courseId);
	}
}
