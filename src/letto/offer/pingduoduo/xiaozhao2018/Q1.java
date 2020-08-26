package letto.offer.pingduoduo.xiaozhao2018;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int offset = sc.nextInt();
            int n = sc.nextInt();
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            solve(offset,n,l1,l2);
        }
    }

    private static void solve(int offset, int n, int l1, int l2) {
        int[] res= new int[4];
        //如果l1商品还有剩余
        if (l1>offset) {
            res[0] = offset;
            //l1商品还够展示完
            if (l1-offset>=n){
                res[1] = offset+n;
                res[2] = 0;
                res[3] = 0;
            }
            else{
                res[1] = l1;
                int last = n-(l1-offset);
                if (last>l2) last= l2;
                res[2] = 0;
                res[3] = last;
            }

        }
        //l1被跳过
        else{
            res[0] = l1;
            res[1] = l1;
            offset = offset-l1;
            //l2也被跳过
            if (offset>=l2){
                res[2] = l2;
                res[3] = l2;
            }
            else{
                res[2] = offset;
                int last = offset+n;
                if (last>l2) last= l2;
                res[3] = last;
            }

        }
        String ans = "";
        for (int i =0; i<4; i++){
            if (i<3) ans+=res[i]+" ";
            else ans+=res[i];
        }
        System.out.println(ans);

    }

}
