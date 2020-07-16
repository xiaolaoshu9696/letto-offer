package letto.offer.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode491递增子序列 {

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }


    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new Stack<>(), 0,result);
        return result;
    }

    private static void dfs(int[] nums, Stack<Integer> stack, int index, List<List<Integer>> result){
        if(index>=nums.length){
            if(stack.size()>=2){
                result.add(new ArrayList<>(stack));
            }
            return;
        }
        if(stack.isEmpty() || nums[index]>=stack.peek()){
            stack.push(nums[index]);
            dfs(nums, stack, index+1,result);
            stack.pop();
        }
        if(index>0 && !stack.isEmpty() && nums[index] == stack.peek()) return;
        dfs(nums, stack, index+1,result);
    }
// 暴力hashset循环解法
//    Set<List<Integer>> res;
//    int[] nums;
//    int n;
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        this.nums = nums;
//        this.n = n;
//        res = new HashSet<>();
//        helper(new ArrayList<Integer>(), 0);
//        return new ArrayList(res);
//    }
//
//    void helper(List<Integer> cur, int start) {
//        if (cur.size() >= 2) {
//            res.add(new ArrayList<Integer>(cur));
//        }
//        for (int i = start; i < nums.length; i ++) {
//            if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]) {
//                cur.add(nums[i]);
//                helper(cur, i + 1);
//                cur.remove(cur.size() - 1);
//            }
//        }
//    }


}
