package letto.offer;

import java.util.List;

public class  Q15_ReverseList {

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head){
        if (head == null) return null;
        //前一个节点
        ListNode pre = null;
        //后一个节点
        ListNode next = null;
        //现在指向的节点
        ListNode now = head;
        while(now!=null){
            //保存下一个节点
            next = now.next;
            //让现处理的节点指向前面
            now.next = pre;
            //把前节点定义为现节点以便下个循环使用
            pre = now;
            //把现节点指向下一个，以便下个循环使用。
            now = next;
        }
        //循环结束。pre指向最后一个节点
        return pre;
    }
}
