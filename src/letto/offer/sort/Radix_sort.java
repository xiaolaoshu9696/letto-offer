package letto.offer.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 基数排序
 *
 */
public class Radix_sort {
    public static void main(String[] args) {
        int[] nums = {4,11,2,5,78,33,33,45,67};
        RadixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void RadixSort(int[] nums){
        //找到最大值，确定位数
        int max = nums[0];
        for (int num : nums){
            if (num > max)  max = num;
        }
        int time = 0;
        while (max>0){
            max /= 10;
            time++;
        }
        //建立10个队列,对应0~9
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i<10; i++){
            queue.add(new ArrayList<Integer>());
        }

        //进行time次分配和收集
        for (int i=0; i<time; i++){
            //分配数组元素
            for (int j = 0; j<nums.length; j++){
                //得到数字的第time+1位数
                int x = nums[j] % (int) Math.pow(10,i+1) / (int)Math.pow(10, i);
//                ArrayList<Integer> queue2 = queue.get(x);
//                queue2.add(nums[j]);
//                queue.set(x, queue2);
                queue.get(x).add(nums[j]);
            }
            int count = 0;
            for (int k =0; k<10; k++){
                while(queue.get(k).size() > 0){
                    ArrayList<Integer> queue3 = queue.get(k);
                    nums[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }


    }
}

