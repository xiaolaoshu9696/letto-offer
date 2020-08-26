package letto.offer;

/**
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q26_Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //中序遍历可以得到有序序列
    private TreeNode pre = null; //记录上一个节点
    private TreeNode head = null; //头节点

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        inOrder(pRootOfTree);

        return head;

    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        //左
        inOrder(node.left);

        //根，改节点指针，与上一个节点连接
        node.left = pre;
        if (pre!=null){
            pre.right = node;
        }
        pre = node;

        if (head == null) head = node;

        //右
        inOrder(node.right);


    }


}
