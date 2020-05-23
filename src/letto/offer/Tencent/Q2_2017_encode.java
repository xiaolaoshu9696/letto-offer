package letto.offer.Tencent;

import java.awt.event.WindowFocusListener;
import java.util.Scanner;

public class Q2_2017_encode {
    static long[] ar = new long[32];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int change = sc.nextInt()-1;
            int find = sc.nextInt()-1;
            System.out.println(Find(change,find));
        }

    }

    public static int Find(int change, int find){
        if (change>=1024||find>=1024) return -1;
        int ch_b = change/32;
        int ch_s = change-ch_b*32;

        int f_b = find/32;
        int f_s = find-f_b*32;

        ar[ch_b] = ar[ch_b]|(long)Math.pow(2, ch_s);  //通过或运算把表示要完成任务的那一位置为1

        if( (ar[f_b] & (long)Math.pow(2, f_s)) == (long)Math.pow(2, f_s) ) //通过或运算来确定表示要查找的任务的那一位是否为1，long型问题同上
            return 1;
        else return 0;
    }
}
