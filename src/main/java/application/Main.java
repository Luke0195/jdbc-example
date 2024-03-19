package application;


import java.util.List;

import connection.SingleConnection;
import dao.PhoneDao;
import dao.UserDao;
import entities.BeanUserPhone;
import entities.Phone;
import entities.User;

public class Main {

	
	public static void main(String[]args) {
		 try {
		   
		    PhoneDao phoneDao = new PhoneDao();
		    List<BeanUserPhone> usersPhones = phoneDao.findUserPhone(3L);
			showData(usersPhones);
			
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	
	}
	
	private static void showData(List<BeanUserPhone> users) {
	
		for( BeanUserPhone item: users) {
			System.out.println(item);
		}
	}

}
