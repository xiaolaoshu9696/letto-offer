package letto.offer;

import java.util.HashSet;

/**
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Q40_FindNumsAppearOnce {
    // Hashset
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0; i<array.length; i++){
            //如果已经存在
            if (!set.add(array[i])){
                //自动装箱
                set.remove(array[i]);
            }
        }
        Object[] temp = set.toArray();
        num1[0] = (int) temp[0];
        num2[0] = (int) temp[1];

    }
    // 用亦或，两个相同的数字
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]){
        int length = array.length;
        if (length==2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        // 亦或出来的结果肯定不为0
        for (int i=0; i<length; i++){
            bitResult ^=array[i];
        }
        // 找到第一个 1 所在的位数，
        // 可以把原数组按这一位是1或是0分成两组，
        // 两组各有一个出现一次的数
        int index = findFirst1(bitResult);

        for (int i=0; i<length; i++){
            if (isBit1(array[i],index)){
                num1[0] ^= array[i];
            }
            else  num2[0] ^= array[i];
        }

    }
    private int findFirst1(int bitResult){
        int index = 0;
        // 依次右移与 1 相与
        while (((bitResult & 1) ==0) && index<32){
            bitResult >>=1;
            index++;
        }
        return index;
    }
    private boolean isBit1(int target, int index){
        return ( (target >> index) & 1) == 1;
    }


}
