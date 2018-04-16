import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
   	 // TODO Auto-generated method stub
   	 Scanner in = new Scanner(System.in);
   	 while(true){
   		 System.out.println("Enter userId and password");
   		 int id = in.nextInt();
   		 String password = in.next();
   		 Login l = new Login();
   		 String s = l.authenticate(id,password);
   		 if(s == "0"){
   			 System.out.println("Invalid User");
   			 continue;
   		 }
   		 else if(s == "1"){
   			 System.out.println("Invalid Password, please check if your caps lock is on");
   			 continue;
   		 }
   		 else{
   			 switch(s){
   				 case "warden":
   					 Warden w = new Warden();
   					 while(true){
  						w.showMethods();
  						int i = in.nextInt();
  						w.selectMethod(i);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					 }
   				 break;
   				 case "supervisor":
   					 Supervisor sr = new Supervisor();
   					 while(true){
  						sr.showMethods();
  						int i = in.nextInt();
  						sr.selectMethod(i);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					 }
   				 break;
   				 case "guard":
   					 Guard g = new Guard();
   					 while(true){
  						g.showMethods();
  						int i = in.nextInt();
  						g.selectMethod(i);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					 }
   				 break;
   				 case "prisoner":
   					 Prisoner p = new Prisoner();
   					 while(true){
  						p.showMethods();
  						int i = in.nextInt();
  						p.selectMethod(i,id);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					}
   				 break;
   				 case "visitor":
   					 Visitor v = new Visitor();
   					 while(true){
  						v.showMethods();
  						int i = in.nextInt();
  						v.selectMethod(i);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					 }
   				break;
   				case "HOSDD":
   					HOSDD h = new HOSDD();
   					while(true){
  						h.showMethods();
  						int i = in.nextInt();
  						h.selectMethod(i);
  						if(i==0){
  							System.out.println("You have successfully logged out");
  							break;
  						}
   					 }
   				break;
   			 }   	 
   		 }
   	 }
    }

}


