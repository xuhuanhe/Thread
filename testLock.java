package gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class testLock {
	public static void main(String[] args) {
		testLock2 testLock2 = new testLock2();
		
		new Thread(testLock2).start();
		new Thread(testLock2).start();
		new Thread(testLock2).start();
	}
}
class testLock2 implements Runnable{
	
	int ticketNum = 10;
	
	//Lock
	private final ReentrantLock lock = new ReentrantLock();
	
	public void run() {
		while(true) {
			
			try {
				lock.lock();
				if(ticketNum > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(ticketNum--);
				}else {
					break;
				}
			}finally {
				//unlock
				lock.unlock();
			}
			
		}
	}
}