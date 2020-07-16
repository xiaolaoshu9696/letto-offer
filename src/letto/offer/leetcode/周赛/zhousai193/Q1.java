package letto.offer.leetcode.周赛.zhousai193;

public class Q1 {

    public int[] runningSum(int[] nums) {
        if(nums.length==0) return new int[0];
        if (nums.length==1) return nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;
    }

}
