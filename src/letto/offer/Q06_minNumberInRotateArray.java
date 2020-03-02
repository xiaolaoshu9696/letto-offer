package letto.offer;

/**
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Q06_minNumberInRotateArray {
    //使用二分查找方法查找最小元素
    public int minNumberInRotateArray(int [] array) {
        //头尾初始化
        int low = 0;
        int high = array.length-1;
        while(low<high){
            //这种方式是偶数长度mid偏左
            int mid = low + (high-low)/2;
            //所找结果在右半区
            if (array[mid]>array[high]){
                low = mid + 1;
            }
            //防止死循环，结果取第一个出现的数字
            else if (array[mid] == array[high]){
                high = high-1;
            }
            //结果在左半区
            else{
                high = mid;
            }
        }
        return array[low];
    }
}
