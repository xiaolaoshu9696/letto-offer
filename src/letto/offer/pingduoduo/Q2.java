package com;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author hkc
 * @date 2020/9/1 19:24
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] mat = new int[N][M];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int res = calMax(mat,N,M);
        System.out.println(res);

    }

    private static int calMax(int[][] mat, int n, int m) {
        int res = 0;
        int union = 0;
        int[][] matrix = new int[n][m];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                matrix[i][j]=mat[i][j];
            }
        }
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (matrix[i][j]==1){
                    union++;
                    findunion(matrix,i, j);
                }
            }
        }
        if (union==0) return 0;

        //如果只有一个联通分支
        if (union==1){
            for (int i = 0; i<n; i++){
                for (int j = 0; j<m; j++){
                    if (mat[i][j]==1){
                        res = findone(mat,i,j);
                    }
                }
            }
            return res;
        }


        //两个联通分支
        else if (union==2){
            for (int i = 0; i<n; i++){
                for (int j = 0; j<m; j++){
                    if (mat[i][j]==0){
                        boolean[][] visit = new boolean[n][m];
                        visit[i][j]=true;
                        int max = dfs(mat,i,j, true, visit);
                        res = Math.max(max,res);
                    }
                }
            }
            return res-1;
        }

        //如果有3个联通分支以上
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (mat[i][j]==0){
                    boolean[][] visit = new boolean[n][m];
                    visit[i][j]=true;
                    int max = dfs(mat,i,j, true, visit);
                    res = Math.max(max,res);
                }
            }
        }
        return res;
    }

    //一个联通分支时
    private static int findone(int[][] mat, int i, int j) {
        if (i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]==0){
            return 0;
        }
        mat[i][j]=0;
        return 1+findone(mat,i+1,j)
                +findone(mat,i-1,j)
                +findone(mat,i,j+1)
                +findone(mat,i,j-1);

    }

    private static void findunion(int[][] matrix, int i, int j) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[0].length ||matrix[i][j]==0){
            return ;
        }
        matrix[i][j]=0;
        findunion(matrix, i+1, j);
        findunion(matrix, i-1, j);
        findunion(matrix, i, j+1);
        findunion(matrix, i, j-1);
    }


    private static int dfs(int[][] mat, int i, int j, boolean flag, boolean[][] visit) {
        if (flag){
            return 1+ dfs(mat,i+1, j, false,visit)+
                    dfs(mat, i-1, j ,false,visit)+
                    dfs(mat, i, j+1,false,visit)+
                    dfs(mat,i, j-1, false,visit);
        }
        if (i<0 || i>=mat.length || j<0 || j>=mat[0].length || visit[i][j] || mat[i][j]==0){
            return 0;
        }
        visit[i][j] = true;
        return 1+ dfs(mat,i+1, j, false,visit)+
                dfs(mat, i-1, j ,false,visit)+
                dfs(mat, i, j+1,false,visit)+
                dfs(mat,i, j-1, false,visit);

    }


}
