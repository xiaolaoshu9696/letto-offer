package letto.offer;

import com.sun.source.tree.WhileLoopTree;

/**
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class Q55_EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //解题重点在于 如果存在环则让一快一慢指针从头节点出发，必定两指针会在环内相遇。而且此时
    // 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast==null||fast.next==null) return null;

        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
