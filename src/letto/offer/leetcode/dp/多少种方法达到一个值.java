package letto.offer.leetcode.dp;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author hkc
 * @version 1.0
 * @date 2020/8/28 10:34
 */
public class 多少种方法达到一个值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n; i++){
            arr[i] = sc.nextInt();
        }
        int res = slove(arr, target);
        System.out.println(res);
    }

    private static int slove(int[] arr, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        //对每一个额度
        for(int i = 0; i<arr.length; i++){
            //计算直到加入这个额度有多少种情况
            for(int j = arr[i]; j<=target; j++){
                dp[j] = (dp[j] + dp[j-arr[i]])%1000000007;
            }
        }
        return dp[target];

        /*
        二维dp
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i= 0; i<=n; i++){
            for(int j = 1; j<=target; j++){
                dp[i][j] = (dp[i-1][j] +  (j>=arr[i-1] ? dp[i][j-arr[i-1]]: 0 ))%1000000007;
            }
        }
        return dp[n][target];

         */


    }



}
