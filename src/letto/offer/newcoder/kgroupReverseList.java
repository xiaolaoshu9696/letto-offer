package letto.offer.newcoder;

import javax.swing.plaf.synth.SynthUI;
import java.util.Scanner;

public class kgroupReverseList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        //链表长度
        int length = arr.length;
        int k = sc.nextInt();
        Node prehead = new Node(0);
        Node currentNode = new Node(0);
        for (int i = 0; i<arr.length; i++){
            if (i==0){
                Node temp = new Node(Integer.parseInt(arr[i]));
                prehead.next = temp;
                currentNode = temp;
            }
            else {
                Node temp = new Node(Integer.parseInt(arr[i]));
                currentNode.next = temp;
                currentNode = temp;
            }
        }

        kReverselist(prehead.next,length,k);
    }

    private static Node kReverselist(Node head,int length,int k){
        //可以逆转几组
        int t = length/k;
        //定义一个虚拟头节点
        Node prehead = new Node(-1);
        //三指针逆转
        Node sign = prehead;
        prehead.next = head;
        Node f = head;
        Node s = f.next;
        while (t>0){
            int m = k;
            while (m>1 && f!=null){
                f.next = s.next;
                s.next = sign.next;
                sign.next = s;
                s = f.next;
                m--;
            }
            sign = f;
            f =s;
            if (f==null) break;
            s = s.next;
            t--;
        }
        return prehead.next;

    }



}
