package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import entities.User;

public class UserDao {
	
	private Connection connection = null;
	
	public UserDao() {
		this.connection = SingleConnection.getConnection();
	}
	
	public void createUser(User user) throws SQLException {
		 String querySql = "INSERT INTO users(id,name, email) VALUES(?,?,?)";
		 PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		 preparedStatement.setLong(1, user.getId());
		 preparedStatement.setString(2, user.getName());
		 preparedStatement.setString(3, user.getEmail());
		 preparedStatement.execute();
		 connection.commit();
	}
	
	public List<User> findAllUsers() throws SQLException{
		List<User> users = new ArrayList<User>();
		String querySql = "SELECT * FROM users";
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		ResultSet resultSet = preparedStatement.executeQuery(); // get result of the select;
		while(resultSet.next()) {
			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			User user = new User(id, name, email);
			users.add(user);
		}
		return users;
		
	}
	
	public User findById(Long id) throws SQLException{
		User user = new User();
		String querySql = "SELECT * FROM users where id = " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(querySql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			user.setId(resultSet.getLong("id"));
			user.setName(resultSet.getString("name"));
			user.setEmail(resultSet.getString("email"));
		}
		return user;
	}
	
	public void update(User user) throws SQLException{
		String querySql = "UPDATE users SET name = ?, email = ? where id = " + user.getId();
		PreparedStatement preparedStament = connection.prepareStatement(querySql);
		preparedStament.setString(1, user.getName());
		preparedStament.setString(2, user.getEmail());
		preparedStament.execute();
		connection.commit();	
		
	}
	
	
	public void delete(Long id) {
		String querySQL = "DELETE FROM users where id = " + id;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
			preparedStatement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}

}
