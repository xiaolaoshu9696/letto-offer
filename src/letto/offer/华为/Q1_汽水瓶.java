package letto.offer.华为;

import java.util.Scanner;

public class Q1_汽水瓶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            if (nums != 0) {
                System.out.println(getNums(nums));
            }
        }
    }

    private static int getNums(int nums) {
        if (nums<3) return 0;
        int ans = 0;
        while (nums>=3){
            ans += nums/3;
            nums = nums-(nums/3)*3 + nums/3;
        }
        if (nums==2) ans++;
        return ans;
    }

}
