package priorityQueue;

import java.lang.*;
import java.util.*;
import edu.berkeley.cs.jqf.fuzz.*;
import java.util.PriorityQueue;

public class PriorityQueue2 {
    
    private int maximum;
	private int ptr;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    PriorityQueue<Integer> reversedQueue = new PriorityQueue<>(Comparator.reverseOrder());
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


    public PriorityQueue2(int num, boolean clasifer) throws OutOfMemoryError{ // constractor
        
        this.maximum = num;
        if(clasifer == false) this.isAscending = true;
		else {
            // this.queue = myQueue;
            this.isAscending = false;
        }
        
        if(num <=0){
            System.out.println("plese put an appropriate size");
            throw new OutOfMemoryError();
        }

		this.ptr = 0;
    }
    

    public void add(int num) throws QueueOverflowError{    // i have to make an excetion by myself

        if(this.ptr >= this.maximum){
            System.out.println("this is full");
            throw new QueueOverflowError();
        }

        if(this.isAscending == true)this.queue.add(num);
        else this.reversedQueue.add(num);

        ArrayList<Integer> pQueue = new ArrayList<Integer>(this.queue);
        StringBuilder sb1 = new StringBuilder();
        int k = 0;
        for (Integer item : pQueue) {
            if(k==0)sb1.append(item.toString());
            else sb1.append(","+item.toString());
            k++;
        }
        String a = sb1.toString();
        System.out.println("p2 currenty has " +a);

        
        this.ptr++;

    }
	
    public int poll() throws EmptyQueueException{ //An exception is thrown if we call pop() when the stack is empty.

        try{
            int poll = 0;
            if(this.isAscending == true)poll = this.queue.poll();
            else poll = this.reversedQueue.poll();
            --this.ptr;
            return poll;
        }
        catch(java.lang.NullPointerException e){
            System.out.println("this stack is empty");
            throw new EmptyQueueException();
        }

	}

    public int peek() throws EmptyStackException{

        try{
            if(this.isAscending == true){
                System.out.println(this.queue.peek());
                return this.queue.peek();
            }
            else return this.reversedQueue.peek();
        }
        catch(java.lang.NullPointerException e){
            System.out.println("this stack is empty");
            throw new EmptyQueueException();
        }
        
    }

    public ArrayList<Integer> get(){

        ArrayList<Integer> pQueue = new ArrayList<Integer>(this.queue);
        ArrayList<Integer> pReversedQueue = new ArrayList<Integer>(this.reversedQueue);
        if(this.isAscending == true)return pQueue;

		return pReversedQueue;
	}


}