package letto.offer.tree;

import java.util.Stack;

public class 遍历 {

    class Node{
        int val;
        Node left;
        Node right;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrderUseStack(Node root){
        if (root==null) return;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            Node curNode = s.pop();
            System.out.println(curNode.val);
            //栈后进先出，先加右侧节点，输出时先输左侧
            if (curNode.right!=null) s.push(curNode.right);
            if (curNode.left!=null) s.push(curNode.left);
        }
    }

    //中序

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void inOrderUseStack(Node root){

        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node curNode = root;
        while (!s.isEmpty() || curNode != null) {
            // 入栈所有左节点并输出左节点
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }

            // 弹出左节点
            curNode = s.pop();
            System.out.print(curNode.val + " ");
            // 弹出后，指向当前节点的右节点
            curNode = curNode.right;
        }
    }


}
