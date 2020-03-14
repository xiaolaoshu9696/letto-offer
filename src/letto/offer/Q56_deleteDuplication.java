package letto.offer;

/**
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Q56_deleteDuplication {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        deleteDuplication(node1);
        while (node1!=null){
            System.out.println(node1.val);
            node1 = node1.next;
        }



    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead==null||pHead.next==null) return pHead;
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
        while (last!=null){
            if (last.next!=null && last.val == last.next.val){
                while (last.next!=null && last.val==last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }
            else {
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
}
