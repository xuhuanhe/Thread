package asd;

public class testYeild {
	
	public static void main(String args[]) {
		myYield myYield = new myYield();
		new Thread(myYield,"a").start();
		new Thread(myYield,"b").start();
	}
	
}
class myYield implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " thread begin to execute");
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + " thread end ");
	}
	
}