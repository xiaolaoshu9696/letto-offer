package letto.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */

public class Q47_Sum_Solution {
    //利用短路特性来模拟while
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0) && ((sum+=Sum_Solution(--n))>0);
        return sum;
    }
}
