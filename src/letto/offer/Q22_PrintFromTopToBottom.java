package letto.offer;


import javax.swing.table.TableRowSorter;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Q22_PrintFromTopToBottom {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(PrintFromTopToBottom(root).toString());

    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null) return list;
        //先打印当前节点，然后把左右节点依次进入队列，队列弹出作为新的当前节点。
        while (root!=null){
            list.add(root.val);
            if (root.left!=null)queue.offer(root.left);
            if (root.right!=null)queue.offer(root.right);
            root = queue.poll();
        }
         return list;
    }
}
