package org.bao;

import org.bao.component.ListNode;
import org.bao.component.Utils;
import org.junit.Assert;
import org.junit.Test;

public class TestRoundFour {

    private RoundFour rf=new RoundFour();

    @Test
    public void climbStairsTest(){
        Assert.assertEquals(3,rf.climbStairs(3));
        Assert.assertEquals(5,rf.climbStairs(4));
        Assert.assertEquals(8,rf.climbStairs(5));
        Assert.assertEquals(13,rf.climbStairs(6));
        Assert.assertEquals(21,rf.climbStairs(7));
        Assert.assertEquals(34,rf.climbStairs(8));

    }

    @Test
    public void deleteDuplicatesTest(){
        Assert.assertEquals("1,2",rf.deleteDuplicates(ListNode.createByArray(new int[]{1,1,2})).print());
        Assert.assertEquals("1",rf.deleteDuplicates(ListNode.createByArray(new int[]{1,1})).print());
        Assert.assertEquals("1",rf.deleteDuplicates(ListNode.createByArray(new int[]{1})).print());
        Assert.assertEquals("1,2,3,4,5",rf.deleteDuplicates(ListNode.createByArray(new int[]{1,1,2,3,4,5,5})).print());
        Assert.assertNull("",rf.deleteDuplicates(ListNode.createByArray(new int[]{})));
    }

    @Test
    public void mergeTest(){
        int[] num1={};
        int[] num2={};

        int[] num3={0};
        int[] num4={1};

        int[] num5={1};
        int[] num6={};

        int[] num7={1,2,0,0};
        int[] num8={3,4};

        int[] num9={1,2,8,9,0,0};
        int[] num10={3,4};

        int[] num11={1,2,8,9,0,0,0,0,0};
        int[] num12={3,4,10,11,12};
        rf.merge(num1,0,num2,0);
        Assert.assertEquals("", Utils.printArray(num1));
        rf.merge(num3,0,num4,1);
        Assert.assertEquals("1", Utils.printArray(num3));
        rf.merge(num5,1,num6,0);
        Assert.assertEquals("1", Utils.printArray(num5));
        rf.merge(num7,2,num8,2);
        Assert.assertEquals("1,2,3,4", Utils.printArray(num7));
        rf.merge(num9,4,num10,2);
        Assert.assertEquals("1,2,3,4,8,9", Utils.printArray(num9));
        rf.merge(num11,4,num12,5);
        Assert.assertEquals("1,2,3,4,8,9,10,11,12", Utils.printArray(num11));
    }
}
