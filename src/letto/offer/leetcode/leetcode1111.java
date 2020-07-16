package letto.offer.leetcode;

public class leetcode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        char[] c = seq.toCharArray();
        int[] res = new int[c.length];
        //记录至今还有多少个左括号没有闭合，第一个给A，第二个给B，依次继续
        int num = 0;
        for (int i = 0; i < c.length; i++) {
            char current = c[i];
            if (current=='('){
                num++;
                if (num%2==1) res[i] = 0;
                else res[i] = 1;
            }
            if (current == ')'){
                num--;
                if(num%2==0) res[i] = 0;
                else res[i] = 1;
            }
        }
        return  res;

    }


}
