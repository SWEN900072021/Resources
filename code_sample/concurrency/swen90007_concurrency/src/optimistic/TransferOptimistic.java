package optimistic;

import java.sql.Connection;
import java.sql.SQLException;

import utils.DBUtils;

public class TransferOptimistic {

	private Connection conn;
	
	public TransferOptimistic(Connection conn) {
		this.conn = conn;
	}

	public void transfer(String fromAccount, String toAccount, int amount) {
		Account from = Account.find(fromAccount, conn);
		Account to = Account.find(toAccount, conn);

		if (from.getBalance() >= amount) {
			from.addBalance((-1) * amount);
			to.addBalance(amount);
			
			//All updates have to be done in the same system transaction
			try {
				conn.setAutoCommit(false);
				from.update(conn);
				to.update(conn);
				conn.commit();
			} catch (Exception e) {
				try {System.out.println("Rolling back transaction...");
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	
	public static void main(String[] args) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferOptimistic transfer = new TransferOptimistic(conn);
			transfer.transfer("Alice", "Bob", 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
