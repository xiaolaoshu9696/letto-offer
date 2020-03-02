package letto.offer;

import java.util.Arrays;

/**
 * @author hu
 * @time 2020-2-27
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *
 */

public class Q04_reConstructBinaryTree {

    public static void main(String[] args) {
        
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 利用递归重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 ||in.length == 0) return null;
        TreeNode node = new TreeNode(pre[0]);
        // 前序遍历第一个必然是根节点，找到中序遍历的根节点之后，节点左边的是左子树，右边是右子树。
        for(int i=0; i<in.length; i++)
        {
            if (pre[0]==in[i])
            {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return node;
    }
}
