package com.lukman;

import org.junit.Assert;
import org.junit.Test;

public class Solution2Test {
    @Test
    public  void test01(){
        // Create a graph given in the above diagram. Here vertex
        // numbers are 0, 1, 2, 3, 4, 5 with following mappings:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        Solution2 t = new Solution2();
        Solution2.Graph g = t.newGraph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        ;
        Assert.assertEquals("INF 0 2 6 5 3 ", g.shortestPath(s));
    }
}
