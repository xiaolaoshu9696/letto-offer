package letto.offer.leetcode;

//树形dp

public class leetcode337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // public int rob(TreeNode root) {
    //     if (root == null) return 0;

    //     int money = root.val;
    //     if (root.left != null) {
    //         money += (rob(root.left.left) + rob(root.left.right));
    //     }

    //     if (root.right != null) {
    //         money += (rob(root.right.left) + rob(root.right.right));
    //     }

    //     return Math.max(money, rob(root.left) + rob(root.right));
    // }

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}
