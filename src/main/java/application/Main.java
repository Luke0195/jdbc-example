package application;


import java.util.List;

import connection.SingleConnection;
import dao.UserDao;
import entities.User;

public class Main {

	
	public static void main(String[]args) {
		 try {
		   UserDao dao = new UserDao();
		   User user = new User();
		   user.setId(1L);
		   user.setName("nome atualizado");
		   user.setEmail("email_atualizado@mail.com");
		   dao.update(user);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	
	}
	
	private static void showData(List<User> users) {
		for(User user: users) {
			System.out.println(user.toString());
		}
	}

}
