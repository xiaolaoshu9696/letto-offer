package letto.offer;

import java.io.ObjectInputStream;

/**
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Q38_TreeDepth {
    public int depth = -1;

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int TreeDepth(TreeNode root) {
        GetTreeDepth(root, 0);
        return depth;
    }
    // 二叉树的前序遍历
    public void GetTreeDepth(TreeNode root, int dep){
        if (root==null){
            depth = Math.max(dep,depth);
        }
        dep  = dep +1;
        if (root!=null){
            GetTreeDepth(root.left, dep);
            GetTreeDepth(root.right,dep);
        }
    }

//    public int TreeDepth(TreeNode root) {
//        if(root == null) {
//            return 0;
//        }
//        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
//    }
}
