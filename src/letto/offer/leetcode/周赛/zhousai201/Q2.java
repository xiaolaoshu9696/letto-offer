package letto.offer.leetcode.周赛.zhousai201;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Q2 {
    int count =-1;
    boolean flag = false;
    public static void main(String[] args) {
        Q2 s = new Q2();
        System.out.println(s.findKthBit(4,15));
    }
    public  char findKthBit(int n, int k) {
        if (k==1) return '0';
        if (k==2) return '1';
        int m = k;
        while (!flag){
            m = mirro(m);
        }
        if (m==1){
            if (count%2==1) return '1';
            else return '0';
        }
        else{
            if (count%2==1) return '0';
            else return '1';

        }
    }

    //找到大于k的最小二次幂,反转,不停的进行镜像操作，直到找到1，或者2^n/2;
    public int mirro(int k){
        int n = 0;
        while (Math.pow(2,n)-1<k){
            n++;
        }
        int max = (int)Math.pow(2,n);
        int mid = max/2;
        count++;
        if (k==mid || k==1) flag = true;
        if (k == mid) return mid;
        if (k==1) return 1;
        return mid-(k-mid);
    }
}
