package transfer.pessimistic;

import java.sql.Connection;
import java.sql.SQLException;

import net.anotheria.moskito.aop.annotation.Monitor;
import transfer.pessimistic.LockManagerWait;
import transfer.utils.DBUtils;

@Monitor
public class TransferPessimisticWait {

	private Connection conn;
	
	public TransferPessimisticWait(Connection conn) {
		this.conn = conn;
	}

	public void transfer(String fromAccount, String toAccount, int amount) {
		
		//Start of transaction, acquire locks
		LockManagerWait.getInstance().acquireLock(fromAccount, Thread.currentThread().getName());
		LockManagerWait.getInstance().acquireLock(toAccount, Thread.currentThread().getName());
		
		Account from = Account.find(fromAccount, conn);
		Account to = Account.find(toAccount, conn);

		if (from.getBalance() >= amount) {
			from.addBalance((-1) * amount);
			to.addBalance(amount);
			
			try {
				conn.setAutoCommit(false);
				from.update(conn);
				to.update(conn);
				conn.commit();
			} catch (Exception e) {
				try {System.out.println("Rolling back transaction...");
					conn.rollback();
				} catch (SQLException e1) {
					//e1.printStackTrace();
				}
				//e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//End of transaction, release locks
		LockManagerWait.getInstance().releaseLock(fromAccount, Thread.currentThread().getName());
		LockManagerWait.getInstance().releaseLock(toAccount, Thread.currentThread().getName());
	}


	
	public static void main(String[] args) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferPessimisticWait transfer = new TransferPessimisticWait(conn);
			transfer.transfer("Alice", "Bob", 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
