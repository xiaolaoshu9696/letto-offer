package letto.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */
public class Q11_NumberOf1 {
    public int NumberOf1(int n) {
        //我们把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0
        //那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
    //普通解法
    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        //把1每次左移一位，做与运算，如果得到的结果不为0则证明该位是1.
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

}
