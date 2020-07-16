package letto.offer.leetcode.并集查;

import java.util.Arrays;

public class 示例 {

    public static void main(String[] args) {
        int[] parent = new int[5];
        for(int i = 0; i<5;i++){
            parent[i] = i;
        }
        System.out.println(Arrays.toString(parent));
        union(parent,0,4);
        System.out.println(Arrays.toString(parent));
        union(parent,2,3);
        System.out.println(Arrays.toString(parent));
        union(parent,0,3);
        System.out.println(Arrays.toString(parent));
        System.out.println(find(parent,0));
        System.out.println(Arrays.toString(parent));
    }


    public static void union(int[] parent, int index1, int index2){
        parent[find(parent,index1)] = find(parent,index2);


    }
    public static int find(int[] parent, int index){
        while (parent[index]!=index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    public static boolean connected(int[] parent, int index1, int index2){
        return find(parent,index1) == find(parent, index2);
    }

}
