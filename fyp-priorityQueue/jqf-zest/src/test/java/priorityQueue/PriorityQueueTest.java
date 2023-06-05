package priorityQueue;

import java.lang.*;
import java.util.*;
import java.util.Random;
import static java.util.GregorianCalendar.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.junit.Assert.assertArrayEquals;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;


@RunWith(JQF.class)
public class PriorityQueueTest {

    public PriorityQueue1 p1 = new PriorityQueue1(50, false);
    public PriorityQueue2 p2 = new PriorityQueue2(50, false);

    String className1 = p1.getClass().getName();
    String className2 = p2.getClass().getName();

    boolean p1Exception = false;
    boolean p2Exception = false;

    Exception exception1;
    Exception exception2;

    @Fuzz
    public void testPriorityQueue(@From(PriorityQueueIntGenerator.class) int[][] array) {
        
        // System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array));
        // System.out.println(className1);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int k = 0;

        // make a case
        System.out.println(array[0].length);

        for(int i = 0; i < array[0].length; i++) {              

            boolean p1Exception = false;
            boolean p2Exception = false;
            
            int num = array[0][i];
            switch (array[1][i]) {

                case 1:
                System.out.println("case 1 -------------------- "+ i);

                try{
                    p1.add(num);
                }catch(Exception e){
                    p1Exception = true;
                    exception1 = e;
                }

                try{
                    p2.add(num);
                }
                catch(Exception e){
                    p2Exception = true;
                    exception2 = e;
                }

                if(p1Exception == true || p2Exception == true){
                    assertTrue(p1Exception == p2Exception); // check both of them throw exceptions
                    // assertEquals(exception1, exception2); // check both of them throw the same exception

                    boolean compareCase1Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase1Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }

                sb1 = new StringBuilder();
                k = 0;
                for (Integer item : p1.get()) {
                    if(k==0)sb1.append(item.toString());
                    else sb1.append(","+item.toString());
                    k++;
                }

                String a = sb1.toString();
                System.out.println("p1 currenty has " +a);

                sb2 = new StringBuilder();
                k = 0;
                for (Integer item : p2.get()) {
                    if(k==0)sb2.append(item.toString());
                    else sb2.append(","+item.toString());
                    k++;
                }
                a = sb2.toString();
                System.out.println("p2 currenty has " +a);

                break;
                
                case 2:
                System.out.println("case 2 -------------------- "+ i); 
                
                Integer poll1 = 0;
                Integer poll2 = 0;

                try{
                    poll1 = p1.poll();
                    System.out.println(poll1);
                }catch(Exception e){
                    p1Exception = true;
                    exception1 = e;
                }

                try{
                    poll2 = p2.poll();
                    System.out.println(poll2);
                }
                catch(Exception e){
                    p2Exception = true;
                    exception2 = e;
                }

                if(p1Exception == true || p2Exception == true){
                    assertTrue(p1Exception == p2Exception); // check both of them throw exceptions

                    boolean compareCase2Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase2Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }
                else{
                    try{
                        assertTrue(poll1.equals(poll2)); // if they are complex objects
                    }catch(Error e){ 
                        assertTrue(poll1 == poll2); // if they are int
                    }
                    
                }

                sb1 = new StringBuilder();
                k = 0;
                for (Integer item : p1.get()) {
                    if(k==0)sb1.append(item.toString());
                    else sb1.append(","+item.toString());
                    k++;
                }

                String b = sb1.toString();
                System.out.println("p1 currenty has " +b);

                sb2 = new StringBuilder();
                k = 0;
                for (Integer item : p2.get()) {
                    if(k==0)sb2.append(item.toString());
                    else sb2.append(","+item.toString());
                    k++;
                }

                b = sb2.toString();
                System.out.println("p2 currenty has " +b);

                break;
                
                case 3:
                System.out.println("case 3 -------------------- "+ i);

                try{
                    System.out.println("s1 peek is " + p1.peek());
                }catch(Exception e){
                    p1Exception = true;
                    exception1 = e;
                }

                try{
                    System.out.println("s2 peek is " + p2.peek());
                }
                catch(Exception e){
                    p2Exception = true;
                    exception2 = e;
                }

                if(p1Exception == true || p2Exception == true){
                    assertTrue(p1Exception == p2Exception); // check both of them throw exceptions

                    boolean compareCase3Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase3Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }

                if(p1Exception == false && p2Exception == false)
                assertEquals(p1.peek(),  p2.peek());

                sb1 = new StringBuilder();
                k = 0;
                for (Integer item : p1.get()) {
                    if(k==0)sb1.append(item.toString());
                    else sb1.append(","+item.toString());
                    k++;
                }
                String c = sb1.toString();
                System.out.println("p1 currenty has " +c);

                sb2 = new StringBuilder();
                k = 0;
                for (Integer item : p2.get()) {
                    if(k==0)sb2.append(item.toString());
                    else sb2.append(","+item.toString());
                    k++;
                }
                c = sb2.toString();
                System.out.println("p2 currenty has " +c);

                break;

                default:
                break;
            }
           
        }
        
    }

    public boolean compare(Exception e1, Exception e2, String className1, String className2) {

        boolean equivalent = true;

        // check causes are equivalent
        // System.out.println("cause message1: " + e1.getCause());
        // System.out.println("cause message2: " + e2.getCause());
        // do it later as below
        if(e1.getCause() != e2.getCause()){
            equivalent = false;
            System.out.println("getCause is not euivalent!");
        }

       // Returns the cause of this throwable or null if the cause is nonexistent or unknown.

        // System.out.println("traced message1: " + Arrays.toString(e1.getStackTrace()));
        // System.out.println("traced message2: " + Arrays.toString(e2.getStackTrace()));
        // if(e1.getStackTrace() != e2.getStackTrace()){
        //     equivalent = false;
        //     System.out.println("stackTrace is not euivalent!");
        // }


        // check messages are eqivalent
        String m1 = e1.getMessage();
        String m2 = e2.getMessage();
        // System.out.println("message1: " + m1);
        // System.out.println("message2: " + m2);
        // if(e1.getMessage() == null) System.out.println("its null"); //
        if((m1 == null && m2 != null) 
            || (m1 != null && m2 == null)
            || (m1 != null  && !m1.equals(m2))){ // this gets an error if its null

            equivalent = false;
            System.out.println("getMessage is not equivalent!");
        }
        
        // check localised messages are equivalent
        m1 = e1.getLocalizedMessage();
        m2 = e2.getLocalizedMessage();
        // System.out.println("localised message1: " + m1);
        // System.out.println("localised message2: " + m2);
        if((m1 == null && m2 != null) 
            || (m1 != null && m2 == null)
            || (m1 != null  && !m1.equals(m2))){ // this gets an error if its null

            equivalent = false;
            System.out.println("getLocalisedMessage is not equivalent!");
        }


        // check error statements are equivalent
        String mes1 = e1.toString();
        String mes2 = e2.toString();
        // System.out.println("class name 1 is "+className1);
        // System.out.println("class name 2 is "+className2);
        mes1 = mes1.replace(className1, className2);

        // System.out.println("changed error message 1 is "+mes1+", error message2 is "+mes2);

        System.out.println("error message from s1 is "+mes1+", error message from s2 is "+mes2);

        if(!mes1.equals(mes2)){
            equivalent = false;
            System.out.println("error massage is not equivalent!");
        }

        return equivalent;
    }
}