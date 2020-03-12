package letto.offer;

/**
 *
 *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Q48_Add {
    public int Add(int num1,int num2) {
        while(num2!=0){
            // 亦或 不考虑进位
            int temp = num1 ^ num2;
            // 进位
            num2 = (num1&num2)<<1;
            // 亦或和进位相加 ，若还有进位则继续此过程
            num1 = temp;
        }
        return num1;
    }
}
