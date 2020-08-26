package letto.offer.leetcode.dfs;

public class leetcode329 {


    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        //添加备忘录，使得不用重复计算矩阵中每个点的递增最长路径
        int[][] memo = new int[row][col];
        for(int i = 0; i<row; i++){
            for(int j=0; j<col; j++){
                max = Math.max(max,dfs(i,j,visited,matrix,-1,memo));
            }
        }
        return max;
    }

    public int dfs(int i , int j, boolean[][] visited,int[][] matrix, int curval, int[][] memo){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]<=curval || visited[i][j]) return 0;
        if (memo[i][j]!=0) return memo[i][j];
        visited[i][j] = true;
        memo[i][j] = Math.max(memo[i][j],dfs(i-1,j,visited,matrix,matrix[i][j],memo)+1);
        memo[i][j] = Math.max(memo[i][j],dfs(i+1,j,visited,matrix,matrix[i][j],memo)+1);
        memo[i][j] = Math.max(memo[i][j], dfs(i,j+1,visited,matrix,matrix[i][j],memo)+1);
        memo[i][j] = Math.max(memo[i][j], dfs(i,j-1,visited,matrix,matrix[i][j],memo)+1);
        visited[i][j] = false;
        return memo[i][j];


    }
}
