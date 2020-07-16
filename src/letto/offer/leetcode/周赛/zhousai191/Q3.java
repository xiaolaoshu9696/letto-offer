package letto.offer.leetcode.周赛.zhousai191;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q3 {


    public static void main(String[] args) {
        int[][] con = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        System.out.println(minReorder(5, con));
    }

    public static int minReorder(int n, int[][] connections) {
        List<HashSet<Integer>> in = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            in.add(new HashSet<>());
        }
        List<HashSet<Integer>> out = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            out.add(new HashSet<>());
        }
        for (int[] c:connections){
            int a = c[0];
            int b = c[1];
            out.get(a).add(b);
            in.get(b).add(a);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int ans = 0;
        // BFS
        while (!queue.isEmpty()){
            // 取出当前层节点
            int cur = queue.poll();

            if (in.get(cur)!=null && in.get(cur).size()>0){
                //先遍历入度，以初始节点为例子，先取出指向0的节点
                for (int k: in.get(cur)){
                    // 队列加入下一层
                    queue.add(k);
                    // 出度中去除，因为已经指向了正确节点
                    out.get(k).remove(cur);
                }
                in.get(cur).clear();
            }
            if (out.get(cur)!=null && out.get(cur).size()>0){
                // 遍历出度，以初始节点为例子，先取出0指向的节点
                for (int k: out.get(cur)){
                    //这条边要换向
                    ans++;
                    queue.add(k);
                    in.get(k).remove(cur);
                }
            }
        }
        return ans;

    }


    public static int minReorder1(int n, int[][] connections) {
        List<Integer>[] toMap = new List[n];
        List<Integer>[] inMap = new List[n];
        //toMap和inMap用来保存每个节点的指向的节点和指向它的节点
        for (int i = 0; i < n; i++) {
            toMap[i] = new ArrayList<>();
            inMap[i] = new ArrayList<>();
        }
        for (int[] con : connections) {
            toMap[con[0]].add(con[1]);
            inMap[con[1]].add(con[0]);
        }
        return dfs(0, -1, toMap, inMap);
    }

    public static int dfs(int i, int pre, List<Integer>[] toMap, List<Integer>[] inMap) {
        int res = 0;
        for (int k : inMap[i]) {
            if (k == pre) continue;
            res += dfs(k, i, toMap, inMap);
        }
        for (int k : toMap[i]) {
            if (k == pre) continue;
            res += dfs(k, i, toMap, inMap) + 1;
        }
        return res;
    }


    public static int minReorder2(int n, int[][] connections) {
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++) {
            if ((connections[i][0]) == 0) {
                arrayList.add(connections[i][1]);
                count++;
                connections[i] = null;
                continue;
            }
            if (connections[i][1] == 0) {
                arrayList.add(connections[i][0]);
                connections[i] = null;
            }
        }
        while (arrayList.size() != 0) {
            ArrayList<Integer> newArr = new ArrayList<Integer>();
            for (Integer a : arrayList) {
                for (int i = 0; i < n - 1; i++) {
                    if (connections[i] != null) {
                        if (connections[i][0] == a) {
                            newArr.add(connections[i][1]);
                            count++;
                            connections[i] = null;
                            continue;
                        }
                        if (connections[i][1] == a) {
                            newArr.add(connections[i][0]);
                            connections[i] = null;
                        }
                    }
                }
            }
            arrayList = newArr;
        }
        return count;
    }

}
