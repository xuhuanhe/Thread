package asd;

public class staticProxy {
	public static void main(String args[]) {
		new Thread(()->System.out.println("i love you")).start();
		
		new weddingCompany(new you()).happy();
		weddingCompany weddingCompany = new weddingCompany(new you());
		weddingCompany.happy();
	}
}
interface marry{
	void happy();
}
class you implements marry{

	@Override
	public void happy() {
		// TODO Auto-generated method stub
		System.out.println("im going to marry");
	}
	
}

class weddingCompany implements marry{

	private marry target;
	public weddingCompany(marry target) {
		this.target = target;
	}
	@Override
	public void happy() {
		// TODO Auto-generated method stub
		
		before();
		this.target.happy();
		after();
	}
	private void after() {
		System.out.println("after");
	}
	private void before() {
		System.out.println("before");
	}
}