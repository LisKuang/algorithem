package org.bao;

import org.bao.component.ListNode;
import org.bao.component.Utils;
import org.junit.Assert;
import org.junit.Test;

public class TestLeetcodeRoundTwo {

    private LeetcodeRoundTwo leetcodeRoundTwo=new LeetcodeRoundTwo();

    @Test
    public void testMergeTwoLists(){
        ListNode l1=ListNode.createByArray(new int[]{2, 4, 5, 7, 8, 10, 11});
        ListNode l2=ListNode.createByArray(new int[]{1, 3, 6, 11, 12, 15, 20});
        Assert.assertEquals("1,2,3,4,5,6,7,8,10,11,11,12,15,20",leetcodeRoundTwo.mergeTwoLists(l1,l2).print());
        ListNode l4=ListNode.createByArray(new int[]{3});
        Assert.assertEquals("3",leetcodeRoundTwo.mergeTwoLists(null,l4).print());
        ListNode l6=ListNode.createByArray(new int[]{3});
        Assert.assertEquals("3",leetcodeRoundTwo.mergeTwoLists(null,l6).print());
        Assert.assertNull(leetcodeRoundTwo.mergeTwoLists(null,null));
    }

    @Test
    public void testRemoveDuplicates(){
        Assert.assertEquals(0,leetcodeRoundTwo.removeDuplicates(new int[]{}));
        Assert.assertEquals(1,leetcodeRoundTwo.removeDuplicates(new int[]{1}));
        Assert.assertEquals(3,leetcodeRoundTwo.removeDuplicates(new int[]{1,2,3}));
        int[] nums1=new int[]{1,2,3,3,5};
        int[] nums2=new int[]{1,2,3,3,5,6,7,7,7,9};
        Assert.assertEquals(4,leetcodeRoundTwo.removeDuplicates(nums1));
        Assert.assertEquals(7,leetcodeRoundTwo.removeDuplicates(nums2));
        Assert.assertEquals("1,2,3,5,0", Utils.printArray(nums1));
        Assert.assertEquals("1,2,3,5,6,7,9,0,0,0", Utils.printArray(nums2));

    }

    @Test
    public void testRemoveElement(){
        Assert.assertEquals(0,leetcodeRoundTwo.removeElement(new int[]{},0));
        int[] nums1=new int[]{1,2,3,3,5};
        int[] nums2=new int[]{2,3,3,2};
        int[] nums3=new int[]{3,3,3,3};
        Assert.assertEquals(3,leetcodeRoundTwo.removeElement(nums1,3));
        Assert.assertEquals(2,leetcodeRoundTwo.removeElement(nums2,2));
        Assert.assertEquals(0,leetcodeRoundTwo.removeElement(nums3,3));
        Assert.assertEquals("1,2,5,3,5", Utils.printArray(nums1));
        Assert.assertEquals("3,3,3,2", Utils.printArray(nums2));
        Assert.assertEquals("3,3,3,3", Utils.printArray(nums3));
    }


}
