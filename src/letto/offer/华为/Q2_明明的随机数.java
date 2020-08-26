package letto.offer.华为;


import java.util.Arrays;
import java.util.Scanner;

public class Q2_明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i]= sc.nextInt();
            }
            dupAndSort(nums);

        }
    }

    private static void dupAndSort(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]){
                System.out.println(nums[i]);
            }
        }
    }
}
