package application;


import connection.SingleConnection;
import dao.UserDao;
import entities.User;

public class Main {

	
	public static void main(String[]args) {
		 try {
			 User user = new User(2L, "Maria", "maria@mail.com");
			 UserDao dao = new UserDao();
			 dao.createUser(user);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	
	}

}
