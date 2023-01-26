import java.lang.*;

public class StackInt1 {
	
	private int [] stack;  
	private int maximum ;
	private int ptr;
	
	public class EmptyStackIntException extends RuntimeException{
		public EmptyStackIntException() {}
	}
	
	public class OverflowStackIntException extends RuntimeException{
		public OverflowStackIntException() {}
	}
	

	public StackInt1(int num) { // Constructor
		this.maximum = num;
		
		if(num <=0)System.out.println("plese put an appropriate size");
		
		try {
			this.stack = new int [this.maximum];
		}
		catch(OutOfMemoryError e) {
			this.maximum = 0;
		}
		this.ptr = 0;
	}
	
	public int[] push(int num) throws OverflowStackIntException{
		
		if(this.ptr >= this.maximum){
			System.out.println("this is full");
			throw new OverflowStackIntException();
		}
		
		this.stack[this.ptr++] = num;
		System.out.println("pushed " + num);

        return this.stack;
    }
	
	public int pop() throws EmptyStackIntException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackIntException();
            // try to throw an exception if outof memory or bounds 
		}
		result = this.stack[--this.ptr];
		System.out.println("poped put " + result);
		
		// return this.stack;
		return result;
	}
	
	public int peek() throws EmptyStackIntException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackIntException();
		}

		result = this.stack[this.ptr-1];
    	System.out.println("peek is " + result);

        return result;
			
	}

    public int size() {
        return this.stack.length;
    }

	public int[] getStack() {
		return this.stack;
	}
	
}
