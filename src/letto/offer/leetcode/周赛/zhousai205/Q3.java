package letto.offer.leetcode.周赛.zhousai205;

import java.util.Arrays;

/**
 * @author hkc
 * @date 2020/9/6 11:27
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(minCost("aabaa", new int[]{1,2,3,4,1}));
    }

    public static int minCost(String s, int[] cost) {
        int l = 0;
        int r = 1;
        int res =0;
        while(r<s.length()){
            if (s.charAt(r)==s.charAt(r-1)){
                l = r-1;
                while(r<s.length() &&s.charAt(r)==s.charAt(r-1)) r++;
                res+= cal(cost, l, r);
            }
            else{
                r++;
            }
        }
        return res;

    }

    private static int cal(int[] cost, int l, int r) {
        int[] arr = new int[r-l];
        for (int i = 0; i<arr.length; i++){
            arr[i] = cost[l+i];
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i<arr.length-1; i++){
            res+=arr[i];
        }
        return res;


    }
}
