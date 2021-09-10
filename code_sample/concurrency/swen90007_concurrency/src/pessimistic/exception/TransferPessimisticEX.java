package pessimistic.exception;

import java.sql.Connection;
import java.sql.SQLException;

import pessimistic.Account;
import utils.DBUtils;

public class TransferPessimisticEX {

	private Connection conn;
	
	public TransferPessimisticEX(Connection conn) {
		this.conn = conn;
	}

	public void transfer(String fromAccount, String toAccount, int amount) {
		
		//Start of transaction, acquire locks
		//These methods throw an exception if lock cannot be acquired
		LockManagerEX.getInstance().acquireLock(fromAccount, Thread.currentThread().getName());
		LockManagerEX.getInstance().acquireLock(toAccount, Thread.currentThread().getName());
		
		Account from = Account.find(fromAccount, conn);
		Account to = Account.find(toAccount, conn);

		if (from.getBalance() >= amount) {
			from.addBalance((-1) * amount);
			to.addBalance(amount);
			
			//Should these updates be in a single DB transaction?
			from.update(conn);
			to.update(conn);
		}
		
		//End of transaction, release locks
		LockManagerEX.getInstance().releaseLock(fromAccount, Thread.currentThread().getName());
		LockManagerEX.getInstance().releaseLock(toAccount, Thread.currentThread().getName());
	}


	
	public static void main(String[] args) {
		try(Connection conn = DBUtils.getConnection()) {
			TransferPessimisticEX transfer = new TransferPessimisticEX(conn);
			transfer.transfer("Alice", "Bob", 10);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
