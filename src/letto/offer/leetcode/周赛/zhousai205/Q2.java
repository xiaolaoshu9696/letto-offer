package letto.offer.leetcode.周赛.zhousai205;

import letto.offer.sort.Heap_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author hkc
 * @date 2020/9/6 10:51
 */
public class Q2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{100000,100000};
        int[] nums2 = new int[]{100000,100000,100000};
        System.out.println(numTriplets(nums1, nums2));
    }

    public static int numTriplets(int[] nums1, int[] nums2) {
        return getcount(nums1,nums2) + getcount(nums2, nums1);
    }

    public static int getcount(int[] nums1, int[] nums2){
        int count = 0;
        for (int i = 0; i<nums1.length; i++){
            int num1 = nums1[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num:nums2) {
                map.put(num, map.getOrDefault(num,0)+1);
            }
            for (int j = 0; j<nums2.length;j++){
                int num2 = nums2[j];
                map.put(num2, map.get(num2)-1);
                //判断是否存在符合条件
                if (((long)num1*num1)%num2==0){
                    long num3 = ((long)num1*num1)/num2;
                    count+= map.getOrDefault((int)num3,0);
                }
            }

        }
        return count;
    }
}
