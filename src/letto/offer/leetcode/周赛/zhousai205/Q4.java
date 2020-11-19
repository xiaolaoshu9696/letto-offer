package letto.offer.leetcode.周赛.zhousai205;

/**
 * @author hkc
 * @date 2020/9/6 11:48
 */
public class Q4 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count_edges = edges.length;
        int count_type1 = 0;
        int count_type2 = 0;
        int count_type3= 0;
        for (int i = 0; i<edges.length;i++){
            if (edges[i][0]==1) count_type1++;
            if (edges[i][0]==2) count_type2++;
            if (edges[i][0]==3) count_type3++;
        }

        if (count_type1+count_type3<n-1||count_type2+count_type3<n-1) return -1;

        return 0;

    }

}
