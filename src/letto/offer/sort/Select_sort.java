package letto.offer.sort;

/**
 *
 * 选择排序，每次选择一个位置，与后面的比较
 *
 */

public class Select_sort {

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
