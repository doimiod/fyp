package faultyTwo;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static java.util.GregorianCalendar.*;
        
public class FaultyTwoGenerator extends Generator<int[]> {
    
    public FaultyTwoGenerator() {
        super(int[].class);
    }

    @Override
    public int[] generate(SourceOfRandomness random, GenerationStatus status) {

        int[] array = new int[2];
        array[0] = random.nextInt(-1,100);
        array[1] = random.nextInt(-1,100);

        return array;
    }

}