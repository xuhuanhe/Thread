package asd;


public class testStop implements Runnable{
	private boolean flag = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(flag) {
			System.out.println("run......Thread" + i++);
		}
	}
	
	//set a public method to stop thread, change flag
	public void stop() {
		this.flag = false;
		
		
	}
			
			
	public static void main(String args[]) {
		testStop testStop = new testStop();
		new Thread(testStop).start();
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("main"+i);
			if(i == 900) {
				testStop.stop();
				System.out.println("stop");
			}
		}
	}
}
