
public class testPC {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer (container).start();
	}

}

class Consumer extends Thread{
	SynContainer container;
	
	public Consumer (SynContainer container) {
		this.container = container;
	}
	
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("consume-->" + container.pop().id + "chicken");
		}
	}
}
class Productor extends Thread{
	SynContainer container;
	
	public Productor (SynContainer container) {
		this.container = container;
	}
	
	//produce chicken
	public void run() {
		for (int i = 0; i < 100; i++) {
			container.push(new Chicken(i));
			System.out.println("produced" + i + "chicken");
		}
	}
}

class Chicken{
	int id;
	
	public Chicken(int i) {
		this.id = i;
	}
	
}


class SynContainer{
	//container
	Chicken[] chickens = new Chicken[10];
	int count = 0;
	//producer produce product
	
	public synchronized void push(Chicken chicken) {
		//if container is full, need to wait for Consumer to buy
		if(count == chickens.length) {
			//notify consumer , wait producer
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch b\lock
				e.printStackTrace();
			}
		}
		//if container is not full, put chicken in array
		chickens[count] = chicken;
		count++;
		
		//inform consumer to buy
		this.notify();
	}
	//two or more thread use one resource we need to use synchronized
	public synchronized Chicken pop() {
		//if there is no chicken
		if(count == 0) {
			//producer and consumer wait
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		count--;
		Chicken chicken = chickens[count];
		
		this.notifyAll();
		return chicken;
	}
}