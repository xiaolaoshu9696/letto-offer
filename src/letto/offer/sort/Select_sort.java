package letto.offer.sort;

import java.util.Arrays;

/**
 *
 * 选择排序，每次选择一个位置，与后面的比较
 *
 */

public class Select_sort {

    public static void main(String[] args) {
        int[] nums = {2,11,4,5,78,33,33,45,67};
        SelectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void SelectSort(int[] nums){
        int temp = 0;
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if (nums[j]<nums[i]){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

}
