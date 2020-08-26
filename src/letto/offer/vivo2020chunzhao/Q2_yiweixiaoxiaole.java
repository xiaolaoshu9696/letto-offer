package letto.offer.vivo2020chunzhao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;

public class Q2_yiweixiaoxiaole {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        // TODO Write your code here
        if (input==null || input.length==0){
            return 0;
        }
        int len = input.length;
        return DFS(input,len);
    }
    public static int DFS(int[] arr, int len){
        if (len==1) return 1;
        if (len==2) {
            if (arr[0]==arr[1]) return 4;
            else return 2;
        }
        int max = 0;
        int L = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[L]){
                int[] copy = new int[len-(i-L)];
                int j = 0;
                for (; j<L;j++){
                    copy[j] = arr[j];
                }
                for (int r = i; r<len; r++){
                    copy[j++] = arr[r];
                }
                max = Math.max(max,DFS(copy,copy.length) + (i-L)*(i-L));
                L = i;
            }
        }

        if(L == 0){
            return len * len;
        }
        int[] copy = new int[L];
        for(int j = 0; j < L; j++){
            copy[j] = arr[j];
        }
        max = Math.max(max, DFS(copy, copy.length) + (len - L) * (len - L));
        return max;
    }

    static class Node {
        Node prev;
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private static int solution2(int[] input) {
        // TODO Write your code here
        Node head = new Node(0);
        Node node = head;
        for(int i=0;i<input.length;++i){
            Node  p = new  Node(input[i]);
            p.prev = node;
            node.next = p;
            node = p;
        }
        return search(head);
    }
    static int search(Node head){
        if(head.next == null)return 0;

        int max = 0;
        Node p=head.next;
        while(p!=null){
            Node r=p;
            int c=1;
            while(r.next!=null && r.next.val==r.val){ r=r.next; ++c;}
            // remove
            p.prev.next = r.next;
            if(r.next!=null)r.next.prev=p.prev;
            int val = c*c + search(head);
            // restore
            p.prev.next = p;
            if(r.next!=null)r.next.prev=r;
            max = Math.max(max,val);

            p = r.next;
        }

        return max;
    }


}
