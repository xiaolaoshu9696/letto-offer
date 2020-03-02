package letto.offer;

/**
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶
 * 总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Q08_JumpFloor {
    public int JumpFloor(int target) {
        if (target==1)  return 1;
        if (target==2)  return 2;
        // 考虑最后一次跳跃，只能是跳一级或者二级
        if (target>2) return JumpFloor(target-2) + JumpFloor(target-1);
        return 0;
    }
}
