package test;

import java.util.concurrent.CountDownLatch;

import utils.TransferType;

public class ConcurrentTransfers {

	public static void main(String[] args) {
		
		//TransferType type =  TransferType.ACID;
		//TransferType type =  TransferType.NO_ACID;
		//TransferType type =  TransferType.OPTIMISTIC;
		//TransferType type =  TransferType.OPTIMISTIC_WRONG;
		//TransferType type =  TransferType.PESSIMISTIC_EX;
		TransferType type =  TransferType.PESSIMISTIC_WAIT;
		
		int numThreads = 100;
		CountDownLatch startLatch = new CountDownLatch(1);

        for (int i = 0; i < numThreads; i++) {
            new TransferThread(type, startLatch).start();
        }
        System.out.println("Starting threads");
        
        startLatch.countDown();
        

	}

}
