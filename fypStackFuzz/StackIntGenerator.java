import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.util.GregorianCalendar.*;
        
public class StackIntGenerator extends Generator<int[]> {
    
    public StackIntGenerator() {
        super(int[].class);
    }

    @Override
    public int[] generate(SourceOfRandomness random, GenerationStatus status) {
        
        int length = random.nextInt(1, 10); //generate a random length
        // int actualLength = random.nextInt(0, length);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(); //generate a random integer and put it in the array
        }

        return array;
    }


} 


// public class StackIntGenerator extends Generator<Integer> {
    
//     public StackIntGenerator() {
//         super(Integer.class);
//     }

//     @Override
//     public Integer generate(SourceOfRandomness random, GenerationStatus status) {
        
//         int randomNum = random.nextInt(); // generate a random number
//         return randomNum;
//     }


// } 