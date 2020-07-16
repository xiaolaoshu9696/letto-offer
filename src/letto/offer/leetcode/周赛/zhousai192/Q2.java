package letto.offer.leetcode.周赛.zhousai192;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[] arr =new  int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(getStrongest(arr,2)));
    }
    public static int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        if(n==1||k==arr.length) return arr;
        Arrays.sort(arr);
        int m = arr[(n-1)/2];
        int [] res = new int[k];
        int index = 0;

        int left = 0;
        int right = n-1;
        while (left<right){
            if (index==k){
                return res;
            }
            if (Math.abs(arr[left]-m)>Math.abs(arr[right]-m)){
                res[index++] = arr[left++];
                continue;
            }
            if (Math.abs(arr[left]-m)<=Math.abs(arr[right]-m)){
                res[index++] = arr[right--];
            }

        }

        return res;
    }

}
