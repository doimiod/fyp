package faultyOne;

import java.lang.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import edu.berkeley.cs.jqf.fuzz.*;
import java.util.stream.*;

public class FaultyOne1 {

    // public FaultyOne1(){

    // }
	
	public int f(int i, int j) {

        int r = 0;

        if(i == 0)r = j;
        else r = f(i-1, j+1 );

        return r;
    }
	
}
