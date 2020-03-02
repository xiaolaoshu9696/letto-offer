package letto.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 */

public class Q24_FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 深度优先搜索DFS的典型问题。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root==null) return paths;
        dfs(paths,new ArrayList<Integer>(), root, target);
        return paths;
    }
    /**
     *
     * @param paths 保存已经找到的路径
     * @param path  保存此分支正在查找的路径
     * @param root  当前节点
     * @param target  剩余target值
     */
    public void dfs(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target){
        path.add(root.val);
        if (root.left==null && root.right == null){
            if (target == root.val){
                paths.add(path);
            }
            return;
        }
        //这里必须要创建一个新的path，第一个左子树递归回来之后path值已经改变，再传入right中就会出错。
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        if(root.left!=null) dfs(paths,path,root.left,target-root.val);
        if(root.right!=null) dfs(paths,path2,root.right,target-root.val);

    }

    //递归回溯
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if(root == null) return res;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(list));
        }

        FindPath2(root.left, target);
        FindPath2(root.right, target);
        //回溯
        list.remove(list.size() - 1);
        //其实这个return res在递归过程中只是起到返回上一层的作用
        return res;
    }


}
