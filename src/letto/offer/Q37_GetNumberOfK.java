package letto.offer;

/**
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class Q37_GetNumberOfK {

    //最简单循环 一般使用二分法
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i<array.length; i++){
            if (array[i]<k) continue;
            if (array[i]==k) count++;
            if (array[i]>k) break;
        }
        return count;
    }

    //二分写法
    public int GetNumberOfK2(int [] array , int k) {


        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = GetStartOfK(array, k, 0, length - 1);
        int lastK = GetEndOfK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归写法
    private int GetStartOfK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return GetStartOfK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return GetStartOfK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){
            return GetStartOfK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }

    //循环写法
    public int GetEndOfK(int[] array, int k, int start, int end){
        int length = array.length;
        int mid = (start+end)>>1;
        while (start<=end){
            if (array[mid]>k){
                end = mid-1;
            }
            else if (array[mid]<k){
                start = mid+1;
            }
            else if (mid+1<length && array[mid+1] == k){
                start = mid + 1;
            }
            else return mid;
            mid = (start+end)>>1;
        }
        return -1;
    }
}
