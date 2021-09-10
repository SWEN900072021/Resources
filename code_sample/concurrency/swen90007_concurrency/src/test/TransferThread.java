package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import optimistic.TransferOptimistic;
import optimistic.TransferOptimisticWrong;
import pessimistic.exception.TransferPessimisticEX;
import pessimistic.wait.TransferPessimisticWait;
import transfer.TransferAcid;
import transfer.TransferNoAcid;
import utils.DBUtils;
import utils.TransferType;

public class TransferThread extends Thread {

	private TransferType transferType;
	private CountDownLatch startLatch;

	public TransferThread(TransferType transferType, CountDownLatch startLatch) {
		this.transferType = transferType;
		this.startLatch = startLatch;
	}

	@Override
	public void run() {
		try {
			startLatch.await();
			
			try (Connection conn = DBUtils.getConnection()) {
				switch (transferType) {
				case ACID:
					TransferAcid transferAcid = new TransferAcid(conn);
					transferAcid.transfer("Alice", "Bob", 10);
					break;
				case NO_ACID:
					TransferNoAcid transferNoAcid = new TransferNoAcid(conn);
					transferNoAcid.transfer("Alice", "Bob", 10);
					break;
				case OPTIMISTIC:
					TransferOptimistic transferOpt = new TransferOptimistic(conn);
					transferOpt.transfer("Alice", "Bob", 10);
					break;
				case OPTIMISTIC_WRONG:
					TransferOptimisticWrong transferOptWrong = new TransferOptimisticWrong(conn);
					transferOptWrong.transfer("Alice", "Bob", 10);
					break;
				case PESSIMISTIC_EX:
					TransferPessimisticEX transferPessimisticEx = new TransferPessimisticEX(conn);
					transferPessimisticEx.transfer("Alice", "Bob", 10);
					break;
				case PESSIMISTIC_WAIT:
					TransferPessimisticWait transferPessimisticWait = new TransferPessimisticWait(conn);
					transferPessimisticWait.transfer("Alice", "Bob", 10);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
