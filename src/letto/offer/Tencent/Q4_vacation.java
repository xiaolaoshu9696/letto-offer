package letto.offer.Tencent;

import java.util.Scanner;

/**
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
 * 他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，
 * 只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，
 * 求小Q最少需要休息几天。
 * 第一行一个整数 表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * 输出 一个整数，表示小Q休息的最少天数
 * 4
 * 1 1 0 0
 * 0 1 1 0
 *
 * 2
 */
//动态规划

public class Q4_vacation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String day_str = in.nextLine();
        String[] work_str = in.nextLine().split(" ");
        String[] gym_str = in.nextLine().split(" ");
        int day = Integer.parseInt(day_str);
        int[] works = new int[day+1];
        int[] gyms = new int [day+1];
        for (int i=1; i<day+1; i++){
            works[i] = Integer.parseInt(work_str[i-1]);
            gyms[i] = Integer.parseInt(gym_str[i-1]);
        }
        int res = holiday(day, works, gyms);
        System.out.println(res);

    }

    public static int holiday(int day, int[] works, int[] gyms){
        int res;
        int[][] dp = new int[day+1][3];
        //dp[i][0] dp[i][1] dp[i][2]分别记录在第i天如果是休息、工作、健身情况下，前i天有事做（也就是没休息）的最大天数
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i<day+1 ;i++){
            if (works[i] == 1){
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + 1;
            }
            if (gyms[i] == 1){
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + 1;
            }

            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));

        }
        res = day - Math.max(dp[day][0], Math.max(dp[day][1], dp[day][2]));
        return res;

    }


}
