package priorityQueue;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.util.GregorianCalendar.*;
        
public class PriorityQueueIntGenerator extends Generator<int[][]> {
    
    public PriorityQueueIntGenerator() {
        super(int[][].class);
    }

    @Override
    public int[][] generate(SourceOfRandomness random, GenerationStatus status) {
        
        int length = random.nextInt(1, 30); //generate a random length
        // int actualLength = random.nextInt(0, length);
        int[][] array = new int[2][length];
        for (int i = 0; i < length; i++) {
            int input = random.nextInt(-1,100);
            int zeroOrOne = random.nextInt(0,2);
          
            array[0][i] = input;
            // array[0][i] = random.nextInt(-1,100); //generate a random integer and put it in the array
            array[1][i] = random.nextInt(1,4); //generate a random integer having 1,2,3
        }
        return array;
    }
}