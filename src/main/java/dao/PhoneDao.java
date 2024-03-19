
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entities.BeanUserPhone;
import entities.Phone;

public class PhoneDao {
	
	
	private Connection connection;
	
	
	
	public PhoneDao() {
		this.connection = SingleConnection.getConnection();
	}
	
	
	public void insert(Phone phone)  {
		String querySql = "INSERT INTO phones(phone_1, phone_2, user_id) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySql);
			preparedStatement.setString(1, phone.getPhone1());
			preparedStatement.setString(2, phone.getPhone2());
			preparedStatement.setLong(3, phone.getUserId());
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
			e.printStackTrace();
		}
	}
	
	public List<BeanUserPhone> findUserPhone(Long userId) throws SQLException{
		List<BeanUserPhone> beanUsersPhones = new ArrayList<>();
		String querySql = "SELECT * FROM phones as p INNER JOIN users as u ON p.user_id = " + userId; 
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String phone1 = resultSet.getString("phone_1");
			String phone2 = resultSet.getString("phone_2");
			BeanUserPhone beanUserPhone = new BeanUserPhone(name, email, phone1, phone2);
			beanUsersPhones.add( beanUserPhone);
		}
		return beanUsersPhones;
		
	}
	
	private static void rollback(Connection connection){
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
