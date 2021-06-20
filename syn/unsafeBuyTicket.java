package syn;


//unsafe
public class unsafeBuyTicket {
	public static void main(String[] args) {
		BuyTicket station = new BuyTicket();
		
		new Thread(station,"kubi").start();
		new Thread(station,"niubi").start();
		new Thread(station,"huangniu").start();
	}
}
class BuyTicket implements Runnable{

	private int ticketNum = 10;
	boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//bought the ticket 
		while(flag) {
			buy();
		}
	}
	private void buy() {
		//check if there is ticket left
		if(ticketNum <=0 ) {
			flag = false;
			return; 
		}
		//delay
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//bought the ticket
		System.out.println(Thread.currentThread()+"get " + ticketNum--);
	}
}