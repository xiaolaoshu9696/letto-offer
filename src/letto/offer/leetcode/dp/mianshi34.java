package letto.offer.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class mianshi34 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, ans, list);
        return ans;
    }

    public static void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(list));
        }

        if (root.left != null) dfs(root.left, sum - root.val, ans, list);
        if (root.right != null) dfs(root.right, sum - root.val, ans, list);
        list.remove(list.size() - 1);
    }
}