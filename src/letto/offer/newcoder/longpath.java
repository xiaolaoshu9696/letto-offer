package letto.offer.newcoder;

import letto.offer.Q33_GetUglyNumber_Solution;
import sun.nio.cs.ext.IBM037;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class longpath {


    public static void main(String[] args) {
        int[] u = new int[]{2,3,5,4,5,5,6};
        int[] v = new int[]{5,2,1,6,7,4,8};
        int[] w = new int[]{15,6,14,4,1,6,30};
        longpath l = new longpath();
        System.out.println(l.solve(8,u,v,w));
    }

    class node{

        int val;
        //路径和
        long pathsumval;

        private node(int val, long pathsumval){
            this.val = val;
            this.pathsumval = pathsumval;
        }

    }


    public long solve (int n, int[] u, int[] v, int[] w) {
        // write code here
        int[][] path = new int[n+1][n+1];
        for(int i =0; i<u.length; i++){
            path[u[i]][v[i]] = w[i];
            path[v[i]][u[i]] = w[i];
        }
        int rootindex=-1;
        //找到一个一行只有1个路径的屋子
        for(int i = 0; i<path.length;i++){
            int[] arr = path[i];
            ArrayList index = findNotZeroIndex(arr);
            if (index.size()==1){
                rootindex = i;
                break;
            }
        }
        return bulidTree(rootindex,path);




    }

    public long bulidTree(int rootindex, int[][] path){
        long max = -1;
        Queue<node> queue = new LinkedList<>();
        node root = new node(rootindex,0);
        queue.add(root);
        while (!queue.isEmpty()){
            node house = queue.poll();
            ArrayList<Integer> son = findNotZeroIndex(path[house.val]);
            if (son.size()>0){
                for (int i =0; i<son.size();i++){
                    node cur = new node(son.get(i),house.pathsumval+path[house.val][son.get(i)]);
                    queue.add(cur);
                    path[house.val][son.get(i)]=0;
                    path[son.get(i)][house.val]=0;
                }
            }else{
                //到底了
                max = Math.max(house.pathsumval,max);
            }
        }
        return max;
    }


    //找一行不为0的index
    public ArrayList<Integer> findNotZeroIndex(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>0) res.add(i);
        }
        return res;
    }
}
