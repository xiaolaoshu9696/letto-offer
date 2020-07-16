package letto.offer.leetcode;

public class leetcodemianshi64 {


    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNums2(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        //考虑B中每一位1对最后乘法结果的贡献，
        flag = (B&1)>0 && (ans+=A)>0; //当B该位为1时结果加上这位对结果的贡献
        A <<=1;      //下一位B是乘2的，反映到A乘2
        B >>=1;     //更新

        //重复14次，题目给了范围

        return ans;
    }

}
