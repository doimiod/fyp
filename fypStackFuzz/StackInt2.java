import java.lang.*;
import java.util.*;

public class StackInt2 {
    
    private int maximum;
	private int ptr;

    Stack<Integer> stack = new Stack<Integer>();

	public class EmptyStackIntException extends RuntimeException{
		public EmptyStackIntException() {}
	}
	
	public class OverflowStackIntException extends RuntimeException{
		public OverflowStackIntException() {}
	}

    public class OutOfMemoryError extends RuntimeException{
        public OutOfMemoryError() {}
    }


    public StackInt2(int num) throws OutOfMemoryError{
        this.maximum = num;
        
        if(num <=0){
            System.out.println("plese put an appropriate size");
            throw new OutOfMemoryError();
        }

		this.ptr = 0;
    }
    

    public void push(int num) {

        this.stack.push(num);
        System.out.println("pushed " + num);
    }
	
    public int pop(){ //An exception is thrown if we call pop() when the stack is empty.
        
        int result = 0;
        result = this.stack.pop();
		System.out.println("popped " + result);
		
		return result;
	}

    public int size() {
        return stack.size(); 
    }

    public int peek(){
        return stack.peek();
    }

}
