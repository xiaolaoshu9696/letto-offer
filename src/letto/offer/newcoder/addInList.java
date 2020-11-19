package letto.offer.newcoder;

import java.util.Stack;

/**
 * @author hkc
 * @date 2020/9/4 10:36
 */
public class addInList {

     static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        ListNode h =  addInList2(l1, l4);
        System.out.println(h);

    }

    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode newhead1 = reverseList(head1);
        ListNode newhead2 = reverseList(head2);
        int lst = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (newhead1 != null || newhead2 != null || lst != 0) {
            int h1 = newhead1 == null ? 0 : newhead1.val;
            int h2 = newhead2 == null ? 0 : newhead2.val;
            int curval = (lst + h1 + h2) % 10;
            lst = (lst + h1 + h2) / 10;
            cur.next = new ListNode(curval);
            cur = cur.next;
            newhead1 = newhead1==null? null: newhead1.next;
            newhead2 = newhead2==null? null: newhead2.next;
        }
        return reverseList(head.next);


    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }

    public static ListNode addInList2(ListNode head1, ListNode head2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1!=null){
            stack1.push(head1.val);
            head1=  head1.next;
        }
        while (head2!=null){
            stack2.push(head2.val);
            head2=  head2.next;
        }
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while(!stack1.empty() || !stack2.empty() || carry != 0) {
            int a = 0;
            int b = 0;
            if (!stack1.empty()) {
                a = stack1.peek();
                stack1.pop();
            }
            if (! stack2.empty()) {
                b = stack2.peek();
                stack2.pop();
            }
            int sum = a + b + carry;
            int num = sum % 10;
            carry  = sum / 10;
            ListNode nodeNum = new ListNode(num);
            node.next = nodeNum;
            node = node.next;
        }
        result = result.next;
        return reverseList(result);

    }
}
