package syn;

public class unsafeBank {

	public static void main(String[] args) {
		Account account = new Account(100,"ETF");
		Drawing you = new Drawing(account,50,"you");
		Drawing girlFriend = new Drawing(account,100,"girlFriend");
		
		you.start();
		girlFriend.start();
	}
}


class Account{
	int money;
	String name;
	
	public Account(int money, String name) {
		this.money = money;
		this.name = name;
	}
} 

class Drawing extends Thread{
	Account account;
	int drawingMoney;
	int nowMoney;
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	public void run() {
		//check if there is money
		if(account.money - drawingMoney < 0) {
			System.out.println(Thread.currentThread().getName() + "not enought money");
			return;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//drawing 
		account.money = account.money - drawingMoney;
		// after drawing
		nowMoney = nowMoney + drawingMoney;
		
		System.out.println(account.name + "Money: " + account.money);
		System.out.println(this.getName() + Thread.currentThread().getName() +"money in hand " + nowMoney);
	}
	
}