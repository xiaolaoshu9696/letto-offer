package letto.offer.leetcode.回溯;
import java.util.*;

public class leetcode90 {

    public static void main(String[] args) {
        leetcode90 s=  new leetcode90();
        int[] nums = new int[]{1,2,2};
        System.out.println(s.subsetsWithDup(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList<>(), 0,  nums);
        return res;
    }

    public void dfs(List<Integer> temp, int start, int[] nums){
        res.add(new ArrayList<>(temp));

        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(temp, i+1, nums);
            temp.remove(temp.size()-1);

        }

    }
}
