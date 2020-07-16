package letto.offer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode200 {

    public static void main(String[] args) {
        char[][] c = {{'1','0','1','1','0','1','1'}};
        System.out.println(numIslands(c));
    }
 //dfs
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 1){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int i, int j){
        if (i>=grid.length || i<0) return;
        if (j>=grid[0].length || j<0) return;
        if (grid[i][j]=='0') return;

        else{
            grid[i][j]='0';
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
        }
    }

    // bfs
    public static int bfs(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }



//    public static int numIslands(char[][] grid) {
//        if(grid.length==0) return 0;
//        int n = grid.length;
//        int m = grid[0].length;
//        int[] arr = new int[n*m];
//        for(int i = 0; i<n*m; i++){
//            if (grid[i/m][i-((i/m)*m)]==1){
//                arr[i] = i;
//            }
//            else arr[i] = -1;
//        }
//        for (int i=0; i<n; i++){
//            for (int j = 0; j<m; j++){
//                if (grid[i][j]==1)
//            }
//        }
//
//
//    }
//
//    public static void union(int index1, int index2, int[] arr){
//        arr[find(arr, index1)] = find(arr,index2);
//
//    }
//    public static int find(int[] arr, int index){
//        while (arr[index]!=index){
//            // 找到父节点
//            arr[index] = arr[arr[index]];
//            index = arr[index];
//        }
//        return index;
//
//    }

}
