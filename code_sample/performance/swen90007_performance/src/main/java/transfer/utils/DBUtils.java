package transfer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/bankdb";
	private static final String USER = "postgres";
	private static final String PWD = "postgres";
	
	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new org.postgresql.Driver());
		Connection conn = DriverManager.getConnection(CONNECTION_URL, USER, PWD);
		return conn;
	}

}
