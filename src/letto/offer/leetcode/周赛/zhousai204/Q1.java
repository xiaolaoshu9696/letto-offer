package letto.offer.leetcode.周赛.zhousai204;

/**
 * @author hkc
 * @date 2020/8/30 10:31
 */
public class Q1 {
    public static void main(String[] args) {
        int[] a = new int[]{2,2};
        System.out.println(containsPattern(a,1,2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        boolean flag = false;
        int len = arr.length;
        for(int i = 0; i<=len-m*k; i++){
            boolean f = true;
            for (int j = 0; j<k; j++){
                for (int x=0; x<m; x++){
                    if (arr[i+x]!=arr[i+j*m+x]){
                        f = false;
                        break;
                    }
                }
                if (!f)break;
            }
            if (f) {
                flag = true;
                break;
            }
        }
        return flag;

    }


}
