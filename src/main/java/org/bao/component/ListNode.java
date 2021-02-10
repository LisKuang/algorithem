package org.bao.component;


public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createByArray(int[] ints) {
        ListNode head=new ListNode(ints[0]);
        ListNode curr=head;
        for(int i=1;i<ints.length;i++){
            ListNode node=new ListNode(ints[i]);
            curr.next=node;
            curr=node;

        }
        return head;
    }

    public String print() {

        StringBuffer result=new StringBuffer();
        result.append(this.val);
        ListNode currentNode=this;
        while(currentNode.next!=null){
            result.append(","+currentNode.next.val);
            currentNode=currentNode.next;
        }
       return  result.toString();
    }
}
