package asd;

public class testJoin implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			System.out.println("coming " + i);
		}
	}
	public static void main(String args[]) throws InterruptedException {
		testJoin testJoin = new testJoin();
		Thread thread = new Thread(testJoin);
		thread.start();
		
		for (int i = 0; i < 500; i++) {
			if(i == 200) {
				thread.join();
			}
			System.out.println("main" + i);
		}
	}
}
