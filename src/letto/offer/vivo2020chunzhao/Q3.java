package letto.offer.vivo2020chunzhao;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    public static int solution (int n) {
        // write code here
        int k = 0;
        int sum =0;
        while (sum<=n){
            k++;
            sum+=k;
        }
        k--;
        int res = getSum(k);
        res += (n-getDate(k))*(k+1);
        return res;

    }

    private static int getDate(int n){
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res+=i;
        }
        return res;
    }
    private static int getSum(int n){
        int res = 0;
        for (int i = 1; i <=n; i++) {
            res +=i*i;
        }
        return res;
    }

}
