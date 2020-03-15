package letto.offer;

import java.util.ArrayList;

import java.util.Stack;

/**
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

public class Q59_Print {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int n = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot==null) return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        // 根节点进队列
        stack1.push(pRoot);
        // 奇数层
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (n % 2 == 0) {
                n++;
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    //先左后右
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                res.add(temp);
            }

            //偶数层
            else {
                n++;
                ArrayList<Integer> temp2 = new ArrayList<Integer>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    temp2.add(node.val);
                    //先右后左
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                res.add(temp2);
            }
        }
        return res;
    }
}


