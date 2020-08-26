package letto.offer.vivo2020chunzhao;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 *
 */
public class Q2 {

    public static void main(String[] args) {
        System.out.println(solution(36));

    }

    /**
     * 输入一个整形数值，返回一个整形值
     * @param n int整型 n>9
     * @return int整型
     */
    public static int solution (int n) {
        // write code here
        if (n<10) return 10+n;
        int res = 0, base = 1;
        for (int i=9; i>1;i--){
            while (n%i==0){
                res += i*base;
                base = base*10;
                n = n/i;
            }
        }
        if (n>1) return -1;
        else return res;

    }

}
