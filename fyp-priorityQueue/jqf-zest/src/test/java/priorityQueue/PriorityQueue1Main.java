package priorityQueue;

import java.util.ArrayList;
import java.util.*;

public class PriorityQueue1Main{

	public static void main(String[] args) {
		
		PriorityQueue1 s1 = new PriorityQueue1(50, false);
        PriorityQueue1 s2 = new PriorityQueue1(50, true);

        int i = 0;
		
		s1.add(1);
        StringBuilder sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        String a = sb.toString();
        System.out.println(a);
		s1.add(2);
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.add(3);
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.add(3);
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.add(4);
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.add(6);
		s1.add(9);
		s1.add(19);
		s1.add(15);
		s1.add(67);
		s1.add(5);
		s1.add(7);
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }
        a = sb.toString();
        System.out.println(a);

        System.out.println(s1.size());

		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();
        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s1.poll();

        sb = new StringBuilder();
        
        for (Integer item : s1.get()) {
            sb.append(item.toString());
        }
        a = sb.toString();
        System.out.println(a);

        System.out.println("----------------------------------------------------------------");

        

        s2.add(1);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(2);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(3);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(3);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(4);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(6);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(9);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(19);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(15);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(67);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.add(5);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        System.out.println(s1.size());

        a = sb.toString();
        System.out.println(a);
		s2.add(7);
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        System.out.println(s1.size());

        a = sb.toString();
        System.out.println(a);
        System.out.println("---------------");

		s2.poll();
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.poll();
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);
		s2.poll();
        sb = new StringBuilder();
        
        for (Integer item : s2.get()) {
            sb.append(item.toString());
        }

        a = sb.toString();
        System.out.println(a);

		s2.poll();

        sb = new StringBuilder();
        i = 0;
        for (Integer item : s2.get()) {
            if(i==0)sb.append(item.toString());
            else sb.append(", "+item.toString());
            i++;
        }
        a = sb.toString();
        System.out.println(a);

		s2.poll();

        sb = new StringBuilder();
        i = 0;
        for (Integer item : s2.get()) {
            if(i==0)sb.append(item.toString());
            else sb.append(", "+item.toString());
            i++;
        }
        a = sb.toString();
        System.out.println(a);


		s2.poll();

        sb = new StringBuilder();
        i = 0;
        for (Integer item : s2.get()) {
            if(i==0)sb.append(item.toString());
            else sb.append(", "+item.toString());
            i++;
        }
        a = sb.toString();
        System.out.println(a);


		s2.poll();

        sb = new StringBuilder();
        i = 0;
        for (Integer item : s2.get()) {
            if(i==0)sb.append(item.toString());
            else sb.append(","+item.toString());
            i++;
        }
        a = sb.toString();
        System.out.println(a);

	}

}
