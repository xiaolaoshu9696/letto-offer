package letto.offer.sort;


/**
 * 统一按从小到大排序
 *
 * 冒泡排序
 */
public class Bubble_sort {

    private static void BubbleSort(int[] nums){
        for (int i = nums.length-1; i>0; i--){
            boolean isSorted = true;
            for (int j = 0; j<i; j++){
                if (nums[j] > nums [j+1]){
                    swap(nums, j, j+1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
