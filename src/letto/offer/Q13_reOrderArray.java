package letto.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */

public class Q13_reOrderArray {
    public void reOrderArray(int [] array) {
        //类似于排序，要求位置不变，即稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0; //记录已经排好的奇数的数目
        for (int i = 0;  i<m; i++){
            if (array[i]%2==1){
                int j = i;
                //把奇数依次交换到k+1处
                while (j>k){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }
        }
    }
}
