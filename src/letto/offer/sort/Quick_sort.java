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
        QuickSort_2(nums,0,nums.length-1);
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

    //容易理解的写法
    private static void QuickSort_2(int[] nums, int start, int end) {
        if (start>end) return;
        int base = nums[start];
        int temp;
        int i = start, j = end;
        while (i!=j){
            //顺序很重要，先从右边开始找
            while(nums[j]>=base && i<j) j--;
            while(nums[i]<=base && i<j) i++;

            if (i<j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //基准数归位
        nums[start] = nums[i];
        nums[i] = base;
        QuickSort_2(nums, start, i-1);
        QuickSort_2(nums, i+1, end);
    }

    //甜姨写法
    private static void partition(int [] nums, int lo, int hi){
        if (lo>hi) return;
        int v = nums[lo];
        int i = lo, j =hi+1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        partition(nums,lo,j-1);
        partition(nums,j+1,hi);
    }

    //挖坑法
    //1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
    //2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
    //3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
    //4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
    public static void QuickSort_3(int[] s, int l, int r){
        if (l<r){
            int i = l, j = r, x = s[l];
            while (i<j){
                while (i<j && s[j]>=x) j--;
                if (i<j){
                    s[i] = s[j];
                    i++;
                }
                while (i<j && s[i]<x) i++;
                if (i<j){
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;
            QuickSort_3(s,l,i-1);
            QuickSort_3(s,i+1,r);
        }
    }

    //leetcode里partition的写法，选择最后一个当哨兵， 从前往后依次判断是否小于他，小于则依次交换到前面
    public static void  Quick_sort(int[] a, int l, int r){
        if (l<r){
            int x = a[r], i = l-1;
            for(int j = l; j<r; j++){
                if (a[j]<=x){
                    swap(a,++i,j);
                }
            }
            swap(a,i+1,r);
            Quick_sort(a,l,i);
            Quick_sort(a,i+2,r);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        String d = "abc";
        String b = "ddd";
        d.equals(b);
    }

}
