package letto.offer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 */

public class Q58_isSymmetrical {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        // 注意这里千万不能 mRoot = pRoot, 这样在后面镜像操作时其实就是把原来的树给镜像了，导致后面结果肯定是true。
        TreeNode mRoot = copyTree(pRoot);
        Mirror(mRoot);
        return compare(pRoot,mRoot);

    }

    private void Mirror(TreeNode root){
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    private boolean compare(TreeNode root, TreeNode mroot){
        if (root==null) return mroot==null;
        if (mroot==null) return false;
        if (root.val != mroot.val) return false;
        return compare(root.left,mroot.left) && compare(root.right,mroot.right);
    }

    TreeNode copyTree (TreeNode root) {
        if (root == null) return null;
        TreeNode t = new TreeNode(root.val);
        t.left = copyTree(root.left);
        t.right = copyTree(root.right);
        return t;
    }
}
