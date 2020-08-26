package letto.offer.leetcode.滑动窗口;

/**
 * 链接：https://ac.nowcoder.com/acm/contest/6779/B
 * 来源：牛客网
 *
 * 题意：
 * 牛牛从牛毕那里拿了一根长度为n的白木板，木板被等分成了n段（没有被切割，只是虚拟划分成了n段），其中有些段被牛毕用颜料染成了黑色。
 * 牛牛非常不喜欢黑色，它找来了一桶清洗剂决定对木板进行清洗，但是牛牛发现自己的清洗剂最多只能清洗m段。
 * 清洗完后，牛牛会把木板锯成纯色的几段。例如假设木板是 （黑黑黑白白白白黑黑黑 ），就会被锯成（黑黑黑）（白白白白）（黑黑黑）三段。
 * 牛牛想知道，它足够聪明地清洗木板，能获得的纯白色木板的最大长度是多少。
 *
 * 输入：
 * 给定n,m两个整数
 * 和一个长度为n的数组a，为1表示白色，为0表示黑色
 * (1 \leq n\leq 10^{6}1≤n≤10
 * 6
 *   , 1 \leq m\leq n1≤m≤n )
 * (0 \leq a_{i} \leq 10≤a
 * i
 * ​
 *  ≤1)
 *
 * 输出：
 * 一行一个数字表示能获得的纯白色木板的最大长度是多少。
 */

public class newcode {
    public static void main(String[] args) {
        int[] a = new int[]{1,0,1,1,0,0,1,1};
        System.out.println(solve(8,1,a));


    }


    public static int solve (int n, int m, int[] a) {
        // write code here
        //滑动窗口变种
        int l =0;
        //用了多少份清洗剂
        int num = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            if(a[i]==0 && num<m){
                num++;
            }
            else if(a[i]==0 && num==m){
                while(a[l]==1) l++;
                l++;
                //错在这里，当用完清洗剂的时候不用减了，右边碰到0，左边移到下一个0的后一位，右边往前一位刚好用掉
                //num--
            }
            max = Math.max(max, i+1-l);

        }
        return max;
    }

    public static int solve2(int n, int m, int[] a) {
        // write code here
        //滑动窗口变种
        int l =0;
        //用了多少份清洗剂
        int num = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            if(a[i]==0){
                num++;
            }
            while (num>m){
                while(a[l]==1) l++;
                l++;
                num--;
            }
            max = Math.max(max, i+1-l);

        }
        return max;
    }
}
