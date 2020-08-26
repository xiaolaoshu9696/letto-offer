package letto.offer.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class leetcode179 {
    public String largestNumber(int[] nums) {

        int sum  = 0;
        for (int num: nums){
            sum+=num;
        }
        if (sum==0) return "0";
        String[] s_nums = new String[nums.length];
        for (int i =0; i<nums.length; i++){
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return  s2.compareTo(s1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String snum:s_nums){
            res.append(snum);
        }
        return res.toString();

    }
}
