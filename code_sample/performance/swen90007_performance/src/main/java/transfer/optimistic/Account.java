package transfer.optimistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Account {

	private String name;
	private int balance;
	private int version;
	
	public Account(String name, int balance, int version) {
		this.name = name;
		this.balance = balance;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int getVersion() {
		return version;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}
	
	
	//Active record: find
	public static Account find(String name, Connection conn) {
		String stmnt = "SELECT version, balance " + "FROM account_optimistic " + "WHERE account_name = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setString(1, name);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int version = resultSet.getInt(1);
					int balance = resultSet.getInt(2);
					return new Account(name, balance, version);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Can't find account: " + name);
	}
	
	//Active record: update
	public void update(Connection conn) {
		String stmnt = "UPDATE account_optimistic " + "SET balance =  ?, version = version + 1" 
	+ "WHERE account_name = ? AND version = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setInt(1, balance);
			statement.setString(2, name);
			statement.setInt(3, version);
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated == 0) {
				//Reasons for this could further be explored here: is it because account data is outdated (version < db version), is it
				//because the account was deleted and doesn't exist anymore, is it because there is an error in version management (version > db version)...
				throw new RuntimeException("Can't update account " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

