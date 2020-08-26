package letto.offer.mianshizhinan;

//给定一颗二叉树和一个整数 sum，求累加和为 sum 的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所形成的节点链。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class TreeSum_LongPath {
    static int maxLen = 0;
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = creatTree(n,sc);
        int sum = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        maxLength(root, sum, map, 0 ,1);
        System.out.println(maxLen);


    }

    public static void maxLength(TreeNode node, int sum , Map<Integer,Integer> map, int presum, int level){
        if (node == null) return;
        int curSum = presum +node.val;
        if (!map.containsKey(curSum)){
            map.put(curSum, level);
        }
        if (map.containsKey(curSum-sum)){
            maxLen = Math.max(maxLen, level-map.get(curSum-sum));
        }
        maxLength(node.left, sum, map, curSum, level+1);
        maxLength(node.right, sum, map, curSum, level+1);
        //我们在map中存放的是上层所有的和，以及他们对应的level，
        // 而如果在map中发现了curSum，且它的level不是上层，而且是当前这一层，那么说明curSum这个累加和的记录是在遍历到cur的时候加上去的
        //那么就需要将这个记录删除掉，免得后面使用它。因为它并不是代表的上层的多少个数的和值。
        if (map.get(curSum)==level){
            map.remove(curSum);
        }
    }

    public static TreeNode creatTree(int n, Scanner scanner){
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        int number = scanner.nextInt();
        map.put(number,root);
        for (int i=0; i<n;i++){
            TreeNode node = map.get(scanner.nextInt());

            int left_no = scanner.nextInt();
            if (left_no!=0){
                TreeNode left = new TreeNode(0);
                map.put(left_no, left);
                node.left = left;
            }

            int right_no = scanner.nextInt();
            if (right_no!=0){
                TreeNode right = new TreeNode(0);
                map.put(right_no, right);
                node.right = right;
            }

            node.val = scanner.nextInt();
        }
        return root;


    }






}
