package letto.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Q03_printListFromTailToHead {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next(new ListNode(2)).next(new ListNode(3)).next(new ListNode(4)).next(new ListNode(5));
        ArrayList<Integer> list = printListFromTailToHead2(first);
        System.out.println(list.toString());
    }


    //利用栈来完成
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //递归调用
    private static ArrayList<Integer> printListFromTailToHead2(ListNode n){
        ArrayList<Integer> aList = new ArrayList<Integer>();
        revert(n,aList);
        return aList;
    }
    private static void revert(ListNode listNode, ArrayList<Integer> list){
        if (listNode!=null){
            revert(listNode.next, list);
            list.add(listNode.val);
        }
    }

    private static class ListNode{
        public int val;
        public ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode next(ListNode node){
            return this.next = node;
        }
    }
}
