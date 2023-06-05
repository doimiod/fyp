package practice;

public class StackInt1 {
	
	private int [] stack = {};
	private int maximum ;
	private int ptr;

	public class EmptyStackException extends RuntimeException{
		public EmptyStackException() {}
	}
	
	public class OverflowStackIntException extends RuntimeException{
		public OverflowStackIntException() {}
	}

	public class StackOverflowError extends RuntimeException{
		public StackOverflowError() {}
	}
	

	public StackInt1(int num) { // Constructor

		this.maximum = num;
		
		if(num <=0){
			System.out.println("plese put an appropriate size");
			this.ptr = 0;
		}

	}

	public int linearSearch(int [] arr, int num){ //linear search

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}

    // this method can add number into array
	public int[] addNum(int[] arr, int num){

		int[] newNumber = new int[(arr==null)?1:arr.length+1]; //if array is null put 1, otherwise size + 1
		if (arr!= null)
		System.arraycopy( arr, 0, newNumber, 0, arr.length );
		newNumber[newNumber.length-1] = num;
		arr = newNumber;

		return arr;
	}
	
	public void push(int num) throws StackOverflowError{
		
		if(this.ptr >= this.maximum){
			System.out.println("this is full");
			throw new StackOverflowError();
		}

		int containSame = linearSearch(this.stack, num);
		
		if(containSame < 0 || this.ptr != 21){
			this.stack = addNum(this.stack, num);
			System.out.println("s1 pushed " + num);
			this.ptr++;
		}
		else System.out.println("s1 : array alredy contains " + num);
    }

	public int pop() throws EmptyStackException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackException();
            // try to throw an exception if out of memory or bounds 
		}
		
		result = this.stack[--this.ptr];
		System.out.println("s1 popped out " + result);
		
		int[] newArray = new int[this.stack.length-1];

		System.arraycopy( this.stack, 0, newArray, 0, this.stack.length-1 );
	
		this.stack = newArray;
		
		return result;
	}


	public int peek() throws EmptyStackException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackException();
		}
		result = this.stack[this.ptr-1];
        return result;
			
	}

    public int size() {
        return this.stack.length;
    }

	public int[] getStack() {
		return this.stack;
	}
	
}
