package letto.offer;

import java.util.HashSet;

/**
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 */

public class Q50_duplicate {

    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int[] numbers, int length, int [] duplication) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0; i<length; i++){
            int val = numbers[i];
            if (!set.add(val)){
                duplication[0] = val;
                return true;
            }
        }
        return false;
    }

    // 利用数组特点
    public boolean duplicate2(int[] numbers, int length, int [] duplication) {
        for(int i=0;i!=length;++i){
            int index=numbers[i]%length;
            if(numbers[index]>=length){
                duplication[0] = index;
                return true;
            }
            numbers[index]+=length;
        }
        return false;
    }

}
