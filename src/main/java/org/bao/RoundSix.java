package org.bao;

import java.util.HashSet;
import java.util.Set;

public class RoundSix {
    /**
     * 121. 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     */
    public int maxProfit2(int[] prices) {
        int buy = 0;
        int sell = -1;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (sell == -1 && prices[i] <= prices[buy]) {//down
                buy = i;
                sell = -1;
                continue;
            }
            if (sell != -1 && prices[i] < prices[sell]) {//turn
                sum = sum + prices[sell] - prices[buy];
                buy = i;
                sell = -1;
            } else {
                sell = i;//up
            }
        }
        if (sell == -1) {
            return sum;
        }
        return sum + prices[sell] - prices[buy];
    }

    /**
     * 125. 验证回文串
     */

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1 || "".equals(s)) {
            return true;
        }
        String ss = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        int start = 0;
        int end = ss.length() - 1;
        while (start < end) {
            if (ss.charAt(start) != ss.charAt(end)) {
                return false;
            }
            start++;
            end--;

        }

        return true;

    }

    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }


    /**
     * 136. 只出现一次的数字
     */
    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * 141. 环形链表
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        while (head != null) {
            if (!s.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }

}
