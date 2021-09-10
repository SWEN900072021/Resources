package pessimistic.exception;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class LockManagerEX {
	
	private static LockManagerEX instance;
	
	//Key: lockable
	//Value: owner
	private ConcurrentMap<String, String> lockMap;

	public static synchronized LockManagerEX getInstance() {
		if(instance == null) {
			instance = new LockManagerEX();
		}
		return instance;
	}
	
	private LockManagerEX() {
		lockMap = new ConcurrentHashMap<String, String>();
	}
	
	public void acquireLock(String lockable, String owner) {
		if(!lockMap.containsKey(lockable)) {
			//no lock on lockable, grant lock
			lockMap.put(lockable, owner);
		} else {
			throw new RuntimeException("Concurrency exception, " + owner + " could not acquire lock for " + lockable); 
		}
	}
	
	public void releaseLock(String lockable, String owner) {
		lockMap.remove(lockable);
		notify();
	}
}
