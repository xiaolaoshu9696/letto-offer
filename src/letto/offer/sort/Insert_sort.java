package letto.offer.sort;

import org.w3c.dom.CDATASection;

/**
 *
 * 插入排序
 * 依次选择数组中的元素，与前面已经排好序的部分比较
 * 再将此元素插到指定位置上
 */

public class Insert_sort {

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
