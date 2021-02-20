package org.bao;

import org.bao.component.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class RoundFour {

    /**
     * 70. 爬楼梯
     */

    public int climbStairs(int n) {

        //f(n)=f(n-1)+f(n-2)
        //最后一个台阶要么是经过跳一阶跳上，要么经过跳两阶跳上
        //斐波那契数列
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int nSubOne = 2;
        int nSubTwo = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = nSubOne + nSubTwo;
            nSubTwo = nSubOne;
            nSubOne = res;
        }
        return res;

    }

    /**
     * 83. 删除排序链表中的重复元素
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head.next = head.next.next;
            this.deleteDuplicates(head);
        } else {
            this.deleteDuplicates(head.next);
        }
        return head;

    }

    /**
     * 88. 合并两个有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if (n == 0) {
            return;
        }

        int indexM = m - 1;
        int indexN = n - 1;
        while (indexN >= 0) {

            if (indexM >= 0 && nums1[indexM] > nums2[indexN]) {
                nums1[indexM + indexN + 1] = nums1[indexM];
                indexM--;
            } else {
                nums1[indexM + indexN + 1] = nums2[indexN];
                indexN--;
            }
        }

    }

    /**
     * 100. 相同的树
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 101. 对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(root);
        TreeNode left;
        TreeNode right;
        while (!q.isEmpty()) {
            left = q.poll();
            right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null||left.val != right.val) {
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);

        }
        return true;
    }

}
