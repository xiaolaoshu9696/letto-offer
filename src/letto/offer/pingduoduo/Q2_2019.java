package letto.offer.pingduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2_2019 {

    static List<String> ans;
    static int M ,N;
    static int[] A;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N+1];
        M = 0;
        for (int i = 1; i<=N; i++){
            A[i] = scanner.nextInt();
            M +=A[i];
        }
        ans = new ArrayList<>();
        if (dfs(0)) System.out.println(String.join(" ", ans));
        else System.out.println("-");

    }


    static boolean check(int left) {
        for (int i = 1; i <= N; i++) {
            if (A[i] > (left + 1) / 2) return false;
        }
        return true;
    }

    static boolean dfs(int idx) {
        if (!check(M - idx)) return false;
        if (idx == M) {
            return true;
        } else {
            for (int i = 1; i <= N; i++) {
                if (idx == 0 || (A[i] != 0 && i != Integer.valueOf(ans.get(idx - 1)))) {
                    A[i]--;
                    ans.add(i + "");
                    if (dfs(idx + 1)) return true;
                    ans.remove(ans.size() - 1);
                    A[i]++;
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[] A = new int[N+1];
//        int M = 0;
//        for (int i = 1; i<=N; i++){
//            A[i] = scanner.nextInt();
//            M +=A[i];
//        }
//        int now = 0;
//        boolean flag = false;
//        int[] res = new int[M];
//        for (int i = 0; i<M; i++){
//            now = find(A, now);
//            if (now!=-1){
//                res[i] = now;
//            }
//            else{
//                flag =true;
//                break;
//            }
//        }
//        if (flag){
//            System.out.println("-");
//        }else{
//            for (int num:res){
//                System.out.println(num);
//            }
//        }
//
//
//    }
//
//    public static int find(int[] A, int now){
//
//        for (int i = 0; i<A.length; i++){
//            if (A[i]!=0 && i!=now){
//                A[i] = A[i]-1;
//                return i;
//            }
//        }
//        return -1;
//    }
}
