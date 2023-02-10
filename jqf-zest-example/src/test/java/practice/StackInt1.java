package practice;

import java.lang.*;
import java.util.Arrays;
import java.util.ArrayList;
import edu.berkeley.cs.jqf.fuzz.*;
import java.util.stream.*;

public class StackInt1 {
	
	private int [] stack;
	private int maximum ;
	private int ptr;
	
	// public class EmptyStackIntException extends RuntimeException{
	// 	public EmptyStackIntException() {}
	// }

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
		
		if(num <=0)System.out.println("plese put an appropriate size");
		
		try {
			this.stack = new int [this.maximum];
		}
		catch(OutOfMemoryError e) {
			this.maximum = 0;
		}
		this.ptr = 0;
	}
	
	public int[] push(int num) throws StackOverflowError{
		
		if(this.ptr >= this.maximum){
			System.out.println("this is full");
			throw new StackOverflowError();
		}

		int[] temp = Arrays.copyOf(this.stack, this.maximum); //make a copy of the stack
		Arrays.sort(temp);                                  // sort the array for binary search
		int containSame = Arrays.binarySearch(temp, num); // O(logn) search for the same number of elements.

		if(containSame < 0){
			this.stack[this.ptr++] = num;
			System.out.println("s1 pushed " + num);
		}
		else System.out.println("s1 : array alredy contains " + num);

		// System.out.println(Arrays.toString(this.stack));
		// System.out.println("temp is "+Arrays.toString(temp));
		
		return this.stack;
    }
	
	public void pop() throws EmptyStackException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackException();
            // try to throw an exception if outof memory or bounds 
		}

		result = this.stack[--this.ptr];
		System.out.println("s1 popped out " + result);

		this.ptr++;
		
		int[] newArray = new int[this.maximum];
		for (int i = 0, j = 0; i < this.stack.length; i++) { //o(n)
			if (i == this.ptr) {
				continue;
			}
			newArray[j++] = this.stack[i];
		}

		this.stack = newArray;

		--this.ptr;
	}

		// return result;
		
		// return this.stack[--this.ptr];
// //array to arrayList
		// ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(this.stack)); 
		// // Remove the specified element 
		// arrayList.remove(this.ptr); 
	 
		// // return the resultant array 
		// arrayList.stream().mapToInt(Integer::intValue).toArray(); 

// 		System.arraycopy(originalArray, indexToRemove + 1, originalArray, indexToRemove, originalArray.length - indexToRemove - 1);
// originalArray = Arrays.copyOf(originalArray, originalArray.length - 1);

	
	
	public int peek() throws EmptyStackException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyStackException();
		}

		result = this.stack[this.ptr-1];
    	// System.out.println("peek is " + result);

        return result;
			
	}

    public int size() {
        return this.stack.length;
    }

	public int[] getStack() {
		return this.stack;
	}
	
}
