package letto.offer.leetcode.周赛.zhousai191;

import java.util.Arrays;

public class Q1 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = Math.max((nums[0]-1)*(nums[1]-1),(nums[n-1]-1)*(nums[n-2]-1));
        return max;
    }
}
