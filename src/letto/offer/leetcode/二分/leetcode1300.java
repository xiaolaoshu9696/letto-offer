package letto.offer.leetcode.二分;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode1300 {
    public static void main(String[] args) {

    }
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[n-1], ans= -1;
        while(l<=r){
            int mid = (l+r)/2;
            int index = Arrays.binarySearch(arr,mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * mid;
            if (cur <= target) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        int chooseSmall = check(arr, ans);
        int chooseBig = check(arr, ans + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans : ans + 1;
    }

    public int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }


    //暴力枚举
    public int findBestValue2(int[] arr, int target) {
        if(arr.length==0) return 0;
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i = 1; i<=n; i++){
            prefix[i] = prefix[i-1]+arr[i-1];
        }
        int r = arr[n-1];
        int ans = 0;
        int diff = target;
        //暴力枚举
        for(int i = 1; i<=r; i++){
            int index = Arrays.binarySearch(arr,i);
            if(index<0){
                index = -index-1;
            }
            int cur = prefix[index] + (n-index)*i;
            if(Math.abs(cur-target)<diff){
                ans = i;
                diff = Math.abs(cur-target);
            }

        }
        return ans;


    }
}
