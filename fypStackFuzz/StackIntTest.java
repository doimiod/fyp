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
public class StackIntTest {

    // private StackInt1 s[];

    // @Fuzz
    // public void testPush(@From(StackIntGenerator.class) int num) {

    //     s.push(num);

    //     assertEquals(1, s.size());
        
    // }

    // @Fuzz
    // public void testPop(@From(StackIntGenerator.class) int num) {

    //     s.push(num);
    //     s.pop();

    //     assertEquals(0, s.size());
        
    // }

    // @Fuzz
    // public void testPeek(@From(StackIntGenerator.class) int num) {

    //     s.push(num);
    //     s.peek();

    //     assertEquals(num, s.peek());
        
    // }


    // @Fuzz void testMultiplePushes(@From(StackIntGenerator.class) int[] array) {
    // }

    public StackInt1 s1 = new StackInt1(10);
    public StackInt2 s2 = new StackInt2(10);

    @Fuzz
    public void testEverything(@From(StackIntGenerator.class) int[][] array) {
        
        // System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array));

        // make a case
        System.out.println(array[0].length);
        for(int i = 0; i < array[0].length; i++) {

            // Random random = new Random();
            // int caseDecider = random.nextInt(3) + 1; //make a case decision.
                                                        // if it is 1 it pushes, 2 is popping, 3 is showing a peek.
            
            // System.out.println("case is "+caseDecider); 

            int num = array[0][i];

            // System.out.println("num is " + array[0][i]);
            System.out.println("case is " + array[1][i]);

            switch (array[1][i]) {

                case 1:
                System.out.println("case 1 -------------------- ");
                // System.out.println("s1 -------------------- ");
                s1.push(num);
                assertEquals(num, s1.peek());  // i want to compare two arrays s1 and s2　here . 
                                               // Moreover, we also have to charck if it throw an error
                // System.out.println("s2 -------------------- ");
                s2.push(num);
                                               
                break;
                
                case 2:
                System.out.println("case 2 -------------------- ");
                // System.out.println("s1 -------------------- ");
                int expected = s1.peek();
                int poppedNum = s1.pop();
                // System.out.println("s2 -------------------- ");
                int pop2 = s2.pop();
                assertEquals(poppedNum, pop2);

                // assertEquals(expected, poppedNum);
                break;
                
                case 3:
                System.out.println("case 3 -------------------- ");
                System.out.println("peek is " + s1.peek());
                assertEquals(s1.peek(),  s2.peek());
                
               
                break;

                default:
                break;
            }
           
        }

        // s1.push(1);
        // s2.push(1);
        // s1.push(2);
        // s2.push(1);
        // int poppedNum = s1.pop();
        // int pop2 = s2.pop();
        // assertEquals(poppedNum, pop2);
        // poppedNum = s1.pop();
        // pop2 = s2.pop();
        // assertEquals(poppedNum, pop2);
        
    }

}


// To do 
// make an assumption
// know how to operate the test
// like i have to completely understnand how it works
// and think about how to check whether the test is working 
// e.g. how to check whether the pop is working twice in a row




// for (int i = 0; i < array.length; i++) {
//     System.out.print(array[i] + " ");
// }

// for(int i = 0; i < array.length; i++) {

//     int num = array[i];
//     if(num%3 == 0) {
//         s.push(num);
//         assertEquals(num, s.peek());
//         // assertEquals(this.s.length, s.size());
//         // assertEquals(s, s.getStack());
//         // assertArrayEquals(this.s, s.getStack());
//     }
//     else if(num%3 == 1){

//         int expected = s.peek();
//         int poppedNum = s.pop();
//         assertEquals(expected, poppedNum);
//         // assertEquals(this.s.length, s.size());
//     } 
//     else {
//         s.peek();
//     }
// }