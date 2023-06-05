package priorityQueue;

import java.lang.*;
import java.util.*;
// import java.util.Arrays;
// import java.util.ArrayList;
// import edu.berkeley.cs.jqf.fuzz.*;
// import java.util.stream.*;
import java.util.ArrayList;

public class PriorityQueue1 {
	
	ArrayList<Integer> pQueue = new ArrayList<Integer>();
	private int maximum ;
	private int ptr;
	private boolean isAscending;

	public class EmptyQueueException extends RuntimeException{
		public EmptyQueueException() {}
	}
	
	public class OverflowQueueIntException extends RuntimeException{
		public OverflowQueueIntException() {}
	}

	public class QueueOverflowError extends RuntimeException{
		public QueueOverflowError() {}
	}
	

	public PriorityQueue1(int num, boolean clasifer) { // Constructor

		this.maximum = num;
		if(clasifer == true) this.isAscending = true;
		else this.isAscending = false;
		
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

    // this method is doing heapsort
	// public ArrayList<Integer> heap(ArrayList<Integer> list) {

	// 	return list;
	// }
	
	public void add(int num) throws QueueOverflowError{
		
		if(this.ptr >= this.maximum){
			System.out.println("this is full");
			throw new QueueOverflowError();
		}

		this.pQueue.add(num);
		Collections.sort(this.pQueue);
		this.ptr++;

    }
	
	public int poll() throws EmptyQueueException{

        int result = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyQueueException();
            // try to throw an exception if out of memory or bounds 
		}

		if(this.isAscending == true){
			result = this.pQueue.get(this.ptr-1);
			this.pQueue.remove(this.ptr-1);
			this.ptr--;
		}
		else{
			result = this.pQueue.get(0);
			this.pQueue.remove(0);
			this.ptr--;
		}

		return result;
	}
	
	public int peek() throws EmptyQueueException{

        int peek = 0;

		if(this.ptr <= 0) {
			System.out.println("this is empty");
			throw new EmptyQueueException();
		}

		if(this.isAscending == true) peek = this.pQueue.get(this.ptr-1);
		else peek = this.pQueue.get(0);

        return peek;	
	}

    public int size() {
        return this.pQueue.size();
    }

	public ArrayList<Integer> get(){
		return this.pQueue;
	}
	
}
