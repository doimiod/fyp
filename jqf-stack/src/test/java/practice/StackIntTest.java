package practice;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class StackIntTest {

    public StackInt1 s1 = new StackInt1(50);
    public StackInt2 s2 = new StackInt2(50);

    String className1 = s1.getClass().getName();
    String className2 = s2.getClass().getName();

    boolean s1Exception = false;
    boolean s2Exception = false;

    Exception exception1;
    Exception exception2;

    @Fuzz
    public void testEverything(@From(StackIntGenerator.class) int[][] array) {
        
        System.out.println(Arrays.deepToString(array));
  
        System.out.println(array[0].length);

        for(int i = 0; i < array[0].length; i++) {           

            boolean s1Exception = false;
            boolean s2Exception = false;
            
            int num = array[0][i];

            switch (array[1][i]) {

                case 1:
                System.out.println("case 1 -------------------- "+ i);

                try{
                    s1.push(num);
                }catch(Exception e){
                    s1Exception = true;
                    exception1 = e;
                }

                try{
                    s2.push(num);
                }
                catch(Exception e){
                    s2Exception = true;
                    exception2 = e;
                }

                if(s1Exception == true || s2Exception == true){
                    assertTrue(s1Exception == s2Exception); // check both of them throw exceptions

                    boolean compareCase1Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase1Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }

                System.out.println("s1 currenty has " +Arrays.toString(s1.getStack()));
                System.out.println("s2 currenty has " +s2.stackString());
                break;
                
                case 2:
                System.out.println("case 2 -------------------- "+ i); 
                
                Integer pop1 = 0;
                Integer pop2 = 0;

                try{
                    pop1 = s1.pop();
                }catch(Exception e){
                    s1Exception = true;
                    exception1 = e;
                }

                try{
                    pop2 = s2.pop();
                }
                catch(Exception e){
                    s2Exception = true;
                    exception2 = e;
                }

                if(s1Exception == true || s2Exception == true){
                    assertTrue(s1Exception == s2Exception); // check both of them throw exceptions

                    boolean compareCase2Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase2Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }
                else{
                    try{
                        assertTrue(pop1.equals(pop2)); // if they are complex objects
                    }catch(Error e){ 
                        assertTrue(pop1 == pop2); // if they are int
                    }
                }
                
                System.out.println("s1 currenty has " +Arrays.toString(s1.getStack()));
                System.out.println("s2 currenty has " +s2.stackString());

                break;
                
                case 3:
                System.out.println("case 3 -------------------- "+ i);

                Integer peek1 = 0;
                Integer peek2 = 0;

                try{
                    peek1 = s1.peek();
                    System.out.println("s1 peek is " + peek1);
                }catch(Exception e){
                    s1Exception = true;
                    exception1 = e;
                }

                try{
                    peek2 = s2.peek();
                    System.out.println("s2 peek is " + peek2);
                }
                catch(Exception e){
                    s2Exception = true;
                    exception2 = e;
                }

                if(s1Exception == true || s2Exception == true){
                    assertTrue(s1Exception == s2Exception); // check both of them throw exceptions
                    boolean compareCase3Exceptions = compare(exception1, exception2, className1, className2);
                    assertTrue(compareCase3Exceptions); // check both of them throw the same exception
                    System.out.println("both of them throw the same exception");
                }
                else{
                    try{
                        // if they are complex objects
                        assertTrue(peek1.equals(peek2)); 
                    }catch(Error e){
                        // if they are int
                        assertTrue(peek1 == peek2); 

                    }
                }
                break;

                default:
                break;
            }
           
        }
    
    }

    public boolean compare(Exception e1, Exception e2, String className1, String className2) {

        boolean equivalent = true;

        if(e1.getCause() != e2.getCause()){
            equivalent = false;
            System.out.println("getCause is not euivalent!");
        }

        // check messages are eqivalent
        String m1 = e1.getMessage();
        String m2 = e2.getMessage();
        if((m1 == null && m2 != null) 
            || (m1 != null && m2 == null)
            || (m1 != null  && !m1.equals(m2))){ // this gets an error if its null

            equivalent = false;
            System.out.println("getMessage is not equivalent!");
        }
        
        // check localised messages are equivalent
        m1 = e1.getLocalizedMessage();
        m2 = e2.getLocalizedMessage();
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

        System.out.println("error message from s1 is "+mes1+", error message from s2 is "+mes2);

        if(!mes1.equals(mes2)){
            equivalent = false;
            System.out.println("error massage is not equivalent!");
        }
        return equivalent;
    }
}


