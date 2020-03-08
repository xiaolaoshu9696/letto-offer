package letto.offer.sort;

import org.w3c.dom.CDATASection;

import java.util.Arrays;

/**
 *
 * 插入排序
 * 依次选择数组中的元素，与前面已经排好序的部分比较
 * 再将此元素插到指定位置上
 */

public class Insert_sort {

    public static void main(String[] args) {
        int[] nums = {2,11,4,5,78,33,33,45,67};
        InsertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void InsertSort(int[] nums){
        for (int i = 1; i<nums.length; i++){
            int val = nums[i];
            int j = i;
            while(j>0 && nums[j-1]>val){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = val;
        }

    }
}
