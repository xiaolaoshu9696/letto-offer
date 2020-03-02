package letto.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class Q14_FindKthToTail {
    public static void main(String[] args) {

    }

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    //第一个指针先走k步
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null) return null;
        ListNode first = head;
        while(first != null && k>0){
            first = first.next;
            k--;
        }
        if(k!=0) return null;
        ListNode twice = head;
        while (first!=null){
            first = first.next;
            twice = twice.next;
        }
        return twice;
    }

}
