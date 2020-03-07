package letto.offer;

import java.sql.PreparedStatement;

/**
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Q28_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (length <= 0) return 0;
        //找到出现次数大于长度一般的数字
        int count = 1;
        int tmp = array[0];
        for (int i = 0; i<length; i++){
            if (count == 0){
                tmp = array[i];
                count =1;
            }
            else{
                if (array[i] == tmp) count++;
                else count--;
            }
        }

        count = 0;
        for (int value: array){
            if (value==tmp) count++;
        }
        if (count*2<=length) tmp=0;
        return tmp;


    }

}
