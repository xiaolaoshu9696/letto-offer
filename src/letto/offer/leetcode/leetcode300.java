package letto.offer.leetcode;

public class leetcode300 {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1; i<nums.length; i++){
            int max = 1;
            for(int j=0 ; j<i; j++){
                if(nums[j]<nums[i]) max = Math.max(max, dp[j]+1);
            }
            dp[i] = max;
        }
        int max = 0;
        for (int n:
             dp) {
            max = Math.max(max,n);
        }
        return max;
    }

}
