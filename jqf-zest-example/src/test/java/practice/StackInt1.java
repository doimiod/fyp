package practice;

import java.lang.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import edu.berkeley.cs.jqf.fuzz.*;
import java.util.stream.*;

public class StackInt1 {
	
	private int [] stack = {};
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
		/*this.maximum = num;
		
		if(num <=0)System.out.println("plese put an appropriate size");
		
		try {
			this.stack = new int [this.maximum];
		}
		catch(OutOfMemoryError e) {
			this.maximum = 0;
		}
		this.ptr = 0;
		*/

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
		
		if(containSame < 0 || this.ptr != 5){
			this.stack = addNum(this.stack, num);
			// this.stack[this.ptr++] = num;
			System.out.println("s1 pushed " + num);
			this.ptr++;
		}
		else System.out.println("s1 : array alredy contains " + num);
    }

/* 	// int[] temp = Arrays.copyOf(this.stack, this.ptr); //make a copy of the stack
		// System.out.println("temp1 is "+Arrays.toString(temp));
		// Arrays.sort(temp);                                  // sort the array for binary search
		// int containSame = Arrays.binarySearch(temp, num); // O(logn) search for the same number of elements.
		// System.out.println("temp is "+Arrays.toString(temp));
		
		// System.out.println(Arrays.toString(this.stack));
		// System.out.println("temp is "+Arrays.toString(temp));
		
		// return this.stack;
*/
	
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

		// for (int i = 0; i < this.stack.length; i++) { //o(n) <- bad algorithm
		// 	if (i != this.ptr)
		// 	newArray =  addNum(newArray, this.stack[i]);
		// }

		System.arraycopy( this.stack, 0, newArray, 0, this.stack.length-1 );
		// System.out.println("new Array is " + Arrays.toString(newArray));

		this.stack = newArray;
		
		return result;

		
		// 	result = this.stack[--this.ptr];
		// 	System.out.println("s1 popped out " + result);

		// 	int[] newArray = new int[this.stack.length-1];
		// 	System.arraycopy( this.stack, 0, newArray, 0, this.stack.length-1 );

		// 	this.stack = newArray;
		
		// return result;
	
	}

/* 		
		// return this.stack[--this.ptr];
		// //array to arrayList
		// ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(this.stack)); 
		// // Remove the specified element 
		// arrayList.remove(this.ptr); 
	 
		// // return the resultant array 
		// arrayList.stream().mapToInt(Integer::intValue).toArray(); 
		
		// 		System.arraycopy(originalArray, indexToRemove + 1, originalArray, indexToRemove, originalArray.length - indexToRemove - 1);
		// originalArray = Arrays.copyOf(originalArray, originalArray.length - 1);
*/
	
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
