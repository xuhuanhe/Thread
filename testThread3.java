package asd;

public class testThread3 implements Runnable{
	public void run() {
		for(int i = 0 ; i <20; i++) {
			System.out.println("5");
		}
	}
	public static void main (String[] args) {
		//create runnable interface class object
		testThread3 testThread3 = new testThread3();
		//create thread object
		Thread thread = new Thread(testThread3);
		thread.start();
		for(int i = 0 ; i < 1000; i++) {
			System.out.println("2");
		} 
	}
}
