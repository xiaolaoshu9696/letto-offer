package letto.offer.newcoder.小马智行;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.Scanner;

public class Q1 {

//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int N = s.nextInt();
//        int[][] path = new int[N][N];
//        for (int i = 0 ;i <N; i++){
//            for (int j = 0; j<3; j++){
//                path[i][j] = s.nextInt();
//            }
//        }
//        int a = s.nextInt();
//        int b = s.nextInt();
//        int k = s.nextInt();
//
//        //二分查找答案
//        int left = -1;
//        int right = k;
//        while (right-left>1){
//            int mid = left + (right-left)/2;
//            boolean flag = isLegal(path, mid, a,b, k);
//            if (flag){
//                left = mid;
//            }
//            else{
//                right = mid;
//            }
//        }
//        System.out.println(left);
//
//    }
//
//    //判定当前值是否满足条件
//    private static boolean isLegal(int[][] path, int mid, int a, int b, int k) {
//        for (int i = 0; i<path.length; i++){
//            for (int j = i+1; j<path.length; j++){
//                int min = Math.min(path[i][a] + mid + path[b][j], path[i][b] + mid+ path[a][j]);
//                min = Math.min(path[i][j], min);
//                if (min>=k) return false;
//            }
//        }
//        return true;
//
//    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] path = new int[N][N];
        for (int i = 0 ;i <N; i++){
            for (int j = 0; j<3; j++){
                path[i][j] = s.nextInt();
            }
        }
        int a = s.nextInt();
        int b = s.nextInt();
        int k = s.nextInt();

        //二分查找答案
        int left = -1;
        int right = k;
        while (right-left>1){
            int mid = (left+right)/2;
            int ok = 1;
            for (int i = 0; i<N; i++){
                for (int j = i+1; j<N; j++){
                    int d = path[i][j];
                    d = Math.min(d, path[i][a] + mid + path[b][j]);
                    d = Math.min(d, path[i][b] + mid + path[a][j]);
                    if (d+mid>=k){
                        ok=0;
                        break;
                    }
                }
                if (ok==0) break;
            }
            if (ok==0) right = mid;
            else left = mid;

        }
        System.out.println(left);

    }


}
