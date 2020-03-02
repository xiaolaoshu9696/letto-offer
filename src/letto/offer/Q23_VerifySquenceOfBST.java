package letto.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 */

// 递归，后序遍历，取出根节点后小于根节点的前半部分是左子树，右半部分是右子树，且这两个子树也是合法的后序遍历序列
public class Q23_VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] seq = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(seq));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) return false;

        return isLegalSquence(sequence);
    }
    public static boolean isLegalSquence(int [] sub_q){
        //数组长度为1时，可以直接返回true
        int l = sub_q.length;
        if (l==1) return true;
        int root = sub_q[l-1];
        //从零开始依次遍历，比root小的设定为左子树
        int i = 0;
        while(sub_q[i] < root) i++;
        //div是右子树的第一个值的索引
        int div = i;
        //如果有违反规则的直接返回false
        for (; i<l-1;  i++){
            if (sub_q[i]<root) return false;
        }
        //此时遍历通过，有三种情况：1. 右子树为空
        if (div==l-1){
            //左子树长度为div
            int[] left = new int[l-1];
            for (int j = 0; j<l-1 ;j++) left[j] = sub_q[j];
            return isLegalSquence(left);
        }
        //2.左子树为空
        if (div==0) {
            //右子树长度为 l-1
            int[] right = new int[l-1];
            System.arraycopy(sub_q, 0, right, 0, l - 1);
            return isLegalSquence(right);
        }
        //3. 均不为空
        int[] left = new int[div];
        int[] right = new int[l-div-1];
        for (int j = 0; j<div ;j++) left[j] = sub_q[j];
        System.arraycopy(sub_q, div, right, 0, l-div-1);

        return isLegalSquence(left) && isLegalSquence(right);

    }
}
