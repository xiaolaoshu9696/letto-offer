package letto.offer.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 归并排序
 * 先递归到每组一个数，再相邻两组依次合并
 *
 */

public class Merge_sort {
    public static void main(String[] args) {
        int[] nums = {2,11,4,5,78,33,33,45,67};
        MergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


    private static void MergeSort(int[] nums, int start, int end){
        if (start<end){
            int mid = (start+end)/2;
            MergeSort(nums, start, mid);
            MergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] a, int left, int mid, int right){
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left; //p1,p2是检测指针，k是存放指针
        while(p1 <= mid && p2 <= right){
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }
        while(p1<=mid) tmp[k++] = a[p1++];
        while(p2<=right) tmp[k++] = a[p2++];
        //复制回原数组
        for (int i = left; i<=right; i++){
            a[i] = tmp[i];
        }
    }

}
