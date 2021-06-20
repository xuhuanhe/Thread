package asd;

public class testState {
	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("/////////");
		});
		
		//observe the stage
		Thread.State state = thread.getState();
		System.out.println(state);//new
		
		thread.start();
		state = thread.getState();
		System.out.println(state);//run
		
		while(state != Thread.State.TERMINATED) {
			try {
				Thread.sleep(100);
				state = thread.getState();
				System.out.println(state);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
