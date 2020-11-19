package letto.offer.leetcode.双指针;

/**
 * @author hkc
 * @version 1.0
 * @date 2020/8/28 9:52
 */
public class leetcode86 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode pre1 = list1;
        ListNode list2 = new ListNode(0);
        ListNode pre2 = list2;
        while (head != null) {
            if (head.val < x) {
                list1.next = head;
                list1 = list1.next;

            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }
        list2.next = null;
        list1.next = pre2.next;
        return pre1.next;

    }
}
