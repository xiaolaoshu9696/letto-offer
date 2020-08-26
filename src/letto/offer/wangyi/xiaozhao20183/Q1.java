package letto.offer.wangyi.xiaozhao20183;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i <n; i++){
            arr[i] = sc.nextInt();
        }




        StringBuilder s = new StringBuilder();
        for(int num:arr){
            s.append(num + " ");
        }
        s.deleteCharAt(s.length()-1);
        System.out.println(s.toString());
    }
}
