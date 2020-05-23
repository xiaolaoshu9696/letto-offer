package letto.offer.newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class alarmClock {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] h = new int[n];
        int[] m = new int[n];
        int[] mm = new int[n];
        for(int i=0; i<n; i++){
            h[i] = s.nextInt();
            m[i] = s.nextInt();
            mm[i] = h[i]*60+m[i];
        }
        int d = s.nextInt();
        int sh = s.nextInt();
        int sm = s.nextInt();
        int e = sh*60+sm;
        int res = 0;
        Arrays.sort(mm);
        int i=0;
        while(i<n && mm[i]+d<=e){
            i++;
        }
        res = mm[i-1];
        System.out.println(res/60+ " " +res%60);
    }
}
