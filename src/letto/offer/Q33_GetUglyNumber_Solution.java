package letto.offer;

/**
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Q33_GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index<7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 =0, t3=0, t5=0;
        //找出下一个小的丑数,分别用2,3,5在丑数数组里对应的上一个丑数乘2,3,5找出最小的丑数
        for (int i = 1; i<index; i++){
            res[i] = Math.min(res[t2]*2, Math.min(res[t3]*3, res[t5] *5));
            if (res[i] == res[t2]*2) t2++;
            if (res[i] == res[t3]*3) t3++;
            if (res[i] == res[t5]*5) t5++;
        }
        return res[index-1];
    }
}
