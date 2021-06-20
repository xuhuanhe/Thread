package asd;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class testSleep {
	public static void main(String args[]) {
		Date startTime = new Date(System.currentTimeMillis());
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
				startTime = new Date(System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void tenDown() throws InterruptedException {
		int num = 10;
		while(true) {
			Thread.sleep(1000);
			System.out.println(num--);
			if(num<=0) {
				break;
			}
		}
	}
}


