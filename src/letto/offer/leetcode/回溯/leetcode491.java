package letto.offer.leetcode.回溯;

import java.util.*;

public class leetcode491 {
    public static void main(String[] args) {
        leetcode491 s = new leetcode491();
        int[] nums = new int[]{4,6,7,7};
        System.out.println(s.findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new Stack<>(), 0,result);
        return result;
    }

    private void dfs(int[] nums, Stack<Integer> stack, int index, List<List<Integer>> result){
        if(index==nums.length){
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
}
