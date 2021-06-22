

public class testPC2 {
	public static void main(String[] args) {
		TV tv = new TV();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}
class Player extends Thread{
	TV tv;
	public Player (TV tv) {
		this.tv = tv;
	}
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i%2 == 0) {
				this.tv.play("john wick ");
			}else {
				this.tv.play("tiktok");
			}
		}
	}
	
}

class Watcher extends Thread{
	TV tv;
	public Watcher (TV tv) {
		this.tv = tv;
	}
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();
		}
	}
}

class TV{
	//player play, watcher wait T
	//player wait, watcher play F
	String voice;
	boolean flag = true;
	
	public synchronized void play(String voice) {
		
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("player played: " +voice);
		//update the voice
		this.notifyAll();
		this.voice = voice;
		this.flag = !this.flag;
	}
	
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("watched: " + voice);
		this.notifyAll();
		this.flag = !this.flag;
		
	}
}