package letto.offer;

import javax.swing.table.TableRowSorter;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 *
 */

public class Q62_KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode res;
    int n=0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null) return null;
        int length;
        length = getLength(pRoot,0);
        if (length<k) return null;
        getKNode(pRoot,k);
        return res;

    }
    private int getLength(TreeNode root ,int length){
        if (root==null) return 0;
        length++;
        length +=getLength(root.left,length);
        length +=getLength(root.right,length);
        return length;
    }

    private void getKNode(TreeNode root, int k){
        if (root == null) return ;
        getKNode(root.left,k);
        n++;
        if (n==k) res =  root;
        getKNode(root.right,k);
    }


}
