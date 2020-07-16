package letto.offer.leetcode;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TransferQueue;

public class leetcode297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 依次弹出每层节点
            TreeNode cur = queue.remove();
            if (cur == null) {
                res.append("null,");
            } else {
                res.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        //一开始父节点是头节点
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            //循环到右节点时，这里的isLeft为true，
            if (isLeft) {
                parent = parents.peek();
                parents.poll();
            }
        }
        return root;
    }


    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));

    }
}
