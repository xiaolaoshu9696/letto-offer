package letto.offer;

import java.util.ArrayList;

/**
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

public class Q42_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = array.length-1;

//        for (int i=0; i<array.length-1;i++){
//            if (array[i] > sum) break;
//            for (int j  = end; j>i; j--){
//                if ((array[i]+array[j])<sum) break;
//                if ((array[i]+array[j])==sum){
//                    res.add(array[i]);
//                    res.add(array[j]);
//                    return res;
//                }
//            }
//        }
        // 因为数组是递增的，所以只要和大时，尾指针左移，和小时，头指针右移即可
        // 头指针右移时，尾指针不用从尾部开始，因为前一个i已经证明后面的数不行
        while (start<end){
            if (array[start]+array[end]==sum){
                res.add(array[start]);
                res.add(array[end]);
                return res;
            }
            while(start < end && array[start] + array[end] > sum) --end;
            while(start < end && array[start] + array[end] < sum) ++start;
        }
        return res;
    }
}
