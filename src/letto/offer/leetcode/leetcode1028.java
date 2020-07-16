package letto.offer.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode1028 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


    }

    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos<S.length()){
            int level = 0;
            //当前节点深度level
            while (S.charAt(pos)=='-'){
                ++level;
                ++pos;
            }
            //当前节点值
            int value = 0;
            while (pos<S.length() && Character.isDigit(S.charAt(pos))){
                value = value*10 + (S.charAt(pos)-'0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()){
                if (!path.isEmpty()){
                    path.peek().left = node;
                }
            }
            else{
                while (level!=path.size()){
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size()>1){
            path.pop();
        }
        return path.peek();

    }


}
