package letto.offer.pingduoduo.xiaozhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    static int max  = Integer.MIN_VALUE;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int n = sc.nextInt();
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i = 0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i<n-1;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();
            adj[u].add(new int[]{v,d});
        }
        dfs(adj,0, 0);
        System.out.println(max);;

    }

    private static void dfs(List<int[]>[] adj, int cur, int len) {
        //可以选两条
        int size = adj[cur].size();

        for (int i = 0; i<size; i++){
            int[] next = adj[cur].get(i);
            int nextId = next[0];
            int nextlen = next[1];
            int curlen = len+nextlen;
            if (curlen<m){
                max = Math.max(max,curlen);
                dfs(adj,nextId,curlen);
            }
        }
    }
}
