package com;

import java.util.Scanner;

/**
 * @author hkc
 * @date 2020/9/1 19:00
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printMatrix(n);
    }

    private static void printMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                //分割线穿过的元素
                //奇数
                if (n%2==1){
                    if (i==n/2 || j==n/2){
                        matrix[i][j] = 0;
                        continue;
                    }
                }
                //对角线
                if (i==j || i+j==n-1){
                    matrix[i][j]=0;
                }else if(i<n/2 && j>=n/2 && i+j<n-1){
                    matrix[i][j]=1;
                }else if(i<n/2 && j>=n/2 && i+j>n-1){
                    matrix[i][j]=8;
                }else if(i<n/2 && j<n/2 && i<j){
                    matrix[i][j]=2;
                }else if(i<n/2 && j<n/2 && i>j){
                    matrix[i][j]=3;
                }else if(i>=n/2 && j<n/2 && i+j<n-1){
                    matrix[i][j]=4;
                }else if(i>=n/2 && j<n/2 && i+j>n-1){
                    matrix[i][j]=5;
                }else if(i>=n/2 && j>=n/2 && i>j){
                    matrix[i][j]=6;
                }else if(i>=n/2 && j>=n/2 && i<j){
                    matrix[i][j]=7;
                }
            }
        }
        for (int i = 0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j<n ;j++){
                if (j!=n-1){
                    sb.append(matrix[i][j]).append(" ");
                }else{
                    sb.append(matrix[i][j]);
                }

            }
            System.out.println(sb.toString());
        }


    }

}
