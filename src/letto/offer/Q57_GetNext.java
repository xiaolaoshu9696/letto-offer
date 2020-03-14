package letto.offer;

/**
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

public class Q57_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        //它是根节点
        if (pNode.next == null){
            if (pNode.right==null) return null;
            pNode = pNode.right;
            while (pNode.left!=null) pNode = pNode.left;
            return pNode;
        }
        //如果他是一个节点的左节点
        if (pNode == pNode.next.left){
            //如果他的右节点不为空，则下个节点在它右子树上
            if (pNode.right!=null){
                pNode = pNode.right;
                while (pNode.left!=null) pNode = pNode.left;
                return pNode;
            }
            else return pNode.next;
        }
        //如果它是一个节点的右节点
        if (pNode == pNode.next.right){
            //如果他的右节点不为空，则下个节点在它右子树上
            if (pNode.right!=null){
                pNode = pNode.right;
                while (pNode.left!=null) pNode = pNode.left;
                return pNode;
            }
            //他的右节点为空，则下个节点在其上方，第一个为其他节点的左节点的父节点
            else {
                while (pNode.next!=null && pNode != pNode.next.left) pNode = pNode.next;
                if (pNode.next==null) return null;
                return pNode.next;
            }
        }
        return null;
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode){
        if (pNode == null) return null;
        if (pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null) pNode = pNode.left;
            return pNode;
        }
//        else {
//            while (pNode.next!=null && pNode != pNode.next.left) pNode = pNode.next;
//            if (pNode.next==null) return null;
//            return pNode.next;
//        }
        while(pNode.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left==pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

}
