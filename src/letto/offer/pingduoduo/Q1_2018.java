package letto.offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextLong();
        }
        if (n==3) System.out.println(arr[0]*arr[1]*arr[2]);
        getLargestMul(arr,n);


    }

    private static void getLargestMul(long[] arr, int n) {
        long  m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (long num:arr){
            if (num!=0){
                if (num>=m1){
                    m3= m2;
                    m2 = m1;
                    m1 = num;
                }
                else if (num>=m2){
                    m3= m2;
                    m2 = num;
                }
                else if (num>=m3){
                    m3 = num;
                }
                if (num<=min1){
                    min2= min1;
                    min1 = num;
                }
                else if (num>min1 && num<=min2){
                    min2 = num;
                }
            }
        }

        long max = Math.max(m1*m2*m3 , m1*min2*min1);
        System.out.println(max);
    }
}
