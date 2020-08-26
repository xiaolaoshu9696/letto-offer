package letto.offer;

/**
 *输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */

public class Q25_Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }
        // 在旧链表中创建新链表复制每个节点，此时不处理新链表的random节点
        RandomListNode c_node = pHead;
        while(c_node!=null) {
            RandomListNode clone_node = new RandomListNode(c_node.label);
            RandomListNode tmp = c_node.next;
            c_node.next = clone_node;
            clone_node.next = tmp;
            c_node = tmp;
        }


        // 再次遍历链表 复制老节点的随机指针给新节点
        c_node = pHead;
        while (c_node!=null){
            c_node.next.random = c_node.random == null ? null:c_node.random.next;
            c_node = c_node.next.next;
        }

        // 拆分链表
        c_node = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (c_node!=null){
            RandomListNode cloneNode = c_node.next;
            c_node.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null:cloneNode.next.next;
            c_node = c_node.next;
        }
        return pCloneHead;
    }
}
