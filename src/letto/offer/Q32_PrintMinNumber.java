package letto.offer;

import java.util.Arrays;

/**
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 *
 */
public class Q32_PrintMinNumber {
    //把数组排成最小的数
    public String PrintMinNumber(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < nums.length; i ++) {//int转string，比较string相加的值
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));//排序，s1+s2与s2+s1两个字符串比较，谁小谁放前面
        String result = "";
        for(String str: nums) {
            result += str;
        }

        return result;
    }
}
