package letto.offer.leetcode.二分;

public class leetcode35 {

    public static void main(String[] args) {
        leetcode35 s = new leetcode35();
        int[] nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target==nums[mid]) return mid;
            if(target>nums[mid]) left = mid+1;
            if(target<nums[mid]) right = mid-1;
        }
        return left;

    }
}
