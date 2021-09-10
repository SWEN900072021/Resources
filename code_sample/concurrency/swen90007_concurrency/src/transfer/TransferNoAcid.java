package transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtils;

public class TransferNoAcid {

	private Connection conn;

	public TransferNoAcid(Connection conn) {
		this.conn = conn;
	}

	public void transfer(String fromAccount, String toAccount, long amount) {

		long fromBalance = getBalance(fromAccount);

		if (fromBalance >= amount) {
			updateBalance(fromAccount, (-1) * amount);
			updateBalance(toAccount, amount);
		}
	}

	private void updateBalance(String toAccount, long amount) {
		String stmnt = "UPDATE account " + "SET balance = balance + ? " + "WHERE account_name = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setLong(1, amount);
			statement.setString(2, toAccount);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private long getBalance(String account) {
		String stmnt = "SELECT balance " + "FROM account " + "WHERE account_name = ?";
		try (PreparedStatement statement = conn.prepareStatement(stmnt)) {
			statement.setString(1, account);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getLong(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Can't find account: " + account);
	}
	
	public static void main(String[] args) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferNoAcid transfer = new TransferNoAcid(conn);
			transfer.transfer("Alice", "Bob", 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
