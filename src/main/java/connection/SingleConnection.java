package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String dbUrl = "jdbc:postgresql://localhost:5432/posjava";
	private static String dbPassword="root";
	private static String user="root";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
		
	public SingleConnection() {
		this.connect();
	}

	private static void connect() {
		try {
			if(connection == null) { // A conexão com o banco de dados é feita apenas uma vez.
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(dbUrl, user, dbPassword);
				connection.setAutoCommit(false); // As operações não serão executadas automaticamente.
				System.out.println("Conexão realizada com sucesso!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() {
		return connection;
	}

	
	
}
