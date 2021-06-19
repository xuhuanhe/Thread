package asd;

public class testThread4 implements Runnable{
	private int ticketNums = 10;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(ticketNums <= 0) {
				break;
			}
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->get the number of" + ticketNums-- + "ticket");
		}
	}
	
	public static void main (String args[]) {
		testThread4 ticket = new testThread4();
		
		new Thread(ticket,"xiaoming").start();
		new Thread(ticket,"laoshi").start();
		new Thread(ticket,"huangniu").start();
		
	}
}
