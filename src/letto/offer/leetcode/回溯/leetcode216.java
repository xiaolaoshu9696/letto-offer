package letto.offer.leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hkc
 * @date 2020/9/11 10:28
 */
public class leetcode216 {
    List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        leetcode216 s = new leetcode216();
        System.out.println(s.combinationSum3(3,9));
    }


    public List<List<Integer>> combinationSum3(int k, int n) {


        dfs(n,k,0,1, new LinkedList<Integer>());
        return res;
    }

    public void dfs(int n, int k, int cur,int start, LinkedList<Integer> path){
        if(cur==n && k==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(k==0) return;
        if(cur+start>n) return;

        for(int i = start; i<=9; i++){
            if(cur+i<=n){
                path.add(i);
                dfs(n, k-1, cur+i, i+1, path);
                path.removeLast();
            }
        }


    }
}
