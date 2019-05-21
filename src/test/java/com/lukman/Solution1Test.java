package com.lukman;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class Solution1Test

{

    @Test
    public void test01(){
        Solution1 solution1 = new Solution1();
        String text = "key1=value1;key2=value2\nkeyA=valueA";// In this case seperator is ‘&’
        List mapList= solution1.storeMap(text);
        //solution1.printMap(a);
        String result= solution1.loadMap(mapList);

        Assert.assertNotNull(mapList);
        Assert.assertEquals(2, mapList.size());
        Assert.assertEquals(2, mapList.size());
        Assert.assertEquals(text, result.trim());
    }
}
