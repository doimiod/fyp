package faultyTwo;

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
// import janala.logger.inst.POP2;

@RunWith(JQF.class)
public class FaultyTwoTest {
    
    @Fuzz
    public void test(@From(FaultyTwoGenerator.class) int[] array) {

        FaultyTwo1 f1 = new FaultyTwo1();
        FaultyTwo2 f2 = new FaultyTwo2();

        int f1num = f1.f(array[0],array[1]);
        int f2num = f2.f(array[0],array[1]);

        System.out.println("i = "+array[0]+", j = "+array[1]+", f1 = "+f1num+", f2 = "+f2num);
        assertTrue(f1num == f2num);
    }

}

