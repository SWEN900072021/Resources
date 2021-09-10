package pessimistic.wait;

import java.sql.Connection;
import java.sql.SQLException;

import pessimistic.Account;
import pessimistic.wait.LockManagerWait;
import utils.DBUtils;

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
			
			//Should these updates be in a single DB transaction?
			from.update(conn);
			to.update(conn);
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
