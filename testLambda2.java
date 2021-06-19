package asd;

public class testLambda2 {
	public static void main(String args[]) {
		Ilove love = new Love();
		love.love(2);
		
		love = (a)->{
			System.out.println("I Love you" + a);
		};
		love.love(520);
	}
}
interface Ilove{
	void love(int a);
}

class Love implements Ilove{

	@Override
	public void love(int a) {
		// TODO Auto-generated method stub
		System.out.println("I Love you" + a);
		
	}
	
}