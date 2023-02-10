package practice;

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



@RunWith(JQF.class)
public class StackIntTest {

    
    public StackInt1 s1 = new StackInt1(10);
    public StackInt2 s2 = new StackInt2(10);

    boolean s1Exception = false;
    boolean s2Exception = false;

    @Fuzz
    public void testEverything(@From(StackIntGenerator.class) int[][] array) {
        
        // System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array));

        // make a case
        System.out.println(array[0].length);

        // int arr [] = new int[array[0].length];
        // for(int i = 0; i < array[0].length; i++){
        //     Random random = new Random();
        //     int aaa = random.nextInt(2) + 1; //make a case decision.
        //     arr[i] = 2;
        // }

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
                
                s1.push(num);
                // assertEquals(num, s1.peek());  // i want to compare two arrays s1 and s2　here . 
                                               // Moreover, we also have to charck if it throw an error
                
                s2.push(num);

                // Assert.assertArrayEquals(this.s1, this.s2);
                // assertThat(Arrays.equals(this.s1, this.s2)).isTrue();
                // Object[] arr = this.s2.toArray();
                // assertEquals(true, Arrays.equals(this.s1, arr));

                System.out.println("s1 currenty has " +Arrays.toString(s1.getStack()));
                System.out.println("s2 currenty has " +s2.stackString());

                break;
                
                case 2:
                System.out.println("case 2 -------------------- ");
                
                try{
                    // int expected = s1.peek();
                    // int poppedNum = s1.pop();
                    s1.pop();
                    
                }catch(StackInt1.EmptyStackException e){
                    s1Exception = true;
                }

                try{
                    int pop2 = s2.pop();
                }
                catch(EmptyStackException e){
                    s2Exception = true;
                }

                if(s1Exception == true || s2Exception == true){
                    assertTrue(s1Exception == s2Exception);
                    System.out.println("both of them throw the same exception");
                }
                
                s1Exception = false;
                s2Exception = false;

                System.out.println("s1 currenty has " +Arrays.toString(s1.getStack()));
                System.out.println("s2 currenty has " +s2.stackString());


                // Assert.assertArrayEquals(this.s1, this.s2);
                // assertThat(Arrays.equals(this.s1, this.s2)).isTrue();
                // assertEquals(true, Arrays.equals(this.s1, this.s2));
                // assertEquals(poppedNum, pop2);

                // assertEquals(expected, poppedNum);


                break;
                
                case 3:
                System.out.println("case 3 -------------------- ");

                try{
                    System.out.println("s1 peek is " + s1.peek());
                }catch(StackInt1.EmptyStackException e){
                    s1Exception = true;
                }

                try{
                    System.out.println("s2 peek is " + s2.peek());
                }
                catch(EmptyStackException e){
                    s2Exception = true;
                }

                if(s1Exception == true || s2Exception == true){
                    assertTrue(s1Exception == s2Exception);
                    System.out.println("both of them throw the same exception");
                }

                if(s1Exception == false && s2Exception == false)
                assertEquals(s1.peek(),  s2.peek());

                s1Exception = false;
                s2Exception = false;

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