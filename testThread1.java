package asd;

public class testThread1 extends Thread{
	public void run() {
		for(int i = 0 ; i <20; i++) {
			System.out.println("1");
		}
	}
	public static void main (String[] args) {
		//main
		testThread1 test = new testThread1();
		test.run();
		for(int i = 0 ; i <20; i++) {
			System.out.println("2");
		} 
	}
} 
