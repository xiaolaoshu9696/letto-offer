package letto.offer;

/**
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */

public class Q51_multiply {

    //直接循环
    public int[] multiply1(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int i =0; i<len;i++){
            int val=1;
            for (int j = 0; j<len; j++){
                if (j!=i) val = val * A[j];
            }
            B[i] = val;
        }
        return B;
    }

    //构造两个数组存储左乘和右乘值
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] lefts = new int[len];
        int[] rights = new int[len];
        lefts[0]  = rights[len-1] = 1;
        int l = 1;
        int r = 1;
        for (int i=1; i<len; i++){
            lefts[i] = A[i-1]*lefts[i-1];
        }

        for (int i=len-2; i>=0; i--){
            rights[i] = A[i+1]*rights[i+1];
        }
        int[] B = new int[len];
        while (len>0){
            len--;
            B[len] = lefts[len]*rights[len];
        }
        return B;
    }
}
