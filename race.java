package asd;

public class race implements Runnable {
	private static String winner;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		for(int i = 0 ; i <= 100 ; i++) {
			// make the rabbit sleep
			if(Thread.currentThread().getName().equals("rabbit") && i%10 == 0) {
				try {
					Thread.sleep(1);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			boolean flag = gameOver(i);
			if(flag) {
				break;
			}
			System.out.println(Thread.currentThread().getName()+ "-->run " + i + " step");
		}
		
	}
	private boolean gameOver(int steps) {
		if(winner !=null)
			return true;
		if(steps >=100) {
			winner = Thread.currentThread().getName();
			System.out.println("winner is " + winner);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		race race = new race();
		new Thread(race,"rabbit").start();
		new Thread(race,"turtle").start();
	}
}
