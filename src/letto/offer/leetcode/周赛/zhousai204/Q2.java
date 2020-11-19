package letto.offer.leetcode.周赛.zhousai204;

/**
 * @author hkc
 * @date 2020/8/30 10:46
 */
public class Q2 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2};
        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        if (nums.length==1){
            if (nums[0]>0) return 1;
            else return 0;
        }
        //累计的负数
        int temp1 = 0;
        int max = 0;
        //累计的正数
        int temp2 = 0;
        int temp3 = 0;
        for (int num: nums){
            if (num>0){
                if (temp1==0) temp2++;
                else if (temp1==1) temp3++;
                max = Math.max(temp2,max);
                max = Math.max(temp3,max);

            }else if (num<0){
                temp1+=1;
                if (temp1==2){
                    temp2 = temp2+temp3+2;
                    temp3=0;
                    temp1 = 0;
                    max = Math.max(temp2,max);
                }

            } else{
                temp1 = 0;
                temp2 = 0;
                temp3 = 0;
            }

        }
        temp1 = 0;
        temp2 = 0;
        temp3 = 0;
        for (int i = nums.length-1; i>=0; i--){
            int num = nums[i];
            if (num>0){
                if (temp1==0) temp2++;
                else if (temp1==1) temp3++;
                max = Math.max(temp2,max);
                max = Math.max(temp3,max);

            }else if (num<0){
                temp1+=1;
                if (temp1==2){
                    temp2 = temp2+temp3+2;
                    temp3=0;
                    temp1 = 0;
                    max = Math.max(temp2,max);
                }

            } else{
                temp1 = 0;
                temp2 = 0;
                temp3 = 0;
            }

        }


        return max;

    }
}
