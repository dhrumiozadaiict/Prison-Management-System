import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Login {
	public static  String authenticate(int id,String password){
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
				PreparedStatement stmt=con.prepareStatement("SELECT * FROM list_of_valid_users"); 
				ResultSet rs=stmt.executeQuery();
				int flag = 0;
				while(rs.next()){
					if(rs.getInt(1) == id){
						flag = 1;
						if(rs.getString(2).compareTo(password) == 0){
							int p = (rs.getInt(1))/1000;
							if(p == 1)
								return "warden";
							else if(p==2)
								return "supervisor";
							else if(p==3)
								return "guard";
							else if(p==4)
								return "prisoner";
							else if(p==5)
								return "visitor";
							else
								return "HOSDD";
						}
						else
							return "1";
					}
				}
				if(flag == 0)
					return "0";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
