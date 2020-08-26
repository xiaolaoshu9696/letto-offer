package letto.offer.leetcode;

public class leetcode416 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if (sum%2==1) return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i = 0; i<nums.length; i++){
            for(int j = sum; j>=nums[i]; j--){
                if(j-nums[i]>=0&&dp[j-nums[i]]) dp[j] = true;
            }
        }
        return dp[sum/2];


    }
}
