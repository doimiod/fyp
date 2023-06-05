package faultyOne;

import java.lang.*;
import java.util.*;
import edu.berkeley.cs.jqf.fuzz.*;

public class FaultyOne2 {

    public int f(int i, int j) {

        int r = 0;

        if(i==0)r=j;
        else if(i==1)r=j+1;
        else if(i==2)r=j;
        else r = f(i-1, j+1);

        return r;
    }
}
