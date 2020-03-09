package letto.offer;

import java.util.List;

/**
 *
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，
 * 所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 */
public class Q36_FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //        假定 List1长度: a+n  List2 长度:b+n, 且 a<b
        //        那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
        //        接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
        //        将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。  或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
        //        时间复杂度O(n+a+b)
        while (p1!=p2){
            if (p1!=null) p1 = p1.next;
            else p1 = pHead2;
            if (p2!=null) p2 = p2.next;
            else p2 = pHead1;
        }
        return p1;

    }

}


