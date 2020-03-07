package letto.offer.sort;

import java.util.Arrays;

/**
 *
 * 希尔排序
 * 分组进行插入排序
 *
 */
public class Shell_sort {

    public static void main(String[] args) {
        int[] nums = {2,11,4,5,78,33,33,45,67};
        ShellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void ShellSort(int[] nums){
        int N = nums.length;
        for (int gap = N/2; gap>0; gap/=2){
            //这里就是普通的插入排序了
            for (int i = gap; i<N; i++){
                int temp = nums[i];
                //最好这样写，防止越界
                int j = i - gap;
                while (j>=0 && temp<nums[j]){
                    nums[j+gap] = nums[j];
                    j = j-gap;
                }
                nums[j+gap] = temp;
            }
        }
    }

}
