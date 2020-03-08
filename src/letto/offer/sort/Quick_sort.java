package letto.offer.sort;

import java.util.Arrays;

/**
 *
 * 快速排序
 * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 */

public class Quick_sort {
    public static void main(String[] args) {
        int[] nums = {4,11,2,5,78,33,33,45,67};
        QuickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void QuickSort(int[] nums, int start, int end){
        int base = nums[start];
        int temp;
        int i = start, j = end;
        do {
            while ((nums[i]<base) && i<end) i++;
            while ((nums[j]>base) && j>start) j--;
            //能到这步，就是找到不符合小的数在base左边，大的数在base右边
            if (i<=j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }while (i<=j);
        if (start<j)  QuickSort(nums,start,j);
        if (end>i)  QuickSort(nums, i, end);
    }
}
