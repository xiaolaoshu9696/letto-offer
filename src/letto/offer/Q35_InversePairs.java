package letto.offer;

import javax.swing.*;

/**
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 */

public class Q35_InversePairs {
    int count;

    public static void main(String[] args) {
        
    }

    // 整个过程类似于归并排序，在两个数交换过程中统计逆序对个数
    public  int InversePairs(int [] array) {
        count =0;
        if (array.length==0) return 0;
        mergeSort(array, 0, array.length-1);
        return count;
    }

    private  void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left+right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];//辅助数组
        int p1 = left, p2 = mid + 1, k = 0; //p1,p2是检测指针，k是存放指针
        while(p1 <= mid && p2 <= right){
            if (nums[p1] <= nums[p2])
                tmp[k++] = nums[p1++];
            else{
                //往前移了几步就有几个逆序对
                count += mid - p1 + 1;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
                tmp[k++] = nums[p2++];
            }
        }
        while(p1<=mid) tmp[k++] = nums[p1++];
        while(p2<=right) tmp[k++] = nums[p2++];
        //复制回原数组
        for (k = 0; k<tmp.length; k++){
            nums[left+k] = tmp[k];
        }
    }

}
