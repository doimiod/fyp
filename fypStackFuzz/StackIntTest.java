import java.util.*;
import static java.util.GregorianCalendar.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
// import static org.junit.Assert.assertArrayEquals;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class StackIntTest {

    // private StackInt1 s[];
    public StackInt1 s = new StackInt1(10);

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


    @Fuzz void testMultiplePushes(@From(StackIntGenerator.class) int[] array) {

        

    }

    @Fuzz
    public void testEverything(@From(StackIntGenerator.class) int[] array) {

        // for (int i = 0; i < array.length; i++) {
        //     System.out.print(array[i] + " ");
        // }

        for(int i = 0; i < array.length; i++) {

            int num = array[i];
            if(num%3 == 0) {
                s.push(num);
                assertEquals(num, s.peek());
                // assertEquals(this.s.length, s.size());
                // assertEquals(s, s.getStack());
                // assertArrayEquals(this.s, s.getStack());
            }
            else if(num%3 == 1){

                int expected = s.peek();
                int poppedNum = s.pop();
                assertEquals(expected, poppedNum);
                // assertEquals(this.s.length, s.size());
            } 
            else {
                s.peek();
            }
        }
    }

}


// To do 
// make an assumption
// know how to operate the test
// like i have to completely understnand how it works
// and think about how to check whether the test is working 
// e.g. how to check whether the pop is working twice in a row