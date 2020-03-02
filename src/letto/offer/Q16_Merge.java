package letto.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Q16_Merge {
    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newhead = new ListNode(0);
        ListNode start = newhead;
        //依次取值判断
        while (list1!=null && list2!=null){
            if (list1.val <= list2.val){
                newhead.next = list1;
                newhead = list1;
                list1 = list1.next;
            }
            else{
                newhead.next = list2;
                newhead = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) newhead.next = list2;
        if (list2 == null) newhead.next = list1;
        return start.next;
    }
}
