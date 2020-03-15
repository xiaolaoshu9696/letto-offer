package letto.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 */

public class Q60_Print {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0; //记录本层打印了几个
        int end =1; //下层要打印几个
        queue.add(pRoot);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            arrayList.add(temp.val);
            start++;
            if (temp.left!=null) queue.offer(temp.left);
            if (temp.right!=null) queue.offer(temp.right);
            if (start==end){
                end =  queue.size();
                start=0;
                res.add(arrayList);
                arrayList = new ArrayList<Integer>();
            }
        }
        return res;
    }

}
