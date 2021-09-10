package pessimistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Account {

	private String name;
	private int balance;
	
	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}
	
	
	//Active record: find
	public static Account find(String name, Connection conn) {
		String stmnt = "SELECT balance " + "FROM account " + "WHERE account_name = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setString(1, name);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int balance = resultSet.getInt(1);
					return new Account(name, balance);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Can't find account: " + name);
	}
	
	//Active record: update
	public void update(Connection conn) {
		//Use DB trigger to automatically update version when row is updated
		String stmnt = "UPDATE account " + "SET balance =  ? " + "WHERE account_name = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setInt(1, balance);
			statement.setString(2, name);
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated == 0) {
				throw new RuntimeException("Account not found: " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

