package letto.offer.mianshizhinan;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class maxBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Node head = CreatTree(sc, n);
        maxBST b =new maxBST();
        System.out.println(b.getMaxBSTSize(head));
    }

    public static Node CreatTree(Scanner sc, int n){
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        int val = sc.nextInt();
        Node head = new Node(val);
        map.put(val,head);
        for (int i=0; i<n; i++){
            Node now = map.get(sc.nextInt());
            int left = sc.nextInt();
            if (left!=0){
                Node lNo = new Node(left);
                now.left = lNo;
                map.put(left,lNo);
            }
            int right = sc.nextInt();
            if (right!=0){
                Node rNo = new Node(right);
                now.right = rNo;
                map.put(right,rNo);
            }
        }
        return head;
    }


    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;
        public Node(int val) {
            this.val = val;
        }
    }

    public class ReturnType{
        public  Node maxBSTHead;
        public int maxBSTSize;
        public int min;
        public int max;


        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    public  ReturnType process(Node X){
        if (X == null){
            return new ReturnType(null, 0, Integer.MAX_VALUE,Integer.MIN_VALUE);

        }
        //左子树全部信息
        ReturnType lData = process(X.left);
        //右子树全部信息
        ReturnType rData = process(X.right);

        int min = Math.min(X.val, Math.min(lData.min,rData.min));
        int max = Math.max(X.val, Math.max(lData.max,rData.max));

        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        if (maxBSTSize==0) maxBSTSize=1;
        Node maxBSTHead = lData.maxBSTSize>=rData.maxBSTSize ? lData.maxBSTHead:rData.maxBSTHead;
        if (maxBSTHead==null) maxBSTHead=X;

        if (lData.maxBSTHead==X.left && rData.maxBSTHead==X.right && X.val>lData.max && X.val<rData.min){
            maxBSTHead = X;
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);


    }

    public Node getMaxBST(Node head){
        return process(head).maxBSTHead;
    }
    public int getMaxBSTSize(Node head){
        return process(head).maxBSTSize;
    }

    public static int getNodeNum(Node node){
        if (node==null) return 0;
        else{
            return 1 + getNodeNum(node.left) + getNodeNum(node.right);
        }

    }


}
