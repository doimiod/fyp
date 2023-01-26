public class StackInt1Main {

	public static void main(String[] args) {
		
		StackInt1 s1 = new StackInt1(5);
		StackInt1 s2 = new StackInt1(8);
		StackInt1 s3 = new StackInt1(0);
		
		// s3.push(1);
		// s3.pop();



		
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.push(1);
		s1.push(2);
		
		s1.peek();
		
//		System.out.println(s1.peek());
		s2.peek();
		s2.push(1);
		s2.push(2);
		s2.push(3);
		s2.push(4);
		s2.push(5);
		s2.push(6);
		s2.push(7);
		s2.push(8);
		s2.push(9);
		s2.pop();
		s2.pop();
		s2.pop();
		s2.pop();
		
		s1.peek();
		s2.peek();
		
//		System.out.println(s1.peek());
//		System.out.println(s2.peek());
		
	}

}
