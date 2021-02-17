package org.bao;

import org.bao.component.ListNode;

import java.util.Arrays;

public class LeetcodeRoundTwo {
    /*
    21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //check if lists are empty or have only one element
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = null;
        //defind a ListNode pointed to element of l1 and l2
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        if (l1.val < l2.val) {
            newNode = l1;
            currentNode1 = l1.next;
        } else {
            newNode = l2;
            currentNode2 = l2.next;
        }
        ListNode currNode = newNode;
        while (currentNode1 != null && currentNode2 != null) {

            if (currentNode1.val < currentNode2.val) {
                currNode.next = currentNode1;
                currentNode1 = currentNode1.next;
            } else {
                currNode.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            currNode = currNode.next;
        }
        if (currentNode1 == null) {
            currNode.next = currentNode2;
        }
        if (currentNode2 == null) {
            currNode.next = currentNode1;
        }
        return newNode;
    }

    /*
    26. 删除排序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        //length of nums is fixed
        int count = nums.length;
        for (int i = count - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j <= count - 1; j++) {
                    if (j == nums.length - 1) {
                        nums[j] = 0;
                        break;
                    }
                    nums[j] = nums[j + 1];
                }
                count--;
            }
        }
        return count;
    }

    /**
     * 27. 移除元素
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                slow++;
                nums[slow] = nums[j];
            }
        }
        return slow+1;

    }
}


