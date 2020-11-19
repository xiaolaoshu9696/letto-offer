package com;

import java.util.Scanner;

/**
 * @author hkc
 * @date 2020/9/1 20:26
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for (int i= 0; i<M; i++){
            arr[i] = sc.nextInt();
        }
        int res = cal(N, arr);
        System.out.println(res);

    }

    private static int cal(int n, int[] arr) {
        int[] dp = new int[n+1];
        for (int i = 0; i<arr.length; i++){
            int cur = arr[i];
            int add = cur;
            while (cur<=n){
                dp[cur] = 1;
                cur = cur+add;
            }
        }
        int res = 0;
        for (int i =0; i<=n; i++){
            if (dp[i] == 1) res++;
        }
        return res;


    }

}
