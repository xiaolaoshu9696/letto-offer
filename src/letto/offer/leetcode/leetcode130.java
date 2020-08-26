package letto.offer.leetcode;

public class leetcode130 {

    int[][] last;
    public void solve(char[][] board) {
        if(board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        last = new int[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if((last[i][j]==0 && board[i][j]=='O') && (i==0 || i== row-1 || j==0 || j==col-1)){
                    dfs(board,i,j);
                }
            }
        }
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(last[i][j]==1) board[i][j]='O';
                else board[i][j]='X';
            }
        }



    }

    public void dfs(char[][] board, int i , int j){
        int row = board.length;
        int col = board[0].length;
        if(i<0||i>=row||j<0||j>=col||last[i][j]==1||board[i][j]=='X') return;
        last[i][j]=1;
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
