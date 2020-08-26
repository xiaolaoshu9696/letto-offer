package letto.offer.leetcode.周赛.zhousai201;

public class Q3 {
    public static void main(String[] args) {
        Q3 s = new Q3();
        int[] nums = new int[]{-1,3,5,1,4,2,-9};
        System.out.println(s.maxNonOverlapping(nums,6));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int[] prefix = new int[nums.length+1];
        for (int i = 0; i<nums.length; i++){
            prefix[i+1] = prefix[i]+nums[i];
        }
        int count = 0;
        // 从前缀和里找
        int left = 0;
        for (int i = 1; i<prefix.length; i++){
            for (int j = left; j<i; j++){
                if (prefix[i]- prefix[j]==target){
                    count++;
                    left = i;
                    break;
                }
            }

        }
        return count;



    }
}
