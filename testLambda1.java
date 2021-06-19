package asd;

public class testLambda1 {
	
	//3.static internal class
	static class Like2 implements ILike{

		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("I like lambda2");
			
		}
		
	}
	
	public static void main(String args[]) {
		ILike like = new Like();
		like.lambda();
		
		like = new Like2();
		like.lambda();
		
		
		//4.local inner class
		class Like3 implements ILike{

			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda3");
				
			}
			
		}
		like = new Like3();
		like.lambda();
		
		// 5.Anonymous inner class
		like = new ILike() {

			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda4");
			}
			
		};
		like.lambda();
		
		//6.lambda
		like = ()->{
			System.out.println("I like lambda5");
		};
		like.lambda();
		
	}
}
//1. define a functional interface
interface ILike{
	void lambda();
}
//2. implement class
class Like implements ILike{

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("I like lambda");
		
	}
	
}