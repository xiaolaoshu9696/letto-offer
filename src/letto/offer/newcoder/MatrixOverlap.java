package letto.offer.newcoder;
import java.util.*;

/**
 * 矩阵重叠
 *
 */


public class MatrixOverlap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] x1= new int[n];
        int[] y1= new int[n];
        int[] x2= new int[n];
        int[] y2= new int[n];
        for (int i=0; i<n; i++){
            x1[i] = s.nextInt();
        }
        for (int i=0; i<n; i++){
            y1[i] = s.nextInt();
        }
        for (int i=0; i<n; i++){
            x2[i] = s.nextInt();
        }
        for (int i=0; i<n; i++){
            y2[i] = s.nextInt();
        }


        int res = 0;
        //某个重合区域在多少个矩形内，
        // 可以转化为计算这个重合区域的左下角在多少个矩形内。
        // 外面两层循环遍历了所有重合区域可能的左下角，
        // 最里层循环计算这个左下角在多少个矩形内。
        for(int x: x1)
            for(int y: y1)
            {
                int cnt =0;
                for(int j=0;j<n;j++)
                {
                    //注意判断条件，一开一闭，否则两个完全重合的矩形会多计算一次
                    if(x>=x1[j]&&x<x2[j]&&y>=y1[j]&&y<y2[j])
                        cnt++;
                }
                res = Math.max(cnt,res);
            }
        System.out.println(res);
    }
}
