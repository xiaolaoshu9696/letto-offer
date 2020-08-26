package letto.offer;


/**
 *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 */
public class Q17_HasSubtree {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if (root1==null || root2 == null) return false;
        flag = isSubtree(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        return flag;
    }
    //判断是否是子树
    public boolean isSubtree(TreeNode root1, TreeNode root2){
        //两边同时为空 成功
        if (root1==null && root2==null) return true;
        // 子结构不为空 失败
        if (root1 == null) return false;
        // 子结构为空，父结构不为空证明有此子结构不用继续判断
        if (root2 == null) return true;
        if (root1.val != root2.val) return false;
        return isSubtree(root1.left,root2.left) && isSubtree(root1.right, root2.right);
    }
}
