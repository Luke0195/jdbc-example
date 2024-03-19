package application;


import java.util.List;

import connection.SingleConnection;
import dao.PhoneDao;
import dao.UserDao;
import entities.Phone;
import entities.User;

public class Main {

	
	public static void main(String[]args) {
		 try {
		    UserDao userDao = new UserDao();
			
		    
		    Phone phone = new Phone(1L, "(31)99284-9429", "(31)9401-92402", 3L);
		    PhoneDao phoneDao = new PhoneDao();
		    phoneDao.insert(phone);
			
			
			 
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
