package letto.offer.leetcode.并集查;

public class leetcode547 {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int[] arr = new int[N];
        for (int i = 0;i<N;i++){
            arr[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for(int j = i+1; j<N; j++){
                if (M[i][j]==1){
                    union(arr,i,j);
                }

            }
        }
        int res =0;
        for (int i = 0; i < N; i++) {
            if (arr[i]==i) res++;
        }
        return res;




    }

    private void union(int[] arr, int i, int j) {
        arr[find(arr, i)] = find(arr,j);

    }

    private int find(int[] arr,int index){
        // 当当前节点是某个并集，且不是父节点时
        while (arr[index]!=index){
            // 找到父节点
            arr[index] = arr[arr[index]];
            index = arr[index];
        }
        return index;
    }



}
